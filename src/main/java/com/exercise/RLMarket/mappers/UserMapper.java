package com.exercise.RLMarket.mappers;

import com.exercise.RLMarket.DTOs.UserDTO;
import com.exercise.RLMarket.DTOs.creationDTOs.UserCreationDTO;
import com.exercise.RLMarket.enteties.User;
import com.exercise.RLMarket.repositories.UserRepository;

public class UserMapper {
    static UserRepository userRepository;

    public static User userDTOtoUser(UserDTO userDTO) {
        return userRepository.findByEmail(userDTO.getEmail()).get();
    }
    public static UserDTO userToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getEmail(), user.getEpicGames(), user.getRole());
    }

    public static User userCreationDTOtoUser(UserCreationDTO userCreationDTO) {
        return User.builder()
                .id(userCreationDTO.getId())
                .role(userCreationDTO.getRole())
                .password(userCreationDTO.getPassword())
                .epicGames(userCreationDTO.getEpicGames())
                .email(userCreationDTO.getEmail())
                .build();
    }
    public static UserCreationDTO userToUserCreationDTO(User user) {
        return new UserCreationDTO(user.getId(), user.getEmail()
        ,user.getEpicGames(), user.getPassword(), user.getRole());
    }
}
