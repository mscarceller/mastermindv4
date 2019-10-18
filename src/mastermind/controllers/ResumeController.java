package mastermind.controllers;

import mastermind.views.console.ResumeView;
import mastermind.models.Session;

public class ResumeController extends Controller {

	public ResumeController(Session session) {
		super(session);
	}

	public void control() {
		if (new ResumeView().newGame()) {
			this.session.resume();
		}
		this.session.next();
	}

}
