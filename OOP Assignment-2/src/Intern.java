// package assignment3;

public class Intern extends Employee {
    double gpaSalary;
    int gpa;

    public Intern(String id, String name, Double grossSalary) {
        super(id, name, grossSalary);
        int newGpa = 0;
        setGpa(newGpa);
    }

    protected void printInfo(){
        System.out.println("Intern "+ this.id + " was registered successfully.");

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
            gpaSalary = this.grossSalary;
        }
        else{
            gpaSalary = this.grossSalary + 1000;
        }
    }


    @Override
    public String getEmployeeInfo(String id){

        String employeeInfo = (name + "'s gross salary is " + gpaSalary + " SEK per month.");
        return employeeInfo;
    }



}
