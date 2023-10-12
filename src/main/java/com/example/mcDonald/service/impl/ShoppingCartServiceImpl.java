package com.example.mcDonald.service.impl;

import com.example.mcDonald.constants.RtnCode;
import com.example.mcDonald.entity.Menu;
import com.example.mcDonald.entity.ShoppingCart;
import com.example.mcDonald.repository.MenuDao;
import com.example.mcDonald.repository.ShoppingCartDao;
import com.example.mcDonald.service.ifs.ShoppingCartService;
import com.example.mcDonald.vo.request.AddCartRequest;
import com.example.mcDonald.vo.response.AddCartResponse;
import com.example.mcDonald.vo.response.GetShoppingCarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;
    @Autowired
    private MenuDao menuDao;
    @Override
    public AddCartResponse addCart(AddCartRequest request, HttpSession session) {
        String loginAccount = (String) session.getAttribute("account");
        String loginPwd = (String) session.getAttribute("pwd");

        if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPwd)) {
            return new AddCartResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }

        int menuId = request.getMenuId();
        int qty = request.getQty();
        if (!StringUtils.hasText(loginAccount) || menuId < 0 || qty < 0 ){
            return new AddCartResponse(RtnCode.DATA_ERROR.getMessage());
        }
        Optional<Menu> menu = menuDao.findById(menuId);
        if (menu.isEmpty()){
            return new AddCartResponse(RtnCode.NOT_FOUND.getMessage());
        }
        if (menu.get().getInventory() < qty){
            return new AddCartResponse("庫存不夠");
        }
        int insertResult = shoppingCartDao.insertCartWhereNotExists(loginAccount,menuId,qty);
        if (insertResult == 0){
            ShoppingCart cart = shoppingCartDao.findByUserIdAndMenuId(loginAccount,menuId);
            if (cart == null) {
                return new AddCartResponse("購物車內找不到此人");
            }
            int updateResult = shoppingCartDao.updateMenu(qty+ cart.getQty(),loginAccount,menuId);{
                if(updateResult == 0 ){
                    return new AddCartResponse("馨曾商品至購物車錯誤");
                }
            }
        }
        return new AddCartResponse(RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public GetShoppingCarResponse getShoppingCar(HttpSession session) {
        String loginAccount = (String) session.getAttribute("account");
        String loginPwd = (String) session.getAttribute("pwd");

        if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPwd)) {
            return new GetShoppingCarResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        return new GetShoppingCarResponse(shoppingCartDao.getCommodityFromShoppingCar(loginAccount),RtnCode.SUCCESSFUL.getMessage());
    }
}
