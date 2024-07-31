package com.exercise.RLMarket.DTOs.creationDTOs;

import com.exercise.RLMarket.enteties.enums.Role;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class UserCreationDTO {
    int id;
    String email;
    String epicGames;
    String password;
    Role role;
}
