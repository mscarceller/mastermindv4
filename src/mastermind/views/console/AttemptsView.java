package mastermind.views.console;

import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	public AttemptsView() { }

	public void writeln(int attempts) {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
				"" + attempts));
	}
}
