package goksel.elpeze.h2db.services;

import goksel.elpeze.h2db.entity.Instructor;
import goksel.elpeze.h2db.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor> {

    private final InstructorRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Instructor> findAll() {
        List<Instructor> empList = new ArrayList<>();
        Iterable<Instructor> instructorIter = repository.findAll();
        instructorIter.iterator().forEachRemaining(empList::add);
        return empList;
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return repository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return repository.save(instructor);
    }

    public int getNumberOfInstructors() {
        return repository.getNumberOfInstructors();
    }


}
