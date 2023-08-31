package com.example.mcDonald.repository;

import com.example.mcDonald.entity.Punch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface PunchDao extends JpaRepository<Punch,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into punch(staff_id,punch_in,punch_in_IP)" +
            " select :staff_id, :punch_in, :punch_in_IP",nativeQuery = true)
    public int punchIn(
            @Param("staff_id")int staffId,
            @Param("punch_in") LocalDateTime punchIn,
            @Param("punch_in_IP")String punchInIp);
    @Transactional
    @Modifying
    @Query(value = "update punch p set p.punch_out = :punchOut , p.punch_out_IP = :punchOutIp "  +
            " where date_format(punch_in,'%Y-%m-%d') = :date and staff_id = :staffId",nativeQuery = true)
    public int punchOut(
            @Param("punchOut")LocalDateTime punchOut,
            @Param("punchOutIp")String ip,
            @Param("date") LocalDate date,
            @Param("staffId")int staffId);
}
