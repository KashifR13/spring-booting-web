package spring.fi.springbootingweb.data;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.fi.springbootingweb.models.Staff;

public interface StaffRepository extends JpaRepository<Staff, String> {}
