package com.keg.cruddemo.dao.abstarcts;

import com.keg.cruddemo.entity.Instructor;

public interface AppDAO {

    void save (Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void delete(int theId);

}
