
public class Palindrome {

	public static void main(String[] args) {
		
		String text="MADAM";
		String rev="";
		
		char c;
		
		for(int i=0; i<text.length();i++) {
			c=text.charAt(i);
			rev=c+rev;
		}
		//System.out.println(rev);
		//check palindrome or not
		if(text.equalsIgnoreCase(rev)) {
			System.out.println("is palindrome");
		}
		else
			System.out.println("not a palindrome");
	}

}
