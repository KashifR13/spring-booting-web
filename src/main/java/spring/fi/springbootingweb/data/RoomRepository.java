package spring.fi.springbootingweb.data;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.fi.springbootingweb.models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {}
