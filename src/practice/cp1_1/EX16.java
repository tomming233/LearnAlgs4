package practice.cp1_1;

public class EX16 {
	public static String exR1(int n) {
		if (n <= 0) return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(exR1(6));
	}

}