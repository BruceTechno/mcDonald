package com.example.mcDonald.controller;

import com.example.mcDonald.service.ifs.PunchService;
import com.example.mcDonald.vo.response.PunchInResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin
public class PunchController {
    @Autowired
    private PunchService punchService;
    @PostMapping(value = "punch_in")
    public PunchInResponse punchIn(HttpSession session, HttpServletRequest httpServletRequest) {
        return punchService.punchIn(session,httpServletRequest);
    }
    @PostMapping(value = "punch_out")
    public PunchInResponse punchOut(HttpSession session, HttpServletRequest httpServletRequest) {
        return punchService.punchOut(session,httpServletRequest);
    }
    }
