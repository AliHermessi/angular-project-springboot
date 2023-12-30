package com.task.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
   
}
