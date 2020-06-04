package com.springmvc.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Component
@Table(name = "account_info")
public class AccountInformation implements Serializable {
    @Column(name = "fullName")
    private String fullName;
    enum Gender{
        MALE(1),FEMALE(2),OTHER(0);
        private int value;

        Gender(int value) {
            this.value = value;
        }
    }
    private Integer gender;
    private String phone;
    private String address;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String introduction;
    @Id
    @OneToOne(fetch = FetchType.EAGER)
    private Account account;
}
