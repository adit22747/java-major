package com.elearning.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.elearning.entity.Comment;
import com.elearning.service.UserService;
import com.elearning.service.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import io.micrometer.core.ipc.http.HttpSender.Request;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {

	
	@Autowired
	UserService uservice = new UserServiceImpl();
	
	@PostMapping("/comment")
	public ResponseEntity<String> postComment(@RequestParam int userid, @RequestParam int courseid,
			@RequestParam String comment_msg) {
		Comment count = uservice.addComment(userid, courseid, comment_msg);

		if (count == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot add comment");
		}
		return ResponseEntity.status(HttpStatus.OK).body("comment added");

	}
	
	@DeleteMapping("/comment")
	public ResponseEntity<String> deleteComment(@RequestParam int commentid) {

		uservice.deleteComment(commentid);
		return null;

	}

	
	@PutMapping("/comment")
	public ResponseEntity<String> upateComment(@RequestParam int userid, @RequestParam int courseid,
			@RequestParam int commentid, @RequestParam String comment_msg) {
		Comment count = uservice.updateComment(userid, courseid, commentid, comment_msg);

		if (count == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot add comment");
		}
		return ResponseEntity.status(HttpStatus.OK).body("comment added");
	}
	
	@GetMapping("/comment")
	public List<Comment> fetchComment(@RequestParam int courseid) {
		return uservice.fetchComment(courseid);
	}
	
	@PostMapping("/feedback")
	public ResponseEntity<String> postfeedback(@RequestParam int userid, @RequestParam int courseid,
			@RequestParam String feedback_msg, @RequestParam int rating) {
		Feedback count = uservice.addFeedback(userid, courseid, feedback_msg, rating);

		if (count == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot add feedback");
		}
		return ResponseEntity.status(HttpStatus.OK).body("feedback added");

	}
	
	@DeleteMapping("/feedback")
	public ResponseEntity<String> deletefeedback(@RequestParam int feedbackid) {

		uservice.deleteFeedback(feedbackid);
		return null;

	}
	
	@PutMapping("/feedback")
	public ResponseEntity<String> upatefeedback(@RequestParam int userid, @RequestParam int courseid,
			@RequestParam int feedbackid, @RequestParam String feedback_msg) {
		Feedback count = uservice.updateFeedback(userid, courseid, feedbackid, feedback_msg);

		if (count == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot add feedback");
		}
		return ResponseEntity.status(HttpStatus.OK).body("feedback added");
	}
	
	@GetMapping("/feedback")
	public List<Feedback> fetchFeedbackbyCourseID(@RequestParam int courseid) {
		return uservice.fetchFeedbacks(courseid);
	}
	


}
