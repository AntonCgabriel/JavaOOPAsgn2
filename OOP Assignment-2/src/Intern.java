// package assignment3;

public class Intern extends Employee {
    String id;
    double grossSalary;
    double gpaSalary;
    int gpa;

    public Intern(String id, String name, Double grossSalary) {
        super(id, name, grossSalary);
        System.out.println("Employee " + id + " was registered successfully.");
        int newGpa = 0;
        setGpa(newGpa);
    }

    public String setGpa(int gpa){
        this.gpa = gpa;
        return "hold";
    }

    public void setSalary(){
        if (gpa <= 5){
            gpaSalary = 0;
        }
        else if (gpa <= 8){
            gpaSalary = grossSalary; 
        }
        else{
            gpaSalary = grossSalary + 1000;
        }
    }
    


}
