//import assignment3.Manager;

public class Director extends Manager {
    private String department;

    public Director(String id, String name, double grossSalary, String educationdegree, String department) {
        super(id, name, grossSalary, educationdegree);
        this.department = department;
        int bossBonus = 5000;

        this.grossSalary = grossSalary + ((grossSalary * bonus) + bossBonus) - ((grossSalary + (grossSalary * bonus) + bossBonus) * 0.1);
    }

    protected void printInfo(){
        System.out.println("Director "+ this.id + " was registered successfully.");

    }

    public String setDepartment(String department){
        this.department = department;
        return "hold";
    }

}