package assignment3;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Intern extends Employee {
    double gpaSalary;
    int gpa;

    public Intern(String id, String name, Double baseSalary, int gpa) {
        super(id, name, baseSalary);
        this.gpa = gpa;
        setSalary();
    }

    public String setGpa(int gpa){
        this.gpa = gpa;
        return "GPA was updated successfully.";
    }

    //Makes sure that the integer part of the numbers is displayed
    private static final DecimalFormat df;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.'); // Use a dot as the decimal separator
        df = new DecimalFormat("0.00");
    }

    public void setSalary(){
        if (gpa <= 5){
            gpaSalary = 0.00;
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
    
    @Override
    public Double getNetSalary(){
        Double netSalary = Double.parseDouble(df.format(gpaSalary));
        return netSalary;
    }
    
    @Override
    public String getRealGrossSalary(){
        String salary = df.format(gpaSalary);
        return salary;
    }


}
