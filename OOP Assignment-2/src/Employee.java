import java.util.HashSet;
import java.util.Set;

public class Employee {
    // Abstract attributes for every employee
    // Line below was generated by ChatGPT
    private static Set<String> usedIds = new HashSet<>();
    private String id;
    private String name;
    private double grossSalary;

    // Constructor
    public Employee(String name){
        this.name = name;
        id = generateID();
        System.out.println("Employee " + id + " was registered successfully.");
    }

    // Generating unique id based on name
    public String generateID() {
        String newId = name.substring(0, 3).toLowerCase();
        int suffix = 101;
        while (usedIds.contains(newId + suffix)){
            suffix++;
        }
        newId += suffix;
        usedIds.add(newId);
        return newId;
    }

    // Generic methods for all employees
    public String getInfo() {
        String message = name + "’s gross salary is " + grossSalary + " SEK per month.";
        return message;
    }
    public double getNetSalary(){
        double netSalary = grossSalary - ((grossSalary * 0.1));
        return netSalary;
    }
}
