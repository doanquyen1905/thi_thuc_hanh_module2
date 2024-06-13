package thi_thuc_hanh_module2.service;

import thi_thuc_hanh_module2.model.Student;
import thi_thuc_hanh_module2.repository.StudentRepository;

import java.util.List;

public class StudentService implements iServiceStudent{
    StudentRepository studentRepository = new StudentRepository();

    public boolean add(Student student) {
        if (student.getName().equals("")){
            return false;
        }
        studentRepository.add(student);
        return true;
    }

    public List<Student> getAll() {
       return studentRepository.getAll();
    }

    public Student findByCode(int code) {
        return studentRepository.findByCode(code);
    }

    public void removeStudent(Student student) {
        studentRepository.removeStudent(student);
    }

    public String searchByName(String name) {
        return studentRepository.searchByname(name);
    }
}
