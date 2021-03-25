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

import com.elearning.entity.*;

import com.elearning.repositories.*;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	CommentRepo comr;

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
