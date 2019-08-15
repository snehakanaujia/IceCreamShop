import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
/**
 * IceCreamLine 
 * @author Sneha Kanaujia
 *
 */
public class IceCreamLine extends JPanel implements ActionListener {

	//Instance variable that holds a queue of IceCreamCone objects
	public QueueLL<IceCreamCone> iceCreamLine = new QueueLL<IceCreamCone>();
	//Creates a JPanel to hold the queue and a JButton
	public JPanel coneList = new JPanel();
	
	//Creates a JButton that says Add a random order
	public JButton addO = new JButton("Add a random order");
	
	/**
	 * Constructor, to create a new panel
	 **/
	public IceCreamLine()
	{
		//Uses border layout
		super(new BorderLayout());
		//Sets JPanel layout to box layout
		coneList.setLayout(new BoxLayout(coneList, BoxLayout.PAGE_AXIS));
		//Adds the JPanel to the center
		this.add(coneList, BorderLayout.CENTER);
		//Updates the view
		repaint();

		//Creates a new JPanel
		JPanel northPanel = new JPanel();
		//Adds actionListener to the add a random order JButton
		addO.addActionListener(this);
		//Adds the JButton to the JPanel
		northPanel.add(addO);
		//Adds the northPanel to the north
		this.add(northPanel, BorderLayout.NORTH);
		
	}
	
	/**
	 * Method that adds a cone with a random number of random flavoured scoops to the JPanel
	 */
	public void addOrder ()
	{
		//Creates a new cone
		IceCreamCone newCone = new IceCreamCone();
		
		//Creates a random number from 1-4
		int rand = (int) (Math.random()*4) + 1;
		
		//Adds a random number from 1-4 of randomly flavoured scoops to the new cone and adds the new cone to the ice cream line queue
		if(rand == 1)
		{
			newCone.addRandScoop();
			iceCreamLine.enqueue(newCone);
		}
		else if(rand == 2)
		{
			newCone.addRandScoop();
			newCone.addRandScoop();
			iceCreamLine.enqueue(newCone);
		}
		else if(rand == 3)
		{
			newCone.addRandScoop();
			newCone.addRandScoop();
			newCone.addRandScoop();
			iceCreamLine.enqueue(newCone);
		}
		else if(rand == 4)
		{
			newCone.addRandScoop();
			newCone.addRandScoop();
			newCone.addRandScoop();
			newCone.addRandScoop();
			iceCreamLine.enqueue(newCone);
		}
		
		//Creates a new view for this new cone
		IceCreamConeView view = new IceCreamConeView(newCone);
		//Adds the view JComponent to the box JPanel
		coneList.add(view);
	}
	
	
	/**
	 * Needed to sense which JButtons were pressed 
	 */
	public void actionPerformed(ActionEvent event) {
		//Finds the source of the ActionEvent
        Object source = event.getSource();
		
        //If the add random order button was clicked it calls a method to add a random order
		if(source == addO)
		{
			addOrder();
		}
		//Updates view
		coneList.validate();
		repaint();
		
	}
}
