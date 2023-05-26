package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Data
@NoArgsConstructor
@ToString

public class Guest {
    private int guestID;
    private String name;
    private String natID;
    private Room room;
    private LocalDate reservationDate;
    private LocalDate checkout;
    private static int count;
    private List<Service> services;
    private long noOfDays;

    public Guest(int guestID, String name, String natID, Room room, LocalDate checkout) {
        reservationDate = LocalDate.now();
        room.setOccupied(false);
        this.name = name;
        this.natID = natID;
        this.room = room;
        this.checkout = checkout;
        noOfDays = reservationDate.until(checkout, ChronoUnit.DAYS);
    }
}
