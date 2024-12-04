// package assignment3;

public class Manager extends Employee{
    protected String educationDegree;
    protected double bonus;

    public Manager(String id, String name, double grossSalary, String educationdegree) {
        super(id, name, grossSalary);
        this.educationDegree = educationdegree;

        switch (educationdegree){
            case "BSc":
                bonus = 0.1;
                break;
            case "Msc":
                bonus = 0.2;
                break;
            case "PhD":
                bonus = 0.35;
                break;
            case "default":
                break;
        }

        this.grossSalary = grossSalary + (grossSalary * bonus) - ((grossSalary + (grossSalary * bonus)) * 0.1);

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

        String employeeInfo = (educationDegree + " " + name + "'s gross salary is " + grossSalary + " SEK per month.");
        return employeeInfo;
    }
}