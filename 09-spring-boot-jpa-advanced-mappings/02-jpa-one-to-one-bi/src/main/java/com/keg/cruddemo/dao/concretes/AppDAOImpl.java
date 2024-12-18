package com.keg.cruddemo.dao.concretes;

import com.keg.cruddemo.dao.abstarcts.AppDAO;
import com.keg.cruddemo.entity.Instructor;
import com.keg.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class , theId);
    }

    @Override
    @Transactional
    public void delete(int theId) {
        Instructor instructor = entityManager.find(Instructor.class, theId);

        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class , theId);
    }

    @Override
    @Transactional
    public void deleteDetails(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }
}
