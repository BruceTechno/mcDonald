package com.example.mcDonald.service.impl;

import com.example.mcDonald.constants.RtnCode;
import com.example.mcDonald.entity.Punch;
import com.example.mcDonald.entity.Staff;
import com.example.mcDonald.repository.PunchDao;
import com.example.mcDonald.repository.StaffDao;
import com.example.mcDonald.service.ifs.PunchService;
import com.example.mcDonald.vo.response.AddStaffResponse;
import com.example.mcDonald.vo.response.PunchInResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PunchServiceImpl implements PunchService {
    private static final String UNKNOWN = "unknown";
    private static final String HEADER_FORWARDED = "x-forwarded-for";
    private static final String HEADER_PROXY = "Proxy-Client-IP";
    private static final String HEADER_WL_PROXY = "WL-Proxy-Client-IP";
    private static final String HEADER_HTTP = "HTTP_CLIENT_IP";
    private static final String HEADER_HTTP_FORWARDED = "HTTP_X_FORWARDED_FOR";
    private static final String LOCAL_IP = "127.0.0.1";
    private static final String LOCAL_HOST = "localhost";

    @Autowired
    private StaffDao staffDao;
    @Autowired
    private PunchDao punchDao;

    @Override
    public PunchInResponse punchIn(HttpSession session, HttpServletRequest httpServletRequest) {
            // 1.員工登入 2.依照員工編號打卡

        String loginAccount = (String) session.getAttribute("account");
        String loginPwd = (String) session.getAttribute("pwd");

        if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPwd)) {
            return new PunchInResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        Staff staff = staffDao.findByAccount(loginAccount);
        if (staff == null){
            return new PunchInResponse("沒此員工");
        }
        int staffId = staff.getId();
        LocalDateTime now = LocalDateTime.now();
        String punchIp = getIpAddr(httpServletRequest);

        Punch punch = new Punch(staffId,now,punchIp);
        punchDao.save(punch);
        return new PunchInResponse(RtnCode.SUCCESSFUL.getMessage(),punch,staff);
    }

    @Override
    public PunchInResponse punchOut(HttpSession session, HttpServletRequest httpServletRequest) {

        String loginAccount = (String) session.getAttribute("account");
        String loginPwd = (String) session.getAttribute("pwd");

        if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPwd)) {
            return new PunchInResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        Staff staff = staffDao.findByAccount(loginAccount);
        if (staff == null){
            return new PunchInResponse("沒此員工");
        }
        int staffId = staff.getId();
        LocalDate date = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        String punchIp = getIpAddr(httpServletRequest);

        int result = punchDao.punchOut(now,punchIp,LocalDate.of(2023,8,30),staffId);
        if (result == 0 ){
            return new PunchInResponse("punch Out Failed");
        }
        Punch punch = new Punch(staffId,now,punchIp);

        return new PunchInResponse(RtnCode.SUCCESSFUL.getMessage(),punch,staff);
    }

    public String getIpAddr(HttpServletRequest httpServletRequest) {
        String ip = httpServletRequest.getHeader(HEADER_FORWARDED);

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getHeader(HEADER_PROXY);
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getHeader(HEADER_WL_PROXY);
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getHeader(HEADER_HTTP);
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getHeader(HEADER_HTTP_FORWARDED);
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = httpServletRequest.getRemoteAddr();
        }

        // 本机访问
        if (LOCAL_IP.equalsIgnoreCase(ip) || LOCAL_HOST.equalsIgnoreCase(ip) || "0:0:0:0:0:0:0:1".equalsIgnoreCase(ip)) {
            // 根据网卡取本机配置的 IP
            try {
                InetAddress localHost = InetAddress.getLocalHost();
                ip = localHost.getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        // 对于通过多个代理的情况，第一个 IP 为客户端真实 IP,多个 IP 按照','分割
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 15) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }
}


