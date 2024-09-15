package in.studolite.recyclerview;

import java.util.Arrays;
import java.util.List;

public class EmployeeData {

    public static List<Emplyee> getEmployeeData()
    {
        List<Emplyee> emplyeeList = Arrays.asList(
                new Emplyee("2012", "Anuj", "HR"),
                new Emplyee("1242", "Shatrudhan", "Finance"),
                new Emplyee("4321", "Neha", "IT"),
                new Emplyee("8765", "Raj", "Marketing"),
                new Emplyee("9987", "Priya", "Sales"),
                new Emplyee("3345", "Aman", "HR"),
                new Emplyee("4455", "Kiran", "Finance"),
                new Emplyee("5567", "Ravi", "IT"),
                new Emplyee("6678", "Sara", "Marketing"),
                new Emplyee("7789", "Meena", "Sales"),
                new Emplyee("8890", "John", "HR"),
                new Emplyee("9901", "Emily", "Finance"),
                new Emplyee("1011", "Michael", "IT"),
                new Emplyee("1123", "Sophia", "Marketing"),
                new Emplyee("1234", "Daniel", "Sales"),
                new Emplyee("1345", "Olivia", "HR"),
                new Emplyee("2890", "Liam", "HR"),
                new Emplyee("2901", "Elijah", "Finance"),
                new Emplyee("3011", "Benjamin", "IT"),
                new Emplyee("3123", "Lucas", "Marketing"),
                new Emplyee("3234", "Mason", "Sales"),
                new Emplyee("3346", "Ella", "HR"),
                new Emplyee("3457", "Scarlett", "Finance"),
                new Emplyee("3568", "Henry", "IT"));
        return  emplyeeList;

    }

}

class  Emplyee{
    private String id;
    private String name;
    private  String department;


    Emplyee(String id,String name,String department)
    {
        this.id=id;
        this.name=name;
        this.department=department;

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }


}
