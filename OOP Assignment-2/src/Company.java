//import assignment3.Employee;
import java.util.HashMap;
import java.util.Map;

public class Company{

    HashMap<String, Employee> employeeList = new HashMap<>();

    public void createEmployee(String id, String name, Double grossSalary){
        Employee newEmployee = new Employee(id, name, grossSalary);
        employeeList.put(newEmployee.getId(), newEmployee);
        System.out.println(employeeList);
    }

    public void createEmployee(String id, String name, Double grossSalary, String degree){
        Employee newEmployee = new Manager(id, name, grossSalary, degree);
        employeeList.put(newEmployee.getId(), newEmployee);
        System.out.println(employeeList);
    }

    public void createEmployee(String id, String name, Double grossSalary, String degree, String faculty){
        Employee newEmployee = new Director(id, name, grossSalary, degree, faculty);
        employeeList.put(newEmployee.getId(), newEmployee);
        System.out.println(employeeList);
    }

    public void createEmployee(String id, String name, Double grossSalary, int gpa){
        Employee newEmployee = new Intern(id, name, grossSalary);
        employeeList.put(newEmployee.getId(), newEmployee);
        System.out.println(employeeList);
    }

    public void removeEmployee(String id){
        employeeList.remove(id);
    }

    public String printEmployee(String id){
        Employee selectedEmployee = employeeList.get(id);
        String employeeName = selectedEmployee.getName();
        double employeeGrossSalary = selectedEmployee.getGrossSalary();
        String employeeInfo = (employeeName + "'s gross salary is " + employeeGrossSalary + " SEK per month.");
        System.out.print(employeeInfo);
        return employeeInfo;
    }


    public void updateEmployeeName(String id, String newName){
        Employee gotEmployee = employeeList.get(id);
        gotEmployee.setName(newName);

    }

    public void updateGrossSalary(String id, Double newGrossSalary){
        Employee gotEmployee = employeeList.get(id);
        gotEmployee.setGrossSalary(newGrossSalary);
    }

    public void getTotalGrossSalary(){
        double totalGrossSalary = 0;

        // Iterates over all entries in the map and runs function for each entry
        for (Map.Entry<String, Employee> entry : employeeList.entrySet()){
            Employee employee = entry.getValue();

            totalGrossSalary += employee.getGrossSalary();
        }
        System.out.print(totalGrossSalary);
    }

    public void getTotalNetSalary(){
        double totalNetSalary = 0;

        // Iterates over all entries in the map and runs function for each entry
        for (Map.Entry<String, Employee> entry : employeeList.entrySet()){
            Employee employee = entry.getValue();

            totalNetSalary += employee.getNetSalary();
        }
        System.out.print(totalNetSalary);
    }

    public void printAllEmployees(){
        final String EOL = System.lineSeparator();
        String allEmployeesInfo = "All registered employees:";


        for (Map.Entry<String, Employee> entry : employeeList.entrySet()){
            Employee employee = entry.getValue();
            String id = employee.getId();
            String employeeInfo = printEmployee(id);
            allEmployeesInfo = allEmployeesInfo + employeeInfo + EOL;
            }
        System.out.print(allEmployeesInfo);
        }

    public void getNetSalary(String id){
        Employee gotEmployee = employeeList.get(id);
        gotEmployee.getNetSalary();


    }

    public void updateInternGPA(){


    }

    public void updateManagerDegree(){


    }

    public void updateDirectorDept(){


    }

    public void promoteToManager(){


    }

    public void promoteToDirector(){


    }

    public void promoteToIntern(){


    }

    public void printSortedEmployees(){


    }

    public void mapEachDegree(){


    }
}
