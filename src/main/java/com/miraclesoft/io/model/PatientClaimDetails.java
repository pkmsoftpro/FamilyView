package com.miraclesoft.io.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENT_CLAIM_DETAILS")
public class PatientClaimDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CLAIM_ID")
	private int claimId;
	@Column(name="PID")
	private int pId;
	@Column(name="PHY_ID")
	private int phyId;
	@Column(name="TOTAL_AMOUNT")
	private int totalAmount;
	@Column(name="PAID_AMOUNT")
	private int paidAmount;
	@Column(name="DATE")
	private String date;
	@Column(name="HOSPITAL")
	private String hospital;
}
