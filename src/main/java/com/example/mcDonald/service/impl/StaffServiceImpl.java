package com.example.mcDonald.service.impl;

import com.example.mcDonald.constants.RtnCode;
import com.example.mcDonald.entity.Staff;
import com.example.mcDonald.repository.StaffDao;
import com.example.mcDonald.service.ifs.StaffService;
import com.example.mcDonald.vo.request.AddMenuRequest;
import com.example.mcDonald.vo.request.AddStaffRequest;
import com.example.mcDonald.vo.request.LoginRequest;
import com.example.mcDonald.vo.response.AddMenuResponse;
import com.example.mcDonald.vo.response.AddStaffResponse;
import com.example.mcDonald.vo.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public AddStaffResponse addStaff(AddStaffRequest request, HttpSession session) {
        String loginAccount = (String) session.getAttribute("account");
        String loginPwd = (String) session.getAttribute("pwd");
        if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPwd)) {
            return new AddStaffResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        Staff staff = staffDao.findByAccount(loginAccount);
        if (staff.getIdentity() != 3) {
            return new AddStaffResponse("unauthorized");
        }

        String account = request.getAccount();
        String pwd = request.getPwd();
        String phone = request.getPhone();
        String mail = request.getMail();
        String name = request.getName();
        Boolean active = request.getActive();
        Integer identity = request.getIdentity();

        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd) || !StringUtils.hasText(phone)
                || !StringUtils.hasText(mail) || !StringUtils.hasText(name) || active == null || identity == null) {
            return new AddStaffResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }

        int result = staffDao.insertStaffInfoWhereNotExists(account, pwd, name, phone, mail, active, identity);
        if (result == 0) {
            return new AddStaffResponse("Add Staff fail");
        }
        return new AddStaffResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        String account = request.getAccount();
        String pwd = request.getPwd();

        if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
            return new LoginResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }

        Staff staff = staffDao.findByAccountAndPwdAndActive(account, pwd, true);
        if (staff == null) {
            return new LoginResponse(RtnCode.NOT_FOUND.getMessage());
        }
        return new LoginResponse(staff, RtnCode.SUCCESSFUL.getMessage());
    }


}
