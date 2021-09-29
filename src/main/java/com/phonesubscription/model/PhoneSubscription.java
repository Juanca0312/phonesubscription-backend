package com.phonesubscription.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "phone_subscriptions")
@Data
public class PhoneSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
