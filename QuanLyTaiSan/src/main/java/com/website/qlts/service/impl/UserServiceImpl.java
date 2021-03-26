package com.website.qlts.service.impl;

import com.website.qlts.dto.UserRegistrationDto;
import com.website.qlts.entity.Role;
import com.website.qlts.entity.Users;
import com.website.qlts.repository.UserRepository;
import com.website.qlts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public Users save(UserRegistrationDto userRegistrationDto) {
        Users users = new Users(userRegistrationDto.getUserName(), bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()), Arrays.asList(new Role("USER")));
        return userRepository.save(users);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = userRepository.findByName("admin2").orElse(null);
        if (users == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new User(users.getUserName(), users.getPassWord(), grantedAuthorities(users.getRoles()));
    }

    private Collection<? extends GrantedAuthority> grantedAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

    }
}
