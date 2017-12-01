package employeeapp;

/**
 * @author DaoNguyen
 */
public class Employee {
    private String id;
    private String fullName;
    private String address;
    private String salary;
    private String departmentName;
    private String mobile;
    
    public Employee(){
        
    }

    public Employee(String id, String fullName, String address, String salary, String departmentName, String mobile) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.salary = salary;
        this.departmentName = departmentName;
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    
}
