import java.util.HashMap;

public class Company {
    private HashMap<String, Employee> EmployeeList = new HashMap<>();
    
    public void registerEmployee(String name){
        Employee employee = new Employee(name);
        String id = employee.getId();
        EmployeeList.put(id, employee);
    } 

    public void removeEmployee(String id){
        EmployeeList.remove(id);
        System.out.println("Employee " + id + " was successfully removed.");
    }

    public Employee retriveEmployee(String id){
        return EmployeeList.get(id);
    }

    public void updateName(String id, String newName){
        Employee employee = retriveEmployee(id);
        employee.setName(employee, newName);
        EmployeeList.put(id, employee);

    }

    public void updateSalary(String id, double newSalary){
        Employee employee = retriveEmployee(id);
        employee.setSallary(employee, newSalary);
        EmployeeList.put(id, employee);
    }

    public int getNrEmployees(){
        return EmployeeList.size();
    }


    public void updateName(String id, String newName){
        Employee employee = accessEmployee(id);
        employee.name = newName;
        addEmployee(id, employee);
    }

    public void updateSalary(String id, double newSalary){
        Employee employee = accessEmployee(id);
        employee.grossSalary = newSalary;
        addEmployee(id, employee);

    public void calculateTotalGrossSalary(){
        double totalGrossSalary = 0;

        for (String i : EmployeeList.keySet()){
            Employee employee = retriveEmployee(i);
            double salary = employee.getGrossSalary(employee);
            totalGrossSalary += salary;
        }
        System.out.println("Total Gross salary is " + totalGrossSalary);


}
