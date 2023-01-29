package spring.fi.springbootingweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.fi.springbootingweb.models.Staff;
import spring.fi.springbootingweb.service.StaffService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping
    public String getAllStaffMembers (Model model) {
        model.addAttribute("staff", staffService.returnAllStaff());
        return "staff";
    }
}
