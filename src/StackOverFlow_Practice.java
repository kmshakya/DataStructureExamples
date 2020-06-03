import java.time.LocalDate;

public class StackOverFlow_Practice {

	public static void main(String[] args) {
		String sb1="";
		String sb2="";
		sb1= 1+sb1;
		sb1= 2+sb1;
		sb1= 3+sb1;
		sb2= 4+sb2;
		sb2= 5+sb2;
		sb2= 6+sb2;
		int sum=Integer.parseInt(sb1)+Integer.parseInt(sb2); //975
		while(sum%10>0) {
			System.out.println(sum%10);
			sum=sum/10;
		}
		
	}

}
