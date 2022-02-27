package ConsoleKart.ConsoleKart;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner scan=new Scanner(System.in);
    	CommerceController control=new CommerceController();
    	int option=0;
    	do
    	{
    		System.out.println("Tell us your option\n1.Add Item\n2.Display all\n3.Delete item\n4.Filter\n5.Update\n6.Sort");
    		option=scan.nextInt();
    		switch(option)
    		{
    		case 1:
    			System.out.println("Adding new product");
    			Product pr1=new Product();
    			System.out.println("Tell us model name: ");
    			pr1.setModelName(scan.next());
    			System.out.println("Tell us brand name: ");
    			pr1.setBrand(scan.next());
    			System.out.println("Tell us Quantity: ");
    			pr1.setQuantity(scan.nextInt());
    			System.out.println("Tell us no of color: ");
    			int count=scan.nextInt();//3
    			String tmp="";//blue,red,white,
    			while(count>0)
    			{
    				System.out.println("Tell us color: ");
    				tmp+=scan.next()+",";// white,
    				count--;//1
    			}
    			pr1.setColors(tmp.split(","));
    			System.out.println("Enter the price: ");
    			pr1.setPrice(scan.nextInt());
    			System.out.println(control.newStock(pr1));
    			break;
    		case 2:
    			System.out.println("List all available items");
    			System.out.println(Arrays.toString(control.available()));
    			break;
    		case 3:
    			System.out.println("Delete item from stock by position or item name");
    			String which=scan.next();
    			switch(which)
    			{
    			case "position":
    				System.out.println("Tell us position to delete: ");
    				int pos=scan.nextInt();
    				System.out.println(control.detachItem(pos));
    				break;
    			case "name":
    				System.out.println("Tell us model name: ");
    				String model=scan.next();
    				System.out.println(control.detachItem(model));
    				break;
    			}
    			break;
    		case 4:
    			System.out.println("Search/filter items based on boundry or combine(color and model) or brand");
    			which=scan.next();
    			switch(which)
    			{
    			case "boundry":
    				System.out.println("Enter the strat and end points: ");
    				control.filter(scan.nextInt(), scan.nextInt());
    				break;
    			case "combine":
    				System.out.println("Enter the color and model: ");
    				control.filter(scan.next(), scan.next());
    				break;
    			case "brand":
    				System.out.println("Enter the brand: ");
    				control.filter(scan.next(), 0, control.available().length-1);
    				break;
    			}
    			break;
    		case 5:
    			System.out.println("Update items by name");
    			System.out.println(control.update(scan.next()));
    			break;
    		case 6:
    			System.out.println("Sort items");
    			control.orderQuick();
    			break;
    		default:System.out.println("Invalid option");return;
    		}
    	}while(true);
    }
}
