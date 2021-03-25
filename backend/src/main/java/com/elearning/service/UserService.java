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
}
