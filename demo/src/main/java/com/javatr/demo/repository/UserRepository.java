package com.javatr.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatr.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsUserByusername(String username);

}
