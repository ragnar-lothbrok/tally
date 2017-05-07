package p1caccia.test;

public class Vehicle implements ManipulateAnimals {
	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Vehicle(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public void resizeObject() {
		System.out.println(this.getClass().getSimpleName() + " Resized");
	}

	@Override
	public void rotateObject() {
		System.out.println(this.getClass().getSimpleName() + " rotate");
	}

	@Override
	public void playSound() {
		System.out.println(this.getClass().getSimpleName() + " makeSound");
	}

	@Override
	public void drawObject() {
		System.out.println(this.getClass().getSimpleName() + " draw");
	}

}
