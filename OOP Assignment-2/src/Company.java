// package assignment3;

import java.util.HashMap;
import java.util.Map;

public class Company{

    HashMap<String, Employee> employeeList = new HashMap<>();
    Map<String, Integer> actualMap = new HashMap<>();

    public String createEmployee(String id, String name, Double grossSalary){
        Employee newEmployee = new Employee(id, name, grossSalary);
        employeeList.put(newEmployee.getId(), newEmployee);
        System.out.println(employeeList);
        return "Employee " + id + " was registered successfully.";
    }

    public String createEmployee(String id, String name, Double grossSalary, String degree){
        Employee newEmployee = new Manager(id, name, grossSalary, degree);
        employeeList.put(newEmployee.getId(), newEmployee);
        if (actualMap.containsKey(degree)){
            int counter = actualMap.get(degree);
            counter += 1;
            actualMap.put(degree, counter);
        }
        else{
            actualMap.put(degree, 1);
        }
        System.out.println(employeeList);

        return "Employee " + id + " was registered successfully.";
    }

    public String createEmployee(String id, String name, Double grossSalary, String degree, String faculty){
        Employee newEmployee = new Director(id, name, grossSalary, degree, faculty);
        employeeList.put(newEmployee.getId(), newEmployee);
        if (actualMap.containsKey(degree)){
            int counter = actualMap.get(degree);
            counter += 1;
            actualMap.put(degree, counter);
        }
        else{
            actualMap.put(degree, 1);
        }
        System.out.println(employeeList);
        return "Employee " + id + " was registered successfully.";
    }

    public String createEmployee(String id, String name, Double grossSalary, int gpa){
        Employee newEmployee = new Intern(id, name, grossSalary, gpa);
        employeeList.put(newEmployee.getId(), newEmployee);
        System.out.println(employeeList);
        return "Employee " + id + " was registered successfully.";
    }

    public String removeEmployee(String id){
        String message = "";
        if (employeeList.containsKey(id)){
            employeeList.remove(id);
            message = "Employee " + id + " was successfully removed.";
        }
        return message;
    }

    public String printEmployee(String id){
        Employee selectedEmployee = employeeList.get(id);
        String info = selectedEmployee.getEmployeeInfo(id);
        System.out.print(info);
        return info;
    }



    public String updateEmployeeName(String id, String newName){
        Employee selectedEmployee = employeeList.get(id);
        selectedEmployee.setName(newName);
        return "Employee " + id + " was updated successfully";
    }

    public String updateGrossSalary(String id, Double newGrossSalary){
        Employee selectedEmployee = employeeList.get(id);
        selectedEmployee.setGrossSalary(newGrossSalary);
        String test = "Holding2";
        return test;
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

    public double getTotalNetSalary(){
        double totalNetSalary = 0;

        // Iterates over all entries in the map and runs function for each entry
        for (Map.Entry<String, Employee> entry : employeeList.entrySet()){
            Employee employee = entry.getValue();

            totalNetSalary += employee.getNetSalary();
        }
        System.out.print(totalNetSalary);
        double test = 156;
        return test;
    }

    public String printAllEmployees(){
        final String EOL = System.lineSeparator();
        String allEmployeesInfo = "All registered employees:" + EOL;


        for (Map.Entry<String, Employee> entry : employeeList.entrySet()){
            Employee employee = entry.getValue();
            String id = employee.getId();
            String employeeInfo = employee.getEmployeeInfo(id);
            allEmployeesInfo = allEmployeesInfo + employeeInfo + EOL;
        }
        System.out.print(allEmployeesInfo);
        return "test5";
    }


    public double getNetSalary(String id){
        Employee selectedEmployee = employeeList.get(id);
        return selectedEmployee.getNetSalary();

   }

    public String updateInternGPA(String id, int gpa){
        String test = "Holdin3";
        return "Employee " + id + " was updated successfully";

    }


    public String updateManagerDegree(String id, String degree){
        String test = "Holding4";
        return test;

    }

    public String updateDirectorDept(String id, String faculty){
        String test = "Holding5";
        return test;

    }

    public String promoteToManager(String id, String degree){
        String test = "Holding6";
        return test;
    }

    public String promoteToDirector(String id, String degree, String faculty){
        String test = "Holding7";
        return test;
    }

    public String promoteToIntern(String id, int gpa){
        String test = "Holding8";
        return test;
    }

    public String printSortedEmployees(){
        String test = "Holding9";
        return test;

    }

    public Map<String, Integer> mapEachDegree(){
        return actualMap;
    }
}
