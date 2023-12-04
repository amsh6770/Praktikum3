package business;

public class Buergeramt {

	// Name des Buergeramtes
	private String name;
	// Oeffnungszeiten
	private float geoeffnetVon;
	private float geoeffnetBis;
	// Strasse und Hausnummer des Buergeramtes
	private String strasseHNr;
	// Dienstleistungen des Buergeramtes
	private String[] dienstleistungen;

	public Buergeramt(String name, float geoeffnetVon, float geoeffnetBis, String strasseHNr,
			String[] dienstleistungen) {
		this.name = name;
		this.geoeffnetVon = geoeffnetVon;
		this.geoeffnetBis = geoeffnetBis;
		this.strasseHNr = strasseHNr;
		this.dienstleistungen = dienstleistungen;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getGeoeffnetVon() {
		return geoeffnetVon;
	}

	public void setGeoeffnetVon(float geoeffnetVon) {
		this.geoeffnetVon = geoeffnetVon;
	}

	public float getGeoeffnetBis() {
		return geoeffnetBis;
	}

	public void setGeoeffnetBis(float geoeffnetBis) {
		this.geoeffnetBis = geoeffnetBis;
	}

	public String getStrasseHNr() {
		return strasseHNr;
	}

	public void setStrasseHNr(String strasseHNr) {
		this.strasseHNr = strasseHNr;
	}

	public String[] getDienstleistungen() {
		return dienstleistungen;
	}

	public void setDienstleistungen(String[] dienstleistungen) {
		this.dienstleistungen = dienstleistungen;
	}

	public String getDienstleistungenAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for (i = 0; i < this.getDienstleistungen().length - 1; i++) {
			ergebnis = ergebnis + this.getDienstleistungen()[i] + trenner;
		}
		return ergebnis + this.getDienstleistungen()[i];
	}

	public String gibBuergeramtZurueck(char trenner) {
		return this.getName() + trenner + this.getGeoeffnetVon() + trenner + this.getGeoeffnetBis() + trenner
				+ this.getStrasseHNr() + trenner + "\n" + this.getDienstleistungenAlsString(trenner) + "\n";
	}
}






















/*
 *  throws PlausiException{
	String feldname = pruefeFormal(name, geoeffnetVon, geoeffnetBis,
	    beckenlaenge, temperatur);
	if(feldname == null){
		this.name = name;
  	    this.geoeffnetVon = Float.parseFloat(geoeffnetVon);
  	    this.geoeffnetBis = Float.parseFloat(geoeffnetBis);
   	    this.beckenlaenge = Integer.parseInt(beckenlaenge);
   	    this.temperatur = Integer.parseInt(temperatur);
   	    feldname = pruefeInhaltlich();
   	    if(feldname != null) {
  	        throw new PlausiException(PlausiException.INHALTLICH, feldname);
   	    }
    }
	else {
		throw new PlausiException(PlausiException.FORMAL, feldname);
    } 
}
 */
/*
private String pruefeFormal(
    	String name, String geoeffnetVon, String geoeffnetBis,
        String beckenlaenge, String temperatur) {
        String erg = null;
        if(name == null || "".equals(name)){
        	return "Name";
        }
        else{
	        try {
	            Float.parseFloat(geoeffnetVon);
	        }
	        catch(NumberFormatException exc) {
	            return "Geöffnet von";
	        }
	        try {
	            Float.parseFloat(geoeffnetBis);
	        }
	        catch(NumberFormatException exc) {
	        	return "Geöffnet bis";
	        }
	        try {
	            Integer.parseInt(beckenlaenge);
	        }
	        catch(NumberFormatException exc) {
	        	return "Beckenlänge";
	        }
	        try {
	            Integer.parseInt(temperatur);
	        }
	        catch(NumberFormatException exc){
	        	return "Temperatur";
	        }
        }
        return erg;
    }
    
    private String pruefeInhaltlich() {
        String erg = null;
        if(this.getGeoeffnetVon() < 0 || this.getGeoeffnetVon() >= 24){
        	return "Geöffnet von";
        }
        if(this.getGeoeffnetBis() < 0 || this.getGeoeffnetBis() >= 24
        	|| this.getGeoeffnetBis() <= this.getGeoeffnetVon()){
        	return "Geöffnet bis";
        }
        if(this.getStrasseHNr() <= 0){
        	return "Beckenlänge";
        }
        if(this.getTemperatur() <= 0 || this.getTemperatur() >= 100){
        	return "Temperatur";
        }
        return erg;
    }*/