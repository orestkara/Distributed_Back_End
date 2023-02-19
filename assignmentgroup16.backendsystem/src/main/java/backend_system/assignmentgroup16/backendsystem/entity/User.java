package backend_system.assignmentgroup16.backendsystem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import backend_system.assignmentgroup16.backendsystem.entity.Contract;
import backend_system.assignmentgroup16.backendsystem.entity.House;

@Entity
@Table(name = "user", schema = "public")
public class User implements Serializable {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank(message = "Please enter your TIN")
	@Column(length = 9, name = "tin", nullable = false, unique = true)
	private String TIN;

	@NotBlank(message = "Please enter the first name")
	@Size(max = 50, message = "First name should not be greater than 50 characters")
	@Column(name = "first_name")
	private String first_name;

	@NotBlank(message = "Please enter the last name")
	@Size(max = 50, message = "Last name should not be greater than 50 characters")
	@Column(name = "last_name")
	private String last_name;

	@NotBlank(message = "Please enter your email")
	@Size(max = 50, message = "Email should not be greater than 50 characters")
	@Column(name = "email", nullable = false)
	private String email;

	@Id
	@NotBlank(message = "Please enter your username")
	@Size(max = 50, message = "Username should not be greater than 50 characters")
	@Column(name = "username", nullable = false)
	private String username;

	@NotBlank(message = "Please enter your password")
	@Size(max = 80, message = "Password should not be greater than 80 characters")
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@NotBlank(message = "Please enter your password")
	@Size(message = "Password should not be greater than 50 characters")
	@Column(length = 10, name = "phone_number")
	private String phone_number;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private Set<Authorities> authorities = new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH})
	@JsonManagedReference
	private Set<House> houses = new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH})
	@JsonManagedReference
	private Set<Contract> contracts = new HashSet<>();

	public User(String TIN, String first_name, String last_name, String email, String username, String password, boolean enabled, String phone_number, Set<Authorities> authorities, Set<House> houses, Set<Contract> contracts) {
		this.TIN = TIN;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.phone_number = phone_number;
		this.authorities = authorities;
		this.houses = houses;
		this.contracts = contracts;
	}

	public User() {
	}

	public User(String first_name, String last_name, String email, String username, String password, boolean enabled, String phone_number, Set<Authorities> authorities, Set<House> houses, Set<Contract> contracts) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.phone_number = phone_number;
		this.authorities = authorities;
		this.houses = houses;
		this.contracts = contracts;
	}

	public String getTIN() {
		return TIN;
	}

	public void setTIN(String TIN) {
		this.TIN = TIN;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}

	public Set<House> getHouses() {
		return houses;
	}

	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}

	public Set<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	@Override
	public String toString() {
		return "User{" +
				"TIN='" + TIN + '\'' +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", enabled=" + enabled +
				", phone_number='" + phone_number + '\'' +
				", authorities=" + authorities +
				", houses=" + houses +
				", contracts=" + contracts +
				'}';
	}
}