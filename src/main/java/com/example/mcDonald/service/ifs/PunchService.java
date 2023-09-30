package com.example.mcDonald.service.ifs;

import com.example.mcDonald.vo.response.PunchInResponse;
import com.example.mcDonald.vo.response.PunchOutResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface PunchService {
    public PunchInResponse punchIn (HttpSession session , HttpServletRequest httpServletRequest);
    public PunchInResponse punchOut (HttpSession session , HttpServletRequest httpServletRequest);
}
