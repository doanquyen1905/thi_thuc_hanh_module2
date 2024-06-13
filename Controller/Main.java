package thi_thuc_hanh_module2.Controller;

import thi_thuc_hanh_module2.model.Student;
import thi_thuc_hanh_module2.service.StudentService;
import thi_thuc_hanh_module2.view.StudentView;

import java.util.List;

public class Main {
            public static void main(String[] args) {
                StudentView studentView = new StudentView();
                StudentService studentService = new StudentService();
                int choice;
                Student student;
                boolean result;
                List<Student> students;
                while (true) {
                    choice = studentView.view();
                    switch (choice) {
                        case 1:
                        {
                            try {
                                student = studentView.viewAdd();
                                result = studentService.add(student);
                                studentView.viewMessage(result);
                                break;
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }

                        }
                        case 2: {
                            int code = studentView.inputCode();
                            student = studentService.findByCode(code);
                            result= studentView.confirmDelete(student);
                            if (result) {
                                studentService.removeStudent(student);
                            }
                            break;
                        }
                        case 3:
                            int code = studentView.inputCode();
                            student = studentService.findByCode(code);
                            if(student == null) {
                                studentView.viewMessage(false);
                            } else {
                                boolean isConfirm = studentView.confirmDelete(student);
                                if(isConfirm) {
                                    studentService.removeStudent(student);
                                    studentView.viewMessage(true);
                                }
                            }
                            break;
                        case 4:
                            students = studentService.getAll();
                            studentView.displayAllStudent(students);
                            break;
                        case 5:
                            String name = studentView.inputName();
                            studentService.searchByName(name);
                        case 0:
                            return;
                    }
                    System.out.println();
                }
            }
        }

