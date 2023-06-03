package Data;

import Model.*;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;




@ToString

public class DataBase {
    public static List<Employee> employees = new ArrayList<>();


    public static List<Room> rooms = new ArrayList<>();

    public static List<Service> services = new ArrayList<>();

    public static List<Guest> guests = new ArrayList<Guest>();
}

