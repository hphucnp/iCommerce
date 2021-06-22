package com.phuc.icommerce.data.repository;

import com.phuc.icommerce.data.entity.user.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}