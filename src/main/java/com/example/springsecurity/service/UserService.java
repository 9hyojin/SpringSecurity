package com.example.springsecurity.service;

import com.example.springsecurity.UserSignup;
import com.example.springsecurity.domain.Role;
import com.example.springsecurity.dto.UserDTO;
import com.example.springsecurity.dto.UserFormDTO;
import com.example.springsecurity.entity.UserEntity;
import com.example.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class UserService implements UserSignup {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDTO createUser(UserFormDTO userFormDTO) {

        if(userRepository.findByUserEmail(userFormDTO.getUserEmail()) != null){
            return null;
        }
        UserEntity userEntity = userRepository.save(UserEntity.builder()
                .userPassword(bCryptPasswordEncoder.encode(userFormDTO.getUserPassword()))
                .userEmail(userFormDTO.getUserEmail())
                .role(Role.USER)
                .build());
        return UserDTO.builder()
                .id(userEntity.getId())
                .userEmail(userEntity.getUserEmail())
                .userPassword(userEntity.getUserPassword())
                .role(userEntity.getRole())
                .build();
    }
}
