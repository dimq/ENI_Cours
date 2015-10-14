import java.text.ParseException;


public class test {

	public static void main(String[] args) {
		/*Client c = null;
		try {
			c = new Client("michel", "jean-pierre", "1 rue judicael", "35330", "     saint l'hermite-en-vacances ");
			System.out.println(c.getClientToString());
		} catch (Exception e) {
			
			e.printStackTrace();
		}*/
		
		
		
		Livre l = null;
		try {
			l = new Livre("winds of winter","grr martin",1000,"105-2-4569-2058-1");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println(l.getLivreToString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
