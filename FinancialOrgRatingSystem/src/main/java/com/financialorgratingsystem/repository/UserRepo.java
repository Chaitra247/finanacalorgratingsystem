package com.financialorgratingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.financialorgratingsystem.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	@Query("Select u from User u where u.userId=?1 and u.password=?2")
	public User login(int userId, String password);

	@Query("select u.password from User u where userId=:id")
	public String getPassword(@Param("id") int id);
}
