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
	}}

	


