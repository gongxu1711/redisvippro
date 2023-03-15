
package itforstudent;
import java.util.Scanner;

public class Fouth {
	public static void main(String[] args) {
		Third myObj = new Third();
		Scanner scan = new Scanner(System.in);
		String s =  scan.nextLine();
		myObj.setName(s);
		System.out.println(myObj.getName());
	}
}
