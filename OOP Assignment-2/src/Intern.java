// package assignment3;

public class Intern extends Employee {
    double gpaSalary;
    int gpa;

    public Intern(String id, String name, Double grossSalary, int gpa) {
        super(id, name, grossSalary);
        this.gpa = gpa;
        setSalary();
    }

    public String setGpa(int gpa){
        this.gpa = gpa;
        return "GPA was updated successfully.";
    }

    public void setSalary(){
        if (gpa <= 5){
            gpaSalary = 0;
        }
        else if (gpa <= 8){
            gpaSalary = this.baseSalary;
        }
        else{
            gpaSalary = this.baseSalary + 1000;
        }
    }


    @Override
    public String getEmployeeInfo(String id){

        String employeeInfo = (name + "'s gross salary is " + df.format(gpaSalary) + " SEK per month. GPA: " + gpa);
        return employeeInfo;
    }
}
