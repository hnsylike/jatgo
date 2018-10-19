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
@Entity(name="AG_STRATEGY_PARAM_L2")
public class AgStrategyParamL2 {
	public interface TableColumn {
		String id = "id";
		String StrategyID = "StrategyID";
		String CustomerID="CustomerID";
		String Name = "Name";
		String Type = "Type";
		String Value = "Value";
	}
	
	@Id
	@Column(name="ID")			
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "StrategyID", length = 100, nullable = true)
	private Long strategyId;

	@Column(name="CustomerID",length=100,nullable=true)
	private Long customerId;
	
	@Column(name = "Name", length = 255, nullable = true)
	private String name;
	
	@Column(name = "Type", length = 100, nullable = true)
	private Long type;

	@Column(name = "Value", length = 255, nullable = true)
	private String value;

}
