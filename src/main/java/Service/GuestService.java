package Service;

import Data.DataBase;
import Model.Guest;
import Model.Room;

import java.util.List;
import java.util.stream.Collectors;

public class GuestService {
    public void addGuest(Guest guest) {
        DataBase.guests.add(guest);
    }

    public void deleteGuest(int Id) {
        DataBase.guests = DataBase.guests.stream().filter(g -> g.getGuestID() != Id).collect(Collectors.toList());
    }

    public void updateGuestRoom(Guest guest, Room newRoom) {
        guest.setRoom(newRoom);
    }


    public List<Guest> getAllGuests() {
        return DataBase.guests;
    }
}
