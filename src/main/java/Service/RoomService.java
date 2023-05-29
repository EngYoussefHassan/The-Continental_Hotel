package Service;

import Data.DataBase;
import Model.Employee;
import Model.Room;
import Model.RoomType;

import java.util.List;
import java.util.Objects;

public class RoomService {


    public void addRoom(int roomNo, String roomType) {
        double cost;
        RoomType roomTypeEnum;
        if (Objects.equals(roomType, "Single") || Objects.equals(roomType, "single") || Objects.equals(roomType, "SINGLE")) {
            cost = 800;
            roomTypeEnum = RoomType.SINGLE;
            DataBase.rooms.add(new Room(roomNo, roomTypeEnum, false, cost));
        } else if (Objects.equals(roomType, "Double") || Objects.equals(roomType, "double") || Objects.equals(roomType, "DOUBLE")) {
            cost = 1000;
            roomTypeEnum = RoomType.DOUBLE;
            DataBase.rooms.add(new Room(roomNo, roomTypeEnum, false, cost));
        } else if (Objects.equals(roomType, "Suite") || Objects.equals(roomType, "suite") || Objects.equals(roomType, "SUITE")) {
            cost = 1500;
            roomTypeEnum = RoomType.SUITE;
            DataBase.rooms.add(new Room(roomNo, roomTypeEnum, false, cost));
        }

    }

    public void deleteRoom(int Id) {
        DataBase.rooms.removeIf(room -> room.getRoomNo() == Id);
    }

    public void updateRoomAvailability(int roomNo) {
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

    public void filterBusyRoomType(boolean state, String roomType) {
        RoomType roomTypeEnum;

        if (Objects.equals(roomType, "Single") || Objects.equals(roomType, "single") || Objects.equals(roomType, "SINGLE")) {
            roomTypeEnum = RoomType.SINGLE;
            for (Room room : DataBase.rooms) {
                if (room.isOccupied() == state && Objects.equals(room.getRoomType(), roomTypeEnum))
                    System.out.println(room.toString());
            }
        } else if (Objects.equals(roomType, "Double") || Objects.equals(roomType, "double") || Objects.equals(roomType, "DOUBLE")) {
            roomTypeEnum = RoomType.DOUBLE;
            for (Room room : DataBase.rooms) {
                if (room.isOccupied() == state && Objects.equals(room.getRoomType(), roomTypeEnum))
                    System.out.println(room.toString());
            }
        } else if (Objects.equals(roomType, "Suite") || Objects.equals(roomType, "suite") || Objects.equals(roomType, "SUITE")) {
            roomTypeEnum = RoomType.DOUBLE;
            for (Room room : DataBase.rooms) {
                if (room.isOccupied() == state && Objects.equals(room.getRoomType(), roomTypeEnum))
                    System.out.println(room.toString());
            }
        }
    }

    public List<Room> getAllRooms() {
        return DataBase.rooms;
    }
    public boolean doesRoomExist(int roomNo) {
        boolean state = false;
        int flag = 0;
        for (Room room : DataBase.rooms) {
            if (room.getRoomNo() == roomNo) {
                state = true;
                break;
            }
        }
        return state;
    }

}
