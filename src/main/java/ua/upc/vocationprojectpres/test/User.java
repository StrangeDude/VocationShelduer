package ua.upc.vocationprojectpres.test;

public class User {

    private String name;
    private String departament;
    private String role;

    public User(String name, String departament, String role) {
        this.name = name;
        this.departament = departament;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
