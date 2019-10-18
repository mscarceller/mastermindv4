package mastermind;

import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.models.StateValue;
import java.util.HashMap;

class ConsoleMastermind extends Mastermind {

	private ConsoleMastermind() {
		this.session = new Session();
		this.controllers = new HashMap<>();
		controllers.put(StateValue.INITIAL, new StartController(session));
		controllers.put(StateValue.IN_GAME, new ProposalController(session));
		controllers.put(StateValue.FINAL, new ResumeController(session));
		controllers.put(StateValue.EXIT, null);
	}

	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}



}
