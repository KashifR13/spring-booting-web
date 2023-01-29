package spring.fi.springbootingweb.service;

import org.springframework.stereotype.Service;
import spring.fi.springbootingweb.models.Position;
import spring.fi.springbootingweb.models.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StaffService {

    private static final List<Staff> staff = new ArrayList<>();
    static {
        staff.add(new Staff(String.valueOf(UUID.randomUUID()), "Mohammad", "B. Naveed", Position.MANAGER.toString()));
        staff.add(new Staff(String.valueOf(UUID.randomUUID()), "Naveed", "Tabassum", Position.FRONT_DESK.toString()));
        staff.add(new Staff(String.valueOf(UUID.randomUUID()), "Kashif", "Rasool", Position.HOUSEKEEPING.toString()));
        staff.add(new Staff(String.valueOf(UUID.randomUUID()), "Abdullah", "B. Naveed", Position.EXECUTIVE.toString()));
    }

    public List<Staff> returnAllStaff () {
        return staff;
    }
}
