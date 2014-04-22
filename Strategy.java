interface FlyBehavior {
	public void fly();
}

interface QuackBehavior {
	public void quack();
}

class FlyWithWings implements FlyBehavior {
  public void fly() {
	  System.out.println("Flying with Wings!");
  }
}


class FlyNoWay implements FlyBehavior {
	  public void fly() {
		  System.out.println("No way I will Fly!");
	  }
}


class Quack implements QuackBehavior {
	   public void quack() {
	      System.out.println("Quack");
	   }
}

class MuteQuack implements QuackBehavior {
	   public void quack() {
	       System.out.println("<< Silence >>");
	   }
}
	

abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
	public Duck() {
	
	}
	
	public void performFly() {
		flyBehavior.fly();
	}
	public void performQuack(){
		quackBehavior.quack();
		
	}
	
}

class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new MuteQuack();
	}
	public void setFlyBehavior(FlyBehavior flyBehavior){
		this.flyBehavior = flyBehavior;
	}
}
public class Strategy {
  public static void main(String[] args){
    ModelDuck myDuck = new ModelDuck();
    myDuck.performFly();
    myDuck.setFlyBehavior(new FlyWithWings());
    myDuck.performFly();

  }
}
