package com.example.mcDonald.repository;

import com.example.mcDonald.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

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

}
