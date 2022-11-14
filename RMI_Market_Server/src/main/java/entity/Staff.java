package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "staffs")
public class Staff implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "staff_id", nullable = false)
	private String id;

	@Column(nullable = false, columnDefinition = "nvarchar(45)")
	private String name;

	@Column(unique = true, nullable = false, columnDefinition = "nvarchar(45)")
	private String identify;

	@Column(unique = true, nullable = false, columnDefinition = "nvarchar(45)")
	private String phone;

	@Column(nullable = false, columnDefinition = "nvarchar(45)")
	private String address;

	@Column(nullable = false)
	private boolean gender;

	@Column(nullable = false)
	private boolean position;

	@Column(nullable = false)
	private boolean status;

	@OneToOne(mappedBy = "staff")
	@PrimaryKeyJoinColumn
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Staff manager;
	
	@OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Order> orders;

	public Staff() {
		super();
	}

	public Staff(String id, String name, String identify, String phone, String address, boolean gender,
			boolean position) {
		super();
		this.id = id;
		this.name = name;
		this.identify = identify;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.position = position;
		this.status = true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public boolean isPosition() {
		return position;
	}

	public void setPosition(boolean position) {
		this.position = position;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", identify=" + identify + ", phone=" + phone + ", address="
				+ address + ", gender=" + gender + ", position=" + position + ", status=" + status + "]";
	}

}
