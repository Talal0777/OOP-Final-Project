import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class University {
    private String uniName;
    private int uniId;

    public University(String uniName, int uniId) {
        this.uniName = uniName;
        this.uniId = uniId;
    }

    public String getUniName() {
        return uniName;
    }

    public int getUniId() {
        return uniId;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public void setUniId(int uniId) {
        this.uniId = uniId;
    }
}

class Department extends University {
    private String deptName;
    private int deptId;

    public Department(String uniName, int uniId, String deptName, int deptId) {
        super(uniName, uniId);
        this.deptName = deptName;
        this.deptId = deptId;
    }

    // Getters for department
    public String getDeptName() {
        return deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}

class Student extends Department {
    private String studentName;
    private int studentRollNo;
    private int semester;
    private float gpa;
    private float cgpa;
    private static List<Student> students = new ArrayList<>();

    public Student(String uniName, int uniId, String deptName, int deptId, String studentName, int studentRollNo) {
        super(uniName, uniId, deptName, deptId);
        this.studentName = studentName;
        this.studentRollNo = studentRollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentRollNo() {
        return studentRollNo;
    }

    public int getSemester() {
        return semester;
    }

    public float getGpa() {
        return gpa;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void menu() {
        int choice1 = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice1 != 3) {
            System.out.println("\n\n\t\t\t\t**MAIN MENU**");
            System.out.println("\npress 1 for student menu ");
            System.out.println("\tpress 2 for institute menu");
            System.out.println("\tpress 3 to exit\n");
            choice1 = scanner.nextInt();
            switch (choice1) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    instituteMenu();
                    break;
                case 3:
                    System.out.println("\n\n\t\t\t\tTHANK YOU");
                    break;
                default:
                    System.out.println("\n\n\t\t\t\tINVALID OPTION");
            }
        }
    }

    public void studentMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice != 5) {
            System.out.println("\n\n\t\t\t\t**STUDENT MENU**");
            System.out.println("\n\npress 1 to enter new student data ");
            System.out.println("\tpress 2 to update existing student data ");
            System.out.println("\tpress 3 to display all data ");
            System.out.println("\tpress 4 to search for a specific student ");
            System.out.println("\tpress 5 to exit");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    enterStudentData();
                    break;
                case 2:
                    updateStudentData();
                    break;
                case 3:
                    displayAllData();
                    break;
                case 4:
                    searchStudentData();
                    break;
                case 5:
                    System.out.println("\n\n\t\t\t\tTHANK YOU");
                    break;
                default:
                    System.out.println("\n\n\t\t\t\tINVALID OPTION");
            }
        }
    }

    private void enterStudentData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student roll number: ");
        int rollNo = scanner.nextInt();
        System.out.print("Enter semester: ");
        int semester = scanner.nextInt();
        System.out.print("Enter GPA: ");
        float gpa = scanner.nextFloat();
        System.out.print("Enter CGPA: ");
        float cgpa = scanner.nextFloat();
        students.add(new Student(getUniName(), getUniId(), getDeptName(), getDeptId(), name, rollNo));
        Student student = students.get(students.size() - 1);
        student.setSemester(semester);
        student.setGpa(gpa);
        student.setCgpa(cgpa);
        System.out.println("Student data entered successfully.");
    }

    private void updateStudentData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student roll number to update: ");
        int rollNo = scanner.nextInt();
        Student student = findStudentByRollNo(rollNo);
        if (student != null) {
            scanner.nextLine(); // consume newline
            System.out.print("Enter new student name: ");
            student.setStudentName(scanner.nextLine());
            System.out.print("Enter new semester: ");
            student.setSemester(scanner.nextInt());
            System.out.print("Enter new GPA: ");
            student.setGpa(scanner.nextFloat());
            System.out.print("Enter new CGPA: ");
            student.setCgpa(scanner.nextFloat());
            System.out.println("Student data updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void displayAllData() {
        for (Student student : students) {
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Roll Number: " + student.getStudentRollNo());
            System.out.println("Semester: " + student.getSemester());
            System.out.println("GPA: " + student.getGpa());
            System.out.println("CGPA: " + student.getCgpa());
            System.out.println("-------------------------");
        }
    }

    private void searchStudentData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student roll number to search: ");
        int rollNo = scanner.nextInt();
        Student student = findStudentByRollNo(rollNo);
        if (student != null) {
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Roll Number: " + student.getStudentRollNo());
            System.out.println("Semester: " + student.getSemester());
            System.out.println("GPA: " + student.getGpa());
            System.out.println("CGPA: " + student.getCgpa());
        } else {
            System.out.println("Student not found.");
        }
    }

    private Student findStudentByRollNo(int rollNo) {
        for (Student student : students) {
            if (student.getStudentRollNo() == rollNo) {
                return student;
            }
        }
        return null;
    }

    public void instituteMenu() {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (choice != 4) {
            System.out.println("\n\n\t\t\t\t**INSTITUTE MENU**");
            System.out.println("\n\npress 1 to update university details ");
            System.out.println("\tpress 2 to update department details ");
            System.out.println("\tpress 3 to display university and department details ");
            System.out.println("\tpress 4 to exit");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    updateUniversityDetails();
                    break;
                case 2:
                    updateDepartmentDetails();
                    break;
                case 3:
                    displayInstituteDetails();
                    break;
                case 4:
                    System.out.println("\n\n\t\t\t\tTHANK YOU");
                    break;
                default:
                    System.out.println("\n\n\t\t\t\tINVALID OPTION");
            }
        }
    }

    private void updateUniversityDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new university name: ");
        String uniName = scanner.nextLine();
        System.out.print("Enter new university ID: ");
        int uniId = scanner.nextInt();
        setUniName(uniName);
        setUniId(uniId);
        System.out.println("University details updated successfully.");
    }

    private void updateDepartmentDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new department name: ");
        String deptName = scanner.nextLine();
        System.out.print("Enter new department ID: ");
        int deptId = scanner.nextInt();
        setDeptName(deptName);
        setDeptId(deptId);
        System.out.println("Department details updated successfully.");
    }

    private void displayInstituteDetails() {
        System.out.println("University Name: " + getUniName());
        System.out.println("University ID: " + getUniId());
        System.out.println("Department Name: " + getDeptName());
        System.out.println("Department ID: " + getDeptId());
    }
}

public class OOPPP {
    public static void main(String[] args) {
        Student s1 = new Student("University Name", 1, "Department Name", 1, "Student Name", 1);
        s1.menu();
    }
}