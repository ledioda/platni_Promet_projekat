package com.iktpreobuka.platni_promet.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.platni_promet.security.Views;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Views.Admin.class)
	private Long id;

	@JsonView(Views.Client.class)
	private Double amount;

	@JsonView(Views.Client.class)
	private String purpose;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@JsonView(Views.Client.class)
	private Date date;

	/*
	 * @JsonManagedReference
	 * 
	 * @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "clientRecipient")
	 * 
	 * @JsonView(Views.Client.class) private ClientEntity clientRecipient;
	 * 
	 * @JsonManagedReference
	 * 
	 * @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "clientSender")
	 * 
	 * @JsonView(Views.Client.class) private ClientEntity clientSender;
	 */

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "accountRecipient")
	@JsonView(Views.Client.class)
	private AccountEntity accountRecipient;

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "accountSender")
	@JsonView(Views.Client.class)
	private AccountEntity accountSender;

	@Transient
	@Version
	private Integer version;

	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/*
	 * public ClientEntity getClientRecipient() { return clientRecipient; }
	 * 
	 * public void setClientRecipient(ClientEntity clientRecipient) {
	 * this.clientRecipient = clientRecipient; }
	 * 
	 * public ClientEntity getClientSender() { return clientSender; }
	 * 
	 * public void setClientSender(ClientEntity clientSender) {
	 * this.clientSender = clientSender; }
	 */

	public AccountEntity getAccountRecipient() {
		return accountRecipient;
	}

	public void setAccountRecipient(AccountEntity accountRecipient) {
		this.accountRecipient = accountRecipient;
	}

	public AccountEntity getAccountSender() {
		return accountSender;
	}

	public void setAccountSender(AccountEntity accountSender) {
		this.accountSender = accountSender;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public TransactionEntity(Double amount, String purpose, Date date, AccountEntity accountRecipient,
			AccountEntity accountSender) {
		super();
		this.amount = amount;
		this.purpose = purpose;
		this.date = date;
		this.accountRecipient = accountRecipient;
		this.accountSender = accountSender;
	}

}