package com.fooddelivery.food.repositary;

import com.fooddelivery.food.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // You can add custom query methods here if needed
}
