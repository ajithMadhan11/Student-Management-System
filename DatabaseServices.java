interface DatabaseServices {

    abstract boolean validateUser(String username, String password);

    abstract boolean isvalidStudent(int s_id);

    abstract boolean isvalidCourse(int c_id);

}
