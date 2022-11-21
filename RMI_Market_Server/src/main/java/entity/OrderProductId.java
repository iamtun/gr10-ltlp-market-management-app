package entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderProductId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int product;
	private int order;

	public OrderProductId(int product, int order) {
		super();
		this.product = product;
		this.order = order;
	}

	public OrderProductId() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProductId other = (OrderProductId) obj;
		return order == other.order && product == other.product;
	}

}
