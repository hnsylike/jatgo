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
@Entity(name="AG_CUSTOMER")
public class AgCustomer {
	
	public interface TableColumn {
		String id = "id";
		String CustomerID = "CustomerID";
		String CustomerName = "CustomerName";
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CustomerID", length = 100, nullable = true)
	private int customerId;

	@Column(name = "CustomerName", length = 255, nullable = true)
	private String customerName;



}
