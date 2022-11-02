package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "order_date", nullable = false)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
	private Staff staff;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<OrderDetail> details;

	public Order(Date date, Staff staff) {
		super();
		this.date = date;
		this.staff = staff;
	}

	public Order() {
		super();
	}

	public double getTotal() {
		double total = 0;
		for (OrderDetail orderDetail : details) {
			total += orderDetail.getTotalOrderDetail();
		}
		return total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<OrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetail> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + "]";
	}

}
