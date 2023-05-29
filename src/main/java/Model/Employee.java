package Model;

import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Employee extends Person {
    private int empId;
    private double salary;
    private static int count = 0;

    public Employee(String name, double salary) {
        super(name);
        this.empId = ++count + 1000;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{ " +
                "Name= " + getName()+
                ", salary=" + salary +
                ", empId=" + empId +
                " }" + "\n";
    }
}
