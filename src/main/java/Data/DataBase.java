package Data;

import Model.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@ToString

public class DataBase {
    public static int empCounter = 0;
    public static int guestCounter = 0;
    public static int serviceCounter = 0;
    public static int guestsSubscribed = 0;
    public static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee("Johnny Dogs",2500 ));
        employees.add(new Employee("Curley",2500 ));
        employees.add(new Employee("Isaiah",2500 ));
        employees.add(new Employee("Jeremiah",2500 ));

    }

    public static List<Room> rooms = new ArrayList<>();
    static {
        rooms.add(new Room(111, RoomType.SINGLE,false,800));
        rooms.add(new Room(112, RoomType.SINGLE,false,800));
        rooms.add(new Room(113, RoomType.SINGLE,false,800));
        rooms.add(new Room(114, RoomType.SINGLE,false,800));
        rooms.add(new Room(115, RoomType.SINGLE,false,800));
        rooms.add(new Room(211, RoomType.DOUBLE,false,1000));
        rooms.add(new Room(212, RoomType.DOUBLE,false,1000));
        rooms.add(new Room(213, RoomType.DOUBLE,false,1000));
        rooms.add(new Room(214, RoomType.DOUBLE,false,1000));
        rooms.add(new Room(215, RoomType.DOUBLE,false,1000));
        rooms.add(new Room(311, RoomType.SUITE,false,1500));
        rooms.add(new Room(312, RoomType.SUITE,false,1500));
        rooms.add(new Room(313, RoomType.SUITE,false,1500));
        rooms.add(new Room(314, RoomType.SUITE,false,1500));
        rooms.add(new Room(315, RoomType.SUITE,false,1500));
    }

    public static List<Service> services = new ArrayList<>();
    static {
        services.add(new Service(++serviceCounter,"Air Conditioning", 150,0));
        services.add(new Service(++serviceCounter,"All inclusive", 350,0));
        services.add(new Service(++serviceCounter,"Ironing Services", 200,0));
        services.add(new Service(++serviceCounter,"Laundry Services", 200,0));
        services.add(new Service(++serviceCounter,"Dry Cleaning", 250,0));
    }
    public static List<Guest> guests = new ArrayList<Guest>();
    static {
        guests.add(new Guest("Andrew Tate","2010405060",rooms.get(2),LocalDate.of(2023,7,23),services,++guestsSubscribed));
        guests.add(new Guest("Polly Grey","2010405060",rooms.get(4),LocalDate.of(2023,6,2)));
        guests.add(new Guest("Winston Churchill","2010405060",rooms.get(6),LocalDate.of(2023,5,28),services,++guestsSubscribed));
        guests.add(new Guest("Oswald Mosley","2010405060",rooms.get(8),LocalDate.of(2023,7,23),services,++guestsSubscribed));
        guests.add(new Guest("Rick Grimes","2010405060",rooms.get(12),LocalDate.of(2023,5,27),services,++guestsSubscribed));
        guests.add(new Guest("Lou Bloom","2010405060",rooms.get(13),LocalDate.of(2023,6,23)));
    }

}
