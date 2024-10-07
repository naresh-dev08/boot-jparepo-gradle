package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name = "JPA_OTM_PHONENUMBER_TAB")
@RequiredArgsConstructor
public class PhoneNumber implements Serializable {
	
	
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "REGNO_SEQ", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer  regno;
	
	@Column(nullable = false, unique = true)
	@NonNull
	private Long phoneNumber;
	
	@Column(length = 20)
	@NonNull
	private String numberType;
	
	@Column(length = 20)
	@NonNull
	private String provider;
	
	public PhoneNumber() {
		System.out.println("PhoneNumber::: 0 Param Constructor:: "+this.getClass());
	}
	
	
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CID")
	private Customer customer;

	
	@Override
	public String toString() {
		return "PhoneNumber [regno=" + regno + ", phoneNumber=" + phoneNumber + ", numberType=" + numberType
				+ ", provider=" + provider + "]";
	}
	
	
	

}
