/* The observer pattern defines a one to many dependency
 * between objects. If the Publisher change, all the consumer may
 * be notified about that change.
 * 
 */

import java.util.ArrayList;

interface Subject{
	public void registerObserver(Observer1 o);
	public void removeObserver(Observer1 o);
	public void notifyObservers();
}

interface Observer1 {
	public void update(float temp);
}
class CurrentConditionsDisplay implements Observer1 {
	public void update(float temp) {
		System.out.println("Temp changed" + temp);
	}
}

class AnotherObserver implements Observer1 {
	public void update(float temp) {
		System.out.println("Another Observer: " + temp);
	}
}
class WeatherData implements Subject {
	float temp;
	ArrayList<Observer1> observers;
	
	public WeatherData(){
		observers = new ArrayList<Observer1>();
		this.temp = 1;
	}
	
	public void registerObserver(Observer1 o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer1 o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	public void notifyObservers() {
		for(Observer1 o: observers) {
			o.update(temp);
		}
	}
	
	public void setTemp(float temp) {
		this.temp = temp;
		notifyObservers();
	}
		
}
public class Observer_Pattern {
	public static void main(String[] args) {
	  WeatherData w = new WeatherData();
	  w.setTemp(2);
	  CurrentConditionsDisplay c = new CurrentConditionsDisplay();
	  AnotherObserver o = new AnotherObserver();
	  w.registerObserver(c);
	  w.setTemp(3);
	  w.registerObserver(o);
	  w.setTemp(4);
	  w.removeObserver(c);
	  w.setTemp(5);




	  
	  
	}

}
