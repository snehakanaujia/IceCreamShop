import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class IceCreamConeMaker extends JPanel implements ActionListener {
	
	public IceCreamCone cone = new IceCreamCone();
	public IceCreamConeView view = new IceCreamConeView(cone);
	
	//Creates a JButton that says strawberry
	JButton strawberry = new JButton("strawberry");

	//Creates a JButton that says blueberry
	JButton blueberry = new JButton("blueberry");

	//Creates a JButton that says mango
	JButton mango = new JButton("mango");

	//Creates a JButton that says pistachio
	JButton pistachio = new JButton("pistachio");

	//Creates a JButton that says cookiesandcream
	JButton cookiesandcream = new JButton("cookies and cream");
	
	//Creates a JButton that says cookiesandcream
	JButton trash = new JButton("Trash the top scoop!");

	/**
	 * Contructor
	 */
	public IceCreamConeMaker()
	{
		// Set the layout to be border-style
		super(new BorderLayout());
		
		//Adds the view to the center of the frame
		this.add(view, BorderLayout.CENTER);
		
		//Creates a JPanel that will be in the north
		JPanel northPanel = new JPanel(new BorderLayout());
		//Creates a JPanel that will contain all the flavour buttons be in the north of the northPanel
		JPanel buttonPanel = new JPanel(new GridLayout());

		//Sets the color of the strawberry button to pink
		strawberry.setBackground(Color.PINK);
		//Makes the strawberry button opaque
		strawberry.setOpaque(true);
		//Adds the strawberry button to the northern panel
		buttonPanel.add (strawberry);
		//Adds actionlistener to the button
		strawberry.addActionListener(this);
		
		//Sets the color of the blueberry button to blue
		blueberry.setBackground(new Color(181, 232, 255));
		//Makes the blueberry button opaque
		blueberry.setOpaque(true);
		//Adds the blueberry button to the northern panel
		buttonPanel.add (blueberry);
		
		//Adds actionlistener to the button
		blueberry.addActionListener(this);
		
		//Sets the color of the mango button to orange
		mango.setBackground(Color.ORANGE);
		//Makes the mango button opaque
		mango.setOpaque(true);
		//Adds the mango button to the northern panel
		buttonPanel.add (mango);
		//Adds actionlistener to the button
		mango.addActionListener(this);

		//Sets the color of the pistachio button to green
		pistachio.setBackground(new Color(221, 244, 73));
		//Makes the pistachio button opaque
		pistachio.setOpaque(true);
		//Adds the pistachio button to the northern panel
		buttonPanel.add (pistachio);
		//Adds actionlistener to the button
		pistachio.addActionListener(this);

		//Sets the color of the cookiesandcream button to white
		cookiesandcream.setBackground(Color.WHITE);
		//Makes the cookiesandcream button opaque
		cookiesandcream.setOpaque(true);
		//Adds the cookiesandcream button to the northern panel
		buttonPanel.add (cookiesandcream);
		//Adds actionlistener to the button
		cookiesandcream.addActionListener(this);
		
		//Adds the buttons to the north of the nor
		northPanel.add (buttonPanel, BorderLayout.NORTH);
		
		//Makes the trash button opaque
		trash.setOpaque(true);
		//Adds the trash button to the northern panel
		northPanel.add (trash, BorderLayout.CENTER);
		//Adds actionlistener to the button
		trash.addActionListener(this);

		//Places this panel to the northern part of the canvas borderlayout.
		add (northPanel, BorderLayout.NORTH);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		//Finds the source of the ActionEvent
        Object source = event.getSource();
		
        //Depending on what button was clicked, adds the appropriatly flavoured ice cream scoop to the cone or removes the top scoop
		if(source == strawberry)
		{
			cone.addScoop("strawberry");
		}
		else if(source == mango)
		{
			cone.addScoop("mango");
		}
		else if(source == blueberry)
		{
			cone.addScoop("blueberry");
		}
		else if(source == pistachio)
		{
			cone.addScoop("pistachio");
		}
		else if(source == cookiesandcream)
		{
			cone.addScoop("cookiesandcream");
		}
		else if(source == trash)
		{
			cone.eatScoop();
		}
		
		//Refreshes the view
		view.repaint();
	}
}
