//package assignment3;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;

public class Company{
    LinkedHashMap<String, Employee> employeeList = new LinkedHashMap<>();
    Map<String, Integer> degreeCountMap = new HashMap<>();


    // Methods for Creating and removing objects within Company object
    public String createEmployee(String id, String name, Double baseSalary){
        Employee newEmployee = new Employee(id, name, baseSalary);
        employeeList.put(newEmployee.getId(), newEmployee);

        // Feedback on creation
        return newEmployee.getEmployeeAddedMessage();
    }
                        
    public String createEmployee(String id, String name, Double baseSalary, String degree){
        Employee newEmployee = new Manager(id, name, baseSalary, degree);

        // Counting degrees
        incrementDegreeCount(degree);

        // Add employee to dictionary
        return registerEmployee(id, newEmployee);
    }

    public String createEmployee(String id, String name, Double grossSalary, String degree, String faculty){
        Employee newEmployee = new Director(id, name, grossSalary, degree, faculty);

        // Counting degrees
        incrementDegreeCount(degree);

        // Add employee to dictionary
        return registerEmployee(id, newEmployee);
    }

    public String createEmployee(String id, String name, Double grossSalary, int gpa){
        Employee newEmployee = new Intern(id, name, grossSalary, gpa);
        System.out.println(employeeList);

        // Add employee to dictionary
        return registerEmployee(id, newEmployee);
    }

    public String removeEmployee(String id){
        String message = "";
        if (employeeList.containsKey(id)){
            // Remove degree from count if necessary
            if ((employeeList.get(id) instanceof Manager) || (employeeList.get(id) instanceof Director)){
                Manager manager = (Manager) employeeList.get(id);
                String degree = manager.getEducationDegree();
                decrementDegreeCount(degree, id);
            }
            message = "Employee " + id + " was successfully removed.";
        }
        return message;
    }

    public Map<String, Integer> mapEachDegree(){
        return degreeCountMap;
    }


    // Setters
    public String updateEmployeeName(String id, String newName){
        Employee selectedEmployee = employeeList.get(id);
        selectedEmployee.setName(newName);
        return "Employee " + id + " was updated successfully";
    }

    public String updateGrossSalary(String id, Double newGrossSalary){
        Employee selectedEmployee = employeeList.get(id);
        selectedEmployee.setGrossSalary(newGrossSalary);
        String message = "Employee " + id + " was updated successfully";
        return message;
    }

    public String updateInternGPA(String id, int gpa){
        Employee employee = employeeList.get(id);
        Intern intern = (Intern) employee;
        Double base = intern.baseSalary;

        String name = employee.getName();
        Double grossSalary = employee.getGrossSalary();

        removeEmployee(id);
        createEmployee(id, name, grossSalary, gpa);

        return "Employee " + id + " was updated successfully";
    }

    public String updateManagerDegree(String id, String degree){
        Employee employee = employeeList.get(id);
        if (employeeList.get(id) instanceof Director){

            Director director = (Director) employee;
            director.setDegree(degree);

            String name = employee.getName();
            Double grossSalary = employee.getGrossSalary();
            String department = director.getDepartment();

            removeEmployee(id);
            createEmployee(id, name, grossSalary, degree, department);

        } else if (employeeList.get(id) instanceof Manager){
            Manager manager = (Manager) employee;
            manager.setDegree(degree);

            String name = employee.getName();
            Double grossSalary = employee.getGrossSalary();

            removeEmployee(id);
            createEmployee(id, name, grossSalary, degree);
        }

        String message = "Employee " + id + " was updated successfully";
        return message;
    }

    public String updateDirectorDept(String id, String faculty){
        Employee employee = employeeList.get(id);
        Director director = (Director) employee;
        director.setDepartment(faculty);
        String message = "Employee " + id + " was updated successfully";
        return message;

    }


    // Getters
    public String printEmployee(String id){
        Employee selectedEmployee = employeeList.get(id);
        String info = selectedEmployee.getEmployeeInfo(id);
        System.out.print(info);
        return info;
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
        return allEmployeesInfo;
    }

    public void getTotalGrossSalary(){
        double totalGrossSalary = 0;

        // Iterates over all entries in the map and runs function for each entry
        for (Map.Entry<String, Employee> entry : employeeList.entrySet()){
            Employee employee = entry.getValue();

            totalGrossSalary += employee.getGrossSalary();
        }
    }

    public double getTotalNetSalary(){
        double totalNetSalary = 0;

        // Iterates over all entries in the map and runs function for each entry
        for (Map.Entry<String, Employee> entry : employeeList.entrySet()){
            Employee employee = entry.getValue();

            totalNetSalary += employee.getNetSalary();
        }

        return totalNetSalary;
    }

