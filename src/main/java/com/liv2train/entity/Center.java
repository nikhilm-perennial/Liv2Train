package com.liv2train.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 40,message = "Center name should be less then 40 characters")
    private String centerName;

    @Length(min = 12,max = 12,message = "Center Code should be 12 characters")
    @Column(unique = true)
    private String centerCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;

    private Integer studentCapacity;

    @ElementCollection
    private List<String> courses;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime createdOn;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "Email should be valid")
    private String contactEmail;

    @Length(min = 10,max = 10,message = "Phone number should be valid")
    @Column(unique = true)
    private String contactPhone;

    public Center(String centerName, String centerCode, Address address, Integer studentCapacity, List<String> courses, String contactEmail, String contactPhone) {
        this.centerName = centerName;
        this.centerCode = centerCode;
        this.address = address;
        this.studentCapacity = studentCapacity;
        this.courses = courses;
        this.createdOn = LocalDateTime.now();
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }
}
