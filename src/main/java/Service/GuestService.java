package Service;

import Data.GuestList;
import Model.Guest;
import Model.Room;

import java.util.List;
import java.util.stream.Collectors;

public class GuestService {
    public void addGuest(Guest guest) {
        GuestList.guests.add(guest);
    }

    public void deleteGuest(int Id) {
        GuestList.guests = GuestList.guests.stream().filter(g -> g.getGuestID() != Id).collect(Collectors.toList());

    }

    public void updateGuestRoom(Guest guest, Room newRoom) {
        guest.setRoom(newRoom);
    }


    public List<Guest> getAllGuests() {
        return GuestList.guests;
    }
}
