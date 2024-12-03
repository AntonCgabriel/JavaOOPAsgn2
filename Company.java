import java.util.HashMap;
import java.util.Map;

public class Company{

HashMap<String, Employee> employeelist = new HashMap<>();

public void createEmployee(String id, String name, Double grossSalary){
    Employee employee = new Employee(id, name, grossSalary);
    employeelist.put(employee.getId(), employee);
    System.out.println(employeelist);
}

public void removeEmployee(String id){
    employeelist.remove(id);
}

public String printEmployee(String id){
    Employee gotEmployee = employeelist.get(id);
    String employeeid = gotEmployee.getId();
    String employeeName = gotEmployee.getName();
    Double employeeGrossSalary = gotEmployee.getGrossSalary();
    String employeeInfo = (employeeName + "'s gross salary is " + employeeGrossSalary + " SEK per month.");
    System.out.print(employeeInfo);
    return employeeInfo;
}


public void updateEmployeeName(String id, String newName){
    Employee gotEmployee = employeelist.get(id);
    gotEmployee.setName(newName);

}

public void updateGrossSalary(String id, Double newGrossSalary){
    Employee gotEmployee = employeelist.get(id);
    gotEmployee.setGrossSalary(newGrossSalary);
}

//public void getTotalGrossSalary(){
//    double totalGrossSalary = 0;
//
//    //iterates over all entries in the map and runs function for each entry
//    for (Map.Entry<String, Employee> entry : employeelist.entrySet()){
//        Employee employee = entry.getValue();
//
//        totalGrossSalary += employee.getGrossSalary();
//    }
//    System.out.print(totalGrossSalary);
//}

public void getTotalNetSalary(){
    double totalNetSalary = 0;

    //iterates over all entries in the map and runs function for each entry
    for (Map.Entry<String, Employee> entry : employeelist.entrySet()){
        Employee employee = entry.getValue();

        totalNetSalary += employee.getNetSalary();
    }
    System.out.print(totalNetSalary);
}

public void printAllEmployees(){
    final String EOL = System.lineSeparator();
    String allEmployeesInfo = "All registered employees:";


    for (Map.Entry<String, Employee> entry : employeelist.entrySet()){
        Employee employee = entry.getValue();
        String id = employee.getId();
        String employeeInfo = printEmployee(id);
        allEmployeesInfo = allEmployeesInfo + employeeInfo + EOL;
        }
    System.out.print(allEmployeesInfo);
    }

    public void getNetSalary(String id){
        Employee gotEmployee = employeelist.get(id);
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