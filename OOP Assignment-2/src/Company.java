//package assignment3;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;

public class Company{
    LinkedHashMap<String, Employee> employeeList = new LinkedHashMap<>();
    Map<String, Integer> degreeCountMap = new HashMap<>();

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
        String test = "Employee " + id + " was updated successfully";
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
        
        return totalNetSalary;
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


    public double getNetSalary(String id){
        Employee selectedEmployee = employeeList.get(id);
        Double netSalary = selectedEmployee.getNetSalary();
        System.out.print(netSalary);
        return netSalary;

   }

    public void incrementDegreeCount(String degree) {
        if (degreeCountMap.containsKey(degree)) {
            int counter = degreeCountMap.get(degree);
            counter++;
            degreeCountMap.put(degree, counter);
        } else {
            degreeCountMap.put(degree, 1);
        }
    }
    
    public void decrementDegreeCount(String degree, String id) {
        if (degreeCountMap.get(degree) == 1){
            degreeCountMap.remove(degree);
            employeeList.remove(id);
        }
        else{
            int counter =  degreeCountMap.get(degree);
            counter--;
            degreeCountMap.put(degree, counter);
        }
    }
    
    private String registerEmployee(String id, Employee newEmployee){
        employeeList.put(newEmployee.getId(), newEmployee);
        return "Employee "+ id + " was registered successfully.";
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


            
        }
        else if (employeeList.get(id) instanceof Manager){
            Manager manager = (Manager) employee;
            manager.setDegree(degree);

            String name = employee.getName();
            Double grossSalary = employee.getGrossSalary();
            
            removeEmployee(id);
            createEmployee(id, name, grossSalary, degree);
            System.out.print("Arselbajsare");
        }

        String test = "Employee " + id + " was updated successfully";
        return test;

    }

    public String updateDirectorDept(String id, String faculty){
        Employee employee = employeeList.get(id);
        Director director = (Director) employee;
        director.setDepartment(faculty);
        String test = "Employee " + id + " was updated successfully";
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
        String totalEmployeeInfo = "Employees sorted by gross salary (ascending order):\n";
        System.out.println("1" + totalEmployeeInfo);
        Map<String, String> salaryMessage = new HashMap<>();
        ArrayList<String> salaries = new ArrayList<String>();

        for (String i: employeeList.keySet()){
            if (employeeList.get(i) instanceof Manager){
                Manager manager = (Manager) employeeList.get(i);
                String employeeInfo = manager.getEmployeeInfo(i);
                String employeeSalarie = manager.getRealGrossSalary();
                salaryMessage.put(employeeSalarie, employeeInfo);
                salaries.add(employeeSalarie);
            }
        
            else if (employeeList.get(i) instanceof Director){
                Director director = (Director) employeeList.get(i);
                String employeeInfo = director.getEmployeeInfo(i);               
                String employeeSalarie = director.getRealGrossSalary();
                salaryMessage.put(employeeSalarie, employeeInfo);
                salaries.add(employeeSalarie);
            }

            else if (employeeList.get(i) instanceof Intern){
                Intern intern = (Intern) employeeList.get(i);
                String employeeInfo = intern.getEmployeeInfo(i);               
                String employeeSalarie = intern.getRealGrossSalary();
                salaryMessage.put(employeeSalarie, employeeInfo);
                salaries.add(employeeSalarie);
            }
            else {
                String employeeInfo = employeeList.get(i).getEmployeeInfo(i);
                String employeeSalarie = employeeList.get(i).getRealGrossSalary();
                salaryMessage.put(employeeSalarie, employeeInfo);
                salaries.add(employeeSalarie);
            }
        }
        System.out.println(salaries);

        Collections.sort(salaries);
        System.out.println(salaries);

        for (String i: salaries){
            String info = salaryMessage.get(i) + "\n";
            totalEmployeeInfo += info;
        }
        System.out.println("2" + totalEmployeeInfo);
        return totalEmployeeInfo;
    }

    public Map<String, Integer> mapEachDegree(){
        return degreeCountMap;
    }
}
