package Zadatak3;

public class JedinicaMere {

	//● ima privatnu konstantnu ​oznaku​ tipa String koja se setuje pri instanciranju objekta tipa 
	//JedinicaMere​ i može imati jednu od četiri vrednosti "kom", "l", "m" и "kg", a sam konstruktor 
	//diže grešku ako se pokuša oznaci dodeliti neka vrednost koja nije jedna od 4 navedene;
	private String oznaka;
	
	public JedinicaMere(String oznaka) {
		if(oznaka.equals("kom") || oznaka.equals("l") || oznaka.equals("m") || oznaka.equals("kg")) {
			this.oznaka = oznaka;
		}
		else {
			Exception e = new Exception("Oznaka mora biti jedna od dozvoljenih vrednosti");
			e.printStackTrace();
		}
	}
	
	
	//● string reprezentaciju koja sadrži oznaku.
	@Override
	public String toString() {
		return "Oznaka: " + this.oznaka;
	}
}
