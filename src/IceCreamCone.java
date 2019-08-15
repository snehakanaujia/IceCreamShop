/**
 * IceCreamCone object holds a stack of flavour Strings/scoops, has methods to add specific flavoured scoops and random combinations of scoops
 * @author Sneha Kanaujia
 *
 */
public class IceCreamCone {
	
	//Stack of scoop flavours
	public StackLL<String> stack = new StackLL<String>();
	
	/**
	 * Adds a scoop of the specified flavour
	 * @param flavour desired for the next scoop on the ice cream cone
	 */
	public void addScoop(String flavour)
	{
		//Adds the correct tye of ice cream scoop based on what flavour was passed in to the stack of scoops
		if(flavour == "strawberry")
		{
			stack.push("strawberry");
		}
		else if(flavour == "mango")
		{
			stack.push("mango");
		}
		else if(flavour == "blueberry")
		{
			stack.push("blueberry");
		}
		else if(flavour == "pistachio")
		{
			stack.push("pistachio");
		}
		else if(flavour == "cookiesandcream")
		{
			stack.push("cookiesandcream");
		}
		
	}
	

	/**
	 * Adds a random scoop of the specified flavour
	 */
	public void addRandScoop()
	{
		int rand = (int) (Math.random()*5);
		if(rand == 0)
		{
			stack.push("strawberry");
		}
		else if(rand == 1)
		{
			stack.push("mango");
		}
		else if(rand == 2)
		{
			stack.push("blueberry");
		}
		else if(rand == 3)
		{
			stack.push("pistachio");
		}
		else if(rand == 4)
		{
			stack.push("cookiesandcream");
		}
	}
	
	/**
	 * Deletes the top scoop of ice cream
	 */
	public void eatScoop()
	{
		stack.pop();
		
	}
	
	
	
}
