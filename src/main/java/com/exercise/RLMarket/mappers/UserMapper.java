package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.UserDTO;
import com.exercise.RLMarket.enteties.User;

public class UserMapper {
    public static UserDTO userToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .epicGames(user.getEpicGames())
                .role(user.getRole())
                .build();
    }

//    public static User userDTOToUser(UserDTO userDTO) {
//        return User.builder()
//                .build();
//    }
}
