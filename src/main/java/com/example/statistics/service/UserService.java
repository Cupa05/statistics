package com.example.statistics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.statistics.dto.UserDto;
import com.example.statistics.entity.User;
import com.example.statistics.exception.UserAlreadyExistsException;
import com.example.statistics.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserDto userDto) {
        User user = setUser(userDto);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Ez egy olyan végpont ami ID alapján visszaad egy db persont az adatbázisból
     * 
     * @param id
     *            person azonosítója
     * @return person entityvel
     */
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserAlreadyExistsException("Nincs ilyen person azonosító."));
    }

    public void updateUserById(Long id, UserDto userDto) {
        User currentUser = getUserById(id);

        currentUser.setName(userDto.getName());

        currentUser.setBirthDate(userDto.getBirthDate());
        userRepository.save(currentUser);
    }

    private User setUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setBirthDate(userDto.getBirthDate());
        user.setPresentValue(0L);
        return user;
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
