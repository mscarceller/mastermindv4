package mastermind.controllers;

import mastermind.models.Session;

public abstract class Controller {

	final Session session;

	Controller( Session session) {
		this.session = session;
	}

	public abstract void control();

}
