public class StringReverse {

	public static void main(String[] args) {
		
			if( args.length == 1)
			{
				String reverse = new StringBuffer(args[0]).reverse().toString();
				System.out.println(reverse);
							
			}
			else
			{
				System.out.println("B��d. Nie podano dok�adnie jednego argumentu.");
			}

	}

}
