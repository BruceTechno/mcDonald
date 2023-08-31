package com.example.mcDonald.repository;

import com.example.mcDonald.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StaffDao extends JpaRepository<Staff,Integer> {
    Staff findByAccount (String account);

    Staff findByAccountAndPwdAndActive (String account , String pwd ,Boolean active) ;

    @Transactional
    @Modifying
    @Query(value = "insert into staff(account,pwd,name,phone,mail,active,identity)" +
            " select :inputAccount, :inputPwd, :inputName, :inputPhone, :inputMail , :active ,:identity" +
            " where not exists (select 1 from staff where account = :inputAccount)" ,nativeQuery = true)
    public int insertStaffInfoWhereNotExists(
            @Param("inputAccount")String inputAccount,
            @Param("inputPwd")String inputPwd,
            @Param("inputName")String inputName,
            @Param("inputPhone")String Phone,
            @Param("inputMail")String mail,
            @Param("active")Boolean active,
            @Param("identity")Integer identity);


}
