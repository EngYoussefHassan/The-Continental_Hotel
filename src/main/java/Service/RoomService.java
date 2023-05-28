package Service;

import Data.DataBase;
import Model.Guest;
import Model.Room;
import Model.RoomType;
import Model.Service;

import java.util.List;
import java.util.Objects;

public class RoomService {


    public void addRoom(Room room) {
        DataBase.rooms.add(room);
    }

    public void deleteRoom(int Id) {
        DataBase.rooms.removeIf(room -> room.getRoomNo() == Id);
    }

    public void updateRoomAvailability(int roomNo, boolean state) {
        for (Room room : DataBase.rooms) {
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
        for (Room room : DataBase.rooms) {
            if (room.isOccupied() == state)
                System.out.println(room.toString());
        }
    }

    public void filterBusyRoomType(boolean state, RoomType roomType) {
        for (Room room : DataBase.rooms) {
            if (room.isOccupied() == state && Objects.equals(room.getRoomType(), roomType))
                System.out.println(room.toString());
        }
    }

//    public void filterBusyRoomTypeServices(boolean state, RoomType roomType, List<Service> services) {
//        for (Guest guest : DataBase.guests) {
//            for (Room room : DataBase.rooms) {
//                if (room.isOccupied() == state && guest.getServices() == services && room.getRoomType() == roomType) {
//                    System.out.println(room.toString());
//                }
//
//            }
//        }
//    }

    public List<Room> getAllRooms() {
        return DataBase.rooms;
    }

}
