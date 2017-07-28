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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.platni_promet.security.Views;


@Entity
@Table(name = "CLIENT")
public class ClientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Views.Admin.class)
	private Integer id;
	
	@JsonView(Views.Public.class)
	private String name;
	
	@JsonView(Views.Public.class)
	private String surname;
	
	@Transient
	@JsonIgnore
	private String password;
	
	@JsonView(Views.Client.class)
	private String email;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "address")
	@JsonView(Views.Client.class)
	private AddressEntity address;
	
	@Version
	private Integer version;
	
	@JsonBackReference
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JsonView(Views.Client.class)
	private List<AccountEntity> accounts = new ArrayList<>();
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "bank")
	@JsonView(Views.Client.class)
	private BankEntity bank;
	
	/*@JsonBackReference
	@OneToMany(mappedBy = "clientRecipient", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JsonView(Views.Client.class)
	private List<TransactionEntity> recipientTransactions = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "clientSender", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JsonView(Views.Client.class)
	private List<TransactionEntity> senderTransactions = new ArrayList<>();*/
	
	
	public ClientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	public BankEntity getBank() {
		return bank;
	}

	public void setBank(BankEntity bank) {
		this.bank = bank;
	}

	/*public List<TransactionEntity> getRecipientTransactions() {
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
	}*/

	public ClientEntity(String name, String surname, String password, String email, AddressEntity address, BankEntity bank) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.email = email;
		this.address = address;
		this.bank = bank;
	}
}