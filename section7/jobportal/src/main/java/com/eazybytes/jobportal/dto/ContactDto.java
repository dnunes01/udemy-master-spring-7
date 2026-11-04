package com.eazybytes.jobportal.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.eazybytes.jobportal.entity.Contact}
 */
@Value
public class ContactDto implements Serializable {
    String email;
    String message;
    String name;
    String subject;
    String userType;
}