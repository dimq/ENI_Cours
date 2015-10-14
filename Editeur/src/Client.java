
public class Client {
	private String adresse;
	private int cp;
	private String nom;
	private String prenom;
	private String ville;
	
	
	public Client(String nom,String prenom,String adresse,String cp, String ville) throws Exception {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setCodePostal(cp);
		this.setVille(ville);
		
	}


	public String getAdresse() {
		return this.adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getCodePostal() {
		return Integer.toString(this.cp);
	}


	public void setCodePostal(String cp) throws Exception {
		boolean hasError = false;
		try
		{
			int code = Integer.parseInt(cp);
			if(code >= 1000 && code <= 99999)
			{
				this.cp = code;
			}
			else
			{
				hasError = true;
			}
		}
		catch (NumberFormatException e)
		{
			hasError = true;
		}
		if(hasError)
		{
			throw new Exception("Vous avec entré une mauvaise valeur ou pas de valeur veuillez recommencer");
		}
	}
	
	public String getPrenom() {
		return this.prenom;
	}


	public void setPrenom(String prenom) throws Exception {
		this.prenom = firstInUpper(prenom,"-' ");
	}


	public String getNom() {
		return this.nom;
	}


	public void setNom(String nom) throws Exception {
		if(nom == null ||"".equals(nom.trim()))
		{
			throw new Exception("Le nom n'est pas renseigné et doit obligatoirement ètre renseigné");
		}
		else
		{
			this.nom = nom.toUpperCase();
		}
	}


	public String getVille() {
		return this.ville;
	}


	public void setVille(String ville) throws Exception {
		if (ville == null || "".equals(ville.trim()))
		{
			throw new Exception("La ville est obligatoire");
		}
		else
		{
			this.ville = firstInUpper(ville,"-' ");
		}
	}
	
	public String getClientToString()
	{
		return this.getNom()+" "+this.getPrenom()+"\n"+this.getAdresse()+"\n"+this.getCodePostal()+" "+this.getVille();
	}
	
	private static String firstInUpper(String chaine,String separateurs) throws Exception{
		
		if(!(chaine == null) || !("".equals(chaine)))
		{
			chaine = chaine.trim().toLowerCase();
			boolean mettreEnMajusculeLeProchaineCaractere=false;
			char [] caracteres =chaine.toCharArray();
			caracteres[0]= Character.toUpperCase(caracteres[0]);
			for (int i=0;i<caracteres.length;i++){
				if (mettreEnMajusculeLeProchaineCaractere){
					caracteres[i]=Character.toUpperCase(caracteres[i]);
					mettreEnMajusculeLeProchaineCaractere=false;
				}
				if(separateurs.contains(String.valueOf(caracteres[i]))){
					mettreEnMajusculeLeProchaineCaractere=true;
				}
				
				
			}
			chaine = String.valueOf(caracteres);
		}
		else
		{
			chaine = "";
		}
		return chaine;
	}
}
