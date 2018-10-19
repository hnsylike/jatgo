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
@Entity(name="AG_STRATEGY_PARAM_L1")
public class AgStrategyParamL1 {
	
	public interface TableColumn {
		String id = "id";
		String AccountID = "AccountID";
		String Name = "Name";
		String Type = "Type";
		String Value = "Value";
	}
	
	@Id
	@Column(name="ID")			
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "AccountID", length = 100, nullable = true)
	private Integer accountId;

	@Column(name = "Name", length = 255, nullable = true)
	private String name;
	
	@Column(name = "Type", length = 100, nullable = true)
	private Long type;

	@Column(name = "Value", length = 255, nullable = true)
	private String value;

}
