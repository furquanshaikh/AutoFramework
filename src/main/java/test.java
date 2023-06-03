import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//multiplication table of 10
		for(int i=1;i<=10;i++) {
			System.out.println("10 x "+i+ " = "+10*i);
			//System.out.println(7+(3*5)*(4/2)+(5%3)-1);
		}
		
		//swap 2 nos
		int a =1,b=2,c;
		c=a;
		a=b;
		b=c;
		System.out.println(a+ "..."+b);
		
		//sum of all digit
		int number=123456789;
		int sum = 0;
		while(number!=0)
		{
			int remainder = number%10; //12345 % 10 -> gives last digit
			sum = sum+remainder;
			number=number/10; // divide by 10 to eleminate last digit
		}
		System.out.println("sum = "+sum);
		
		//string to integer
		String str = "100";
		System.out.println("data type is "+str.getClass().getSimpleName()); //check data type
		int num = Integer.parseInt(str);
		System.out.println(num+1);
		
		//integer to string
		int ab=123;
		String mystr = Integer.toString(ab);
		System.out.println("data type of mystr " +mystr.getClass().getSimpleName());
		
		//fibonaci series till 50
		String name = "Furquan";
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter a number");
		int number= scanner.nextInt();
		scanner.close();
		
		int x=1,y=1,f=0;
		System.out.print(x+" ");
		System.out.print(y+" ");
		while(f<=number) {
			f=x+y;
			if(f>number)
				break;
			System.out.print(f+" ");
			x=y;
			y=f;
		}
		*/
		
		//reverse a string
		String proper="abcd",rev="";
		char c;
		for(int i=0;i<proper.length();i++) {
			//System.out.print(i);
			c= proper.charAt(i);
			
			rev=c+rev;
		}
		System.out.print(rev);
	}
}



