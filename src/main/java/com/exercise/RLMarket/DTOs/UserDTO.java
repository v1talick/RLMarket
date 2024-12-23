package com.exercise.RLMarket.DTOs;

import com.exercise.RLMarket.enteties.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Value
@AllArgsConstructor
public class UserDTO {
    int id;
    String email;
    String epicGames;
    Role role;
}
