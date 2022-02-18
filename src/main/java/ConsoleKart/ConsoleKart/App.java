package ConsoleKart.ConsoleKart;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Product p1=new Product("9W LED Blub", "Panasonic", 20, new String[] {"White","Blue"}, 780);
    	Product p2=new Product("Oneplus Z-band", "Oneplus", 15, new String[] {"Black, red"}, 2000);
    	Product p3=new Product("Hunter M-Bat", "Hunter", 50, new String[] {"yellow"}, 500);
    	CommerceController controller = new CommerceController();
    	
    	System.out.println(controller.newStock(p1));System.out.println(controller.newStock(p2));System.out.println(controller.newStock(p3));
    	System.out.println(Arrays.toString(controller.available()));
    }
}
