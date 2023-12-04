package gui.guiBuergeraemter;
import java.io.IOException;

import business.BuergeraemterModel;
import business.Buergeramt;
import javafx.stage.Stage;
import ownUtil.*;
import Observer.Observable;
import Observer.Observer;

public class BuergeraemterControl implements Observer{

	private BuergeraemterView buergeraemterView;
	private BuergeraemterModel buergeraemterModel;

	public BuergeraemterControl(Stage primaryStage) {
		this.buergeraemterModel = BuergeraemterModel.getInstance();
		this.buergeraemterView = new BuergeraemterView(this, primaryStage, buergeraemterModel);
		buergeraemterModel.addObserver(this);
	}

	 public void nehmeBuergeraemterAuf(String name, float geoeffnetVon, float geoeffnetbis, String strasseHNr, String[] dienstleistungen) throws PlausiException
	    {
	    	buergeraemterModel.setBuergeramt(new Buergeramt(name, geoeffnetVon, geoeffnetbis, strasseHNr, dienstleistungen));
			//this.update();
			buergeraemterModel.notifyObservers();
			//view.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
	    }
	 /*
	  * try{
	    		buergeraemterModel.setBuergeramt(new Buergeramt(name, geoeffnetVon, geoeffnetbis, strasseHNr, dienstleistungen));
	    		//this.update();
	    		buergeraemterModel.notifyObservers();
	    		//view.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
	       	}
	       	catch(PlausiException exc){
	       		buergeraemterView.zeigeFehlermeldungsfensterAn(exc.getPlausiTyp() + "er ", exc.getMessage());
	     	}
	  */
	void schreibeBuergeraemterInDatei(String typ) {
		try {
			System.out.println("Wird in Datei speichern...");
			if ("csv".equals(typ)) {
				buergeraemterModel.schreibeBuergeraemterInCsvDatei();
				buergeraemterView.zeigeInformationsfensterAn("Die Bürgerämter wurden gespeichert!");
			} else {
				buergeraemterView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			buergeraemterView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!", null);
			exc.printStackTrace();
		} catch (Exception exc) {
			buergeraemterView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!", null);
			exc.printStackTrace();
		}
	}



	@Override
	public void update() {
		// programmieren
		
	}
	

}