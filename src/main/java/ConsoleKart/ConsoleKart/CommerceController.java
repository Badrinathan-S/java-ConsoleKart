package ConsoleKart.ConsoleKart;

import java.util.Arrays;
import java.util.Scanner;

public class CommerceController implements CommerceActions {
	
	
	private Product products[] = new Product[10]; 
	

	/**
	 * @param products
	 *
	 */
	
	public CommerceController() {
		products[0] = new Product("16GBpendrive", "Sandisk", 20, new String[] {"Black","Red"}, 250);
		products[1] = new Product("Airdopes", "Boat", 180, new String[] {"White","Blue","Red"}, 999);
		products[2] = new Product("15AC2022Laptop", "Dell", 45, new String[] {"Grey","Silver","Black"}, 87600);
		products[3] = new Product("64GBpendrive", "Transcend", 30, new String[] {"White","Blue","Grey"}, 540);
		products[4] = new Product("Sneakers", "Puma", 90, new String[] {"Black","White","Blue","Red"}, 1299);
		products[5] = new Product("Smartwatch", "Boat", 190, new String[] {"Black","White","Blue","Red","Green"}, 2399);
		products[6] = new Product("Beanbag", "Comfy", 30, new String[] {"Black","White"}, 2100);
		products[7] = new Product("Beanbag", "Comfy", 30, new String[] {"Black","White"}, 2100);
		products[8] = new Product("Beanbag", "Comfy", 30, new String[] {"Black","White"}, 2100);
//		products[9] = new Product("Beanbag", "Comfy", 30, new String[] {"Black","White"}, 2100);
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
		for(int index=0;index<products.length;index++) {
			if(products[index] == null) {
				products[index] = product;
				return product.getModelName()+" has added into consoleKart";
			}
		}
		return product.getModelName()+" couldn't add to ConsoleKart";	
	}

	@Override
	public Product[] available() {
		return products;
	}

	@Override
	public void filter(Integer start, Integer end) {
		if(start<=end&&end<=products.length) {
			for(;start<=end;start++) {
				System.out.println(products[start]);
			}
		}
		else {
			System.out.println(start+" and " + " boundry invalid");
		}
	}

	@Override
	public void filter(String color, String model) {
		for(int index=0;index<products.length;index++) {
			if(products[index] != null && Arrays.toString(products[index].getColors()).contains(color) && products[index].getModelName().equals(model)) {
				System.out.println(products[index]);
			}
		}
	}

	@Override
	public void filter(String brand, Integer start, Integer end) {
		if(start<=end) {
			int mid = (start+end) / 2;
			if(products[mid].getBrand().compareTo(brand) == 0) {
				System.out.println(products[mid]);
			}
			else if(products[mid].getBrand().compareTo(brand)<0) {
				filter(brand, start, mid);
			}
			else {
				filter(brand, mid + 1, end);
			}
		}
		else {
			System.out.println(brand+" Brand doesn't match anywhere");
		}
		
	}

	@Override
	public String detachItem(String itemName) {
		for(int index=0;index<products.length;index++) {
			if(products[index]!=null&&products[index].getModelName().equals(itemName)) {
				String akc = products[index].getModelName()+" is removed from stock";
				products[index] = null;
				return akc;
			}
		}
		return "No item found as "+ itemName;
		
	}

	@Override
	public String detachItem(Integer position) {
		if(position<products.length&&products[position] != null) {
			String akc = products[position].getModelName()+" is removed from stock";
			products[position] = null;
			return akc;
		}
		else {
			return "No item found at"+ position;
		}
	}

	@Override
	public String update(String itemName) {
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		for(int index=0;index<products.length;index++)
		{
			if(products[index]!=null&&products[index].getModelName().equals(itemName))
			{
				System.out.println(products[index]);
				System.out.println("Tell us what to update(name,brand,qty,price,color): ");
				String criteria=scan.next();
				criteria=criteria.toLowerCase();
				switch(criteria)
				{
				case "name":
					System.out.println("Tell us new ModelName: ");
					String item=scan.next();
					products[index].setModelName(item);
					return item+" has updated as modelName";
				case "brand":
					System.out.println("Tell us new brand name: ");
					String bnd=scan.next();
					products[index].setBrand(bnd);
					return bnd+" has updated as Brand "+itemName;
				case "qty":
					System.out.println("Tell us new quantity: ");
					int q=scan.nextInt();
					products[index].setQuantity(q);
					return q+" has updated as new Quantity "+itemName;
				case "price":
					System.out.println("Tell us new cost: ");
					int c=scan.nextInt();
					products[index].setPrice(c);;
					return c+" has updated as new price of "+itemName;
				case "color":
					System.out.println("Available colors are: "+Arrays.toString(products[index].getColors()));
					System.out.println("Do you wish to add new color or update existing one: ");
					String wish=scan.next();
					if(wish.equalsIgnoreCase("new"))
					{
						System.out.println("Tell us new color to add: ");
						String users=scan.next();
						String tmp=Arrays.toString(products[index].getColors())+","+users;
						products[index].setColors(tmp.split(","));
						return users+" color has added newly for "+itemName;
					}
					else if(wish.equalsIgnoreCase("modify")) 
					{
						System.out.println("Tell us what to modify: ");
						String what=scan.next();
						System.out.println("Tell us which you wish to replace: ");
						String which=scan.next();
						String tmp=Arrays.toString(products[index].getColors());
						tmp.replace(what, which);
						products[index].setColors(tmp.split(","));
						return which+" color has replaced "+what+" on "+itemName;
					}
				}
			}
		}
		return itemName+" hasn't found anywhere";
	}
	
	private int qsort(int start,int end)
	{
		Product piData = products[end];
		int initial=start-1;
		for(int current=start;current<end;current++) {
			if(products[current].getBrand().compareToIgnoreCase(piData.getBrand())>0) {
				initial++;
				Product third = products[current];
				products[current]=products[initial];
				products[initial]=third;
			}
		}
		Product third=products[end];
		products[end]=products[initial+1];
		products[initial+1]=third;
		
		return initial+1;
	}
	private void quick(int start,int end)
	{
		if(start<end) {
			int pPoint=qsort(start, end);
			quick(start, pPoint-1);
			quick(pPoint+1, end);
		}
	}
	
	@Override
	public void orderQuick() {
		quick(0, products.length-1);
		
	}

}
