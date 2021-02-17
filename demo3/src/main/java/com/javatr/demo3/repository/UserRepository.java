package com.javatr.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatr.demo3.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsUserByVkn(String vkn);

}
