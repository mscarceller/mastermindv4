package mastermind.controllers;

import java.util.ArrayList;
import java.util.List;

import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;
import mastermind.views.MessageView;
import mastermind.views.console.*;

public class ProposalController extends Controller {

	private final ProposedCombinationView proposedCombinationView;

	public ProposalController(Session session) {
		super(session);
		this.proposedCombinationView = new ProposedCombinationView();
	}

	public void control(){
		Error error;
		do {
			String characters = this.proposedCombinationView.read();
			List<Color> colors = new ArrayList<Color>();
			for (int i=0; i<characters.length(); i++) {
				colors.add(ColorView.getInstance(characters.charAt(i)));
			}
			error = this.addProposedCombination(colors);
			if (error != null) {
				this.proposedCombinationView.showError(error);
			}
		} while (error != null);
		this.proposedCombinationView.writeln();
		new AttemptsView().writeln(this.session.getAttempts());
		new SecretCombinationView().writeln(this.session.getGameWidth());

		for (int i = 0; i < this.session.getAttempts(); i++) {
			this.writeColors(i);
		}
		if (this.session.isWinner()) {
			this.proposedCombinationView.writeln(MessageView.WINNER.getMessage());
			this.session.next();
		} else if (this.session.isLooser()) {
			this.proposedCombinationView.writeln(MessageView.LOOSER.getMessage());
			this.session.next();
		}
	}

	private void writeColors(int position){
		for (Color color : this.session.getColors(position)) {
			new ColorView(color).write();
		}
		new ResultView().writeln(this.session.getBlacks(position),this.session.getWhites(position));
	}

	private Error addProposedCombination(List<Color> colors) {
		Error error = null;
		if (colors.size() != Combination.getWidth()) {
			error = Error.WRONG_LENGTH;
		} else {
			for (int i = 0; i < colors.size(); i++) {
				if (colors.get(i) == null) {
					error = Error.WRONG_CHARACTERS;
				} else {
					for (int j = i+1; j < colors.size(); j++) {
						if (colors.get(i) == colors.get(j)) {
							error = Error.DUPLICATED;
						}
					}
				}				
			}
		}
		if (error == null){
			this.session.addProposedCombination(colors);
		}
		return error;	
	}

}
