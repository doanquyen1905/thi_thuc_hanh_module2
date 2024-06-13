package thi_thuc_hanh_module2.repository;

import CaseStudyModule2.Model.Book;
import thi_thuc_hanh_module2.model.Student;

import java.io.*;
import java.util.LinkedList;
import java.util.List;


public class StudentRepository {
    public StudentRepository(){
        loadBooksFromCSV();
    }
    private static final String SRC_STUDENT = "C:\\Users\\quyen\\IdeaProjects\\module_2\\src\\thi_thuc_hanh_module2\\students.csv";
    //    private static Student[] students = new Student[100];
//    up casting
//    Generic
    private static List<Student> students = new LinkedList<>();

    static {
        students.add(new Student(1, "HaiTT", "Quáº£ng Nam", "C1123G1"));
    }

    public void add(Student student) {
        List<Student> students = new LinkedList<>();
        students.add(student);
        writeFile(students, true);


    }

    public List<Student> getAll() {
        List<Student> students = new LinkedList<>();
        File file = new File(SRC_STUDENT);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                students.add(new Student(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading data");
        } finally {
            if( br !=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error closing file");
                }
            }
        }
        return students;
    }

    public Student findByCode(int code) {
        List<Student> students = getAll();
        for (Student student : students) {
            if(student == null) {
                return null;
            }
            if (student.getCode() == code) {
                return student;
            }
        }
        return null;
    }

    public void removeStudent(Student student) {
        List<Student> students = getAll();
        int size = students.size();
        for(int i = 0; i < size; i++) {
            if(students.get(i).getCode() == (student.getCode())) {
                students.remove(i);
                break;
            }
        }

        writeFile(students, false);

    }

    private void writeFile(List<Student> students, boolean append) {
        File file = new File(SRC_STUDENT);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for(Student temp: students) {
                bufferedWriter.write(toString(temp));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Lá»—i ghi file");
        } finally {
            if(bufferedWriter !=null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Lá»—i Ä‘Ã³ng file");
                }
            }
        }
    }

    private String toString(Student student) {
        return student.getCode()+","+student.getName()+","+student.getAddress()+","+ student.getClassroom();
    }

    public String searchByname(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student.toString();
            }
        }
        return null;
    }
    private void loadBooksFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SRC_STUDENT))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int code = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String address = parts[2];
                    String classroom = parts[3];
                    Student student = new Student(code, name, address, classroom);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

