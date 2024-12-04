// package assignment3;

public class Director extends Manager {
    private String department;

    public Director(String id, String name, double grossSalary, String educationDegree, String department) {
        super(id, name, grossSalary, educationDegree);
        this.department = department;
        int bossBonus = 5000;
        this.grossSalary = truncate(grossSalary);
        bonus = calculateBonusRatio(educationDegree);
        totalSalary = this.grossSalary + ((this.grossSalary * bonus) + bossBonus);

        if(totalSalary < 30000){
            netSalary = totalSalary - (totalSalary * 0.1);
        } else if (totalSalary <= 50000) {
            netSalary = totalSalary - (totalSalary * 0.2);
        } else {
            netSalary = totalSalary - (30000 * 0.2) - ((totalSalary - 30000) * 0.4);
        }
    }

    protected void printInfo(){
        System.out.println("Director "+ this.id + " was registered successfully.");

    }

    public String setDepartment(String department){
        this.department = department;
        return "hold";
    }

    @Override
    public String getEmployeeInfo(String id){
        String employeeInfo = (educationDegree + " " + name + "'s gross salary is " + df.format(totalSalary) + " SEK per month. Dept: " + department);
        return employeeInfo;
    }

}