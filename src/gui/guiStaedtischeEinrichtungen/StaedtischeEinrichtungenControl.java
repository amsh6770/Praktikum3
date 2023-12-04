package gui.guiStaedtischeEinrichtungen;
import Observer.Observer;
import business.BuergeraemterModel;
import javafx.stage.Stage;


public class StaedtischeEinrichtungenControl implements Observer
{
	private StaedtischeEinrichtungenView stView;
    private BuergeraemterModel buModel;
    
	public StaedtischeEinrichtungenControl (Stage primaryStage)
	{
		this.buModel = BuergeraemterModel.getInstance();
		this.stView = new StaedtischeEinrichtungenView (this, primaryStage, buModel);
		buModel.addObserver(this);
	}

	public void update() 
	{
		stView.zeigeBuergeraemterAn();
	}

}