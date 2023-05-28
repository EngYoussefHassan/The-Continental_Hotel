package Model;

import lombok.*;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Employee extends Person {
    private double salary;
    private int empId;
    private static int count = 0;

    public Employee(String name, double salary) {
        super(name);
        this.empId = ++count + 1000;
        this.salary = salary;
    }
}
