package mastermind;

import mastermind.controllers.Controller;
import mastermind.controllers.ProposalController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.models.Session;
import mastermind.models.StateValue;

import java.util.HashMap;
import java.util.Map;

class Mastermind {

	Session session;
	Map<StateValue, Controller> controllers;

	private Mastermind() {
		this.session = new Session();
		this.controllers = new HashMap<>();
		controllers.put(StateValue.INITIAL, new StartController(session));
		controllers.put(StateValue.IN_GAME, new ProposalController(session));
		controllers.put(StateValue.FINAL, new ResumeController(session));
		controllers.put(StateValue.EXIT, null);
	}

	private void play() {
		Controller controller;
		do {
			controller = this.controllers.get(this.session.getStateValue());
			if (controller != null){
				controller.control();
			}
		} while (controller != null);
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
