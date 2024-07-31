package com.exercise.RLMarket.services.impl;

import com.exercise.RLMarket.DTOs.UserDTO;
import com.exercise.RLMarket.DTOs.creationDTOs.UserCreationDTO;
import com.exercise.RLMarket.enteties.User;
import com.exercise.RLMarket.mappers.UserMapper;
import com.exercise.RLMarket.repositories.UserRepository;
import com.exercise.RLMarket.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    @Override
    public void createUser(UserCreationDTO user) {
        userRepository.save(UserMapper.userCreationDTOtoUser(user));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).get();
    }

    @Override
    public UserDTO getUserById(int id) {
        return UserMapper.userToUserDTO(userRepository.getReferenceById(id));
    }
}
