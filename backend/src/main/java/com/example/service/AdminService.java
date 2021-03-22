package com.example.service;

import java.util.List;
import java.util.Optional;

public interface AdminService {

	public List<Category> getAllCategory();

	public Optional<Category> getCategoryById(int id);

	public void deleteCategory(int id);

	public List<Course> getAllCourse();

	public Optional<Course> getCourseById(int id);

	public void deleteCourse(int i);

	public List<Video> getAllVideo();

	public Optional<Video> getVideoById(int id);

	public void deleteVideo(int i);

}