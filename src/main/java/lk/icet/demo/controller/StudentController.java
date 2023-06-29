package lk.icet.demo.controller;
import lk.icet.demo.entity.Student;
import lk.icet.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    private final String FOLDER_PATH = "C:\\Users\\Administrator\\Desktop\\Software Engineer\\ICET\\uploads\\";
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
@PostMapping("/addImage")
    public boolean addImage(@RequestParam(value="id")Integer id, @RequestParam(value = "image")MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH+ file.getOriginalFilename();

    Student studentsById = repo.getStudentsById(id);
    studentsById.setImgUrl(filePath);
    repo.save(studentsById);
    file.transferTo(new File(filePath));

    return true;
}

        @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) throws IOException {
        byte[] image = Files.readAllBytes(new File(FOLDER_PATH+fileName).toPath());
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("img/png")).body(image);
    }
}








