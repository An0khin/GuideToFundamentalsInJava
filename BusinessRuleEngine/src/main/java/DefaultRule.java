
public class DefaultRule implements Rule {

	private final Condition condition;
	private final Action action;
	
	public DefaultRule(final Condition condition, final Action action) {
		this.condition = condition;
		this.action = action;
	}
	
	@Override
	public void perform(final Facts facts) {
		// TODO Auto-generated method stub
		if(condition.evaluate(facts)) {
			action.execute(facts);
		}
	}

}
