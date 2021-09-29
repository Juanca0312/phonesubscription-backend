package com.phonesubscription.repository;

import com.phonesubscription.model.PhoneSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneSubscriptionRepository extends JpaRepository<PhoneSubscription, Long> {
    List<PhoneSubscription> findAll();
}
