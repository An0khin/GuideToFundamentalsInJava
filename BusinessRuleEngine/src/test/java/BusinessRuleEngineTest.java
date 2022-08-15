import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class BusinessRuleEngineTest {
	@Test
	public void shouldHaveNoRulesInitially() {
		final BusinessRuleEngine engine = new BusinessRuleEngine(new Facts());
		
		assertEquals(0, engine.count());
	}
	
	@Test
	public void shouldAddTwoActions() {
		final BusinessRuleEngine engine = new BusinessRuleEngine(new Facts());
		
		engine.addAction((facts) -> {});
		engine.addAction((facts) -> {});
		
		assertEquals(2, engine.count());
	}
	
	@Test
	public void shouldExecuteActionWithFacts() {
		final Action mockAction = Mockito.mock(Action.class);
		final Facts mockFacts = Mockito.mock(Facts.class);
		final BusinessRuleEngine engine = new BusinessRuleEngine(new Facts());
		
		engine.addAction(mockAction);
		engine.run();
		
		Mockito.verify(mockAction).execute(mockFacts);
	}
}
