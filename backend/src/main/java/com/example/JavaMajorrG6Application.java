package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class JavaMajorrG6Application implements CommandLineRunner {

	

	public static void main(String[] args) {
		SpringApplication.run(JavaMajorrG6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Profile p = new Profile();
//		User u = new User("uname", "xyz@gmail.com", "123xyz", true, true, "kjfsgbikrg");
//		p.setUser(u);
//		u.setProfile(p);
//		ur.save(u);
//		Course course = new Course("angular", "learn angular", "java.png", 290, 0);
//		Course course1 = new Course("react", "learn react","java.png", 123, 0);
//		List<Course> courses = new ArrayList<>();
//		Video vid1=new Video("xyz", "abc", "1.mp4");
//		Video vid2=new Video("xyz", "abc", "2.mp4");
//		Video vid3=new Video("xyz", "abc", "3.mp4");
//		List<Video> videos=new ArrayList<>();
//		videos.add(vid3);videos.add(vid2);videos.add(vid1);
//		course.setVideo(videos);
//		course1.setVideo(videos);
//		courses.add(course1);
//		courses.add(course);
//		Category category = new Category("frontend", "learn frontend", "java", courses);
//		catr.save(category);

		// cr.save(c1);
//		Profile p=new Profile("Devang S", null, null, "Male");
//		User u=new User("dev//1", "abc@gmail.com",  new BCryptPasswordEncoder().encode("123xyzz"), false, false, "kjfsgbikrg");
//		p.setUser(u);
//		u.setProfile(p);
//		ur.save(u);

	}

}
