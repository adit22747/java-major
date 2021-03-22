package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	CategoryRepository cat;
	@Autowired
	CourseRepository cou;
	@Autowired
	VideoRepository vr;

	@Autowired
	UserRepo ur;

	@Override
	public List<Category> getAllCategory() {
		return cat.findAll();
	}

	@Override
	public Optional<Category> getCategoryById(int id) {
		return cat.findById(id);
	}

	@Override
	public void deleteCategory(int id) {
		cat.deleteById(id);

	}

	@Override
	public List<Course> getAllCourse() {
		return cou.findAll();
	}

	@Override
	public Optional<Course> getCourseById(int id) {
		return cou.findById(id);
	}

	@Override
	public void deleteCourse(int i) {
		cou.deleteById(i);

	}

	@Override
	public List<Video> getAllVideo() {
		return vr.findAll();
	}

	@Override
	public Optional<Video> getVideoById(int id) {
		return vr.findById(id);
	}

	@Override
	public void deleteVideo(int i) {
		vr.deleteById(i);

	}

}