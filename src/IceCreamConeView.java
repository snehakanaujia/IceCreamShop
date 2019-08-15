import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/** 
 * Creates a JComponent to draw the cone and ice cream scoops
 *
 * @author Sneha Kanaujia
 */

public class IceCreamConeView extends JComponent
{
	//Instance variable to hold the same stack used in the other class
	public StackLL<String> scoops = new StackLL<String>();
	
	/**
	 * Sets the scoop diameter to 50 pixels
	 */
	public static final int SCOOP_DIAM = 50;
	
	/**
	 * Constructor, to create a new component
	 * @param currentCone being made/updated through paint/graphics
	 **/
	public IceCreamConeView(IceCreamCone currentCone)
	{
		super();
		//Sets instnce variable to the cone passed in
		scoops = currentCone.stack;
		//Calls the paint method
		repaint();
	}
	
	/**
	 * Paint the game.
	 * @param g Graphics object
	 */
	public void paint(Graphics g)
	{
		//Make brown colored cone
		g.setColor(new Color(232, 198, 136));
		int[] xCoor = {this.getWidth()/2-SCOOP_DIAM/2, this.getWidth()/2+SCOOP_DIAM/2, this.getWidth()/2};
		int[] yCoor = {this.getHeight()-110, this.getHeight()-110, this.getHeight()};
		g.fillPolygon(xCoor, yCoor, 3);
		
		//Creates a counter to add each and every scoop in the stack
		int scoopCounter = scoops.getSize();
		//Creates a temporary stack
		StackLL<String> tempStack = new StackLL<String>();
		
		//Cycles through the stack elements
		while(!scoops.isEmpty() && scoops != null && scoopCounter>0)
		{
			//Adds the elements from the original stack to the temporary stack
			tempStack.push(scoops.pop());
			//Gets the data of the first scoop saved in the temporary stack
			String flavour = tempStack.peek();
			
			//Checks which flavor the scoop is by taking in the data of the top/first scoop in the temporary stack and sets the color to be a color that correlates with the flavor
			if(flavour == "strawberry")
			{
				g.setColor(Color.PINK);
			}
			else if(flavour == "mango")
			{
				g.setColor(Color.ORANGE);
			}
			else if(flavour == "blueberry")
			{
				g.setColor(new Color(181, 232, 255));
			}
			else if(flavour == "pistachio")
			{
				g.setColor(new Color(221, 244, 73));
			}
			else if(flavour == "cookiesandcream")
			{
				g.setColor(Color.WHITE);
			}
			
			//Draws the scoop in relation to the size of the window and diameter of the scoops
			g.fillOval(this.getWidth()/2-SCOOP_DIAM/2, this.getHeight()-100-(SCOOP_DIAM-20)*(scoopCounter), SCOOP_DIAM, SCOOP_DIAM);
			
			//Decrements the counter
			scoopCounter--;
			
		}
		
		//Adds the elements from the temporary stack back onto the original stack
		while(!tempStack.isEmpty() && tempStack != null)
		{
			scoops.push(tempStack.pop());
		}
		
	}
	
	
}
