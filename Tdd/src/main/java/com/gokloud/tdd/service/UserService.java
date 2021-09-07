package com.gokloud.tdd.service;

import com.gokloud.tdd.dto.SaveUserDto;
import com.gokloud.tdd.model.User;

public interface UserService {

    User getUser(Long userId);

    User saveUser(SaveUserDto userDto);

    User updateUser(SaveUserDto userDto, Long userId);
}
