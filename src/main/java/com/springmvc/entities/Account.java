package com.springmvc.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Component
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 30)
    private  String username;
    @Column(nullable = false, length = 30)
    private  String password;
    @Column(name = "times_login_failed")
    private Integer timesLoginFailed;
    @Column(name = "time_blocked")
    private Date timeBlocked;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public enum Status{
        ACTIVED(1),DEACTIVED(-1);
        private  int value;

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        Status(int value) {
            this.value = value;
        }
    }
    @Column
    private Integer status ;
    @OneToOne(mappedBy = "account",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private com.springmvc.entities.AccountInformation accountInformation;

    public boolean isActive(){
        return this.status== Status.ACTIVED.value;
    }
    public boolean isBeforeNow(){
        return Instant.now().isAfter(timeBlocked.toInstant());
    }
    public Long timeBlockedRemain(){
        Duration duration = Duration.between(Instant.now(),timeBlocked.toInstant());
        return  duration.toMinutes();
    }
}
