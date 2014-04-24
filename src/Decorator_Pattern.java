/* Decorator Pattern */

/* The decorator pattern allow us to apply the open/closed principle
 * This means that classes should be closed for modifications 
 * but open for extension
 */

/* With the decorator pattern we are able to attach
 * new behavior or responsibilities to an object dynamically
 * It is an alternative to subclassing for extending functionality
 */



abstract class Beverage 
{
	String description ="Unknown Beverage";
	
	public String getDescription()
	{
		return description;
	}
	public abstract double cost();
}
abstract class CondimentDecorator extends Beverage 
{
	public abstract String getDescription();
}

class Expresso extends Beverage 
{
	public Expresso()
	{
		description = "Expresso";
	}
	public double cost(){
		return 1.9;
	}
}


class Soy extends CondimentDecorator
{
	Beverage beverage;
	public Soy(Beverage b)
	{
		this.beverage = b;
	}
	public String getDescription() 
	{
	  return "Soy " + beverage.getDescription();	
	}
	
	public double cost()
	{
		return 1 + beverage.cost();
	}
}

class Whip extends CondimentDecorator
{
	Beverage beverage;
	public Whip(Beverage b)
	{
		this.beverage = b;
	}
	public String getDescription() 
	{
	  return "Whip " + beverage.getDescription();	
	}
	
	public double cost()
	{
		return 3 + beverage.cost();
	}
}


public class Decorator_Pattern 
{
  public static void main(String[] args)
  {
	Beverage b = new Expresso();
	System.out.println(b.getDescription());
	System.out.println(b.cost());

	b = new Whip(b);
	System.out.println(b.getDescription());
	System.out.println(b.cost());
	
	b = new Soy(b);
	System.out.println(b.getDescription());
	System.out.println(b.cost());
  }
}
