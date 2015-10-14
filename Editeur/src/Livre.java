import java.text.ParseException;

import javax.swing.text.MaskFormatter;


public class Livre {
	private String titre;
	private String auteur;
	private int nbpages;
	private long isbn;
	
	public Livre(String titre, String auteur, int nbpages, String isbn) throws Exception {
		super();
		this.setTitre(titre);
		this.setAuteur(auteur);
		this.setNbpages(nbpages);
		this.setIsbn(isbn);
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return this.auteur;
	}

	public void setAuteur(String auteur) throws Exception {
		if(auteur == null || "".equals(auteur))
		{
			throw new Exception("L'auteur est obligatoire");
		}
		else
		{
			this.auteur = auteur;
		}
	}

	public int getNbpages() {
		return this.nbpages;
	}

	public void setNbpages(int nbpages) {
		if (nbpages > 0)
		{
			this.nbpages = nbpages;
		}
	}

	public String getIsbn() throws ParseException {
		String isbn2 = "";
		try
		{
			MaskFormatter mf = new MaskFormatter("###-#-####-####-#");
			mf.setValueContainsLiteralCharacters(false);
			isbn2 = mf.valueToString(String.valueOf(this.isbn));
		}
		catch(Exception e)
		{
			
		}
		return isbn2;
		
	}

	public void setIsbn(String isbn) {
		String str = "";
		for(int i =0 ;i<isbn.length();i++)
		{
			if(isbn.charAt(i)>= '0' && isbn.charAt(i) <= '9')
			{
				str += isbn.charAt(i);
			}
		}
		
		this.isbn = Long.valueOf(str);
	}
	
	public double getPrix()
	{
		return (this.getNbpages()*0.05)+10;
	}
	
	public String getLivreToString() throws ParseException
	{
		return this.getTitre()+" "+this.getPrix()+"€\n"+this.getAuteur()+"\n"+this.getIsbn()+"\nNombres de pages : "+this.getNbpages();
	}
	
}
