package com.upc.sh_joseph.repositories;

import com.upc.sh_joseph.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
