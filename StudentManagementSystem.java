import java.util.*;

public class StudentManagementSystem {

    static List<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static String announcement = "📢 Mid-sem Exams will start from 25th June!";

    public static void main(String[] args) {

        // Preloaded Students
        students.add(new Student(101, "Rahul", "AI", "pass1", "9876543210", 85, 80, 100000, 60000));
        students.add(new Student(102, "Anjali", "ML", "pass2", "9123456789", 90, 88, 100000, 80000));
        students.add(new Student(103, "Ravi", "DS", "pass3", "9988776655", 78, 70, 95000, 50000));
        students.add(new Student(104, "Priya", "IoT", "pass4", "9876501234", 92, 85, 100000, 95000));

        int choice;
        do {
            System.out.println("\n---- Student Management Menu ----");
            System.out.println("1. Login Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Add New Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: loginStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: addStudent(); break;
                case 7: System.out.println("👋 Exiting... Thank you!"); break;
                default: System.out.println("❌ Invalid choice. Try again!");
            }
        } while (choice != 7);
    }

    static void loginStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        for (Student s : students) {
            if (s.getRollNo() == roll && s.getPassword().equals(pass)) {
                System.out.println("\n✅ Login Successful!");
                boolean loggedIn = true;

                while (loggedIn) {
                    System.out.println("\n--- Welcome, " + s.getName() + " ---");
                    System.out.println("1. View My Profile");
                    System.out.println("2. Change Password");
                    System.out.println("3. View Marks");
                    System.out.println("4. View Fees");
                    System.out.println("5. View Announcement");
                    System.out.println("6. Logout");
                    System.out.print("Enter choice: ");
                    int option = sc.nextInt();
                    sc.nextLine();

                    switch (option) {
                        case 1:
                            System.out.println("\n📄 Your Profile:");
                            System.out.println(s);
                            break;
                        case 2:
                            System.out.print("Enter new password: ");
                            String newPass = sc.nextLine();
                            s.setPassword(newPass);
                            System.out.println("✅ Password updated.");
                            break;
                        case 3:
                            System.out.println("📊 Marks:");
                            System.out.println("Present Semester: " + s.getPresentMarks());
                            System.out.println("Previous Semester: " + s.getPreviousMarks());
                            break;
                        case 4:
                            System.out.println("💰 Fee Status:");
                            System.out.println("Total Fees: ₹" + s.getTotalFees());
                            System.out.println("Paid: ₹" + s.getPaidFees());
                            System.out.println("Due: ₹" + s.getDueFees());
                            break;
                        case 5:
                            System.out.println("📢 Announcement: " + announcement);
                            break;
                        case 6:
                            System.out.println("👋 Logged out!");
                            loggedIn = false;
                            break;
                        default:
                            System.out.println("❌ Invalid option.");
                    }
                }
                return;
            }
        }
        System.out.println("❌ Invalid Roll No or Password!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("❌ No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();
        for (Student s : students) {
            if (s.getRollNo() == roll) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    static void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        int roll = sc.nextInt();
        for (Student s : students) {
            if (s.getRollNo() == roll) {
                sc.nextLine();
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new course: ");
                s.setCourse(sc.nextLine());
                System.out.print("Enter new mobile number: ");
                s.setMobile(sc.nextLine());
                System.out.print("Enter new present marks: ");
                s.setPresentMarks(sc.nextInt());
                System.out.print("Enter new previous marks: ");
                s.setPreviousMarks(sc.nextInt());
                System.out.print("Enter total fees: ");
                s.setTotalFees(sc.nextInt());
                System.out.print("Enter paid fees: ");
                s.setPaidFees(sc.nextInt());
                sc.nextLine();
                System.out.print("Enter new password: ");
                s.setPassword(sc.nextLine());
                System.out.println("✅ Student updated.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int roll = sc.nextInt();
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            Student s = itr.next();
            if (s.getRollNo() == roll) {
                itr.remove();
                System.out.println("✅ Student deleted.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    static void addStudent() {
        sc.nextLine(); // consume newline
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if (s.getRollNo() == roll) {
                System.out.println("❌ Student with this Roll No already exists.");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();
        System.out.print("Enter Present Marks: ");
        int presentMarks = sc.nextInt();
        System.out.print("Enter Previous Marks: ");
        int previousMarks = sc.nextInt();
        System.out.print("Enter Total Fees: ");
        int totalFees = sc.nextInt();
        System.out.print("Enter Paid Fees: ");
        int paidFees = sc.nextInt();
        sc.nextLine(); // consume newline

        Student newStudent = new Student(roll, name, course, password, mobile,
                                         presentMarks, previousMarks, totalFees, paidFees);
        students.add(newStudent);
        System.out.println("✅ New student added successfully!");
    }
}
