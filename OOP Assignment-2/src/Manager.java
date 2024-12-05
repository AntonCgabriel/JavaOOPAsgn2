// package assignment3;

public class Manager extends Employee{
    protected String educationDegree;

    public Manager(String id, String name, double baseSalary, String educationDegree) {
        super(id, name, baseSalary);
        this.educationDegree = educationDegree;
        this.baseSalary = truncate(baseSalary);
        bonusRatio = calculateBonusRatio(educationDegree);
        grossSalary = calculateGross(this.baseSalary);
        this.netSalary = calculateNet(grossSalary);
    }

    @Override
    public double calculateGross(double base) {
        double bonusAmount = Math.floor(base * bonusRatio * 100) / 100;
        // Truncate gross salary to 2 decimal places
        double gross = Math.floor((base + bonusAmount) * 100) / 100;
        return gross;
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
            case "MSc" -> 0.2;
            case "PhD" -> 0.35;
            default -> 0;
        };

    }


}