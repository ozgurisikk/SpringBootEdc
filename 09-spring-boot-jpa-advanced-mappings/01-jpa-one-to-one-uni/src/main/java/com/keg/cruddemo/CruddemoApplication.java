package com.keg.cruddemo;

import com.keg.cruddemo.dao.abstarcts.AppDAO;
import com.keg.cruddemo.entity.Instructor;
import com.keg.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner cmdLineRunner(AppDAO appDAO){

		return runner -> {

			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);

		};


	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 3;

		appDAO.delete(theId);


	}

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
//		Instructor tempInstructor = new Instructor("ha" , "test", "ozg@gmail.com");
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
