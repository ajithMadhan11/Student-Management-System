interface Authenticate {

    final static String userId = "Admin";
    final static String password = "Admin";

    abstract boolean authenticateUser(String userName, String Password);

}

class Login implements Authenticate {

    public boolean authenticateUser(String userName, String password) {
        if (userName.equals(Authenticate.userId) && password.equals(Authenticate.password))
            return true;
        else
            return false;
    }

}
