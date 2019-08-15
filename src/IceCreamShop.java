import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Class that manages buttons, panel layout, matching the random ice cream cone order to the one the user makes, and updates the score and view.
 * @author Sneha Kanaujia
 *
 */
public class IceCreamShop extends JPanel implements ActionListener {

	//JButton to Serve the next order
	public JButton serveO = new JButton("Serve the next order");
	
	//IceCreamLine and IceCreamConeMaker instance variables to hold the current 
	public IceCreamLine ICL = new IceCreamLine();
	public IceCreamConeMaker ICCM = new IceCreamConeMaker();
	
	//Creates instance variable to hold the JLabel instructions and score
	public JLabel instructions;
	//Instance variable for the score
	public int score = 0;

	/**
	 * IceCream shop constructor
	 */
	public IceCreamShop() {

		//Uses a BorderLayout
		super( new BorderLayout() );

		//Creates a JPanel to be in the northern part of the border layout to hold the instructions, score and serve ice cream button
		JPanel northPanel = new JPanel(new BorderLayout());

		//Creates instructions and put at the top
		instructions = new JLabel("Make ice cream cones to match the next order (at the top). \nEvery correct order served earns you 10 points. \nMake the wrong cone an you'll lose 5 points. \nScore: " + score);
		//Alligns the JLabel text to the center of the JPanel
		instructions.setHorizontalAlignment(JLabel.CENTER);
		//Adds the instructions to the north of the northern JPanel 
		northPanel.add( instructions, BorderLayout.NORTH );

		//Gives the serve the next order JButton an actionlistener
		serveO.addActionListener(this);
		//Adds the serve the next order JButton to the center of the northern JPanel
		northPanel.add(serveO, BorderLayout.CENTER);
		//Adds the northern JPanel to the north of the JFrame
		add(northPanel, BorderLayout.NORTH);
		
		//Adds the IceCreamConeMaker object/JPanel to the center of the JFrame
		add(ICCM, BorderLayout.CENTER );
		//Adds the IceCreamLine object/JPanel to the west of the JFrame
		add(ICL, BorderLayout.WEST );	
	}

	/**
	 * Serve method is meant to check if the scoop order of the current IceCreamCone in the IceCreamLine matches the one made in the IceCreamConeMaker JPanel
	 */
	public void serveOrder ()
	{
		//Checks to make sure there are items in the IceCreamLine queue to dequeue
		if(!(ICL.iceCreamLine.isEmpty()))
		{
			//boolean to keep track of whether every scoop matches or not
			boolean match = true;

			//Checks to make sure the stack of scoops in the IceCreamConeMaker class isn't empty
			if(!ICCM.cone.stack.isEmpty())
			{
				//Makes sure the size of the stack of scoops in each ice cream cone being compared are the same
				if(ICL.iceCreamLine.peek().stack.getSize() == ICCM.cone.stack.getSize())
				{
					//Cycles through the stack of scoops in the IceCreamConeMaker class until it's empty 
					while(!ICCM.cone.stack.isEmpty())
					{
						//Looks to check if the scoops order is the same  in each ice cream cone being compared
						if(ICL.iceCreamLine.peek().stack.peek().equals(ICCM.cone.stack.peek()))
						{
							//Pops the top scoop so the one underneath can be compared
							ICL.iceCreamLine.peek().stack.pop();
							ICCM.cone.stack.pop();
						}
						else
						{
							//If any of the scoops don't match the boolean is set to false
							match = false;
							//If there are the same number of scoops but they're not the same flavour, ends the while loop since otherwise it'll recurse forever since the scoops won't ever be completely popped/removed
							break;
						}
					}
					
					//Updates view
					repaint();
				}
				//Marks the matched boolean to false if the size of the stack of scoops in each ice cream cone being compared aren't the same
				else
				{
					match = false;
				}
			}

			//If all the scoops match, remove the top/current order in the iceCreamLine queue
			if(match)
			{
				//Dequeues the top ice cream cone in the iceCreamLine queue
				ICL.iceCreamLine.dequeue();
				//Removes the JComponent/view that held that particular IceCreamCone from the JPanel
				ICL.coneList.remove(0);
				//Increases score by 10
				score+= 10;
				//Updates view
				repaint();
			}
			else
			{
				//Dequeues the cone first made
				ICL.iceCreamLine.dequeue();
				//Removes the JComponent/view that held that particular IceCreamCone from the JPanel
				ICL.coneList.remove(0);
				//Removes all the scoops from the IceCreamConeMaker class cone
				while(!ICCM.cone.stack.isEmpty())
				{
					ICCM.cone.stack.pop();
				}
				//Decreases score by 5
				score-= 5;
				//Updates view
				repaint();
			}
			//Updates the JLabel instructions and score statement
			instructions.setText("Make ice cream cones to match the next order (at the top). \nEvery correct order served earns you 10 points. \nMake the wrong cone an you'll lose 5 points. \nScore: " + score);
		}
		
		//Updates view
		repaint();
	}

	/**
	 * Needed to sense which JButtons were pressed 
	 */
	public void actionPerformed(ActionEvent event) {
		//Finds the source of the ActionEvent
		Object source = event.getSource();

		//If the serve the next order JButton was clicked it calls the serveOrder method
		if(source == serveO)
		{
			serveOrder();
		}

	}

}
