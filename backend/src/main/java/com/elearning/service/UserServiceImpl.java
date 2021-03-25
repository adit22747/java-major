package com.elearning.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.elearning.entity.Course;
import com.elearning.entity.Like;
import com.elearning.repositories.CourseRepo;
import com.elearning.repositories.LikeRepo;
import com.elearning.repositories.UserRepo;
import com.elearning.repositories.VideoRepo;
import com.elearning.entity.Video;
import com.elearning.entity.EnrolledCourseVideo;
import com.elearning.entity.EnrolledCourses;
import com.elearning.entity.User;

		
@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	LikeRepo lr;
	@Autowired 
	UserRepo ur;
	@Autowired
	CourseRepo cr;
	@Autowired
	VideoRepo vr;
	@Autowired
	EnrolledCourseRepo ecr;
	
	@Override
	public boolean like(int uid, int cid) {
		
		Optional<Course> c=cr.findById(cid);
		Optional<User> u=ur.findById(uid);
		Like IfLike = lr.findByCourseAndUser(c.get(), u.get());
		if(IfLike==null) {
			Like like=new Like(c.get(),u.get());
			int likes=c.get().getLikes();c.get().setLikes(++likes);
			cr.save(c.get());
			lr.save(like);
			return true;
		}
		
		return false;


	}

	@Override
	public boolean unlike(int likeid,int cid) {
		
		Optional<Like> IfLike=lr.findById(likeid);
		if(IfLike.get()!=null) {
			Optional<Course> c=cr.findById(cid);
			int likes=c.get().getLikes();c.get().setLikes(--likes);
			cr.save(c.get());
			lr.deleteById(likeid);
			
			return true;
			
		}
		return false;
		
	}
	@Override
	public boolean isliked(int cid, int uid) {
		Optional<Course> c = cr.findById(cid);
		Optional<User> u = ur.findById(uid);
		Like IfLike = lr.findByCourseAndUser(c.get(), u.get());
		if (IfLike == null) {
			return false;
		}
		return true;
	}

	@Override
	
		// TODO Auto-generated method stub
		public boolean Enroll(int cid,int uid) {
			// TODO Auto-generated method stub
			Optional<Course> course = cr.findById(cid); 
			Optional<User> u=ur.findById(uid);
			List<Video> videos=vr.findAllByCourse(course.get());
			List<EnrolledCourseVideo> ecvideos=new ArrayList<>();
			for (Video video : videos) {
				EnrolledCourseVideo ecv=new EnrolledCourseVideo(0,false, video, null);
				ecvideos.add(ecv);
				
				
			
	}
			return true;
	}
	@Override
	public boolean nextVideo(int cid, int uid, int vid) {
		// TODO Auto-generated method stub
		Optional<Course> course = cr.findById(cid); 
		Optional<Video> video = vr.findById(vid);
		Optional<User> u=ur.findById(uid);
		EnrolledCourses ec = ecr.findByUserAndCourse(u.get(), course.get());
		int ecid=ec.getEcourseId();
		List<EnrolledCourseVideo> ecvs = ecvr.findAllByEc(ec);
		for(int i=0;i<ecvs.size();i++) {
			if(ecvs.get(i).getVideo()==vid) {
				if(i==0) {
					return true;
				}
				if(ecvs.get(i-1).isCompleted()==true) {
					return true;
				}
				return false;
			}
			
		}
		return false;
	}

	@Override
	public boolean completeVideo(int cid, int uid, int vid) {
		Optional<Course> course = cr.findById(cid); 
		Optional<Video> video = vr.findById(vid);
		Optional<User> u=ur.findById(uid);
		EnrolledCourses ec = ecr.findByUserAndCourse(u.get(), course.get());
		List<EnrolledCourseVideo> ecvs = ec.getEcvideo();
		for(int i=0;i<ecvs.size();i++) {
			if(ecvs.get(i).getVideo()==vid) {
			ecvs.get(i).setCompleted(true);
			if(i==ecvs.size()-1) {
				long millis=System.currentTimeMillis();
				Date date=new java.sql.Date(millis);
				ec.setEndDate(date);
				ec.setEcvideo(ecvs);
				ecr.save(ec);
				return true;
				
			}
			}
			
		}
		ec.setEcvideo(ecvs);
		ecr.save(ec);
		
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean generateCompeletionCerti(int uid, int cid) {
		// TODO Auto-generated method stub
		
		Optional<User> user=ur.findById(uid);
		Profile profile=pfr.findByUser(user.get());
		Optional<Course> course = cr.findById(cid);
		System.out.println(profile.getFullName());
		System.out.println(course.get().getCourseName());
		EnrolledCourses ec=ecr.findByUserAndCourse(user.get(), course.get());
		Date enddate = ec.getEndDate();
		System.out.println(ec.getEndDate());
		String pdfname=user.get().getUsername()+course.get().getCourseName();
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(pdfname+".pdf"));
			document.open();
			Paragraph right=new Paragraph(Element.ALIGN_RIGHT);
			Paragraph left=new Paragraph(Element.ALIGN_LEFT);
			Font font = FontFactory.getFont(FontFactory.COURIER_BOLD, 30, BaseColor.BLACK);
			Chunk chunk = new Chunk("Certificate Of Completion", font);
			Paragraph preface = new Paragraph(chunk); 
			
			preface.setAlignment(Element.ALIGN_CENTER);
			document.add(preface);
			
			
			
			Image img = Image.getInstance(course.get().getCourseLogo());
	
			
			right.add(img);
			
			Font font1 = FontFactory.getFont(FontFactory.COURIER_OBLIQUE, 15, BaseColor.GRAY);
			Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD, 25, BaseColor.DARK_GRAY);
			Chunk chunk1=new Chunk("This is to Certify that"+"\n",font1);
			Chunk chunk2=new Chunk(profile.getFullName()+"\n",font2);
			Chunk chunk3=new Chunk("has successfully completed "+course.get().getCourseName()+" course on date "+"\n",font1);
			Chunk chunk4=new Chunk("'"+enddate+"'");
		
			PdfPCell leftcell=new PdfPCell();
			leftcell.addElement(chunk1);leftcell.addElement(chunk2);leftcell.addElement(chunk3);leftcell.addElement(chunk4);
			PdfPCell rightcell=new PdfPCell(img);
			leftcell.setBorder(Rectangle.NO_BORDER);
			rightcell.setBorder(Rectangle.NO_BORDER);
			leftcell.setPaddingTop(100);
			rightcell.setPaddingTop(100);
			leftcell.setVerticalAlignment(5);
			
			
			
			
			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100);
			table.addCell(leftcell);
			table.addCell(rightcell);
			table.setPaddingTop(2000);
		
	
			
		    
		
			document.add(table);
			Image cybage = Image.getInstance("Cybage-e-learning-logo.png");
			cybage.setAlignment(Element.ALIGN_CENTER);
			cybage.setBackgroundColor(BaseColor.BLUE);
			document.add(cybage);
			
		    
			
			document.close();
			
			Certificate certi=new Certificate(pdfname+".pdf", course.get(), user.get());
			ctr.save(certi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return false;
	}
	
}

	


