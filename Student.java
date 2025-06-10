public class Student {
    private int rollNo;
    private String name;
    private String course;
    private String password;
    private String mobile;
    private int presentMarks;
    private int previousMarks;
    private int totalFees;
    private int paidFees;

    public Student(int rollNo, String name, String course, String password, String mobile,
                   int presentMarks, int previousMarks, int totalFees, int paidFees) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.password = password;
        this.mobile = mobile;
        this.presentMarks = presentMarks;
        this.previousMarks = previousMarks;
        this.totalFees = totalFees;
        this.paidFees = paidFees;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public String getPassword() { return password; }
    public String getMobile() { return mobile; }
    public int getPresentMarks() { return presentMarks; }
    public int getPreviousMarks() { return previousMarks; }
    public int getTotalFees() { return totalFees; }
    public int getPaidFees() { return paidFees; }

    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setPassword(String password) { this.password = password; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public void setPresentMarks(int presentMarks) { this.presentMarks = presentMarks; }
    public void setPreviousMarks(int previousMarks) { this.previousMarks = previousMarks; }
    public void setTotalFees(int totalFees) { this.totalFees = totalFees; }
    public void setPaidFees(int paidFees) { this.paidFees = paidFees; }

    public int getDueFees() {
        return totalFees - paidFees;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Course: " + course +
               ", Mobile: " + mobile + ", Present Marks: " + presentMarks +
               ", Previous Marks: " + previousMarks + ", Total Fees: ₹" + totalFees +
               ", Paid: ₹" + paidFees + ", Due: ₹" + getDueFees();
    }
}
