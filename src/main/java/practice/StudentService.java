package practice;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private final StudentRepository studentRepository;
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }
  public Student getStudentsByName(Long id) {
    return studentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("id에 일치하는 값이 없습니다."));
  }
}
