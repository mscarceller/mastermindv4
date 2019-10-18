package mastermind.views.console;

import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class StartView extends WithConsoleView {

	public StartView(){ }

	public void writeGameIntro() {
		this.console.writeln(MessageView.TITLE.getMessage());
	}

}
