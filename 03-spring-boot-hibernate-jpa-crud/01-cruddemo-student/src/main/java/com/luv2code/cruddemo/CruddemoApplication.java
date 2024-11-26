package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDao theStudentDao){
		return runner -> {
			//createStudent(theStudentDao);

			readStudent(theStudentDao);
		};
	}

	private void readStudent(StudentDao theStudentDao) {

		// create a student object
		System.out.println("Creating new student");
		Student tempStudent = new Student("Daffy", "Duck" , "daffy@gmail.com");

		//save the student
		System.out.println("Saving the student");
		theStudentDao.save(tempStudent);

		//display id of the saved student
		int theId= tempStudent.getId();

		//retrieve student based on the id : primary key
		System.out.println("Retrieving student info");
		Student checkStudent = theStudentDao.findById(theId);

		//display the student
		System.out.println("Found the student: " + checkStudent);

	}

	private void createStudent(StudentDao theStudentDao) {

		//create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("impl" , "impl" , "impl@luv2code.com");


		//save the student object
		System.out.println("Saving the student object");
		theStudentDao.save(tempStudent);

		//display the id of the saved student
		System.out.println("Student saved. Generated ID: " + tempStudent.getId());
	}
}
