package softserve.academy.models;

public class User {
    private String firstName;
    private String lastName;
    private String role;
    private String location;
    private String photopath;
    private String login;
    private String password;

    public User() {
    }

//****************************************************************************************************************
    public User (String firstName,
                 String lastName,
                 String role,
                 String location,
                 String photopath,
                 String login,
                 String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.role =  role;
        this.location = location;
        this.photopath=photopath;
        this.login=login;
        this.password=password;
    };

    public User(String login, String password)  {
        setLogin(login);
        setPassword(password);
    }

    public void setAllFields(String firstName,
                             String lastName,
                             String role,
                             String location,
                             String photopath,
                             String login,
                             String password)  {

        this.firstName=firstName;
        this.lastName=lastName;
        this.role =  role;
        this.location = location;
        this.photopath=photopath;
        this.login=login;
        this.password=password;
    }


    public void setLogin(String login) {
            this.login = login;
    }

    public void setPassword(String password) {
          this.password = password;
    }
//*******************************************************************************************************
    /**
     * to create Invalid user without validation

     */
    public void setNotValidPassword(String password) {
        this.password = password;
    }

    public void setNotValidLogin(String login) {
        this.login = login;
    }

    //**************************************************************************************************
    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    private void setRole(String role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    private void setLocation(String location) {
        this.location = location;
    }

    public String getPhotopath() {
        return photopath;
    }

    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }

    @Override
    public String toString() {
        return "User:" +
                " " + firstName +
                " " + lastName +
                " " + role +
                " " + location +
                " " + photopath +
                " " + login +
                " " + password;
    }

}