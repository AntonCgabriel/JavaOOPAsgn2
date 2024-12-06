//package assignment3;

public class Director extends Manager {
    private String department;
    private int directorBonus = 5000;

    public Director(String id, String name, double baseSalary, String educationDegree, String department) {
        super(id, name, baseSalary, educationDegree);
        this.department = department;
        this.baseSalary = truncate(baseSalary);
        bonusRatio = calculateBonusRatio(educationDegree);
        grossSalary = calculateGross(baseSalary);
        netSalary = calculateNet(grossSalary);
    }


    // Getters
    @Override
    public String getEmployeeInfo(String id){
        String employeeInfo = (educationDegree + " " + name + "'s gross salary is " + df.format(grossSalary) + " SEK per month. Dept: " + department);
        return employeeInfo;
    }


    // Calculating Methods
    protected double calculateNet(double grossSalary){
        double tax = 0;
        double highTax = 0.4;

        if(grossSalary < 30000){
            tax = 0.1;
            netSalary = grossSalary - (grossSalary * 0.1);
        } else {
            tax = 0.2;
            if (grossSalary <= 50000) {
                netSalary = grossSalary - (grossSalary * tax);
            } else {
                netSalary = grossSalary - (30000 * tax) - ((grossSalary - 30000) * highTax);
            }
        }
        return netSalary;
    }

    @Override
    public double calculateGross(double base) {
        double bonusAmount = base * bonusRatio;
        //System.out.print("-------" + bonusRatio + "--------");
        double gross = Math.floor(((base + bonusAmount) + directorBonus) * 100) / 100;
        System.out.print("-------" + gross + "--------");
        return gross;
    }
    public String getDepartment(){
        return department;
    }

    public String setDepartment(String department){
        this.department = department;
        return "hold";
    }

}