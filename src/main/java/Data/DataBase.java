package Data;

import Model.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Service.*;



@ToString

public class DataBase {
    public static List<Employee> employees = new ArrayList<>();


    public static List<Room> rooms = new ArrayList<>();

    public static List<Service> services = new ArrayList<>();

    public static List<Guest> guests = new ArrayList<Guest>();
}

