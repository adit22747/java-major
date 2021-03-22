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


	
}