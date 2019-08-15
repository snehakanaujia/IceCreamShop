import javax.swing.JFrame;

/**
 * GUI application offering buttons to add a random order to the line or remove the first order
 * @author Sneha Kanaujia
 *
 */
public class IceCreamLineManager {

	/**
	 * Sets the width of the frame to 800 pixels
	 */
    public static int FRAME_WIDTH = 800;
	
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
		JFrame dessertFrame = new JFrame("Ice Cream Line!");
		
		//Adds SeparateIceCreamLine panel/object to JFrame
		dessertFrame.add(new SeparateIceCreamLine());
		//Sets JFrame dimensions and sets it to close when exited out of and makes it visible
		dessertFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		dessertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dessertFrame.setVisible(true);
    }
	
}
