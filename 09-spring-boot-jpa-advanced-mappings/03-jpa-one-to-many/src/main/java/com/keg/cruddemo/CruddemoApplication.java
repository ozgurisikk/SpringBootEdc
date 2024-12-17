package com.keg.cruddemo;

import com.keg.cruddemo.dao.abstarcts.AppDAO;
import com.keg.cruddemo.entity.Course;
import com.keg.cruddemo.entity.Instructor;
import com.keg.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmdLineRunner(AppDAO appDAO){

		return runner -> {

			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);

			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			findCoursesForInstructor(appDAO);

		};


	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("finding instructor id:" + theId);
		Instructor theInstructor = appDAO.findInstructorById(theId);
		System.out.println(theInstructor);

		//find courses for instructor
		System.out.println("finding courses of instructor");
		List<Course> courseList = appDAO.findCoursesByInstructorId(theId);

		System.out.println("courses; " + courseList);


	}

//	private void findInstructorWithCourses(AppDAO appDAO) {
//		int theId = 1;
//		System.out.println("finding instructor id:" + theId);
//		Instructor theInstructor = appDAO.findInstructorById(theId);
//		System.out.println(theInstructor);
//		System.out.println(theInstructor.getCourses());
//
//	}

//	private void createInstructorWithCourses(AppDAO appDAO) {
//		Instructor tempInstructor = new Instructor("susan" , "test", "ozg@gmail.com");
//	    InstructorDetail tempDetail= new InstructorDetail("https://www.youtube.com/", "ha");
//
//		//associate the objects
//		tempInstructor.setInstructorDetail(tempDetail);
//
//		//create course
//		Course tempCourse = new Course("Guitar");
//		Course tempCourse2 = new Course("Math");
//
//		//add courses to the instructor
//		tempInstructor.add(tempCourse);
//		tempInstructor.add(tempCourse2);
//
//		//saving instructor
//		System.out.println("saving");
//		appDAO.save(tempInstructor);
//		System.out.println("saved");
//	}

//	private void deleteInstructorDetail(AppDAO appDAO) {
//		int theId = 4;
//
//		appDAO.deleteDetails(theId);
//		System.out.println("done");
//
//	}

//	private void findInstructorDetail(AppDAO appDAO) {
//		int theId = 1;
//
//		System.out.println("finding the person with id: " + theId);
//
//		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(theId);
//
//		System.out.println("details:" + instructorDetail);
//		System.out.println("itself: " + instructorDetail.getInstructor());
//
//	}

//	private void deleteInstructor(AppDAO appDAO) {
//		int theId = 3;
//
//		appDAO.delete(theId);
//
//
//	}

//	private void findInstructor(AppDAO appDAO) {
//		int theId = 2;
//		System.out.println("findting person with id: " + theId);
//
//		Instructor tempInstructor = appDAO.findInstructorById(theId);
//
//		System.out.println("person:" + tempInstructor);
//		System.out.println("details: " + tempInstructor.getInstructorDetail());
//	}


//	private void createInstructor(AppDAO appDAO) {
//
//		Instructor tempInstructor = new Instructor("ozg" , "test", "ozg@gmail.com");
//		InstructorDetail tempDetail= new InstructorDetail("https://www.youtube.com/", "ha");
//
//		//associate the objects
//
//		tempInstructor.setInstructorDetail(tempDetail);
//
//		System.out.println("saving instructor");
//		appDAO.save(tempInstructor);
//
//		System.out.println("done");
//
//	}


}
