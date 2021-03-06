package com.kafang.atgo.restful.entity;

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
@Entity(name="WS_USER_CUSTOMER_MP")
public class WsUserCustomerMp {
	public interface TableColumn {
		String Id = "Id";
		String UserID = "UserID";
		String CustomerID = "CustomerID";
	}
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "UserID", length = 100, nullable = true)
	private long userId;
	
	@Column(name = "CustomerID", length = 100, nullable = true)
	private long customerId;

}
