package backend_system.assignmentgroup16.backendsystem.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import backend_system.assignmentgroup16.backendsystem.entity.User;

@Entity
@Table(name = "contract", schema = "public")
public class Contract implements Serializable {

//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid", strategy = "uuid")
//	@Column(columnDefinition = "CHAR(32)")
//	@Id
//	private String id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contract_id", nullable = false)
	private int contract_id;
//	String uuid = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 12));
//	String uuid12digits = uuid.substring(uuid.length() - 12);
//	contract_id=Integer.parseInt(uuid12digits);
	//@GeneratedValue(strategy = GenerationType.IDENTITY)


	@NotBlank(message = "Please enter the contract's submission date")
	@Size(max = 20, message = "Submission date should not be greater than 20 characters")
	@Column(name = "submission_date")
	private String submission_date;

	@NotBlank(message = "Please enter the tenant's name")
	@Size(max = 100, message = "Tenant's name should not be greater than 100 characters")
	@Column(name = "tenant_name")
	private String tenant_name;

	@NotBlank(message = "Please enter the tenant's TIN")
	@Size(message = "Tenant's TIN should be 9 characters")
	@Column(length = 9, name = "tenant_tin", nullable = false, unique=true)
	private String tenant_TIN;

	@NotBlank(message = "Please enter the tenant's email")
	@Size(max = 50, message = "Email should not be greater than 50 characters")
	@Column(name = "email", nullable = false)
	private String email;

	@NotBlank(message = "Please enter the tenant's phone number")
	@Size(message = "Password should not be greater than 50 characters")
	@Column(length = 10, name = "phone_number")
	private String phone_number;

	@NotBlank(message = "Please enter the electricity id")
	@Size(message = "Electricity id should be 14 characters")
	@Column(length = 15, name = "electricity_id", nullable = false,unique=true)
	private String electricity_id;

	@NotBlank(message = "Please enter the special terms")
	@Size(max = 255, message = "Special terms should not be greater than 255 characters")
	@Column(name = "special_terms")
	private String special_terms;

	@NotBlank(message = "Please enter the rental period")
	@Size(message = "Rental period should be 21 characters")
	@Column(length = 21, name = "rental_period")
	private String rental_period;

	@Column(name = "approved", nullable = false)
	private Integer approved;

	@NotBlank(message = "Please enter the payment")
	@Column(name = "payment")
	private Integer payment;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH})
	@JoinColumn(name = "tenant_tin", referencedColumnName ="tin", insertable=false, updatable=false)
	@JsonBackReference
	private User user;


	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "electricity_id", referencedColumnName ="id_electricity", insertable=false, updatable=false)
	@JsonBackReference
	private House house;

	public Contract(String submission_date, String tenant_name, String tenant_TIN, String email, String phone_number, String electricity_id, String special_terms, String rental_period, Integer approved, Integer payment, User user, House house) {
		this.submission_date = submission_date;
		this.tenant_name = tenant_name;
		this.tenant_TIN = tenant_TIN;
		this.email = email;
		this.phone_number = phone_number;
		this.electricity_id = electricity_id;
		this.special_terms = special_terms;
		this.rental_period = rental_period;
		this.approved = approved;
		this.payment = payment;
		this.user = user;
		this.house = house;
	}

	public Contract(int contract_id, String submission_date, String tenant_name, String tenant_TIN, String email, String phone_number, String electricity_id, String special_terms, String rental_period, Integer approved, Integer payment, User user, House house) {
		this.contract_id = contract_id;
		this.submission_date = submission_date;
		this.tenant_name = tenant_name;
		this.tenant_TIN = tenant_TIN;
		this.email = email;
		this.phone_number = phone_number;
		this.electricity_id = electricity_id;
		this.special_terms = special_terms;
		this.rental_period = rental_period;
		this.approved = approved;
		this.payment = payment;
		this.user = user;
		this.house = house;
	}

	public Contract() {
	}

	@Override
	public String toString() {
		return "Contract{" +
				"contract_id=" + contract_id +
				", submission_date='" + submission_date + '\'' +
				", tenant_name='" + tenant_name + '\'' +
				", tenant_TIN='" + tenant_TIN + '\'' +
				", email='" + email + '\'' +
				", phone_number='" + phone_number + '\'' +
				", electricity_id='" + electricity_id + '\'' +
				", special_terms='" + special_terms + '\'' +
				", rental_period='" + rental_period + '\'' +
				", approved=" + approved +
				", payment=" + payment +
				", user=" + user +
				", house=" + house +
				'}';
	}

	public int getContract_id() {
		return contract_id;
	}

	public void setContract_id(int contract_id) {
		this.contract_id = contract_id;
	}

	public String getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}

	public String getTenant_name() {
		return tenant_name;
	}

	public void setTenant_name(String tenant_name) {
		this.tenant_name = tenant_name;
	}

	public String getTenant_TIN() {
		return tenant_TIN;
	}

	public void setTenant_TIN(String tenant_TIN) {
		this.tenant_TIN = tenant_TIN;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getElectricity_id() {
		return electricity_id;
	}

	public void setElectricity_id(String electricity_id) {
		this.electricity_id = electricity_id;
	}

	public String getSpecial_terms() {
		return special_terms;
	}

	public void setSpecial_terms(String special_terms) {
		this.special_terms = special_terms;
	}

	public String getRental_period() {
		return rental_period;
	}

	public void setRental_period(String rental_period) {
		this.rental_period = rental_period;
	}

	public Integer getApproved() {
		return approved;
	}

	public void setApproved(Integer approved) {
		this.approved = approved;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}
}