package dev.patika.hw4.service;

import dev.patika.hw4.dto.CourseDTO;
import dev.patika.hw4.exceptions.CourseIsAlreadyExistException;
import dev.patika.hw4.mappers.CourseMapper;
import dev.patika.hw4.model.Course;
import dev.patika.hw4.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private CourseMapper courseMapper;

    public boolean existsById(int courseId) {
        return courseRepository.existsById(courseId);
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> findCourseById(int courseId) {
        return courseRepository.findById(courseId);
    }

    /**
     * Check course is already existing
     * If not save to db
     * Else throw exception
     *
     * @param courseDTO
     * @return Optional<Course>
     */
    @Transactional
    public Optional<Course> saveCourse(CourseDTO courseDTO) {
        Course course = courseMapper.mapFromCourseDTOtoCourse(courseDTO);
        if (Objects.nonNull(courseRepository.findCourseByCourseCode(course.getCourseCode()))) {
            throw new CourseIsAlreadyExistException("Course " + course.getCourseName() + " is already exists!");
        }
        return Optional.of(courseRepository.save(course));
    }

    @Transactional
    public void deleteCourse(Course course) {
        courseRepository.delete(course);
    }

    @Transactional
    public void deleteCourseById(int courseId) {
        courseRepository.deleteById(courseId);
    }

    public List<Course> findCoursesByCourseName(String courseName) {
        return courseRepository.findCoursesByCourseName(courseName);
    }

    @Transactional
    public void deleteCoursesByCourseName(String courseName) {
        courseRepository.deleteCoursesByCourseName(courseName);
    }

}
