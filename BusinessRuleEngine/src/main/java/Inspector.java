import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inspector {
	private final List<ConditionalAction> conditionalActionList;
	
	public Inspector(final ConditionalAction... conditionalActions) {
		conditionalActionList = Arrays.asList(conditionalActions);
	}
	
	public List<Report> inspect(final Facts facts) {
		final List<Report> reportList = new ArrayList<>();
		for(int i = 0; i < conditionalActionList.size(); i++) {
			final ConditionalAction action = conditionalActionList.get(i);
			final boolean conditionResult = action.evaluate(facts);
			reportList.add(new Report(facts, action, conditionResult));
		}
		return reportList;
	}
}
