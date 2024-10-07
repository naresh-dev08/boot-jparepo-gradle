package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;



//@Table(name = "BANK_ACCOUNT_TAB")
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount {

	@Id
	@Column(name = "ACCNO")
	@SequenceGenerator(name = "gen1", sequenceName = "ACCNO_SEQ", initialValue = 10000000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Long acNo;
	
	@Column(length = 20)
	@NonNull
	private String holderName;
	
	@NonNull
	private Double balance;
	
	@NonNull
	private Long mobileNo;
	
	@Version
	private Integer updateCount;
	
	@CreationTimestamp
	private LocalDateTime creationTime;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdationTime;
}
