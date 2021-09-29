package com.phonesubscription.service;

import com.phonesubscription.model.PhoneSubscription;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PhoneSubscriptionService {
    List<PhoneSubscription> getAllPhoneSubscriptions();
    PhoneSubscription createPhoneSubscription(PhoneSubscription phoneSubscription);
    PhoneSubscription updatePhoneSubscription(Long phoneSubscriptionId, PhoneSubscription phoneSubscriptionRequest);
    ResponseEntity<?> deletePhoneSubscription(Long phoneSubscriptionId);
}
