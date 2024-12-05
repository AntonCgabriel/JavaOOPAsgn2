// package assignment3;

public class Manager extends Employee{
    protected String educationDegree;
    protected double bonus;

    public Manager(String id, String name, double baseSalary, String educationDegree) {
        super(id, name, baseSalary);
        this.educationDegree = educationDegree;
        this.baseSalary = truncate(baseSalary);
        bonus = calculateBonusRatio(educationDegree);
        grossSalary = calculateGross(this.baseSalary, bonus);
        this.netSalary = calculateNet(grossSalary);
    }

    // Manager Getters
    @Override
    public String getEmployeeInfo(String id){
        String employeeInfo = (educationDegree + " " + name + "'s gross salary is " + df.format(grossSalary) + " SEK per month.");
        return employeeInfo;
    }

    public String getEducationDegree(){
        return educationDegree;
    }

    // Manager Setters
    public String setDegree(String educationDegree){
        this.educationDegree = educationDegree;
        return "hold";
    }

    // Calculating Methods
    public double calculateBonusRatio(String educationDegree) {
        return switch (educationDegree) {
            case "BSc" -> 0.1;
            case "Msc" -> 0.2;
            case "PhD" -> 0.35;
            default -> 0;
        };
    }

    // Overloading for Manager
    public double calculateGross(double base, double bonus){
        double gross = base + (base * bonus);
        return gross;
    }
}