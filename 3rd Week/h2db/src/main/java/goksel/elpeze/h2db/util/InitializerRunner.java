package goksel.elpeze.h2db.util;

import goksel.elpeze.h2db.entity.*;
import goksel.elpeze.h2db.repository.CourseRepository;
import goksel.elpeze.h2db.repository.InstructorRepository;
import goksel.elpeze.h2db.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InitializerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public void run(String... args) throws Exception {
        studentRepository.deleteAll();

        Student student1 = Student.builder().name("Göksel").birthdate(LocalDate.of(1996, 4, 2)).address("İzmir").gender('M').build();
        Student student2 = Student.builder().name("Taylan").birthdate(LocalDate.of(1999, 2, 5)).address("İstanbul").gender('M').build();
        Student student3 = Student.builder().name("Oktay").birthdate(LocalDate.of(1994, 6, 16)).address("Kayseri").gender('M').build();
        Student student4 = Student.builder().name("Elif").birthdate(LocalDate.of(1990, 9, 21)).address("Antalya").gender('F').build();


        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);

        studentRepository.findAll().forEach(student -> logger.info("{}", student));


        instructorRepository.deleteAll();


        Instructor instructor1 = VisitingResearcher.builder().name("Yvonne West").address("Grande Prairie").hourlySalary(500).build();
        Instructor instructor2 = VisitingResearcher.builder().name("Dacey Wright").address("Mazy").hourlySalary(200).build();
        Instructor instructor3 = PermanentInstructor.builder().name("Chaim Cabrera").address("Clarksville").fixedSalary(3000).build();
        Instructor instructor4 = PermanentInstructor.builder().name("Gregory Carr").fixedSalary(5000).build();

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);
        instructorRepository.save(instructor4);

        courseRepository.deleteAll();

        Course course1 = Course.builder().courseName("Data Structures").courseCode("CME3201").creditScore(4).instructor(instructor1).build();
        Course course2 = Course.builder().courseName("Algorithms").courseCode("CME3202").creditScore(4).instructor(instructor2).build();
        Course course3 = Course.builder().courseName("Design Patterns").courseCode("CME3206").creditScore(3).instructor(instructor3).build();
        Course course4 = Course.builder().courseName("Electrics").courseCode("CME3205").creditScore(2).instructor(instructor4).build();

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);



    }
}
