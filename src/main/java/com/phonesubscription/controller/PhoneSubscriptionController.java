package com.phonesubscription.controller;

import com.phonesubscription.model.PhoneSubscription;
import com.phonesubscription.resource.PhoneSubscriptionResource;
import com.phonesubscription.resource.SavePhoneSubscriptionResource;
import com.phonesubscription.service.PhoneSubscriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PhoneSubscriptionController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PhoneSubscriptionService phoneSubscriptionService;

    @GetMapping("/phoneSubscriptions")
    public List<PhoneSubscription> getAllPhoneSubscriptions(){
        return phoneSubscriptionService.getAllPhoneSubscriptions();
    }

    @PostMapping("/phoneSubscriptions")
    public PhoneSubscriptionResource createPhoneSubscription(@Valid @RequestBody SavePhoneSubscriptionResource resource){
        PhoneSubscription phoneSubscription = convertToEntity(resource);
        return convertToResource(phoneSubscriptionService.createPhoneSubscription(phoneSubscription));
    }

    @PutMapping("/phoneSubscriptions/{id}")
    public PhoneSubscriptionResource updateUser(@PathVariable(name = "id") Long phoneSubscriptionId, @Valid @RequestBody SavePhoneSubscriptionResource resource){
        PhoneSubscription phoneSubscription = convertToEntity(resource);
        return convertToResource(phoneSubscriptionService.updatePhoneSubscription(phoneSubscriptionId, phoneSubscription));
    }

    @DeleteMapping("/phoneSubscriptions/{id}")
    public ResponseEntity<?> deletePhoneSubscription(@PathVariable(name = "id") Long phoneSubscriptionId){
        return phoneSubscriptionService.deletePhoneSubscription(phoneSubscriptionId);
    }

    private PhoneSubscription convertToEntity(SavePhoneSubscriptionResource resource) { return mapper.map(resource, PhoneSubscription.class); }

    private PhoneSubscriptionResource convertToResource(PhoneSubscription entity) { return mapper.map(entity, PhoneSubscriptionResource.class); }
}
