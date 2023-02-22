package com.example.springsecurity.dto;

import com.example.springsecurity.domain.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String userEmail;
    private String userPassword;
    private Role role;

    @Builder
    public UserDTO(Long id, String userEmail, String userPassword, Role role){
        this.id = id;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.role = role;
    }


}
