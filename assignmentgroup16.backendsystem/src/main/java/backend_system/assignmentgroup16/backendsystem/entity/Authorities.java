package backend_system.assignmentgroup16.backendsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "authorities", schema = "public")
public class Authorities implements Serializable {

	@Id
	@Column(name= "username", nullable = false)
	@Size(max = 50)
	private String username;

	@Column(name = "authority", nullable = false)
	@Size(max = 50)
	private String authority;

//	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
//	@JoinColumn(name = "username", referencedColumnName = "username",insertable=false, updatable=false, nullable = false)
//	private User user;
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
		CascadeType.REFRESH })
	@JoinColumn(name = "username", insertable=false, updatable=false)
	@JsonBackReference
	private User user;
	public Authorities() {

	}

	public Authorities(String authority, User user) {
		this.authority = authority;
		this.user = user;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Authorities [username=" + username + ", authority=" + authority + ", user=" + user + "]";
	}

}
