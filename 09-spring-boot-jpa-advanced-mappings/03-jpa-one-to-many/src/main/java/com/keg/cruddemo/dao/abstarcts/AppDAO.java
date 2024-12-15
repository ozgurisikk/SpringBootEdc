package com.keg.cruddemo.dao.abstarcts;

import com.keg.cruddemo.entity.Instructor;
import com.keg.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save (Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void delete(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteDetails(int theId);
}
