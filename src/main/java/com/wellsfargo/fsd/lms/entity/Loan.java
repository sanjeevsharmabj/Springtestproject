package com.wellsfargo.fsd.lms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="loans")
public class Loan {

	@Id
	@Column(name="lid")
	@NotNull(message= "LoanId is mandatory")
	@Min(value=1,message="LoanId cannot be negative or Zero" )
	private Integer loanId;
	
	@Column(name="p")
	@NotNull(message= "Principal is mandatory")
	@Min(value=10000,message="Principal cannot be less than 10000" )
	private Double principal;
	
	@Column(name="r")
	@NotNull(message= "Rate of Interest is mandatory")
	@Min(value=0,message="Rate of Interest cannot be Negative" )
	@Min(value=0,message="Rate of Interest cannot be more than 1" )
	private Double rateOfInterest;
	
	@Column(name="ec")
	@NotNull(message= "EMI Count is mandatory")
	@Min(value=1,message="EMI count cannot be Negative or 0" )
	private Integer emiCount;
	
	@Column(name="dob")
	@NotNull(message= "Date of Disburesment is mandatory")
	@PastOrPresent(message="Date of Disburesment is expected to be past or present Date" )
	@DateTimeFormat(iso=ISO.DATE )
	private LocalDate dateOfDisbursment;
	
	
	@Column(name="status")
	@NotNull(message = "Status is manditory")
	@NotBlank(message = "Status is manditory")
	@Size(min=3,max=20,message = "Status is expected to be 3 to 20 chars in length")
	
	private String status;
	
	public Loan() {
		//left unimplemented
	}

	public Loan(Integer loanId, Double principal, Double rateOfInterest, Integer emiCount, LocalDate dateOfDisbursment,
			String status) {
		super();
		this.loanId = loanId;
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.emiCount = emiCount;
		this.dateOfDisbursment = dateOfDisbursment;
		this.status = status;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Integer getEmiCount() {
		return emiCount;
	}

	public void setEmiCount(Integer emiCount) {
		this.emiCount = emiCount;
	}

	public LocalDate getDateOfDisbursment() {
		return dateOfDisbursment;
	}

	public void setDateOfDisbursment(LocalDate dateOfDisbursment) {
		this.dateOfDisbursment = dateOfDisbursment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", principal=" + principal + ", rateOfInterest=" + rateOfInterest
				+ ", emiCount=" + emiCount + ", dateOfDisbursment=" + dateOfDisbursment + ", status=" + status + "]";
	}
	
	
}
