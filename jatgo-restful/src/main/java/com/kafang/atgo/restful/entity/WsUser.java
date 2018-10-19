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
@Entity(name = "WS_USER")
public class WsUser implements SimpleEntity, Cloneable{

	public interface TableColumn {
		String id = "id";
		String userid = "userid";
		String username = "username";
		String password = "password";
		String role = "role";
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "userid", length = 100, nullable = false)
	private Long userid;
	
	@Column(name = "username", length = 32, nullable = false)
	private String username;

	@FastJsonIgnore
	@Column(name = "password", length = 32, nullable = false)
	private String password;

	@Column(name = "role", length = 32, nullable = false)
	private String role;
	
	private long customerId;
	
	private String phone;

    @Override
    public WsUser clone(){
        try {
            return (WsUser)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}