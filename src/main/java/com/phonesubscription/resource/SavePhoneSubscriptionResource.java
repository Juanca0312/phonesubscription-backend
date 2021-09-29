package com.phonesubscription.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class SavePhoneSubscriptionResource {
    @NotNull
    @NotBlank
    private Date month;

    @NotBlank
    @NotNull
    private String network_technology;

    @NotNull
    @NotBlank
    private String plan_type;

    @NotNull
    @NotBlank
    private int subscriptions;
}
