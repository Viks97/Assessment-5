package web.assess5;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String desp;
	private int price;
	private int quantity;
	
	public Product() {}
	
	public Product(String name, String desp, int price, int quantity) {
		this.name = name;
		this.desp = desp;
		this.price = price;
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesp() {
		return desp;
	}
	
	public void setDesp(String desp) {
		this.desp = desp;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desp=" + desp + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}


}
