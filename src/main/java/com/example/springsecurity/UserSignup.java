package com.example.springsecurity;

import com.example.springsecurity.dto.UserDTO;
import com.example.springsecurity.dto.UserFormDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserSignup {
    UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException;

    UserDTO createUser(UserFormDTO userFormDTO);
}
