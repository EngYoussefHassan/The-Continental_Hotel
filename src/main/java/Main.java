import Model.Guest;
import Service.GuestService;

public class Main {
    public static void main(String[] args) {
//        Guest guest = new Guest();
//        guest.setGuestID(5);

        GuestService guestService = new GuestService();
        System.out.println(guestService.getAllGuests());
    }
}
