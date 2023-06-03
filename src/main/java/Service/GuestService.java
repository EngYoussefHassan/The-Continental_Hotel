package Service;

import Data.DataBase;
import Model.Employee;
import Model.Guest;
import Model.Room;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {

    public static void addGuest(String name, String natID, int roomNo, LocalDate checkout) {
        Room roomAdd = new Room();
        for (Room room : DataBase.rooms) {
            if (room.getRoomNo() == roomNo) {
                roomAdd = room;
                room.setOccupied(true);
            }
        }
        Guest guest = new Guest(name, natID, roomAdd, checkout);
        DataBase.guests.add(guest);
        JOptionPane.showMessageDialog(null, "Guest Added successfully!");
    }

    public static void deleteGuest(int Id) {
        DataBase.guests = DataBase.guests.stream().filter(g -> g.getGuestId() != Id).collect(Collectors.toList());
    }

    public static void updateGuestRoom(int guestId, int roomNo) {
        for (Guest guest : DataBase.guests) {
            if (guest.getGuestId() == guestId) {
                RoomService.updateRoomAvailability(guest.getRoom().getRoomNo());
                for (Room room : DataBase.rooms) {
                    if (room.getRoomNo() == roomNo) {
                        guest.setRoom(room);
                    }
                }
            }
        }
    }

    public static boolean doesGuestExist(int id) {
        boolean state = false;
        for (Guest guest : DataBase.guests) {
            if (guest.getGuestId() == id) {
                state = true;
                break;
            }
        }
        return state;
    }

}
