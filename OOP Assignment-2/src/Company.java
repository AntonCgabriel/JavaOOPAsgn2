import java.util.HashMap;

public class Company {
    private HashMap<String, Object> EmployeeList = new HashMap<String, Object>();

    public void addEmployee(String id, Object newEmployee){
        EmployeeList.put(id, newEmployee);
    }

    public void removeEmployee(String id){
        EmployeeList.remove(id);
    }

    public Object accessEmployee(String id){
        return EmployeeList.get(id);
    }

    public int getNrEmployees(){
        return EmployeeList.size();
    }

    public updateName(String id, String newName);{
        Employee employee = accessEmployee(id);
        employee.name = newName;
        addEmployee(id, employee);


    }

    public updateSalary(String id, double newSalary);{
        Employee employee = accessEmployee(id);
        employee.grossSalary = newSalary;
        addEmployee(id, employee);
    }


}
