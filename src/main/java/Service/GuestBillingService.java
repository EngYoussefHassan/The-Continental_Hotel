package Service;

import Model.Guest;
import Model.RoomType;
import Model.Service;

import java.time.temporal.ChronoUnit;

public class GuestBillingService {
    public double calcReservationCost(Guest guest) {
        double cost = 0.0;
        if (guest.getRoom().getRoomType() == RoomType.SINGLE) {
            cost = guest.getNoOfDays() * 800;
        } else if (guest.getRoom().getRoomType() == RoomType.DOUBLE) {
            cost = guest.getNoOfDays() * 1000;
        } else cost = guest.getNoOfDays() * 1500;
        return cost;
    }

    public double calcCostOfServices(Guest guest) {
        double cost = 0.0;
        for(Service service : guest.getServices()){
            cost = service.getPrice()*guest.getNoOfDays();
        }
        return cost;
    }

    public double calcGuestInvoice(Guest guest) {
        return calcReservationCost(guest) + calcCostOfServices(guest);
    }
}
