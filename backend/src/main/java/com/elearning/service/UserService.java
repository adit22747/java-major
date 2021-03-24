package com.elearning.service;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;



public interface UserService {
	
	public boolean like(int uid,int cid);
	public boolean unlike(int likeid,int cid);
	public boolean isliked(int cid,int uid);
	public boolean Enroll(int cid,int uid);
	
}
