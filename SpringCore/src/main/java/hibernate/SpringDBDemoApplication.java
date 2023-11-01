package hibernate;

import hibernate.dao.StudentDAO;
import hibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDBDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDBDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
//        String[] args
        return runner -> {
//            System.out.println("Hello world");
//            createStudent(studentDAO);
            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByFirstName(studentDAO);
//            updateStudent(studentDAO);
//            deleteStudent(studentDAO);
//            deleteAll(studentDAO);
        };
    }

    private void deleteAll(StudentDAO studentDAO) {
        System.out.println("Deleted row count: " + studentDAO.deleteAll());
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        System.out.println("Updating student ...");
        myStudent.setLastName("White");
        studentDAO.update(myStudent);
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByFirstName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByFirstName("John");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> all = studentDAO.findAll();
        for (Student student : all) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findById(2);
        System.out.println("Saved student. Generated id: " + student.getId());
    }

    private void createStudent(StudentDAO studentDAO){
        System.out.println("Creating new student object ...");
        Student student = new Student("Paul", "Doe", "paul.doe@gmail.com");

        studentDAO.save(student);
        System.out.println("Saving the student ...");
        System.out.println("Saved student. Generated id: " + student.getId());
    }

    private void createMultipleStudents(StudentDAO studentDAO){
        System.out.println("Creating 3 student objects ...");
        Student student1 = new Student("John", "Doe", "john.doe@gmail.com");
        Student student2 = new Student("Mary", "Loki", "mary.doe@gmail.com");
        Student student3 = new Student("Bonita", "Toky", "bonita.doe@gmail.com");

        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
        System.out.println("Saving the students ...");
    }
}
