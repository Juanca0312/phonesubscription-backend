package com.phonesubscription.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class PhoneSubscriptionResource {
    private Long id;
    private Date month;
    private String network_technology;
    private String plan_type;
    private int subscriptions;
}
