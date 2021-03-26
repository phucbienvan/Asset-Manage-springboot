package com.website.qlts.service;

import com.website.qlts.dto.UserRegistrationDto;
import com.website.qlts.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {
    Users save(UserRegistrationDto userRegistrationDto);
}
