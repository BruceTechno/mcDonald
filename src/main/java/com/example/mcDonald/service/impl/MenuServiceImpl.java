package com.example.mcDonald.service.impl;

import com.example.mcDonald.constants.RtnCode;
import com.example.mcDonald.entity.Menu;
import com.example.mcDonald.entity.Staff;
import com.example.mcDonald.repository.MenuDao;
import com.example.mcDonald.repository.StaffDao;
import com.example.mcDonald.service.ifs.MenuService;
import com.example.mcDonald.vo.request.AddMenuRequest;
import com.example.mcDonald.vo.request.DeleteMenuRequest;
import com.example.mcDonald.vo.request.SearchMenuRequest;
import com.example.mcDonald.vo.response.AddMenuResponse;
import com.example.mcDonald.vo.response.AddStaffResponse;
import com.example.mcDonald.vo.response.DeleteMenuResponse;
import com.example.mcDonald.vo.response.SearchMenuResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private StaffDao staffDao;

    @Override
    public AddMenuResponse addMenu(AddMenuRequest request, HttpSession session) {

        String loginAccount = (String) session.getAttribute("account");
        String loginPwd = (String) session.getAttribute("pwd");
        if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPwd)) {
            return new AddMenuResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        Staff staff = staffDao.findByAccount(loginAccount);
        if (staff.getIdentity() != 3) {
            return new AddMenuResponse("unauthorized");
        }
        String name = request.getName();
        int price = request.getPrice();
        int serveTime = request.getServeTime();
        String description = request.getDescription();
        String img = request.getImg();

        if (!StringUtils.hasText(name) || !StringUtils.hasText(description) || !StringUtils.hasText(img)){
            return new AddMenuResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        if (price < 0 || serveTime < 0 || serveTime > 2 ){
            return new AddMenuResponse(RtnCode.DATA_ERROR.getMessage());
        }

        int result = menuDao.insertMenuWhereNotExists(name,price,serveTime,description,img);
        if (result == 0 ){
            return new AddMenuResponse(RtnCode.DATA_ERROR.getMessage());
        }
        Menu insertMenu = new Menu(name,price,serveTime,description,img);

        return new AddMenuResponse(RtnCode.SUCCESSFUL.getMessage(),insertMenu);
    }

    @Override
    public DeleteMenuResponse deleteMenu(DeleteMenuRequest request, HttpSession session) {
        String loginAccount = (String) session.getAttribute("account");
        String loginPwd = (String) session.getAttribute("pwd");
        if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPwd)) {
            return new DeleteMenuResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        Staff staff = staffDao.findByAccount(loginAccount);
        if (staff.getIdentity() != 3) {
            return new DeleteMenuResponse("unauthorized");
        }
        int id = request.getId();
        int status = request.getStatus();
//        int result = menuDao.updateMenuStatus(status,id);
//        if (result == 0 ){
//            return new DeleteMenuResponse("update failed");
//        }
        return new DeleteMenuResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public SearchMenuResponse allMenu() {
        return new SearchMenuResponse(menuDao.findAll());
    }

    @Override
    public SearchMenuResponse searchMenuDistinctly(SearchMenuRequest request) {
        String keyword = request.getKeyword();

        List<Menu> result = menuDao.distinctSearchMenu(keyword);
        if (result.isEmpty()){
            return new SearchMenuResponse(RtnCode.NOT_FOUND.getMessage());
        }
        return new SearchMenuResponse(result,RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public SearchMenuResponse searchBestSellingMenu(SearchMenuRequest request) {

        return new SearchMenuResponse(menuDao.searchTopMenu(request.getLimitNum()));
    }
}
