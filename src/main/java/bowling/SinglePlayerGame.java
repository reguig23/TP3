package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
         int nbre_de_point;
         int nombre_de_tour;
         int quille_premier_tour=0;
         boolean spare=false;
         boolean strike=false;
       
	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
           this.nbre_de_point=0;
        }
	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
        
                if (this.quille_premier_tour==0 && nombreDeQuillesAbattues<10   ){
                    if (spare==false && strike==false){
                    this.quille_premier_tour+=nombreDeQuillesAbattues;
                   
                    }
                    else if ( strike || spare) {
                         
                        
                         this.quille_premier_tour+=nombreDeQuillesAbattues*2;
                       
                        
                    }
                }
                
                 else if ((this.quille_premier_tour!=0 && this.quille_premier_tour!=10) && this.quille_premier_tour+ nombreDeQuillesAbattues<10 ){
                          
                         if (  strike==false){
                             
                            this.nbre_de_point+=this.quille_premier_tour+nombreDeQuillesAbattues;
                            this.quille_premier_tour=0;
                         }
                         
                         else if (spare){
                             spare=false; 
                         }
                         
                         else if (strike){
                             
                             this.nbre_de_point+=this.quille_premier_tour+(nombreDeQuillesAbattues*2);
                             this.quille_premier_tour=0;
                             strike=false; 
                         }
                 }
                
                 else if ((quille_premier_tour!=0 && quille_premier_tour!=10) && quille_premier_tour+ nombreDeQuillesAbattues==10 ){
                     
                     this.spare=true;
                     this.nbre_de_point+=this.quille_premier_tour+nombreDeQuillesAbattues;
                     this.quille_premier_tour=0;
                }
                
                 else if (nombreDeQuillesAbattues==10){
                   
                     this.strike=true;
                     this.nbre_de_point+=nombreDeQuillesAbattues;
                     
                     
                 }
                
        
        }
                
               

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            return this.nbre_de_point;
	}
        
        
}
