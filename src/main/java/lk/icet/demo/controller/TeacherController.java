package lk.icet.demo.controller;

import lk.icet.demo.entity.Teacher;
import lk.icet.demo.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherRepo repo;

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        Teacher save = repo.save(teacher);
        return save;
    }


}
