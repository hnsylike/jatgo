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
@Entity(name="AG_STRATEGY")
public class AgStrategy {
	
	public interface TableColumn {
		
		String id = "id";
		String StrategyID = "StrategyID";
		String StrategyName = "StrategyName";
	}
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "StrategyID", length = 100, nullable = true)
	private Long strategyId;

	@Column(name = "StrategyName", length = 255, nullable = true)
	private String strategyName;
	
}
