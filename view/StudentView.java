package thi_thuc_hanh_module2.view;

import thi_thuc_hanh_module2.model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentView {

    public int view() {
        System.out.println("--------Student View--------");
        System.out.println("1. Add student");
        System.out.println("2. Edit student");
        System.out.println("3. Delete student");
        System.out.println("4. Display all student");
        System.out.println("5. Search Student by Name");
        System.out.println("0. End program");
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            try {
                System.out.print("Input your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Choice phai la so");
            } catch (Exception e) {
                System.out.println("loi khac.");
            } finally {
                System.out.println("a");
            }
        } while (choice < 0 || choice > 5);


        return choice;

    }

    public Student viewAdd() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input code: ");
        int code = Integer.parseInt(scanner.nextLine());
        if(code < 0) {
            throw new NumberFormatException();
        }
        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input address: ");
        String address = scanner.nextLine();
        System.out.println("Input classroom: ");
        String classroom = scanner.nextLine();
        Student student = new Student(code, name, address, classroom);
        return student;
    }

    public void viewMessage(boolean result) {
        if(result) {
            System.out.println("tac vu thanh cong");
        } else {
            System.out.println("tac vu that bai");
        }
    }

    public void displayAllStudent(List<Student> students) {
        System.out.println("Danh sach hoc sinh ");
        for (Student student: students) {
            System.out.println(infoStudent(student));
        }
    }

    private String infoStudent(Student student) {
        return "Code: " + student.getCode() +", name: "+ student.getName();
    }

    public int inputCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ma hoc sinh: ");
        return Integer.parseInt(scanner.nextLine());

    }

    public boolean confirmDelete(Student student) {
        System.out.println("ma hoc sinh "+ student.getCode() +" bam Y xac nhan");
        Scanner scanner = new Scanner(System.in);
        String confirm = scanner.nextLine();
        if(confirm.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }

    public String inputName() {
        System.out.print("nhap ten: ");
        return new Scanner(System.in).nextLine();
    }
}

