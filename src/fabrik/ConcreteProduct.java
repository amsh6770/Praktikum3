//ConcreteProduct
package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteProduct extends Product {
	private BufferedWriter aus;

	public ConcreteProduct() throws IOException {

		aus = new BufferedWriter(new FileWriter("Buergeramt.csv", true));
	}

	public void fuegeInDateiHinzu(Buergeramt buergeramt) throws IOException {
		aus.write(buergeramt.gibBuergeramtZurueck(';'));
	}

	public void schliesseDatei() throws IOException {
		aus.close();
	}

}