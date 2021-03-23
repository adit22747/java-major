package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.entity.Category;
import com.example.entity.Course;
import com.example.repositiories.CategoryRepository;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplMockTest {
	
	

	@Mock
	public CategoryRepository catRepo;
	
	
	
	@InjectMocks
	private AdminServiceImpl as;
	

	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	void testGetAllCategory() {

		List<Course> course = null;
		
		List<Category> category = new ArrayList<Category>();
		category.add(new Category("devloping", "description of category", "abc.jpeg", course));
		category.add(new Category("designing", "description of category", "abc.jpeg", course));
		category.add(new Category("Testing", "description of category", "abc.jpeg", course));
		
		when(catRepo.findAll()).thenReturn(category);
		
		List<Category> result = as.getAllCategory();
		assertEquals(3, result.size());
		
	}
	
//	@Test
//	void testCourseStats() {
//		fail("Not yet implemented");
//	}


	@Test
	void testGetCategoryById() {
		
		List<Course> course = null;
		Category cat=new Category(12,"devloping", "description of category", "abc.jpeg", course);
		
		Optional<Category> c = Optional.of(cat)  ;
		when(catRepo.findById(12)).thenReturn(c);
		
		
		Optional<Category> result = as.getCategoryById(12);
		assertEquals(13, result.get().getCategoryId());	
		
	}

	@Test
	void testAddCategory() {
		
		List<Course> course = null;
		
		Category category = new Category("Testing", "description of category", "abc.jpeg", course);
		when(catRepo.save(category)).thenReturn(category);
		boolean result = as.addCategory(category);
		assertEquals(true, result);
	}

	@Test
	void testDeleteCategory() {
		
		as.deleteCategory(12);
        verify(catRepo, times(1)).deleteById(12);
	}

	@Test
	void testUpdateCategory() {
		
		List<Course> course = null;
		
		Category category = new Category("Testing", "description of category", "abc.jpeg", course);
		category.setCategoryId(12);
		when(catRepo.save(category)).thenReturn(category);
		Optional<Category>c=Optional.of(category);
		boolean status = as.updateCategory(category, c, 12 );
		assertEquals(true, status);
	}

//	@Test
//	void testGetAllCourse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCourseById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAddCourse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteCourse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateCourse() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAddVideo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllVideo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetVideoById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateVideo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteVideo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCategoryCount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCourseCount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetVideoCount() {
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
//	void testGetLockedAccount() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetAllUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetUserCount() {
//		fail("Not yet implemented");
//	}

}
