package assignment3;
public class Employee{

    protected String id = "";
    protected String name = "";
    protected double grossSalary = 0.0;
    protected double netSalary = 0.0;

    public Employee(String id, String name, double grossSalary) {
        this.id = id;
        this.name = name;
        this.grossSalary = truncate(grossSalary);
        this.netSalary = this.grossSalary - (this.grossSalary * 0.1);
        this.netSalary = truncate(this.netSalary);
        System.out.println("Employee "+ this.id + " was registered successfully.");
    }

    protected double truncate(double value){
        double truncatedValue =  Math.floor(value * 100) / 100;

        return truncatedValue;
    }

    public String getId(){
        return id;
        
    }

    public String getName(){
        return name;
        
    }

    public void setName(String newName){
        name = newName;

    }

    public double getGrossSalary(){
        return grossSalary;
        
    }

    public double getNetSalary(){
        return netSalary;
    }

    public void setGrossSalary(Double newGrossSalary){
        grossSalary = newGrossSalary;

    }
}




