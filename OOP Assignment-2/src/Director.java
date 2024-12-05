// package assignment3;

public class Director extends Manager {
    private String department;

    public Director(String id, String name, double baseSalary, String educationDegree, String department) {
        super(id, name, baseSalary, educationDegree);
        this.department = department;
        int bossBonus = 5000;
        this.baseSalary = truncate(baseSalary);
        bonus = calculateBonusRatio(educationDegree);
        grossSalary = this.baseSalary + ((this.baseSalary * bonus) + bossBonus);

        if(grossSalary < 30000){
            netSalary = grossSalary - (grossSalary * 0.1);
        } else if (grossSalary <= 50000) {
            netSalary = grossSalary - (grossSalary * 0.2);
        } else {
            netSalary = grossSalary - (30000 * 0.2) - ((grossSalary - 30000) * 0.4);
        }
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