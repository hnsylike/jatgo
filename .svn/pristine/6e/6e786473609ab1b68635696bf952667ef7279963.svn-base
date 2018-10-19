package com.kafang.atgo.persistence.db.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity(name = "AG_ACCOUNT")
public class AgAccount {

    public interface TableColumn {

        String id = "id";
        String AccountID = "AccountID";
        String IsActive = "IsActive";
        String ClientID = "ClientID";
        String StrategyID = "StrategyID";
        String EnableBalance = "EnableBalance";
        String CreditBalance = "CreditBalance";
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AccountID", nullable = true)
    private int accountId;

    @Column(name = "IsActive", nullable = false)
    private boolean isActive;

    @Column(name = "ClientID", nullable = true)
    private int clientId;

    @Column(name = "StrategyID", nullable = true)
    private int strategyId;

    @Column(name = "EnableBalance", nullable = true)
    private double enableBalance;

    @Column(name = "CreditBalance", nullable = true)
    private double creditBalance;

}
