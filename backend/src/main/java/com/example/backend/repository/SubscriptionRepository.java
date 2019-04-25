package com.example.backend.repository;

import com.example.backend.entity.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {

    Optional<Subscription> findByUserId(int id);

}
