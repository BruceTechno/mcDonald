package com.example.mcDonald.controller;

import com.example.mcDonald.constants.RtnCode;
import com.example.mcDonald.service.ifs.StaffService;
import com.example.mcDonald.vo.request.AddStaffRequest;
import com.example.mcDonald.vo.request.LoginRequest;
import com.example.mcDonald.vo.response.AddStaffResponse;
import com.example.mcDonald.vo.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping(value = "login")
    public LoginResponse login(@RequestBody LoginRequest request, HttpSession session) {
        LoginResponse loginResponse = staffService.login(request);
        if (loginResponse.getMessage().equalsIgnoreCase(RtnCode.SUCCESSFUL.getMessage())) {
            session.setAttribute("account", request.getAccount());
            session.setAttribute("pwd", request.getPwd());
            session.setMaxInactiveInterval(60000);
        }
        return loginResponse;
    }
    @PostMapping(value = "add_staff")
    public AddStaffResponse addStaff(@RequestBody AddStaffRequest request, HttpSession session) {
        return staffService.addStaff(request,session);
    }

    }
