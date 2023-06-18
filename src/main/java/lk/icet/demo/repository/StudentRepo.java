package lk.icet.demo.repository;

import lk.icet.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student getStudentsById (Integer id);
}
