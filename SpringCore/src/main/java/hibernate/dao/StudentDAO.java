package hibernate.dao;

import hibernate.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student thStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();
}
