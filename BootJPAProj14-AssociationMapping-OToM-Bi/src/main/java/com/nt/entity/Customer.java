package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_OTM_CUSTOMER_TAB")
@Setter
@Getter
@RequiredArgsConstructor
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	
	@Column(length = 20)
	@NonNull
	private String cname;
	
	@Column(length = 20)
	@NonNull
	private String caddrs;
	
	public Customer() {
		System.out.println("Customer::: 0 Param Constructor:: "+this.getClass());
	}
	
	
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, mappedBy = "customer",fetch = FetchType.LAZY)
	//@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CID")
	private Set<PhoneNumber> phones;  //For One to many association



	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", caddrs=" + caddrs + "]";
	}
	
	
	
}
