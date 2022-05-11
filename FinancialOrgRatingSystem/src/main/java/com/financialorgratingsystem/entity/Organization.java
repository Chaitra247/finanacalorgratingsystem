
package com.financialorgratingsystem.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Organization_tb")
public class Organization implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "organization_Id",length=25)
	private int organizationId;
	@Column(name = "user_Name",length=25)
	private String userName;
	@Column(name = "password",length=25)
	private String password;
	@Column(name = "organization_Name",length=25)
	private String organizationName;
	@Column(name = "organization_Rating",length=25)
	private int organizationRating;
	@Column(name = "email_Id",length=25)
	private String emailId;
	@Column(name = "contact_Number",length=25)
	private String contactNumber;
	@Column(name = "finance_Rating",length=25)
	private int financeRating;

	public Organization() {
	}

	public Organization(int organizationId, String userName, String password, String organizationName,
			int organizationRating, String emailId, String contactNumber, int financeRating) {
		super();
		this.organizationId = organizationId;
		this.userName = userName;
		this.password = password;
		this.organizationName = organizationName;
		this.organizationRating = organizationRating;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.financeRating = financeRating;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public int getOrganizationRating() {
		return organizationRating;
	}

	public void setOrganizationRating(int organizationRating) {
		this.organizationRating = organizationRating;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getFinanceRating() {
		return financeRating;
	}

	public void setFinanceRating(int financeRating) {
		this.financeRating = financeRating;
	}

	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId + ", userName=" + userName + ", password=" + password
				+ ", organizationName=" + organizationName + ", organizationRating=" + organizationRating + ", emailId="
				+ emailId + ", contactNumber=" + contactNumber + ", financeRating=" + financeRating + "]";
	}
}
