package com.example.mcDonald.repository;

import com.example.mcDonald.entity.Menu;
import com.example.mcDonald.vo.response.SearchMenuResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MenuDao extends JpaRepository<Menu,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into menu(name,price,serve_time,description,img)" +
            " select :name, :price, :serve_time, :description, :img" +
            " where not exists (select 1 from menu where name = :name)" ,nativeQuery = true)
    public int insertMenuWhereNotExists(
            @Param("name")String name,
            @Param("price")int price,
            @Param("serve_time")int serveTime,
            @Param("description")String description,
            @Param("img")String img);

    @Transactional
    @Modifying
    @Query(value = "update menu m set m.status = :status "  +
            " where m.id = :id ",nativeQuery = true)
    public int updateMenu(
            @Param("status") int status,
            @Param("id")int id);

    @Transactional
    @Modifying
    @Query(value = "select * from menu m " +
            " where m.name like concat('%',:inputKeyword,'%') or" +
            " m.category like concat('%',:inputKeyword,'%')",nativeQuery = true)
    public List<Menu> distinctSearchMenu (@Param("inputKeyword")String nameOrCategory);

    @Transactional
    @Modifying
    @Query(value = "select * from menu m  where sales order by sales DESC limit :limitNum",nativeQuery = true)
    public List<Menu> searchTopMenu(@Param("limitNum")int limitNum);
}
