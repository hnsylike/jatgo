package com.kafang.atgo.restful.entity;

import com.kafang.atgo.persistence.db.base.entity.SimpleEntity;
import com.kafang.atgo.restful.annotation.FastJsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity(name = "AG_CLIENT")
public class AgClient implements SimpleEntity,Cloneable {

	public interface TableColumn {

		String id = "id";
		String ClientID = "ClientID";
		String ClientName = "ClientName";
		String Broker = "Broker";
		String CustomerID = "CustomerID";
		String AdaptorType = "AdaptorType";
		String AdaptorUser1 = "AdaptorUser1";
		String AdaptorUser2 = "AdaptorUser2";
		String AdaptorUser3 = "AdaptorUser3";
		String AdaptorPwd1 = "AdaptorPwd1";
		String AdaptorPwd2 = "AdaptorPwd2";
		String AdaptorPwd3 = "AdaptorPwd3";
		String IsCredit = "IsCredit";
	}

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ClientID", length = 100, nullable = true)
	private Integer clientId;

	@Column(name = "ClientName", length = 255, nullable = true)
	private String clientName;

	@Column(name = "Broker", length = 255, nullable = true)
	private String broker;

	@Column(name = "CustomerID", length = 100, nullable = true)
	private Long customerId;

	@Column(name = "AdaptorType", length = 255, nullable = true)
	private String adaptorType;

	@Column(name = "AdaptorUser1", length = 255, nullable = true)
	private String adaptorUser1;

	@Column(name = "AdaptorUser2", length = 255, nullable = true)
	private String adaptorUser2;

	@Column(name = "AdaptorUser3", length = 255, nullable = true)
	private String adaptorUser3;

	@FastJsonIgnore
	@Column(name = "AdaptorPwd1", length = 255, nullable = true)
	private String adaptorPwd1;

	@FastJsonIgnore
	@Column(name = "AdaptorPwd2", length = 255, nullable = true)
	private String adaptorPwd2;

	@FastJsonIgnore
	@Column(name = "AdaptorPwd3", length = 255, nullable = true)
	private String adaptorPwd3;

	@Column(name = "IsCredit", length = 1, nullable = true)
	private int isCredit;

	@Override
	public AgClient clone(){
		try {
			return (AgClient) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
