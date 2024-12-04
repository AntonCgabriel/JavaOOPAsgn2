// package assignment3;

public class Manager extends Employee{
    protected String educationDegree;
    protected double bonus;
    protected double totalSalary;

    public Manager(String id, String name, double grossSalary, String educationDegree) {
        super(id, name, grossSalary);
        this.educationDegree = educationDegree;
        this.grossSalary = truncate(grossSalary);
        this.netSalary = calculateNet(this.grossSalary);
        bonus = calculateBonusRatio(educationDegree);
        totalSalary = this.grossSalary + (this.grossSalary * bonus);
    }

    protected void printInfo(){
        System.out.println("Manager "+ this.id + " was registered successfully.");

    }


    public String setDegree(String educationDegree){
        this.educationDegree = educationDegree;
        return "hold";
    }

    @Override
    public String getEmployeeInfo(String id){
        String employeeInfo = (educationDegree + " " + name + "'s gross salary is " + df.format(totalSalary) + " SEK per month.");
        return employeeInfo;
    }

<<<<<<< Updated upstream
    public double calculateBonusRatio(String educationDegree) {
        switch (educationDegree) {
            case "BSc":
                return 0.1;
            case "Msc":
                return 0.2;
            case "PhD":
                return 0.35;
        }
        return 0;
    }
=======
    public String getEducationDegree(){
        return educationDegree;
    }

>>>>>>> Stashed changes
}