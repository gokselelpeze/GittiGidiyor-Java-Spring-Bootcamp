package dev.patika.spring.dao.instructor;

import dev.patika.spring.models.Instructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDAOHibernateImpl implements InstructorDAO<Instructor> {

    private EntityManager entityManager;

    public InstructorDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Instructor", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public Instructor save(Instructor instructor) {
        Session session = entityManager.unwrap(Session.class);
        return (Instructor) session.merge(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor instructor = this.findById(id);
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return entityManager.merge(instructor);
    }
}
