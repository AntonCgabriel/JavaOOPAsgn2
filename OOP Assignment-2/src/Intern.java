public class Intern extends Employee {
    String id;
    double grossSalary;
    double gpaSalary;
    int gpa;

    public Intern(String name) {
        super(name);
        id = generateID();
        System.out.println("Employee " + id + " was registered successfully.");
        int newGpa = 0;
        setGpa(newGpa);
    }

    public void setGpa(int newGpa){
        gpa = newGpa;
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