package tets;

public class Demo {
	public static void main(String[] args) {
	String str="jgaikwa22@";
	String s="";
	int sum=0;
	int a=0;
	char ch[]=str.toCharArray();
	for(char c:ch) {
		if(Character.isDigit(c)) {
			a++;
			sum=sum+Character.getNumericValue(c);
			
		}
	}
		System.out.println(s);
		//sum=sum+Character.getNumericValue(a);
		System.out.println(sum);
		}
	}
	


