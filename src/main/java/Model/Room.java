package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString

public class Room {
    private int roomNo;
    private RoomType roomType;
    private boolean isOccupied;
    private double roomCost;
}
