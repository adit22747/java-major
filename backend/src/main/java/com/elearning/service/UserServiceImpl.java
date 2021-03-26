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

	@Autowired
	CommentRepo comr;
    
   @Autowired
	LikeRepo lr;

	@Autowired
	UserRepo ur;

	@Autowired
	CourseRepo cr;

	@Autowired
	EnrolledCourseRepo ecr;

	@Autowired
	FeedbackRepo fr;

	@Autowired
	VideoRepo vr;

	@Autowired
	LikeRepo lr;

	@Autowired
	EnrolledCourseVideoRepo ecvr;

	@Autowired
	ProfileRepo pfr;
	
	@Autowired
	CertiRepo ctr;
	
	@Autowired
	Categoryrepo catr;

	@Override
	public Comment addComment(int userID, int courseID, String msg) {

		Optional<User> userD = ur.findById(userID);

		Optional<Course> courseD = cr.findById(courseID);
		if (ecr.findAllByUserAndCourse(userD.get(), courseD.get()).size() == 1) {
			Comment comment = new Comment(msg);
			comment.setUser(userD.get());
			comment.setCourse(courseD.get());
			return comr.save(comment);
		}
		return null;
	}

	@Override
	public boolean deleteComment(int commentid) {
		// TODO Auto-generated method stub
		comr.deleteById(commentid);
		return true;
	}

	@Override
	public Comment updateComment(int userid, int courseid, int commentid, String comment_msg) {
		Optional<User> userD = ur.findById(userid);

		Optional<Course> courseD = cr.findById(courseid);
		if (ecr.findAllByUserAndCourse(userD.get(), courseD.get()).size() == 1) {
			Comment comment = new Comment(commentid, comment_msg);
			comment.setUser(userD.get());
			comment.setCourse(courseD.get());
			return comr.save(comment);
		}
		return null;
	}

	@Override
	public List<Comment> fetchComment(int id) {
		List<Comment> comments = comr.fetchComment(id);
		return comments;
	}

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
			return true;}}

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
public Feedback addFeedback(int uid, int cid, String feedback, int rating) {
	Optional<User> userD = ur.findById(uid);
	Optional<Course> courseD = cr.findById(cid);
	boolean value = isCourseCompleted(cid, uid);
	System.out.println(value);
//	System.out.println(userD.get().getUserId());
//	System.out.println(courseD.get().getCourseId());
//	System.out.println(fr.findAllByUserAndCourse(userD.get(), courseD.get()).size());
	if (fr.findAllByUserAndCourse(userD.get(), courseD.get()).size() == 0) {
		if (value == true) {
			Optional<Course> c = cr.findById(cid);
			Optional<User> u = ur.findById(uid);
			Feedback fb = new Feedback(feedback, c.get(), u.get(), rating);
			// TODO Auto-generated method stub

			return fr.save(fb);
		}
	} else {
		System.out.println("do not add");
	}
//	if (fr.findAllByUserAndCourse(userD.get(), courseD.get()).size() == 1) {
//		if(value == true) {
//			Optional<Course> c = cr.findById(cid);
//			Optional<User> u = ur.findById(uid);
//			Feedback fb = new Feedback(feedback, c.get(), u.get());
//			// TODO Auto-generated method stub
//
//			return fr.save(fb);
//		}
//	}

	return null;
}

@Override
public boolean isCourseCompleted(int cid, int uid) {
	Optional<Course> c = cr.findById(cid);
	Optional<User> u = ur.findById(uid);
	EnrolledCourses ec = ecr.findByUserAndCourse(u.get(), c.get());
	if(ec!=null) {
		if (ec.getStartDate() != null & ec.getEndDate() != null) {
			return true;
	}
	
	}
	return false;
}

@Override
public boolean deleteFeedback(int feedbackid) {
	fr.deleteById(feedbackid);
	return true;
}

@Override
public Feedback updateFeedback(int userid, int courseid, int feedbackid, String feedback_msg) {
	Optional<User> userD = ur.findById(userid);

	Optional<Course> courseD = cr.findById(courseid);
	if (ecr.findAllByUserAndCourse(userD.get(), courseD.get()).size() == 1) {
		Feedback feedback = new Feedback(feedbackid, feedback_msg);
		feedback.setUser(userD.get());
		feedback.setCourse(courseD.get());
		return fr.save(feedback);
	}
	return null;
}

@Override
public List<Feedback> fetchFeedbacks(int cid) {
	Optional<Course> c = cr.findById(cid);
	return fr.findAllByCourse(c.get());
}
}
	

	


