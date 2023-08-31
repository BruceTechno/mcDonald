//package com.example.mcDonald.service.impl;
//
//import com.example.mcDonald.entity.Staff;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Collections;
//
//@Component
//public class StaffDetails implements UserDetails {
//
//    private Staff staff;
//
//    public StaffDetails() {
//    }
//
//    public StaffDetails(Staff staff) {
//        this.staff = staff;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        String identity = Integer.toString(staff.getIdentity());
//
//        return Collections.singleton(new SimpleGrantedAuthority(identity));
//    }
//
//    @Override
//    public String getPassword() {
//        return staff.getPwd();
//    }
//
//    @Override
//    public String getUsername() {
//        return staff.getAccount();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
