package dev.patika.spring.services;

import dev.patika.spring.dao.student.StudentDAO;
import dev.patika.spring.models.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements BaseService<Student> {

    private StudentDAO studentDAO;

    public StudentService(@Qualifier("studentDAOHibernateImpl") StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }


    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();

    }

    @Override
    public Student findById(int id) {
        return (Student) studentDAO.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return (Student) studentDAO.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentDAO.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        return (Student) studentDAO.update(student);
    }
}
