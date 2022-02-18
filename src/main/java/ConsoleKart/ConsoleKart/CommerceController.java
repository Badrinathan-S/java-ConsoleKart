package ConsoleKart.ConsoleKart;

public class CommerceController implements CommerceActions {
	
	
	private Product products[] = new Product[10]; 
	
	

	/**
	 * @param products
	 *
	 */
	
	public CommerceController() {
//		products = new Product[] {
//				new Product("Samsung M30", "Samsung", 20, new String[] {"black, blue"}, 10000),
//				new Product("Oneplus Z-band", "Oneplus", 15, new String[] {"Black, red"}, 2000),
//				new Product("Hunter M-Bat", "Hunter", 50, new String[] {"yellow"}, 500),
//				
//		};
		
	}

	/**
	 * @param products
	 */
	public CommerceController(Product[] products) {
		super();
		this.products = products;
	}

	@Override
	public String newStock(Product product) {
		// TODO Auto-generated method stub
		for(int index=0;index<products.length;index++)
		{
			if(products[index]==null)
			{
				products[index]=product;
				return product.getModelName()+" has added into ConsoleKart";
			}
		}
		return product.getModelName()+" couldn't added to ConsoleKart";
	}

	@Override
	public Product[] available() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public void filter(Integer start, Integer end) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filter(String color, String model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filter(String brand, Integer start, Integer end) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detachItem(String itemName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detachItem(Integer position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String update(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void orderQuick() {
		// TODO Auto-generated method stub
		
	}

}
