package com.mms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="First Name cannot be blank")
    @Column(name = "first_name", nullable = false)
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;
}
