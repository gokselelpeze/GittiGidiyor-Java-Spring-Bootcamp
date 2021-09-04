package goksel.elpeze.h2db.services;

import goksel.elpeze.h2db.entity.Course;
import goksel.elpeze.h2db.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course> {

    private final CourseRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> courseIter = repository.findAll();
        courseIter.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return repository.save(course);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return repository.save(course);
    }

    public int getNumberOfCourses() {
        return repository.getNumberOfCourses();
    }

//    public List<Course> getCoursesWithName(String name) {
//        return repository.findByFullName(name);
//    }
//
//    public List<Course> getCoursesWithNameContaining(String name) {
//        return repository.findByFullNameContaining(name);
//    }
//
//    public List<Course> findByAgeGreaterThan(int age) {
//        return repository.findByAgeGreaterThan(age);
//    }
//
//    public List<Course> findByAgeGreaterThanAndSalaryBefore(int age, double salary) {
//        return repository.findByAgeGreaterThanAndSalaryBefore(age, salary);
//    }
//
//    public List<Course> findFirst3BySalaryGreaterThan(double salary) {
//        return repository.findFirst3BySalaryGreaterThan(salary);
//    }


}
