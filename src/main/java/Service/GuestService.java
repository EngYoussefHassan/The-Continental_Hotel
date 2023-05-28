package Service;

import Data.DataBase;
import Model.Guest;
import Model.Room;

import java.util.List;
import java.util.stream.Collectors;

public class GuestService {


    RoomService roomService = new RoomService();
    public void addGuest(Guest guest) {
        DataBase.guests.add(guest);
    }

    public void deleteGuest(int Id) {
        DataBase.guests = DataBase.guests.stream().filter(g -> g.getGuestId() != Id).collect(Collectors.toList());
    }

    public void updateGuestRoom(int guestId, int roomNo) {
        for (Guest guest : DataBase.guests) {
            if (guest.getGuestId() == guestId) {
                roomService.updateRoomAvailability(guest.getRoom().getRoomNo());
                for (Room room : DataBase.rooms) {
                    if (room.getRoomNo() == roomNo) {
                        guest.setRoom(room);
                    }
                }
            }
        }

    }


    public List<Guest> getAllGuests() {
        return DataBase.guests;
    }
}
