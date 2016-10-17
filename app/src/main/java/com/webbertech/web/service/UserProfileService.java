package com.webbertech.web.service;

import java.util.List;

import com.webbertech.web.model.UserProfile;
 
public interface UserProfileService {
 
    UserProfile findById(int id);
 
    UserProfile findByType(String type);
     
    List<UserProfile> findAll();
     
}