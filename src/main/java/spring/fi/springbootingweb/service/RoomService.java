package spring.fi.springbootingweb.service;

import org.springframework.stereotype.Service;
import spring.fi.springbootingweb.models.Room;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private static final List<Room> rooms = new ArrayList<>();
    static {
        for (int i=0; i<10; i++) {
            rooms.add(new Room(i, "Room "+i, "R "+i, "Q"));
        }
    }

    public List<Room> returnAllRooms () {
        return rooms;
    }
}
