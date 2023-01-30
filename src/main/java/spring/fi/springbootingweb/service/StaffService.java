package spring.fi.springbootingweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.fi.springbootingweb.data.StaffRepository;
import spring.fi.springbootingweb.models.Staff;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> returnAllStaff () {
        return staffRepository.findAll();
    }
}
