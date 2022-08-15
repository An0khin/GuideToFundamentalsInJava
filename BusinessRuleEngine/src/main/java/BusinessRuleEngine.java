import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {
	private final List<Action> actions;
	
	private final Facts facts;
	
	public BusinessRuleEngine(final Facts facts) {
		this.actions = new ArrayList<Action>();
		this.facts = facts;
	}
	
	public void addAction(final Action action) {
		actions.add(action);
	}
	
	public int count() {
		return actions.size();
	}
	
	public void run() {
		actions.forEach(action -> action.execute(facts));
	}
}
