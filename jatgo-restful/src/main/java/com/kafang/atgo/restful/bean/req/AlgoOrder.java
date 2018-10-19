package com.kafang.atgo.restful.bean.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by User on 2018/10/12.
 */
@Getter
@Setter
@ToString
public class AlgoOrder {

    private String OrderType;

    private int userid;

    private int id;
    private int isReview;
    private Date reviewTime;
    private Date EffectiveTime;
    private Date ExpireTime;
    private int limitAction;
    private int afterAction;
    private Long ClOrdID;
    private int ClientID;
    private int AccountID;
    private String Symbol;
    private int SecurityType;
    private int SecurityExchange;
    private String Side;
    private Date TransactTime;
    private int OrderQty;
    private String OrdType;
    private Double Price;

}
