package mastermind.views.console;

import mastermind.types.Error;
import santaTecla.utils.Console;

public class ErrorView extends mastermind.views.ErrorView {

	public ErrorView(Error error) {
		super(error);
	}
	
	public void writeln() {
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	

}
