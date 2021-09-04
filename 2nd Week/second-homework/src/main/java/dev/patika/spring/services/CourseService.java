package dev.patika.spring.services;

import dev.patika.spring.dao.course.CourseDAO;
import dev.patika.spring.dao.course.CourseDAO;
import dev.patika.spring.models.Course;
import dev.patika.spring.models.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService implements BaseService<Course> {

    private CourseDAO courseDAO;

    public CourseService(@Qualifier("courseDAOHibernateImpl") CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) courseDAO.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return (Course) courseDAO.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseDAO.deleteById(id);
    }

    @Override
    public Course update(Course course) {
        return (Course) courseDAO.update(course);
    }
}
