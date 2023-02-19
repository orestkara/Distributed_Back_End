package backend_system.assignmentgroup16.backendsystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import backend_system.assignmentgroup16.backendsystem.entity.User;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "house", schema = "public")
public class House implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "house_id", nullable = false)
	private int house_id;

	@NotBlank(message = "Please enter the house description")
	@Size(max = 255, message = "House description should not be greater than 255 characters")
	@Column(name = "house_description")
	private String house_description;

	@NotBlank(message = "Please enter the rent details")
	@Size(max = 255, message = "Rent details should not be greater than 255 characters")
	@Column(name = "rent_details")
	private String rent_details;

	@NotBlank(message = "Please enter the electricity id")
	@Size(message = "Electricity id should be 14 characters")
	@Column(length = 15, name = "id_electricity", nullable=false, unique=true)
	private String electricity_id;

	@NotBlank(message = "Please enter the house size")
	@Column(name = "house_size")
	private Integer house_size;

	@NotBlank(message = "Please enter number of bedrooms")
	@Column(name = "bedrooms")
	private Integer bedrooms;

	@NotBlank(message = "Please enter the owner's TIN")
	@Size(message = "Owner's TIN should be 9 characters")
	@Column(length = 9, name = "owner_tin", nullable = false, unique=true)
	private String owner_TIN;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinColumn(name = "owner_tin", referencedColumnName="tin",insertable=false, updatable=false)
	@JsonBackReference
	private User user;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "house", cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JsonManagedReference
	private Set<Contract> contracts = new HashSet<>();

	@Override
	public String toString() {
		return "House{" +
				"house_id=" + house_id +
				", house_description='" + house_description + '\'' +
				", rent_details='" + rent_details + '\'' +
				", electricity_id='" + electricity_id + '\'' +
				", house_size=" + house_size +
				", bedrooms=" + bedrooms +
				", owner_TIN='" + owner_TIN + '\'' +
				", user=" + user +
				", contracts=" + contracts +
				'}';
	}

	public int getHouse_id() {
		return house_id;
	}

	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}

	public String getHouse_description() {
		return house_description;
	}

	public void setHouse_description(String house_description) {
		this.house_description = house_description;
	}

	public String getRent_details() {
		return rent_details;
	}

	public void setRent_details(String rent_details) {
		this.rent_details = rent_details;
	}

	public String getElectricity_id() {
		return electricity_id;
	}

	public void setElectricity_id(String electricity_id) {
		this.electricity_id = electricity_id;
	}

	public Integer getHouse_size() {
		return house_size;
	}

	public void setHouse_size(Integer house_size) {
		this.house_size = house_size;
	}

	public Integer getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	public String getOwner_TIN() {
		return owner_TIN;
	}

	public void setOwner_TIN(String owner_TIN) {
		this.owner_TIN = owner_TIN;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Set<Contract> contracts) {
		this.contracts = contracts;
	}

	public House(String house_description, String rent_details, String electricity_id, Integer house_size, Integer bedrooms, String owner_TIN, User user, Set<Contract> contracts) {
		this.house_description = house_description;
		this.rent_details = rent_details;
		this.electricity_id = electricity_id;
		this.house_size = house_size;
		this.bedrooms = bedrooms;
		this.owner_TIN = owner_TIN;
		this.user = user;
		this.contracts = contracts;
	}

	public House(int house_id, String house_description, String rent_details, String electricity_id, Integer house_size, Integer bedrooms, String owner_TIN, User user, Set<Contract> contracts) {
		this.house_id = house_id;
		this.house_description = house_description;
		this.rent_details = rent_details;
		this.electricity_id = electricity_id;
		this.house_size = house_size;
		this.bedrooms = bedrooms;
		this.owner_TIN = owner_TIN;
		this.user = user;
		this.contracts = contracts;
	}

	public House() {
	}
}