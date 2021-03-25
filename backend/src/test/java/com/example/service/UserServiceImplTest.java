package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.entity.Category;
import com.example.entity.Comment;
import com.example.entity.Course;
import com.example.entity.User;
import com.example.repositiories.CommentRepo;
import com.example.repositiories.CourseRepository;
import com.example.repositiories.UserRepo;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	
	@Mock 
	public CommentRepo commentRepo;
	
	@Mock
	public UserRepo userRepo;
	
	@Mock
	public CourseRepository courseRepo;
	
	
	@InjectMocks
	public UserServiceImpl us;
	
	
	@Test
	void testAddComment() {
		Comment comment = new Comment("good course");
		List<Comment> comments = null;
		Category categoryObj = null;
		String cat_name = comment.getComment();
//		System.out.println(comment.getComment());
		
		User user = new User(1, "abc", "abc@xyz.com", "hello", false, false, "user");
		
		Optional<User> userD = Optional.of(user) ;
		when(userRepo.findById(1)).thenReturn(userD);
		System.out.println(userD.get().getUserId());
		
		Course course = new Course(2,"java", "description of Course", "abc.jpeg", 5000, 3, categoryObj, comments, 0, 0, 0, 0, 0);
		
		Optional<Course> courseD = Optional.of(course) ;
		when(courseRepo.findById(2)).thenReturn(courseD);
		System.out.println(courseD.get().getCourseName());
	
		
		comment.setUser(userD.get());
		comment.setCourse(courseD.get());
		
		when(commentRepo.save(comment)).thenReturn(comment);
		Comment result = us.addComment(1, 2, cat_name);
		assertEquals(true, result);
	}

	@Test
	void testDeleteComment() {
		us.deleteComment(15);
		verify(commentRepo, times(1)).deleteById(15);
	}
//
//	@Test
//	void testUpdateComment() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testFetchComment() {
		List<Comment> comments = new ArrayList<Comment>();
		Category categoryObj = null;
		comments.add(new Comment());
	
		
		when(commentRepo.findAll()).thenReturn(comments);
		
		Course course = new Course(2,"java", "description of Course", "abc.jpeg", 5000, 3, categoryObj, comments, 0, 0, 0, 0, 0);
		
		List<Comment> result = us.fetchComment(2);
		assertEquals(1, result.size());
	}

//	@Test
//	void testAddFeedback() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testIsCourseCompleted() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteFeedback() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateFeedback() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFetchFeedbacks() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFetchcompletedCourses() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAllCourse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetAvgRatingListOfCourse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCourseById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetAvgRatingOptionalOfCourse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFeedbackcount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCommentcount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetVideos() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testLike() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUnlike() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testIsliked() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testEnroll() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testIsenrolled() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetEnrolledCourse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetEnrolledCourseVideo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testNextVideo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCompleteVideo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGenerateCompeletionCerti() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRegotp() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testVerifyOtp() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testLockAccount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUnlocakAccount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testIncrementfailed() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testClearfalied() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testIsLocked() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCreateUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testIsActivated() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testForgototp() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testChangepassword() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSendcert() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCreateProfile() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testIsProfileCreated() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetProfileDetails() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCheckUsername() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCheckEmail() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindCourseByCat() {
//		fail("Not yet implemented");
//	}

}
