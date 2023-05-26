package Data;

import Model.Guest;
import Model.Room;
import Model.RoomType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class GuestList {
    public static List<Guest> guests = new ArrayList<Guest>();
    public static int count = 0;

    static {
        guests.add(new Guest(++count, "Youssef Hassan", "29408010103698", new Room(123, RoomType.SINGLE, true, 300.5), LocalDate.now()));
        guests.add(new Guest(++count, "Islam Hassan", "29408010103698", new Room(124, RoomType.SINGLE, true, 300.5), LocalDate.now()));
        guests.add(new Guest(++count, "Amr Hassan", "29408010103698", new Room(125, RoomType.SINGLE, true, 300.5), LocalDate.now()));
        guests.add(new Guest(++count, "Ahmed Hassan", "29408010103698", new Room(126, RoomType.SINGLE, true, 300.5), LocalDate.now()));
    }
}
