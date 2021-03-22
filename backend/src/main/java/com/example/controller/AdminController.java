package com.example.controller;

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

import com.example.service.AdminServiceImpl;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminServiceImpl asi;

	// show all categories
	@GetMapping("/category")
	public ResponseEntity<List<Category>> AllCategory() {
		List<Category> li = asi.getAllCategory();
		if (li.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No category found!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(li);

		}
	}

	// show category by id
	@GetMapping(value = "/category/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Optional<Category>> CategoryById(@PathVariable int id) {

		Optional<Category> c = asi.getCategoryById(id);

		if (c.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No category found!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(c);
		}

	}

	
	// delete category by id
	@DeleteMapping("/category/{id}")
	public ResponseEntity<Boolean> deleteCategory(@PathVariable int id) {

		Optional<Category> c = asi.getCategoryById(id);
		if (c.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Given category not found, so cannot be deleted!!!");
		} else {
			asi.deleteCategory(id);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}

	}

	

	
	// show all courses
	@GetMapping("/course")
	public ResponseEntity<List<Course>> AllCourse() {
		List<Course> li = asi.getAllCourse();
		if (li.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No course found!!!");

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(li);
		}

	}

	// show course by id
	@GetMapping("/course/{id}")
	public ResponseEntity<Optional<Course>> CourseById(@PathVariable int id) {

		Optional<Course> c = asi.getCourseById(id);
		if (c.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No course found!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(c);
		}

	}



	// delete course by id
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Boolean> deleteCourse(@PathVariable int id) {
		Optional<Course> c = asi.getCourseById(id);
		if (c.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Given course not found, so cannot be deleted!!!");
		} else {
			asi.deleteCourse(id);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}
	}

	

	

	// show all videos
	@GetMapping("/video")
	public ResponseEntity<List<Video>> AllVideos() {
		List<Video> li2 = asi.getAllVideo();

		if (li2.size() == 0) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No video found!!!");

		} else {
			return ResponseEntity.status(HttpStatus.OK).body(li2);
		}

	}

	// show video by id
	@GetMapping("/video/{id}")
	public ResponseEntity<Optional<Video>> VideoById(@PathVariable int id) {
		Optional<Video> v = asi.getVideoById(id);
		if (v.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No video found!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(v);
		}

	}

	

	// delete video
	@DeleteMapping("/video/{id}")
	public ResponseEntity<Boolean> deleteVideo(@PathVariable int id) {

		Optional<Video> c = asi.getVideoById(id);

		if (c.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Given video not found, so cannot be deleted!!!");
		} else {
			asi.deleteVideo(id);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}
	}



	
}