package com.phonesubscription.service;

import com.phonesubscription.exception.ResourceNotFoundException;
import com.phonesubscription.model.PhoneSubscription;
import com.phonesubscription.repository.PhoneSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneSubscriptionServiceImpl implements PhoneSubscriptionService{

    @Autowired
    private PhoneSubscriptionRepository phoneSubscriptionRepository;

    @Override
    public List<PhoneSubscription> getAllPhoneSubscriptions() {
        return phoneSubscriptionRepository.findAll();
    }

    @Override
    public PhoneSubscription createPhoneSubscription(PhoneSubscription phoneSubscription) {
        //TODO: validar si ya existe dato con el mismo month, technology y type of plan
        /*
        PhoneSubscription existingPhoneSubscription = userRepository.findByMonth(existingPhoneSubscription.getMonth());
        if(existingPhoneSubscription != null) {
            throw new ResourceAlreadyExistsException("PhoneSubscription", "Date", existingPhoneSubscription.getMonth());
        }
        */

        return phoneSubscriptionRepository.save(phoneSubscription);
    }

    @Override
    public PhoneSubscription updatePhoneSubscription(Long phoneSubscriptionId,PhoneSubscription phoneSubscriptionRequest) {
        PhoneSubscription phoneSubscription = phoneSubscriptionRepository.findById(phoneSubscriptionId).orElseThrow(()-> new ResourceNotFoundException("PhoneSubscription", "Id", phoneSubscriptionId));
        phoneSubscription.setMonth(phoneSubscriptionRequest.getMonth());
        phoneSubscription.setNetwork_technology(phoneSubscriptionRequest.getNetwork_technology());
        phoneSubscription.setPlan_type(phoneSubscriptionRequest.getPlan_type());
        phoneSubscription.setSubscriptions(phoneSubscriptionRequest.getSubscriptions());
        return phoneSubscriptionRepository.save(phoneSubscription);
    }

    @Override
    public ResponseEntity<?> deletePhoneSubscription(Long phoneSubscriptionId) {
        PhoneSubscription phoneSubscription = phoneSubscriptionRepository.findById(phoneSubscriptionId).orElseThrow(() -> new ResourceNotFoundException("PhoneSubscription", "Id", phoneSubscriptionId));
        phoneSubscriptionRepository.delete(phoneSubscription);
        return ResponseEntity.ok().build();
    }
}
