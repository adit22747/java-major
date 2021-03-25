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
	UserService uservice;
	
	@PutMapping(path="/{cid}")
	public String like(@PathVariable int cid) {
		
		//11 is the user id
		boolean status=uservice.like(4, cid);
		if(status) {
			return "Liked";
		}
		return "can not like";
	}
	@DeleteMapping(path="/{likeid}/{cid}")
	public String unlike(@PathVariable int likeid,@PathVariable int cid) {
		
		//11 is the user id
		boolean status=uservice.unlike(likeid,cid);
		if(status) {
			return "Un Liked";
		}
		return "can not unlike";	}


	


}
