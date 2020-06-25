package com.spring.repository;

import com.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JPAREPOSITORY来完成对数据库的操作
public interface UserRepository extends JpaRepository<User, Integer> {
}
