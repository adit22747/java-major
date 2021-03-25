package com.elearning.service;

import java.util.List;
import java.util.Optional;


public interface AdminService {
   

	public boolean addCategory(Category c);

	public boolean updateCategory(Category c, Optional<Category> ctest, int id);

	public boolean addCourse(Course c, int id);

	public boolean updateCourse(Course c, Optional<Course> ctest);

	public boolean addVideo(Video v, int id);

	boolean updateVideo(Video v, int id);

	public long getCategoryCount();

	public long getCourseCount();

	public long getVideoCount();

	public List<Category> getAllCategory();

	public Optional<Category> getCategoryById(int id);

	public void deleteCategory(int id);

	public List<Course> getAllCourse();

	public Optional<Course> getCourseById(int id);

	public void deleteCourse(int i);

	public List<Video> getAllVideo();

	public Optional<Video> getVideoById(int id);

	public void deleteVideo(int i);

	public List<User> getAllUser();

	public List<User> getLockedAccount();

	public boolean unlocakAccount(int uid);

	public boolean lockAccount(int uid);

	
}