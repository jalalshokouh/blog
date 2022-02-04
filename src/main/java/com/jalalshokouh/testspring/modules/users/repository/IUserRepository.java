package com.jalalshokouh.testspring.modules.users.repository;

import com.jalalshokouh.testspring.modules.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<Users , Long> {
}
