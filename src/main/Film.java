package main;

import java.io.Serializable;
import java.util.Comparator;


public class Film implements Serializable{

	private static final long serialVersionUID = 1L;
		private String titre;
		private int anneeReal;
		private String genre;
		private int duree;
		private String paysProd;
		private String langue;
		private String real;
		private String scenariste;
		private String listeActeurs;
		private String description;
		private int nbVotes;
		private float moyenneVotes;

		
		static public Comparator<Film> compareNom = new Comparator <Film>() {

		    public int compare(Film f1, Film f2) {

		        return f1.titre.compareToIgnoreCase(f2.titre);
}};

		static public Comparator<Film> compareNbVote = new Comparator <Film>() {
		
		    public int compare(Film f1, Film f2) {
		    	
		        return f1.nbVotes-f2.nbVotes;

    }
		    
		//static public Comparator<Film> compareFilm = new Comparator <Film>() {
			
			//return null
			
		//}
};}