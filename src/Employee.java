public class Employee extends User {
    private EmployeeRole role;
    private Hotel employer;

    public Employee(int id, String name, String email, String phone, EmployeeRole role, Hotel employer) {
        super(id, name, email, phone);
        setRole(role);
        setEmployer(employer);
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    public Hotel getEmployer() {
        return employer;
    }

    public void setEmployer(Hotel employer) {
        this.employer = employer;
    }
}