    public String printSortedEmployees(){
        String totalEmployeeInfo = "Employees sorted by gross salary (ascending order):\n";
        Map<String, String> salaryMessage = new HashMap<>();
        ArrayList<String> salaries = new ArrayList<String>();

        for (String i: employeeList.keySet()){
            if (employeeList.get(i) instanceof Manager){
                Manager manager = (Manager) employeeList.get(i);
                String employeeInfo = manager.getEmployeeInfo(i);
                String employeeSalarie = manager.getRealGrossSalary();
                salaryMessage.put(employeeSalarie, employeeInfo);
                salaries.add(employeeSalarie);
            } else if (employeeList.get(i) instanceof Director){
                Director director = (Director) employeeList.get(i);
                String employeeInfo = director.getEmployeeInfo(i);
                String employeeSalarie = director.getRealGrossSalary();
                salaryMessage.put(employeeSalarie, employeeInfo);
                salaries.add(employeeSalarie);
            } else if (employeeList.get(i) instanceof Intern){
                Intern intern = (Intern) employeeList.get(i);
                String employeeInfo = intern.getEmployeeInfo(i);
                String employeeSalarie = intern.getRealGrossSalary();
                salaryMessage.put(employeeSalarie, employeeInfo);
                salaries.add(employeeSalarie);
            } else {
                String employeeInfo = employeeList.get(i).getEmployeeInfo(i);
                String employeeSalarie = employeeList.get(i).getRealGrossSalary();
                salaryMessage.put(employeeSalarie, employeeInfo);
                salaries.add(employeeSalarie);
            }
        }

        Collections.sort(salaries);

        for (String i: salaries){
            String info = salaryMessage.get(i) + "\n";
            totalEmployeeInfo += info;
        }
        return totalEmployeeInfo;
    }

    // Overloading
    public double getNetSalary(String id){
        Employee selectedEmployee = employeeList.get(id);
        Double netSalary = selectedEmployee.getNetSalary();
        return netSalary;

   }


   // Helper methods
    private void incrementDegreeCount(String degree) {
        if (degreeCountMap.containsKey(degree)) {
            int counter = degreeCountMap.get(degree);
            counter++;
            degreeCountMap.put(degree, counter);
        } else {
            degreeCountMap.put(degree, 1);
        }
    }
    
    private void decrementDegreeCount(String degree, String id) {
        if (degreeCountMap.get(degree) == 1){
            degreeCountMap.remove(degree);
            employeeList.remove(id);
        } else{
            int counter =  degreeCountMap.get(degree);
            counter--;
            degreeCountMap.put(degree, counter);
        }
    }
    
    private String registerEmployee(String id, Employee newEmployee){
        employeeList.put(newEmployee.getId(), newEmployee);
        return "Employee "+ id + " was registered successfully.";
    }


    // Promotion methods
    public String promoteToManager(String id, String degree){
        String promoteManagerMessage = id + " promoted successfully to Manager.";
        Employee employee = employeeList.get(id);
        if ((employeeList.get(id) instanceof Employee) || (employeeList.get(id) instanceof Intern)){
            String name = employee.getName();
            Double baseSalary = employee.baseSalary;
            removeEmployee(id);
            createEmployee(id, name, baseSalary, degree);
        }
        return promoteManagerMessage;
    }
    public String promoteToDirector(String id, String degree, String faculty){
        String promoteDirectorMessage = id + " promoted successfully to Manager.";
        Employee employee = employeeList.get(id);

        if ((employeeList.get(id) instanceof Employee) || (employeeList.get(id) instanceof Intern)){
            String name = employee.getName();
            Double baseSalary = employee.baseSalary;
            removeEmployee(id);
            createEmployee(id, name, baseSalary, degree, faculty);
        } else if (employeeList.get(id) instanceof Manager) {
            Manager manager = (Manager) employee;
            String name = manager.getName();
            Double baseSalary = manager.baseSalary;
            degree = manager.getEducationDegree();
            removeEmployee(id);
            createEmployee(id, name, baseSalary, degree, faculty);
        }
        return promoteDirectorMessage;
    }

    public String promoteToIntern(String id, int gpa){
        String promoteInternMessage = id + " promoted successfully to Intern.";
        Employee employee = employeeList.get(id);

        if (employeeList.get(id) instanceof Employee){
            String name = employee.getName();
            Double baseSalary = employee.baseSalary;
            removeEmployee(id);
            createEmployee(id, name, baseSalary, gpa);
        }
        return promoteInternMessage;
    }
}
