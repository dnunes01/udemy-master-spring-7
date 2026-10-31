package com.eazybytes.jobportal.dto;

import com.eazybytes.jobportal.entity.Company;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;

import java.math.BigDecimal;
import java.time.Instant;

public record CompanyDto(Long id, String name, String logo, String industry, String size, BigDecimal rating,
                         String locations, Integer founded, String description, Integer employees, String website,
                         Instant createdAt) {

}
