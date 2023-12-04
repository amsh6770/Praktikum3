package fabrik;

public class ConcreteTxtCreator extends Creator {
	public Product factoryMethod() {
		return new ConcreteTxtProduct();
	}
}