import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {
	private final List<Rule> rules;
	
	private final Facts facts;
	
	public BusinessRuleEngine(final Facts facts) {
		this.rules = new ArrayList<Rule>();
		this.facts = facts;
	}
	
	public void addRule(final Rule rule) {
		rules.add(rule);
	}
	
	public int count() {
		return rules.size();
	}
	
	public void run() {
		rules.forEach(rule -> rule.perform(facts));
	}
}
