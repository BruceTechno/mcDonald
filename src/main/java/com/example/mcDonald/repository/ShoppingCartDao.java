package com.example.mcDonald.repository;

import com.example.mcDonald.entity.Menu;
import com.example.mcDonald.entity.ShoppingCart;
import com.example.mcDonald.vo.response.GetShoppingCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShoppingCartDao extends JpaRepository<ShoppingCart,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into shopping_cart(user_id , menu_id ,qty)" +
            " select :user_id , :menu_id, :qty" +
            " where not exists (select 1 from shopping_cart where user_id = :user_id and menu_id = :menu_id)" ,nativeQuery = true)
    public int insertCartWhereNotExists(
            @Param("user_id")String name,
            @Param("menu_id")int price,
            @Param("qty")int serveTime);

    @Transactional
    @Modifying
    @Query(value = "update shopping_cart sc set sc.qty = :qty "  +
            " where sc.user_id = :userId and sc.menu_id = :menuId ",nativeQuery = true)
    public int updateMenu(
            @Param("qty") int qty,
            @Param("userId")String userId,
            @Param("menuId")int menu_id);
    public ShoppingCart findByUserIdAndMenuId(String userId , int menuId);
    @Transactional
    @Modifying
    @Query("select new com.example.mcDonald.vo.response.GetShoppingCarResponse(sc.userId,sc.menuId,sc.qty,m.name,m.category,m.inventory,m.price,m.serveTime,m.description,m.img,m.sales,m.status)" +                                     //
            " from ShoppingCart sc join Menu m  on m.id = sc.menuId" +
            " where sc.userId = :userId")
    public List<GetShoppingCarResponse> getCommodityFromShoppingCar (@Param("userId")String userid);

}
