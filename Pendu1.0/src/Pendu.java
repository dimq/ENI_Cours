import java.util.Scanner;


public class Pendu {

	public static void main(String[] args) {
		int nbEssais = 5;
		String pendu = "";
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Joueur 1 veuillez saisir le mot à découvrir:");
		String mot = sc.nextLine();
		String copieMot = mot;
		
		
		char[] mot1;
		
		StringBuffer str =new StringBuffer();
		StringBuffer str1 =new StringBuffer();
		mot1 = copieMot.toCharArray();
		
		for(int i =0;i<mot1.length;i=i+1)
		{
			if(mot1[i] >= 'a' && mot1[i] <= 'z' || mot1[i] >= 'A' && mot1[i] <= 'Z' || mot1[i] >= 'é' && mot1[i] <= 'ù')
			{
				str.append('_');
				str.append(' ');
				str1.append(mot1[i]);
				str1.append(' ');
			}
			else
			{
				str.append(mot1[i]);
			}
		}
		
		char[] motEnCour = new char[str.length()];
		motEnCour = new String(str).toCharArray();
		
		while((nbEssais > 0) && (sontEgaux(motEnCour,str1))==false)
		{
			System.out.println("Joueur 2 veuillez saisir un caractère:");
			String caractere = sc.nextLine();
			
			char c =caractere.charAt(0);
			
			boolean trouve =false;
			for(int i =0;i<str1.length();i++)
			{
				if(str1.charAt(i)==c)
				{
					motEnCour[i] = c;
					trouve = true;
				}
				
			}
			if(trouve == false)
			{
				nbEssais--;
			}
			System.out.println(motEnCour);
			System.out.println("Il vous reste "+nbEssais+ " essais!");
			
		}
		if(nbEssais > 0)
		{
			System.out.println("Bravo vous avez trouvé le mot qui est :"+str1);
		}
		else
		{
			System.out.println("Dommage tu es mauvais!");
		}
	}
	
	public static boolean sontEgaux(char[] mot1, StringBuffer mot2)
	{
		return new String(mot1).equals(new String(mot2));
	}
}