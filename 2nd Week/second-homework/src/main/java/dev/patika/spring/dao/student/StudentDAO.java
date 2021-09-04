package dev.patika.spring.dao.student;

import dev.patika.spring.dao.BaseDAO;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO<Student> extends BaseDAO<Student> {
}
