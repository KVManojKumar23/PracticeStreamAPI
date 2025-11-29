package com.Streams.PracticeStreamAPI.DTO;

import com.Streams.PracticeStreamAPI.domain.enums.Gender;
import com.Streams.PracticeStreamAPI.domain.enums.Role;
import com.Streams.PracticeStreamAPI.domain.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private int id;
    private String name;
    private String userName;
    private String password;
    private Role role;
    private Status status;
    private Gender gender;

}
