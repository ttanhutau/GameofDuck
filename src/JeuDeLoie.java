import java.util.Random;

public class JeuDeLoie {
	
	static final int casedefin = 63;
	public int position = 0;

	public int lancerDe() {
		
		Random rd = new Random();
		final int valmin = 1;
		final int valmax = 6;
		return rd.nextInt((valmax-valmin)+1)+1;	
		
	}
		public boolean partieFinie(int position){
			if(this.position == casedefin) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean estSurUneOie(int position) {
			if(position % 9 == 0 ){
				return true;
			}else {
				return false;
			}
		}

		public int avancerPionJoueur(int position , int valeurde, int valeurde2) {
			int valeurdesde = valeurde + valeurde2;
			
			caculSpecialOie(this.position, valeurde, valeurde2);
			
			if(this.position != casedefin) {
				
				if (estSurUneOie(this.position)) {
					
				 this.position = position + valeurdesde;
				 
				}
			}
				
			  if(position + valeurdesde > casedefin) {
					
					int retour = (position + valeurdesde) - casedefin;
					if((casedefin - retour) == 54) {
						return this.position = 44;
					}else {
					return this.position = (position +1) - retour;
					}
				}
				
				else{
				return this.position = position + valeurdesde;
				}
			
	}

		public int caculSpecialOie(int position ,int valeurde , int valeurde2) {
			
			if((position == 0 && valeurde == 6 && valeurde2 == 3 )|| (position == 0 && valeurde == 3 && valeurde2 == 6) ) {
				return this.position = 26;
				
			}
			
			if(position == 0 && valeurde == 4 && valeurde2 == 5 || position == 0 && valeurde == 5 && valeurde2 == 4 ) {
				return this.position = 53;
			}
			return position;
		}
		
		public int caseSurprises(int position) {
			if (position == 6) {
				this.position = 12;
				System.out.println(" le pont ");
			}
			if (position == 19) {	
				this.position = 3;
				System.out.println(" l'hotel ");
			}
			if (position == 31) {
				this.position = 2;
				System.out.println(" le piege ");
			}
			if (position == 42) {
				this.position = 30;
				System.out.println(" le labyrinthe ");
			}
			if (position == 52) {
				this.position = 62;
				System.out.println(" le train ");
			}
			if (position == 58) {
				this.position = 1;
				System.out.println(" la mort ");
			}
			return position;
		}
		
		public boolean jouerJeuDeLoie(int position , int valeurde, int valeurde2) {
			
			avancerPionJoueur(position, valeurde, valeurde2);
			
			if(this.position != 63 && this.position != 0) {
				
				if(estSurUneOie(this.position)) {
					
					this.position += valeurde + valeurde2;
				}
				if(position == 9) {
				caculSpecialOie(position, valeurde, valeurde2);
				}
			}
			partieFinie(position);
			if(partieFinie(position) == true) {
				System.out.println("partie gagné");
				return true;
			}
			return false;
		}
}