import javax.swing.JFrame;

/**
 * Creates the frame and runs the proogram
 * @author Sneha
 *
 */
public class IceCreamConeManager {

	/**
	 * Sets the width of the frame to 1000 pixels
	 */
    public static int FRAME_WIDTH = 1050;
	
	/**
	 * Sets the height of the frame to 800 pixels
	 */
    public static int FRAME_HEIGHT = 800;

	/**
	 * Creates and draws the frame for the circles
	 * 
	 * @param args not used
	*/
    public static void main(String[] args)
    {
		JFrame dessertFrame = new JFrame("Ice Cream Shop!");
		
		//Adds IceCreamShop panel/object to JFrame
		dessertFrame.add(new IceCreamShop());
		//Sets JFrame dimensions and sets it to close when exited out of and makes it visible
		dessertFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		dessertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dessertFrame.setVisible(true);
    }
}
