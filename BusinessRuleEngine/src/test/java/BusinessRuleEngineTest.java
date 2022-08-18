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
		
		engine.addRule((facts) -> {});
		engine.addRule((facts) -> {});
		
		assertEquals(2, engine.count());
	}
	
	@Test
	public void shouldExecuteActionWithFacts() {
		final Rule mockRule = Mockito.mock(Rule.class);
		final Facts mockFacts = Mockito.mock(Facts.class);
		final BusinessRuleEngine engine = new BusinessRuleEngine(mockFacts);
		
		engine.addRule(mockRule);
		engine.run();
		
		Mockito.verify(mockRule).perform(mockFacts);
	}
}
