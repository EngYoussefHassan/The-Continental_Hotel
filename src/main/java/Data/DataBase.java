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
//    public static int empCounter = 0;
//    public static int guestCounter = 0;
//    public static int serviceCounter = 0;
//    public static int guestsSubscribed = 0;
//
//
    public static List<Employee> employees = new ArrayList<>();

//    static {
//        employees.add(addEmp(new Employee("Johnny", 3000)));
//        employees.add(Employee(new Employee("Curley", 2500)));
//        employees.add(EmployeeService.addEmp(new Employee("Isaiah", 2500)));
//        employees.add(addEmp(new Employee("Jeremiah", 2500)));
//
//    }

    public static List<Room> rooms = new ArrayList<>();
//
//    static {
//        rooms.add(RoomService.addRoom(111, "Single"));
//        rooms.add(RoomService.addRoom(112, "Single"));
//        rooms.add(RoomService.addRoom(113, "Single"));
//        rooms.add(RoomService.addRoom(114, "Single"));
//        rooms.add(RoomService.addRoom(115, "Single"));
//        rooms.add(RoomService.addRoom(211, "Double"));
//        rooms.add(RoomService.addRoom(212, "Double"));
//        rooms.add(RoomService.addRoom(213, "Double"));
//        rooms.add(RoomService.addRoom(214, "Double"));
//        rooms.add(RoomService.addRoom(215, "Double"));
//        rooms.add(RoomService.addRoom(311, "Suite"));
//        rooms.add(RoomService.addRoom(312, "Suite"));
//        rooms.add(RoomService.addRoom(313, "Suite"));
//        rooms.add(RoomService.addRoom(314, "Suite"));
//        rooms.add(RoomService.addRoom(315, "Suite"));
//    }
//
    public static List<Service> services = new ArrayList<>();
//
//    static {
//        services.add(new Service(++serviceCounter, "Air Conditioning", 150, 0));
//        services.add(new Service(++serviceCounter, "All inclusive", 350, 0));
//        services.add(new Service(++serviceCounter, "Ironing Services", 200, 0));
//        services.add(new Service(++serviceCounter, "Laundry Services", 200, 0));
//        services.add(new Service(++serviceCounter, "Dry Cleaning", 250, 0));
//    }
//
    public static List<Guest> guests = new ArrayList<Guest>();
//
//    static {
//        guests.add(new Guest("Andrew Tate", "2010405060", rooms.get(2), LocalDate.of(2023, 7, 23), services, ++guestsSubscribed));
//        guests.add(new Guest("Polly Grey", "2010405060", rooms.get(4), LocalDate.of(2023, 6, 2)));
//        guests.add(new Guest("Winston Churchill", "2010405060", rooms.get(6), LocalDate.of(2023, 5, 28), services, ++guestsSubscribed));
//        guests.add(new Guest("Oswald Mosley", "2010405060", rooms.get(8), LocalDate.of(2023, 7, 23), services, ++guestsSubscribed));
//        guests.add(new Guest("Rick Grimes", "2010405060", rooms.get(12), LocalDate.of(2023, 5, 27), services, ++guestsSubscribed));
//        guests.add(new Guest("Lou Bloom", "2010405060", rooms.get(13), LocalDate.of(2023, 6, 23)));
//    }
}
