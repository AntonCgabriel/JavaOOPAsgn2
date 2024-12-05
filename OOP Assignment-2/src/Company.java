package assignment3;
import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;

public class Company{

    LinkedHashMap<String, Employee> employeeList = new LinkedHashMap<>();
    Map<String, Integer> actualMap = new HashMap<>();

    public String createEmployee(String id, String name, Double baseSalary){
        Employee newEmployee = new Employee(id, name, baseSalary);
        employeeList.put(newEmployee.getId(), newEmployee);
        //System.out.println(employeeList);

        // Feedback on creation
        return newEmployee.getEmployeeAddedMessage();
    }

    public String createEmployee(String id, String name, Double baseSalary, String degree){
        Employee newEmployee = new Manager(id, name, baseSalary, degree);
        employeeList.put(newEmployee.getId(), newEmployee);

        // Counting degrees
        if (actualMap.containsKey(degree)){
            int counter = actualMap.get(degree);
            counter += 1;
            actualMap.put(degree, counter);
        }
        else{
            actualMap.put(degree, 1);
        }
        // System.out.println(employeeList);

        // Feedback on creation
        return newEmployee.getEmployeeAddedMessage();
    }

    public String createEmployee(String id, String name, Double grossSalary, String degree, String faculty){
        Employee newEmployee = new Director(id, name, grossSalary, degree, faculty);
        employeeList.put(newEmployee.getId(), newEmployee);

        // Counting degrees
        if (actualMap.containsKey(degree)){
            int counter = actualMap.get(degree);
            counter += 1;
            actualMap.put(degree, counter);
        }
        else{
            actualMap.put(degree, 1);
        }
        //System.out.println(employeeList);

        // Feedback on creation
        return newEmployee.getEmployeeAddedMessage();
    }

    public String createEmployee(String id, String name, Double grossSalary, int gpa){
        Employee newEmployee = new Intern(id, name, grossSalary, gpa);
        employeeList.put(newEmployee.getId(), newEmployee);
        System.out.println(employeeList);
        return newEmployee.getEmployeeAddedMessage();
    }

    public String removeEmployee(String id){
        String message = "";
        if (employeeList.containsKey(id)){
            if (employeeList.get(id) instanceof Manager){
                Manager manager = (Manager) employeeList.get(id);
                String degree = manager.getEducationDegree();
                if (actualMap.get(degree) == 1){
                    actualMap.remove(degree);
                    employeeList.remove(id);
                }
                else{
                    int counter =  actualMap.get(degree);
                    counter -= 1;
                    actualMap.put(degree, counter);
                }
            }
            if (employeeList.get(id) instanceof Director){
                Director manager = (Director) employeeList.get(id);
                String degree = manager.getEducationDegree();
                if (actualMap.get(degree) == 1){
                    actualMap.remove(degree);
                    employeeList.remove(id);
                }
                else{
                    int counter =  actualMap.get(degree);
                    counter -= 1;
                    actualMap.put(degree, counter);
                }
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
        return allEmployeesInfo;
    }


    public double getNetSalary(String id){
        Employee selectedEmployee = employeeList.get(id);
        Double netSalary = selectedEmployee.getNetSalary();
        System.out.print(netSalary);
        return netSalary;

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
        String test = "Holding9";
        return test;

    }

    public Map<String, Integer> mapEachDegree(){
        return actualMap;
    }
}
