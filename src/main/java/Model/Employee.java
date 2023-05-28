package Model;

import lombok.*;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Employee extends Person{
    private double salary;
    private static int count = 0;
    public Employee(int id, String name,double salary){
        super(id, name);
        this.salary=salary;
    }
}
