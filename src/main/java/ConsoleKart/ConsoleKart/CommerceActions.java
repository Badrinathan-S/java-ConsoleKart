package ConsoleKart.ConsoleKart;

public interface CommerceActions {
	public String newStock(Product product);
	public Product[] available();
	public void filter(Integer start, Integer end);
	public void filter(String color, String model);
	public void filter(String brand, Integer start, Integer end);
	public void detachItem(String itemName);
	public void detachItem(Integer position);
	public String update(String itemName);
	public void orderQuick();

}
