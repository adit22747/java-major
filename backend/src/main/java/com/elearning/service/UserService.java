package com.elearning.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;

import com.elearning.entity.Comment;



public interface UserService {
	public Comment addComment(int userID,int courseID,String msg);
	public boolean deleteComment(int commentid);
	public Comment updateComment(int userid, int courseid, int commentid, String comment_msg);
	public List<Comment> fetchComment(int id);
	public List<Comment> fetchComment(int id);
	boolean isCourseCompleted(int cid, int uid);
	public Feedback addFeedback(int uid, int cid,String feedback,int rating);
	public boolean deleteFeedback(int feedbackid);
	public Feedback updateFeedback(int userid, int courseid, int feedbackid, String feedback_msg);
	public List<Feedback> fetchFeedbacks(int id);
}
