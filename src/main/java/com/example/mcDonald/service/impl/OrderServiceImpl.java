package com.example.mcDonald.service.impl;

import com.example.mcDonald.constants.RtnCode;
import com.example.mcDonald.entity.Menu;
import com.example.mcDonald.entity.Order;
import com.example.mcDonald.repository.MenuDao;
import com.example.mcDonald.repository.OrderDao;
import com.example.mcDonald.service.ifs.OrderService;
import com.example.mcDonald.vo.request.AddOrderRequest;
import com.example.mcDonald.vo.response.AddOrderResponse;
import com.example.mcDonald.vo.response.AddStaffResponse;
import com.example.mcDonald.vo.response.SearchOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private MenuDao menuDao;
    @Override
    public AddOrderResponse addOrder(AddOrderRequest request, HttpSession session) {
        //抓訂單編號 => 新增前先付款 => 付款完訂單成立 =>菜單銷售額 + 1
        String loginAccount = (String) session.getAttribute("account");
        String loginPwd = (String) session.getAttribute("pwd");
        if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPwd)) {
            return new AddOrderResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }

        List<Order> orderList = request.getOrderList();
        int latestOrderId = orderDao.searchMaxOrderId();

//        int latestOrderId = 100;
        for (Order item : orderList){
            // basic input check
            if ( item.getQty() < 1   ){
                return new AddOrderResponse(RtnCode.DATA_ERROR.getMessage());
            }
            Optional<Menu> menu = menuDao.findById(item.getMenuId());
            if (!menu.isPresent()){
                return new AddOrderResponse("無此菜單");
            }
            // inventory check
            if (menu.get().getQty() < item.getQty()){
                return new AddOrderResponse("Inventory not enough");
            }
            // 銷售量++
            menu.get().setSales(menu.get().getSales()+ item.getQty());
            // inventory --
            menu.get().setQty(menu.get().getQty()- item.getQty());
            menuDao.save(menu.get());
            // search the latest order id to set
            item.setOrderId(latestOrderId+1);
            // set user id
            item.setConsumerId(loginAccount);
        }
        orderDao.saveAll(orderList);
        return new AddOrderResponse(RtnCode.SUCCESSFUL.getMessage(),orderList);
    }

    @Override
    public SearchOrderResponse searchOrderByConsumerId(HttpSession session) {
        String loginAccount = (String) session.getAttribute("account");
        String loginPwd = (String) session.getAttribute("pwd");
        if (!StringUtils.hasText(loginAccount) || !StringUtils.hasText(loginPwd)) {
            return new SearchOrderResponse(RtnCode.PLEASE_LOGIN_FIRST.getMessage());
        }
        List<Order> result = orderDao.findAllByConsumerId(loginAccount);
        if (result.isEmpty()){
            return new SearchOrderResponse(RtnCode.NOT_FOUND.getMessage());
        }

        return new SearchOrderResponse(RtnCode.SUCCESSFUL.getMessage(),result);
    }
}
