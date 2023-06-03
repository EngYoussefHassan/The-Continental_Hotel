package Service;

import Data.DataBase;
import Model.Guest;
import Model.RoomType;
import Model.Service;

import javax.swing.*;
import java.time.temporal.ChronoUnit;

public class GuestBillingService {
    public static double calcReservationCost(int guestId) {
        double cost = 0.0;
        for (Guest guest : DataBase.guests) {
            if (guest.getGuestId() == guestId) {
                if (guest.getRoom().getRoomType() == RoomType.SINGLE) {
                    cost = guest.getNoOfDays() * guest.getRoom().getRoomCost();
                } else if (guest.getRoom().getRoomType() == RoomType.DOUBLE) {
                    cost = guest.getNoOfDays() * guest.getRoom().getRoomCost();
                } else cost = guest.getNoOfDays() * guest.getRoom().getRoomCost();
            }
        }
        return cost;
    }


    public static double calcCostOfServices(int guestId) {
        double cost = 0.0;
        for (Guest guest : DataBase.guests) {
            if (guest.getGuestId() == guestId) {
                for (Service service : guest.getServices()) {
                    cost = service.getPrice() * guest.getNoOfDays();
                }
            }
        }
        return cost;
    }


    public static double calcGuestInvoice(int guestId) {
        return calcReservationCost(guestId) + calcCostOfServices(guestId);
    }

}
