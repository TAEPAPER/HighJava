package Step01;


public class dice {
	public static void main(String[] args) {
	   int a = (int)(Math.random()*6)+1;
	   int b = (int)(Math.random()*6)+1;
	   int c = (int)(Math.random()*6)+1;

	   if(a == b && a == c && b == c)
		{
			System.out.print(10000+(a*1000));
		}
		else if(a == b || a == c)
		{
		System.out.print(1000+(a*100));
		}
		else if(b == c)
		{
		System.out.print(1000+(b*100));
		}
		else
		{
			System.out.print((Math.max(a, Math.max(b, c)))*100);
		}
	
	   
		}
	}

