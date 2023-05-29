package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class Room {
    private int roomNo;
    private RoomType roomType;
    private boolean isOccupied;
    private double roomCost;

    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", roomType=" + roomType +
                ", isOccupied=" + isOccupied +
                ", roomCost=" + roomCost +
                '}' + "\n";
    }
}
