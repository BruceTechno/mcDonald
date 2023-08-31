package com.example.mcDonald.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "punch")
public class Punch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "staff_id")
    private int staffId;
    @Column(name = "punch_in")
    private LocalDateTime punchIn ;
    @Column(name = "punch_out")
    private LocalDateTime punchOut;
    @Column(name = "punch_in_IP")
    private String punchInIp;
    @Column(name = "punch_out_IP")
    private String punchOutIp;
    @Column(name = "day_off")
    private int dayOff;
//==


    public Punch() {
    }

    public Punch(int staffId, LocalDateTime punchIn, LocalDateTime punchOut, String punchInIp, String punchOutIp, int dayOff) {
        this.staffId = staffId;
        this.punchIn = punchIn;
        this.punchOut = punchOut;
        this.punchInIp = punchInIp;
        this.punchOutIp = punchOutIp;
        this.dayOff = dayOff;
    }

    public Punch(int staffId, LocalDateTime punchIn, String punchInIp) {
        this.staffId = staffId;
        this.punchIn = punchIn;
        this.punchInIp = punchInIp;
    }

    //==

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public LocalDateTime getPunchIn() {
        return punchIn;
    }

    public void setPunchIn(LocalDateTime punchIn) {
        this.punchIn = punchIn;
    }

    public LocalDateTime getPunchOut() {
        return punchOut;
    }

    public void setPunchOut(LocalDateTime punchOut) {
        this.punchOut = punchOut;
    }

    public String getPunchInIp() {
        return punchInIp;
    }

    public void setPunchInIp(String punchInIp) {
        this.punchInIp = punchInIp;
    }

    public String getPunchOutIp() {
        return punchOutIp;
    }

    public void setPunchOutIp(String punchOutIp) {
        this.punchOutIp = punchOutIp;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }
}
