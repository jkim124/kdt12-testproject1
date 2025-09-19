package practice;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
  private StudentService studentService;
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }
  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentService.getAllStudents();
  }
  @GetMapping("/students/{id}")
  public Student getStudentsById(@PathVariable Long id) {
    return studentService.getStudentsByName(id);
  }
}
