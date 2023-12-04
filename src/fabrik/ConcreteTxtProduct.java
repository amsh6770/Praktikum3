package fabrik;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import business.Buergeramt;

public class ConcreteTxtProduct extends Product {
	private PrintWriter aus;

	public void fuegeInDateiHinzu(Buergeramt buergeramt) throws IOException {
		aus = new PrintWriter(new FileWriter("Buergeraemter.txt", true));
		aus.println("Daten des Burgeramtes");
		aus.println("Name des Burgeramtes: " + buergeramt.getName());
		aus.println(
				"Offnungszeit des Burgeramts: " + buergeramt.getGeoeffnetVon() + " - " + buergeramt.getGeoeffnetBis());
		aus.println("Strasse und Hausnummer des Buergeramtes: " + buergeramt.getStrasseHNr());
		aus.println("Dienstleistungen des Burgeramtes: " + buergeramt.getDienstleistungen());
		aus.println();
	}

	public void schliesseDatei() throws IOException {
		aus.close();
	}

}