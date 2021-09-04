package dev.patika.spring.dao.course;

import dev.patika.spring.models.Course;
import dev.patika.spring.models.Student;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOHibernateImpl implements CourseDAO<Course> {

    private EntityManager entityManager;

    public CourseDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public Course save(Course course) {
        Session session = entityManager.unwrap(Session.class);
        return (Course) session.merge(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Course course = this.findById(id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return entityManager.merge(course);
    }
}
