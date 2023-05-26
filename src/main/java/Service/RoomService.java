package Service;

import Data.GuestList;
import Data.RoomList;
import Model.Guest;
import Model.Room;
import Model.RoomType;
import Model.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoomService {


    public void addRoom(Room room) {
        RoomList.rooms.add(room);
    }

    public void deleteRoom(int Id) {
        RoomList.rooms.removeIf(room -> room.getRoomNo() == Id);
    }

    public void updateRoomAvailability(int roomNo, boolean state) {
        for (Room room : RoomList.rooms) {
            if (room.getRoomNo() == roomNo) {
                room.setOccupied(false);
            }
        }
    }

    /**
     * this works for both busy and empty rooms depending
     * on what you call from MAIN
     **/
    public void filterBusy(boolean state) {
        for (Room room : RoomList.rooms) {
            if (room.isOccupied() == state)
                System.out.println(room.toString());
        }
    }

    public void filterBusyRoomType(boolean state, RoomType roomType) {
        for (Room room : RoomList.rooms) {
            if (room.isOccupied() == state && Objects.equals(room.getRoomType(), roomType))
                System.out.println(room.toString());
        }
    }

    public void filterBusyRoomTypeServices(boolean state, RoomType roomType, List<Service> services) {
        for (Guest guest : GuestList.guests) {
            for (Room room : RoomList.rooms) {
                if (room.isOccupied() == state && guest.getServices() == services && room.getRoomType() == roomType) {
                    System.out.println(room.toString());
                }

            }
        }
    }

    public List<Room> getAllRooms() {
        return RoomList.rooms;
    }

}
