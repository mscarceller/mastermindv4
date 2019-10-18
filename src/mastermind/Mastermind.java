package mastermind;

import mastermind.controllers.Controller;
import mastermind.models.Session;
import mastermind.models.StateValue;

import java.util.Map;

abstract class Mastermind {

	Session session;
	Map<StateValue, Controller> controllers;

	Mastermind() { }

	void play() {
		Controller controller;
		do {
			controller = this.controllers.get(this.session.getStateValue());
			if (controller != null){
				controller.control();
			}
		} while (controller != null);
	}

}
