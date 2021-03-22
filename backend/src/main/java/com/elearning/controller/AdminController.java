package com.elearning.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.elearning.service.AdminServiceImpl;


@RestController
@CrossOrigin
public class AdminController {
@Autowired
	private AdminServiceImpl asi;
	

	// add category
	@PostMapping("/category")
	public  ResponseEntity<Boolean> addCategory(@RequestBody Category c) {
		boolean b= asi.addCategory(c);
		 if(b==false) {
			 throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Category not addedd!!!");
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }
	
	}

	// update category by id
	@PutMapping("/category/{cat_id}")
	public ResponseEntity<Boolean> updateCategory(@RequestBody Category c, @PathVariable int cat_id) {
		c.setCategoryId(cat_id);
		Optional<Category> ctest=asi.getCategoryById(cat_id);
		boolean b=asi.updateCategory(c,ctest,cat_id);
		 if(b==false) {
			 throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Category not updated!!!");
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }

	}
	
	// total categories
	@GetMapping("/category/total")
	public ResponseEntity<Integer> totalCategory() {
		int c;
		c=(int) asi.getCategoryCount();
		 if(c==0) {
			 throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Category count is '0'!!!");
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(c); 
		 }
		
		
	}
	
	

	// add course
	@PostMapping("/course/{cat_id}")
	public ResponseEntity<Boolean> addCourse(@RequestBody Course c, @PathVariable int cat_id) {
		boolean b=asi.addCourse(c, cat_id);
		if(b==false) {
			throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Course not addedd!!!");
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }
	}

	

	// update category by id
	@PutMapping("/course/{co_id}/{cat_id}")
	public ResponseEntity<Boolean> updateCourse(@RequestBody Course c, @PathVariable int co_id,@PathVariable int cat_id) {
		c.setCourseId(co_id);
		Optional<Course> ctest=asi.getCourseById(co_id);
		boolean b= asi.updateCourse(c,ctest);
		if(b==false) {
			 throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Course not updated!!!");
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }


	}

	// total courses
		@GetMapping("/course/total")
		public ResponseEntity<Integer> totalCourses() {
			int c;
			c=(int) asi.getCourseCount();
			 if(c==0) {
				 throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Course count is '0'!!!");
			 }
			 else {
				 return  ResponseEntity.status(HttpStatus.OK).body(c); 
			 }
			 
		}
	
	
	

	// add video
	@PostMapping("/video/{co_id}")
	public ResponseEntity<Boolean> addVideo(@RequestBody Video c, @PathVariable int co_id) {
		boolean b= asi.addVideo(c,co_id);
		
		
		if(b==false) {
			 throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Video not addedd!!!");
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }
	}

	

	// update video by id
	@PutMapping("/video/{v_id}/{co_id}")
	public ResponseEntity<Boolean> updateVideo(@RequestBody Video v, @PathVariable int v_id,@PathVariable int co_id) {
		v.setVideoId(v_id);
		boolean b= asi.updateVideo(v,co_id);
		
		if(b==false) {
			 throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Video not updated!!!");
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }

		
	}
	
	
	// total videos
	@GetMapping("/video/total")
	public ResponseEntity<Integer> totalVideos() {
		int c;
		c=(int) asi.getVideoCount();
		 if(c==0) {
			 throw new ResponseStatusException(HttpStatus.NO_CONTENT,"Video count is '0'!!!");
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(c); 
		 }
	}
	
	
	
	
	

}