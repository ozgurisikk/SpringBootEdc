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
			createStudent(theStudentDao);
		};
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
