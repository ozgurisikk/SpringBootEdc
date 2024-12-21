package com.keg.cruddemo;

import com.keg.cruddemo.dao.abstarcts.AppDAO;
import com.keg.cruddemo.entity.*;
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

			//createCourseAndStudents(appDAO);

			//findCourseAndStudents(appDAO);

			//findStudentAndCourses(appDAO);

//			addMoreCoursesForStudent(appDAO);

			//deleteCourse(appDAO);

			deleteStudent(appDAO);
		};


	}

	private void deleteStudent(AppDAO appDAO) {
		int theId= 2;

		appDAO.deleteStudentById(theId);

	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndClassByStudentId(theId);
		Course course2 = new Course("Spring mid");
		Course course3 = new Course("Spring advanced");

		tempStudent.addCourse(course2);
		tempStudent.addCourse(course3);

		System.out.println("done");

		appDAO.update(tempStudent);


	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 2;

		Student student = appDAO.findStudentAndClassByStudentId(theId);

		System.out.println("loaded student: " + student);
		System.out.println("classes: " + student.getCourses());

		System.out.println("done");

	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId = 10;

		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("loaded course: " + tempCourse);
		System.out.println("students: " + tempCourse.getStudents());

		System.out.println("done");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course course1 = new Course("Spring beginnerr");
		Course course2 = new Course("Spring mid");
		Course course3 = new Course("Spring advanced");

		Student student1 = new Student("ozg" , "isk", "ozg@gmail.com");
		Student student2 = new Student("arz" , "test", "de@gmail.com");
		Student student3 = new Student("vey" , "hu", "re@gmail.com");


		course1.addStudent(student1);
		course1.addStudent(student2);
		appDAO.save(course1);
	}

//	private void deleteCourseAndReviews(AppDAO appDAO) {
//		int theId = 11;
//
//		System.out.println("Deleting course id: " + theId);
//
//		appDAO.deleteCourseById(theId);
//	}
//
//	private void retrieveCourseAndReviews(AppDAO appDAO) {
//
//		// get the course and reviews
//		int theId = 10;
//		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
//		// print course
//		System.out.println(tempCourse);
//		// print reviews
//		System.out.println(tempCourse.getReviews());
//
//		System.out.println("done");
//	}
//
//	private void createCourseAndReviews(AppDAO appDAO) {
//
//		Course tempCourse = new Course("sprng math");
//
//		tempCourse.addReview(new Review("fine1"));
//		tempCourse.addReview(new Review("fine2"));
//		tempCourse.addReview(new Review("fine3"));
//
//		System.out.println("saving the course");
//
//		appDAO.save(tempCourse);
//
//		System.out.println("done");
//
//	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("deleting the course with id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done");

	}


//	private void updateCourse(AppDAO appDAO) {
//		//find course
//		int theId = 11;
//		Course course = appDAO.findCourseById(theId);
//		System.out.println("found the course");
//
//		course.setTitle("Update test");
//		System.out.println("course title updated");
//
//		appDAO.updateCourse(course);
//		System.out.println("course updating mergec");
//		System.out.println("done");
//
//	}

//	private void updateInstructor(AppDAO appDAO) {
//		//find instructor
//		int id = 1;
//		Instructor tempInstructor = appDAO.findInstructorById(id);
//
//		//update
//		System.out.println("updating instructor");
//		tempInstructor.setLastName("updated");
//
//		appDAO.updateInstructor(tempInstructor);
//		System.out.println("updated");
//		System.out.println("done");
//
//	}

//	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
//		int theId = 1;
//
//		System.out.println("finding the instructor");
//		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId); // Instructor and courses are retrieved thanks to JOIN FETCH
//
//		System.out.println("The instructor:");
//		System.out.println(tempInstructor);
//		System.out.println("courses: " + tempInstructor.getCourses());
//		System.out.println("done");
//
//
//	}

//	private void findCoursesForInstructor(AppDAO appDAO) {
//		int theId = 1;
//		System.out.println("finding instructor id:" + theId);
//		Instructor theInstructor = appDAO.findInstructorById(theId);
//		System.out.println(theInstructor);
//
//		//find courses for instructor
//		System.out.println("finding courses of instructor");
//		List<Course> courseList = appDAO.findCoursesByInstructorId(theId);
//
//		System.out.println("courses; " + courseList);
//
//
//	}

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
//		int theId = 2;
//		System.out.println("deleting");
//
//		appDAO.deleteInstructorById(theId);
//
//		System.out.println("done");
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
