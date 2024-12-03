public class Manager extends Employee{
    private String educationDegree;

    public Manager(String id, String name, double grossSalary, String educationdegree) {
        super(id, name, grossSalary);
        Double bonus = 0.0;
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
    grossSalary = grossSalary + (grossSalary * bonus) - ((grossSalary + (grossSalary * bonus)) * 0.1);
    System.out.println("Manager "+ this.id + " was registered successfully.");

    }
}