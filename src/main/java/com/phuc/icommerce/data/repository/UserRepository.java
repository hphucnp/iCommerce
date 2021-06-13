package com.phuc.icommerce.data.repository;

import com.phuc.icommerce.data.entity.user.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
}