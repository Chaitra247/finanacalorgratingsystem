package com.financialorgratingsystem;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.financialorgratingsystem.entity.User;
import com.financialorgratingsystem.exception.NotFoundException;
import com.financialorgratingsystem.exception.UserNotFoundException;
import com.financialorgratingsystem.repository.UserRepo;
import com.financialorgratingsystem.service.UserService;

@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService userService;

	@MockBean
	UserRepo userRepo;

	User u1;

	@BeforeEach
	void setUp() throws Exception {

	u1= new User();
		u1.setUserId(1);
		u1.setUserName("Chaitra R");
		u1.setContactNumber("5678998899");
		u1.setPassword("cg21");
		u1.setEmailId("adfhg@gmail.com");
		u1.setFirstName("Chai");
		u1.setLastName("R");
		u1.setRole("user");
	}

	@Test
	void testAddUser() {
		Mockito.when(userRepo.save(u1)).thenReturn(u1);
		assertThat(userService.addUser(u1)).isEqualTo(u1);
	}

	@Test
	void testgetUserById() throws UserNotFoundException {

		Mockito.when(userRepo.existsById(u1.getUserId())).thenReturn(true);
		Mockito.when(userRepo.getById(u1.getUserId())).thenReturn(u1);
		assertThat(userService.getUserById(u1.getUserId())).isEqualTo(u1);

	}
	@Test
	void testLoginService() throws NotFoundException {
	Mockito.when(userRepo.existsById(u1.getUserId())).thenReturn(true);
	Mockito.when(userRepo.getPassword(u1.getUserId())).thenReturn(u1.getPassword());
	Mockito.when(userRepo.getById(u1.getUserId())).thenReturn(u1);
	assertThat(userService.login(u1.getUserId(), u1.getPassword())).isEqualTo(u1.getRole());
	}
	
	@Test
	void testViewUsers() throws NotFoundException {
	User u2 = new User();
	u2.setUserId(1);
	u2.setUserName("Chaitra");
	u2.setContactNumber("5678998899");
	u2.setRole("Administrator");
	u2.setEmailId("adfhg@gmail.com");
	u2.setFirstName("Chai");
	u2.setLastName("R");
	u2.setPassword("ch2442");
	List<User> userList = new ArrayList<>();
	userList.add(u1);
	userList.add(u2);
	Mockito.when(userRepo.findAll()).thenReturn(userList);
	assertThat(userService.viewUser()).isEqualTo(userList);
	}


}
