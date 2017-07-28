package com.iktpreobuka.platni_promet.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.platni_promet.security.Views;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Views.Admin.class)
	private Integer id;

	@JsonView(Views.Client.class)
	private Long accountNumber;

	@JsonView(Views.Client.class)
	private Double balance;

	/*
	 * @JsonManagedReference
	 * 
	 * @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "bank")
	 * 
	 * @JsonView(Views.Client.class) private BankEntity bank;
	 */

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "client")
	@JsonView(Views.Client.class)
	private ClientEntity client;

	@Transient
	@Version
	private Integer version;

	@JsonBackReference
	@OneToMany(mappedBy = "accountRecipient", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JsonView(Views.Client.class)
	private List<TransactionEntity> recipientTransactions = new ArrayList<>();

	@JsonBackReference
	@OneToMany(mappedBy = "accountSender", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JsonView(Views.Client.class)
	private List<TransactionEntity> senderTransactions = new ArrayList<>();

	public AccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/*
	 * public BankEntity getBank() { return bank; }
	 * 
	 * public void setBank(BankEntity bank) { this.bank = bank; }
	 */
	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<TransactionEntity> getRecipientTransactions() {
		return recipientTransactions;
	}

	public void setRecipientTransactions(List<TransactionEntity> recipientTransactions) {
		this.recipientTransactions = recipientTransactions;
	}

	public List<TransactionEntity> getSenderTransactions() {
		return senderTransactions;
	}

	public void setSenderTransactions(List<TransactionEntity> senderTransactions) {
		this.senderTransactions = senderTransactions;
	}

	public AccountEntity(Long accountNumber, Double balance, ClientEntity client) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.client = client;
	}
}