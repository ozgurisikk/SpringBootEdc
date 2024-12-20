package com.keg.cruddemo.dao.concretes;

import com.keg.cruddemo.dao.abstarcts.AppDAO;
import com.keg.cruddemo.entity.Course;
import com.keg.cruddemo.entity.Instructor;
import com.keg.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void deleteInstructorById(int theId) {
        Instructor instructor = entityManager.find(Instructor.class, theId);

        List<Course> courseList = instructor.getCourses();

        for (Course tempCourse : courseList){
            tempCourse.setInstructor(null);
        }
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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);

        query.setParameter("data", theId);

        //execute the query
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        //create a query
        TypedQuery<Instructor> query = entityManager.createQuery("SELECT i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id = :data " , Instructor.class);
        query.setParameter("data", theId);

        Instructor tempInstructor = query.getSingleResult();


        return tempInstructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor theInstructor) {
        entityManager.merge(theInstructor);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);

    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course course = entityManager.find(Course.class , theId);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }





}
