interface AdminServices {

    
    abstract boolean authenticateUser(String userName, String Password);

    abstract void addStudent();

    abstract void removeStudent();

    abstract void editStudentInfo();

    abstract void enrollCourse();

    abstract void payFees();

    abstract void generateReport();

}
