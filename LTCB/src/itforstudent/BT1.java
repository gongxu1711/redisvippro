package itforstudent;

abstract class Main{
	public int age = 10;
	public String fname = "Tu";
	public abstract void study();
}

class student extends Main{
	public int gratulation = 2023;
	public void study() {
		System.out.println("Study");
	}
}