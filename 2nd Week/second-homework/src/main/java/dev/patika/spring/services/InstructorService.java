package dev.patika.spring.services;

import dev.patika.spring.dao.instructor.InstructorDAO;
import dev.patika.spring.models.Instructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorService implements BaseService<Instructor> {

    private InstructorDAO instructorDAO;

    public InstructorService(@Qualifier("instructorDAOHibernateImpl") InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    @Override
    public Instructor findById(int id) {
        return (Instructor) instructorDAO.findById(id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return (Instructor) instructorDAO.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        instructorDAO.deleteById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return (Instructor) instructorDAO.update(instructor);
    }
}
