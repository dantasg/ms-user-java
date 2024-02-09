package com.dtec.ms.user.repositories;

import com.dtec.ms.user.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
