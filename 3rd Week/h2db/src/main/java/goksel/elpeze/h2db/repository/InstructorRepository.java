package goksel.elpeze.h2db.repository;

import goksel.elpeze.h2db.entity.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {



    @Query("select count(i) from Instructor i")
    int getNumberOfInstructors();



}
