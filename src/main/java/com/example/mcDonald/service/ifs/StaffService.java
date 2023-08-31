package com.example.mcDonald.service.ifs;

import com.example.mcDonald.vo.request.AddMenuRequest;
import com.example.mcDonald.vo.request.AddStaffRequest;
import com.example.mcDonald.vo.request.LoginRequest;
import com.example.mcDonald.vo.response.AddMenuResponse;
import com.example.mcDonald.vo.response.AddStaffResponse;
import com.example.mcDonald.vo.response.LoginResponse;
import com.mysql.cj.log.Log;

import javax.servlet.http.HttpSession;

public interface StaffService {
    public AddStaffResponse addStaff (AddStaffRequest request , HttpSession session);

    public LoginResponse login (LoginRequest request);



}
