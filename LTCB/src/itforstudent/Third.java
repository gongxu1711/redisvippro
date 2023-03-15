package itforstudent;

public class Third {
	
	private String name = "Tu";
	
	public String getName(){
		return name;
	}
	
	public void setName(String a) {
		this.name = a;
	}
	
	public static void main(String[] args) {
		Third myObj = new Third();
		System.out.println(myObj.name);
	}
}
