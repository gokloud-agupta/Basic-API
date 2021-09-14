package com.gokloud.tdd.serviceimpl;

import com.gokloud.tdd.dao.UsersDao;
import com.gokloud.tdd.dto.SaveUserDto;
import com.gokloud.tdd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokloud.tdd.constants.MessageConstants;
import com.gokloud.tdd.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl extends MessageConstants implements UserService {

	@Autowired
	public UsersDao userDao;

	@Override
	public User getUser(Long userId) {
		Optional<User> userDetail=userDao.findById(userId);
		if(userDetail.isPresent()){
			return userDetail.get();
		}
		return  null;


//		Optional<User> userDetail=userDao.findByEmail("");
//		if(userDetail.isPresent()){
//		return userDetail.get();
//		}
	}

	@Override
	public User saveUser(SaveUserDto userDto) {
		Optional<User> isUserExist = userDao.findByEmail(userDto.getEmail());
		if(isUserExist.isPresent()){
			//User already exist by this email
			return  null;
		}
		User user = new User(userDto.getEmail(),userDto.getPhoneNo(),userDto.getFirstName(),userDto.getLastName());
		return userDao.save(user);
	}

	@Override
	public User updateUser(SaveUserDto userDto, Long userId) {
		Optional<User> user=userDao.findById(userId);
		if(user.isPresent()){
			user.get().setEmail(userDto.getEmail());
			user.get().setPhoneNo(userDto.getPhoneNo());
			user.get().setFirstName(userDto.getFirstName());
			user.get().setLastName(userDto.getLastName());
			return user.get();
		}else{
			return null;
		}
	}

	@Override
	public User get() {
		User user = new User("ad","sss","shkdvbcln","hycv");
		return user;
	}
}
