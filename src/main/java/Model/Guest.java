package Model;

import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class Guest extends Person{
    private String natID;
    private Room room;
    private LocalDate reservationDate;
    private LocalDate checkout;
    private List<Service> services;
    private static int guestCount = 0;
    private long noOfDays;

    public Guest(int id, String name, String natID, Room room, LocalDate checkout) {
        super(id, name);
        reservationDate = LocalDate.now();
        room.setOccupied(false);
        this.natID = natID;
        this.room = room;
        this.checkout = checkout;
        noOfDays = reservationDate.until(checkout, ChronoUnit.DAYS);
    }

    public Guest(int id, String name, String natID, Room room, LocalDate checkout, List<Service> services,int guestCount) {
        super(id, name);
        this.services = services;
        reservationDate = LocalDate.now();
        room.setOccupied(false);
        this.natID = natID;
        this.room = room;
        this.checkout = checkout;
        noOfDays = reservationDate.until(checkout, ChronoUnit.DAYS);
        for(Service service : services){
            service.setGuestsSubscribed(guestCount);
        }
    }
}
