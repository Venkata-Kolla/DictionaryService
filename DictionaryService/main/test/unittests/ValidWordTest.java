package unittests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import DictionaryRule.DictionaryRuleEnforcer;

public class ValidWordTest {
	DictionaryRuleEnforcer dict = new DictionaryRuleEnforcer();;
	@BeforeClass
	public static void initDictionay() {
		
	}

	@Before
	public void beforeEachTest() {
		System.out.println("This is executed before each Test");
	}

	@After
	public void afterEachTest() {
		System.out.println("This is exceuted after each Test");
	}

	@Test
	public void testPositiveCases() {
		assertTrue("falied: San Francisco", dict.inputTextEntryMethod("San Francisco"));
		assertTrue("failed: God", dict.inputTextEntryMethod("God"));
		assertTrue("failed: Indistinct", dict.inputTextEntryMethod("Indistinct"));
		assertTrue("failed: Privilege", dict.inputTextEntryMethod("Privilege"));
	}

	@Test
	public void testNegativeCases() {
		assertFalse("passed: Indistinct", dict.inputTextEntryMethod("Swathi"));
		assertFalse("passed: Indistinct", dict.inputTextEntryMethod("Venkat"));
		assertFalse("passed: lkglkdj", dict.inputTextEntryMethod("lkglkdj"));
		assertFalse("passed: Pulihora", dict.inputTextEntryMethod("Pulihora"));
	}
}
