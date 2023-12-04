package business;

import java.io.IOException;
import java.util.Vector;

import Observer.Observable;
import Observer.Observer;
import fabrik.ConcreteCreator;
import fabrik.ConcreteTxtCreator;
import fabrik.Creator;
import fabrik.Product;
import gui.guiBuergeraemter.BuergeraemterControl;

public class BuergeraemterModel implements Observable{
	private Vector<Observer> observers = new Vector<Observer>();
	private static BuergeraemterModel buModel;

	private Buergeramt buergeramt;

	public Buergeramt getBuergeramt() {
		return this.buergeramt;
	}
	//private?
	private BuergeraemterModel()
	{
		//this.control = control;
	}
	public String getUeberschrift()
	{
		 return "Verwaltung von Buergeraemter";
	} 

	public void setBuergeramt(Buergeramt buergeramt) {
		this.buergeramt = buergeramt;
		//notify aufrufen
	}
	

	public void schreibeBuergeraemterInCsvDatei() throws IOException {

		// Kreieren eines Creator-Objekts und Abspeicherung mit Hilfe
		// einer Variablen vom Typ der entsprechenden abstrakten
		// Creator-Klasse.

		Creator Creator = new ConcreteCreator();
		Product writer = Creator.factoryMethod();

		// Kreieren eines Product-Objekts mit Hilfe der Factory-
		// Methode des Creator-Objekts und Abspeicherung mit Hilfe
		// einer Variablen vom Typ der entsprechenden abstrakten
		// Product-Klasse.

		writer.fuegeInDateiHinzu(this.buergeramt);
		writer.schliesseDatei();
	}

	/*
	 * BufferedWriter aus = new BufferedWriter(new FileWriter("Buergeraemter.csv",
	 * true)); aus.write(this.buergeramt.gibBuergeramtZurueck(';')); aus.close();
	 */
	public void schreibeFreizeitbaederInTxtDatei() throws IOException {
		Creator writerCreator = new ConcreteTxtCreator();
		Product writer = writerCreator.factoryMethod();
		writer.fuegeInDateiHinzu(this.buergeramt);
		writer.schliesseDatei();
	}

	public void addObserver(Observer buergeraemterControl)
	{
		this.observers.addElement(buergeraemterControl);
	}
	
	public void removeObserver(Observer obs)
	{
		this.observers.removeElement(obs);
	}
	
	public void notifyObservers()
	{
		for(int i = 0; i<this.observers.size(); i++)
		{
			this.observers.elementAt(i).update();
		}
	}

	public static BuergeraemterModel getInstance()
	{
		if(buModel == null)
		{
			buModel = new BuergeraemterModel();
		}
		return buModel;
	}
	
	
}