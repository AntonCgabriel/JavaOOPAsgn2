package assignment3;

public class Director extends Manager {
    private String department;

    public Director(String id, String name, double baseSalary, String educationDegree, String department) {
        super(id, name, baseSalary, educationDegree);
        this.department = department;
        this.baseSalary = truncate(baseSalary);
        bonusRatio = calculateBonusRatio(educationDegree);
        grossSalary = calculateGross(baseSalary);

        if(grossSalary < 30000){
            netSalary = grossSalary - (grossSalary * 0.1);
        } else if (grossSalary <= 50000) {
            netSalary = grossSalary - (grossSalary * 0.2);
        } else {
            netSalary = grossSalary - (30000 * 0.2) - ((grossSalary - 30000) * 0.4);
        }
    }

    @Override
    public double calculateGross(double base) {
    double bonusAmount = base * bonusRatio;
    //System.out.print("-------" + bonusRatio + "--------");
    double gross = Math.floor(((base + bonusAmount) + 5000) * 100) / 100;
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


    @Override
    public String getEmployeeInfo(String id){
        String employeeInfo = (educationDegree + " " + name + "'s gross salary is " + df.format(grossSalary) + " SEK per month. Dept: " + department);
        return employeeInfo;
    }



}