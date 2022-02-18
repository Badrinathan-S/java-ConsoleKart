package ConsoleKart.ConsoleKart;

import java.util.Arrays;

public class Product {
	private String modelName;
	private String brand;
	private Integer quantity;
	private String[] colors;
	private Integer price;
	/**
	 * @param modelName
	 * @param brand
	 * @param quantity
	 * @param colors
	 * @param price
	 */
	@Override
	public String toString() {
		return "Product [modelName=" + modelName + ", brand=" + brand + ", quantity=" + quantity + ", colors="
				+ Arrays.toString(colors) + ", price=" + price + "]\n";
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String modelName, String brand, Integer quantity, String[] colors, Integer price) {
		super();
		this.modelName = modelName;
		this.brand = brand;
		this.quantity = quantity;
		this.colors = colors;
		this.price = price;
	}
	/**
	 * 
	 */
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String[] getColors() {
		return colors;
	}
	public void setColors(String[] colors) {
		this.colors = colors;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
