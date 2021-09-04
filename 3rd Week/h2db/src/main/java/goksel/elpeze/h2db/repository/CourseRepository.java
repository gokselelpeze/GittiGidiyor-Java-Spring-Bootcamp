package goksel.elpeze.h2db.repository;

import goksel.elpeze.h2db.entity.Course;
import goksel.elpeze.h2db.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {


    @Query("select count(e) from Course e")
    int getNumberOfCourses();



}
