package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.LinkedList;
import java.util.List;

public class MenuFilms {
	static int tailleListe = 80944;
	public static void main() throws IOException{
		
		String nomFichier = "IMDbmoviesFULL.tsv";
		
		System.out.println("Veuillez choisir l'action à effectuer :"
				+ "1)charger les films"
				+ "2)afficher les films"
				+ "3)trier les films"
				+ "4)filtrer les films"
				+ "5)rechercher un film par le titre"
				+ "6)sauvegarder le tri ou la recherche"//optionnel
				+ "7)quitter");
		
		int action = Clavier.lireInt();
		
		while(action!=7){
			if (action==1){ 
				System.out.println("Veuillez saisir la base de données souhaitée :"
						+ "1) Base complète (80 944 films)"
						+ "2) Base partielle (40 000 films)"
						+ "3) Base partielle (10 000 films)"
						+ "4) Base partielle (1 000 films)"
						+ "5) Base partielle (100 films)");
				int base = Clavier.lireInt();
				choixBase(base);
			}
			else if (action==2){
				System.out.println("Veuillez saisir la base de données souhaitée :"
						+ "1) Base complète (80 944 films)"
						+ "2) Base partielle (40 000 films)"
						+ "3) Base partielle (10 000 films)"
						+ "4) Base partielle (1 000 films)"
						+ "5) Base partielle (100 films)");
				int base = Clavier.lireInt();
				choixBase(base);
			}
			else if (action==3){
				System.out.println("Quel type de tri souhaitez-vous ?"
						+ "1) tri sélection"
						+ "2) tri fusion"
						+ "3) tri Java");
				int typeTri = Clavier.lireInt();
				if (typeTri==1) {
					triSelection(listeFilms, attribut);
				}
				else if (typeTri==2) {
					triFusion(tab, g, d);//pour l'instant c'est un tableau en paramètre, il faudra changer
				}
				else if (typeTri==3) {
					//se documenter sur algo tri java (Collections.sort(liste, fonction_comparaison))
					//algo utilisé : TimSort, c'est une fonction fusion hybride
				}
				
			}
			else if (action==4){
				System.out.println("Quel type de filtre souhaitez-vous ?"
						+ "1)Filtre linéaire"
						+ "2)Filtre java");
				int typeFiltre = Clavier.lireInt();
				if (typeFiltre==1){
					System.out.println("Quel critère utilisez-vous pour le filtre ?"
							+ "1) titre"
							+ "2) année"
							+ "3) genre"
							+ "4) duree"
							+ "5) pays"
							+ "6) langue"
							+ "7) réalisateur"
							+ "8) scénariste"
							+ "9) acteur");
					int critere = Clavier.lireInt();
					filtreLineaire(nomFichier, critere);
				}
			}
			else if (action==5){
				System.out.println("Quel type de recherche voulez-vous effectuer ?"
						+ "1) recherche linéaire"
						+ "2) recherche dichotomique");
				int typeRecherche = Clavier.lireInt();
				System.out.println("Veuillez renseigner le titre du film recherché :");
				String titre = Clavier.lireString();
				if (typeRecherche==1) {
					rechercheLineaire(listeFilm, titre);
				}
				else if (typeRecherche==2) {
					rechercheDichotomique(listeFilm, titre);
				}
			}
			else if (action==6){
				System.out.println("action==6");
			}
			System.out.println("Veuillez choisir l'action à effectuer :"
				+ "1)charger les films"
				+ "2)afficher les films"
				+ "3)trier les films"
				+ "4)filtrer les films"
				+ "5)rechercher un film par le titre"
				+ "6)sauvegarder le tri ou la recherche"//optionnel
				+ "7)quitter");
		
			action = Clavier.lireInt();
		}
		//arrêt du programme
		System.out.println("arrêt du programme");
	}
	
	public static int choixBase(int base) {
		String nomFichier = "IMDbmoviesFULL.tsv";
		if (base==2){
			nomFichier = "IMDbmoviesCUT40000.tsv";
			tailleListe = 40000;
		}
		else if (base==3){
			nomFichier = "IMDbmoviesCUT10000.tsv";
			tailleListe = 10000;
		}
		else if (base==4){
			nomFichier = "IMDbmoviesCUT1000.tsv";
			tailleListe = 1000;
		}
		else if (base==5){ 
			nomFichier = "IMDbmoviesCUT100.tsv";
			tailleListe = 100;
		}
		FileReader FileReader = new FileReader(nomFichier);
		BufferedReader tsvReader = new BufferedReader(FileReader);
		String row=new String();
		row=tsvReader.readLine();
	}
	
	public static Object filtreLineaire(Object listeFilms, Object critere){
		List < Film > lFilms = new LinkedList < Film > ();
		for (int i=0; i<=tailleListe; i++){
			//if (listeFilms[i]==critere){//ça ne sera pas listeFilms[i] mais c'est en attendant
			//	lFilms = listeFilms[i])//ça ne sera pas listeFilms[i] mais c'est en attendant
			//}
		}
		
		return null;
	}
	
	//les algos de tri utilisent un tableau, donc à changer
	public static Object triSelection(listeFilms, attribut) {
			//algo de tri sélection d'un tableau :
			int ind=0, variable=0, minimum = tableau[0];
			
			for(int i=0; i<(n-2); i++ ){
				for(int f=i+1; f<(n-1); f++){
					if (minimum>tableau[f]){
						minimum = tableau[f];
						ind = f;
					}
				}
				variable = tableau[i];
				tableau[i] = tableau[ind];
				tableau[ind] = variable;
			}
	}
	
	public static void triFusion(int []tableau, int g, int d){
		int milieu = 0;
		
		if(g<d){
			milieu = (int)((g+d)/2);
			triFusion(tableau, g, milieu);
			triFusion(tableau, milieu+1, d);
			fusionner(tableau, g, milieu, d);
			
		}
	}
		public static void fusionner(int [] tableau, int g, int milieu, int d){
			for (int i=0; i<d; i++){
				if (tableau[g+i]<=tableau[milieu +1 +i]){
					copieTab[i] = tableau[g];
				}
				else if (tableau[g+i]>tableau[milieu +1 +i]){
					copieTab[i] = tableau[milieu +1 +i];
				}
			}
			System.out.println("le tableau = "+copieTab);
			
		}
			
	}
}