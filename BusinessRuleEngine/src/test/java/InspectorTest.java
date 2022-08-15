import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class InspectorTest {
	@Test
	public void inspectOneConditionEvaluatesTrue() {
		final Facts facts = new Facts();
		facts.addFact("jobTitle", "CEO");
		final ConditionalAction conditionalAction = new JobTitleCondition();
		final Inspector inspector = new Inspector(conditionalAction);
		
		final List<Report> reportList = inspector.inspect(facts);
		
		assertEquals(1, reportList.size());
		assertEquals(true, reportList.get(0).isPositive());
	}
	
	private static class JobTitleCondition implements ConditionalAction {

		@Override
		public boolean evaluate(Facts facts) {
			return "CEO".equals(facts.getFact("jobTitle"));
		}

		@Override
		public void execute(Facts facts) {
			throw new UnsupportedOperationException();
		}
		
	}
}
