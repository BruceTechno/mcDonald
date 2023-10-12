package com.example.mcDonald.repository;

import com.example.mcDonald.entity.Order;
import com.example.mcDonald.vo.response.GetMenuFromOrderByConsumerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {

    @Query(value = "select max(order_id) from mcdonald.order_info " ,nativeQuery = true)
    public int searchMaxOrderId();

    public List<Order> findAllByConsumerId(String consumerId);
    @Transactional
    @Modifying
    @Query("select new com.example.mcDonald.vo.response.GetMenuFromOrderByConsumerId(o.id,m.name,o.qty,o.time)" +                                     //
            " from Order o join Menu m  on m.id = o.menuId" +
            " where o.consumerId = :consumerId")
    public List<GetMenuFromOrderByConsumerId> getMenuFromOrderByConsumerId (@Param("consumerId")String consumerId);

}
