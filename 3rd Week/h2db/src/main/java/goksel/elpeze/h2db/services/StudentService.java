package goksel.elpeze.h2db.services;

import goksel.elpeze.h2db.entity.Student;
import goksel.elpeze.h2db.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student> {

    private final StudentRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        List<Student> empList = new ArrayList<>();
        Iterable<Student> studentIter = repository.findAll();
        studentIter.iterator().forEachRemaining(empList::add);
        return empList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return repository.save(student);
    }

    @Transactional
    public List<Student> findStudentsGendersAndCounts() {
        return repository.countStudentsByGender();
    }

}
