//package com.example.CapstoneProject.entity;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
//import jakarta.validation.constraints.Null;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "invoices")
//@Data
//@NoArgsConstructor
//public class Invoice {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getClientName() {
//		return clientName;
//	}
//
//	public void setClientName(String clientName) {
//		this.clientName = clientName;
//	}
//
//	public double getAmount() {
//		return amount;
//	}
//
//	public void setAmount(double amount) {
//		this.amount = amount;
//	}
//
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	@Null
//    @jakarta.validation.constraints.Size(min = 5)
//    private String clientName;
//
//    @Null
//    @jakarta.validation.constraints.Min(value = 3000)
//    private double amount;
//
//    @Null
//    @jakarta.validation.constraints.Past
//    @Temporal(TemporalType.DATE)
//    private Date date;
//
//    private String description;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    // Constructors, getters, and setters
//}



package com.example.CapstoneProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String clientName;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(int i) {
		this.amount = (double) i;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "amount")
    private Double amount;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public Object getUser() {
		// TODO Auto-generated method stub
		return null;
	}

    // Getters and setters
}
