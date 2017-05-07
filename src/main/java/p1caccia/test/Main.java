package p1caccia.test;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		List<ManipulateAnimals> list = new ArrayList<ManipulateAnimals>();
		
		list.add(new Animal("Boar", 13));
		list.add(new Animal("Dog", 23));
		
		list.add(new Vehicle("Car", 13));
		list.add(new Vehicle("Bus", 23));
		
		
		for(ManipulateAnimals activity : list){
			activity.drawObject();
			activity.playSound();
			activity.resizeObject();
			activity.rotateObject();
		}
		
	}
}
