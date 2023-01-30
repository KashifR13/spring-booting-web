package spring.fi.springbootingweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.fi.springbootingweb.data.RoomRepository;
import spring.fi.springbootingweb.models.Room;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> returnAllRooms () {
        return roomRepository.findAll();
    }
}
