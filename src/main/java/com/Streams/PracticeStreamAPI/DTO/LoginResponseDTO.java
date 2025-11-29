package com.Streams.PracticeStreamAPI.DTO;

import com.Streams.PracticeStreamAPI.domain.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDTO {

    private String token;
    private Role role;

}
