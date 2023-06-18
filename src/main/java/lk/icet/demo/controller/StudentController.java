package lk.icet.demo.controller;

import lk.icet.demo.entity.Student;
import lk.icet.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    StudentRepo repo;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        Student save = repo.save(student);
        return save;
    }

    @GetMapping
    public List<Student> addStudent() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable(value = "id") Integer id) {
        Student student = repo.getStudentsById(id);

        if (student!=null){
            repo.delete(student);
        }
        return student;
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable(value = "id") Integer id,@RequestBody Student student){
        Student student1 = repo.getStudentsById(id);

        if (student1!=null){
            student1.setName(student.getName());
            student1.setAddress(student.getAddress());
            student1.setMark(student.getMark());
            repo.save(student1);
        }

        return student1;


    }
}








