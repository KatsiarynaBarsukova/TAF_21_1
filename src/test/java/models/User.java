package models;

public class User {
    private String email;
    private String password;

    public static class Buider {
        private User newUser;

        public Buider() {
            newUser = new User;
        }

        public Buider withEmail(String value) {
            newUser.email = value;

            return this;

        }
        public Buider withPassword(String value){
            newUser.password = value;

            return this;
        }
        public User build(){
            return newUser;
        }

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
