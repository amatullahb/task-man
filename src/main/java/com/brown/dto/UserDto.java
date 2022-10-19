package com.brown.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    
    private Long id;
    
    @NotEmpty
    private String firstname;
    
    @NotEmpty
    private String lastname;
    
    @NotEmpty(message="Email required.")
    @Email
    private String email;
    
    @NotEmpty(message="Password required.")
    private String password;

}