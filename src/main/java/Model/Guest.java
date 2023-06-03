package Model;

import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class Guest extends Person{
    private String natID;
    private Room room;
    private LocalDate reservationDate;
    private LocalDate checkout;
    private List<Service> services;
    private static int guestCount = 0;
    private long noOfDays;
    private int guestId;
    private static int count = 0;

    public Guest(String name, String natID, Room room, LocalDate checkout) {
        super(name);
        this.guestId = ++count;
        reservationDate = LocalDate.now();
        room.setOccupied(true);
        this.natID = natID;
        this.room = room;
        this.checkout = checkout;
        noOfDays = reservationDate.until(checkout, ChronoUnit.DAYS);
    }

    public Guest(String name, String natID, Room room, LocalDate checkout, List<Service> services,int guestCount) {
        super(name);
        this.guestId = ++count;
        this.services = services;
        reservationDate = LocalDate.now();
        room.setOccupied(true);
        this.natID = natID;
        this.room = room;
        this.checkout = checkout;
        noOfDays = reservationDate.until(checkout, ChronoUnit.DAYS);
        for(Service service : services){
            service.setGuestsSubscribed(guestCount);
        }
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name= " + getName() +
                ", natID='" + natID +
                ", room=" + room +
                ", reservationDate=" + reservationDate +
                ", checkout=" + checkout +
                ", services=" + services +
                ", noOfDays=" + noOfDays +
                ", guestId=" + guestId +
                '}' + "\n";
    }
}
