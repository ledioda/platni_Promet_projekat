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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.iktpreobuka.platni_promet.security.Views;


@Entity
@Table(name = "BANK")
public class BankEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Views.Admin.class)
	private Integer id;
	
	@JsonView(Views.Public.class)
	private String name;
	
	@JsonView(Views.Public.class)
	private String pib;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name = "address")
	@JsonView(Views.Public.class)
	private AddressEntity address;
	
	@Version
	private Integer version;
	
	@JsonBackReference
	@OneToMany(mappedBy = "bank", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JsonView(Views.Admin.class)
	private List<ClientEntity> clients = new ArrayList<>();
	
	/*@JsonBackReference
	@OneToMany(mappedBy = "bank", fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JsonView(Views.Admin.class)
	private List<AccountEntity> accounts = new ArrayList<>();*/
	
	
	public BankEntity() {
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

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
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

	public List<ClientEntity> getClients() {
		return clients;
	}

	public void setClients(List<ClientEntity> clients) {
		this.clients = clients;
	}

	/*public List<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountEntity> accounts) {
		this.accounts = accounts;
	}*/
	
	public BankEntity(String name, String pib, AddressEntity address) {
		super();
		this.name = name;
		this.pib = pib;
		this.address = address;
	}
	
}


