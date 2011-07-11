package BA.Automaton.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import BA.Automaton.PresburgerAutomaton;
import BA.Automaton.PresburgerAutomatonFactory;
import BA.Automaton.State;


public class PresburgerAutomatonTest {

	@Test
	public void testBasic() {
		
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x","y"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		State thirdState = a.addState("Third");
		firstState.setInitial(true);
		secondState.setFinal(true);
		
		a.addTransition(firstState, firstState, new boolean[]{false,true});
		a.addTransition(firstState, secondState, new boolean[]{false,false});
		a.addTransition(firstState, thirdState, new boolean[]{true,false});
		a.addTransition(firstState, secondState, new boolean[]{true,true});
		
		a.addTransition(secondState, secondState, new boolean[]{false,false});
		a.addTransition(secondState, firstState, new boolean[]{false,true});
		a.addTransition(secondState, secondState, new boolean[]{true,false});
		a.addTransition(secondState, thirdState, new boolean[]{true,true});
		
		a.addTransition(thirdState, secondState, new boolean[]{false,false});
		a.addTransition(thirdState, firstState, new boolean[]{false,true});
		a.addTransition(thirdState, secondState, new boolean[]{true,false});
		a.addTransition(thirdState, thirdState, new boolean[]{true,true});
		
		assertFalse(a.run(new Character[]{'0','1'}));
		assertTrue(a.run(new Character[]{'1','1'}));
		assertFalse(a.run(new Character[]{'1','1','1','1'}));
		assertFalse(a.run(new Character[]{'1','1','0','1'}));
		assertTrue(a.run(new Character[]{'1','0','0','0'}));
	}
	
	@Test
	public void testNFA() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x","y"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		State thirdState = a.addState("Third");
		firstState.setInitial(true);
		secondState.setFinal(true);
		
		a.addTransition(firstState, firstState, new boolean[]{false,true});
		a.addTransition(firstState, secondState, new boolean[]{false,true});
		
		a.addTransition(firstState, secondState, new boolean[]{false,false});
		a.addTransition(firstState, thirdState, new boolean[]{true,false});
		a.addTransition(firstState, secondState, new boolean[]{true,true});
		
		a.addTransition(secondState, secondState, new boolean[]{false,false});
		a.addTransition(secondState, firstState, new boolean[]{false,true});
		a.addTransition(secondState, secondState, new boolean[]{true,false});
		a.addTransition(secondState, thirdState, new boolean[]{true,true});
		
		a.addTransition(thirdState, firstState, new boolean[]{false,false});
		a.addTransition(thirdState, secondState, new boolean[]{false,false});
		a.addTransition(thirdState, thirdState, new boolean[]{false,false});
		
		a.addTransition(thirdState, firstState, new boolean[]{false,true});
		a.addTransition(thirdState, secondState, new boolean[]{true,false});
		a.addTransition(thirdState, thirdState, new boolean[]{true,true});
		
		assertTrue(a.run(new Character[]{'0','1'}));
		assertTrue(a.run(new Character[]{'1','1'}));
		assertFalse(a.run(new Character[]{'1','1','1','1'}));
		assertFalse(a.run(new Character[]{'1','1','0','1'}));
		assertTrue(a.run(new Character[]{'1','0','0','0'}));
	}
	
	
	@Test
	public void testEasyWrappers() {

		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x","y"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		firstState.setInitial(true);
		secondState.setFinal(true);
		
		a.addTransition(firstState, firstState, "01");
		a.addTransition(firstState, secondState, "00");
		a.addTransition(firstState, secondState, "10");
		a.addTransition(firstState, secondState, "11");
		
		a.addTransition(secondState, secondState, "00");
		a.addTransition(secondState, firstState, "01");
		a.addTransition(secondState, secondState, "10");
		a.addTransition(secondState, secondState, "11");

		assertFalse(a.run("01"));
		assertTrue(a.run("11"));
		
	}
	
	@Test
	public void testEasyExistQuant() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x","y"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		firstState.setInitial(true);
		secondState.setFinal(true);
		
		a.addTransition(firstState, firstState, "01");
		a.addTransition(firstState, firstState, "00");
		a.addTransition(firstState, secondState, "10");
		a.addTransition(firstState, secondState, "11");
		
		a.addTransition(secondState, firstState, "00");
		a.addTransition(secondState, firstState, "01");
		a.addTransition(secondState, firstState, "10");
		a.addTransition(secondState, firstState, "11");

		a.existQuant("y");
		
		assertFalse(a.run("0"));
		assertTrue(a.run("1"));
		assertFalse(a.run("10"));
		assertFalse(a.run("11"));
		assertTrue(a.run("111"));
		assertFalse(a.run("110"));
	}
	
	@Test
	public void testHardExistQuant() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x","y","z"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		firstState.setInitial(true);
		secondState.setFinal(true);
		
		a.addTransition(firstState, firstState, "000");
		a.addTransition(firstState, firstState, "010");
		a.addTransition(firstState, secondState, "100");
		a.addTransition(firstState, secondState, "110");
		a.addTransition(firstState, firstState, "001");
		a.addTransition(firstState, firstState, "011");
		a.addTransition(firstState, secondState, "101");
		a.addTransition(firstState, secondState, "111");
		
		a.addTransition(secondState, secondState, "000");
		a.addTransition(secondState, secondState, "010");
		a.addTransition(secondState, secondState, "100");
		a.addTransition(secondState, secondState, "110");
		a.addTransition(secondState, secondState, "001");
		a.addTransition(secondState, secondState, "011");
		a.addTransition(secondState, secondState, "101");
		a.addTransition(secondState, secondState, "111");
		
		assertTrue(a.run("111"));
		assertFalse(a.run("000"));
		
		a.existQuant("y");
		
		assertFalse(a.run("00"));
		assertTrue(a.run("11"));
		
		a.existQuant("z");
		
		assertFalse(a.run("0"));
		assertTrue(a.run("1"));
		
	} 
	
	@Test
	public void testPadClosure() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x","y","z"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		firstState.setInitial(true);
		secondState.setFinal(true);
		
		a.addTransition(firstState, firstState, "000");
		a.addTransition(firstState, firstState, "010");
		a.addTransition(firstState, secondState, "100");
		a.addTransition(firstState, secondState, "110");
		a.addTransition(firstState, firstState, "001");
		a.addTransition(firstState, firstState, "011");
		a.addTransition(firstState, secondState, "101");
		a.addTransition(firstState, secondState, "111");
		
		a.addTransition(secondState, secondState, "000");
		a.addTransition(secondState, secondState, "010");
		a.addTransition(secondState, secondState, "100");
		a.addTransition(secondState, secondState, "110");
		a.addTransition(secondState, secondState, "001");
		a.addTransition(secondState, secondState, "011");
		a.addTransition(secondState, secondState, "101");
		a.addTransition(secondState, secondState, "111");
		
		assertTrue(a.run("111"));
		assertFalse(a.run("000"));
		assertFalse(a.run(""));
		
		a.existQuant("x");
		System.out.println(a);
		
		assertTrue(a.run(""));
		assertTrue(a.run("00"));
		assertTrue(a.run("11"));
		
		assertFalse(a.run("1"));
		assertFalse(a.run("0"));
		
	} 
	
	@Test
	public void testDeterminize() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		
		a.addTransition(firstState, firstState, "0");
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, secondState, "1");

		a.addTransition(secondState, firstState, "0");
		a.addTransition(secondState, firstState, "1");
		
		a = a.determinize();
		
		assertTrue(a.run("0101110"));
	}
	
	@Test
	public void testDeterminize2() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		
		a.addTransition(firstState, firstState, "0");
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, secondState, "1");

		a.addTransition(secondState, firstState, "0");
		a.addTransition(secondState, firstState, "1");
		
		a = a.determinize2();
		
		assertTrue(a.run("0101110"));
	}
	
	@Test
	public void testDeterminize3() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		
		a.addTransition(firstState, firstState, "0");
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, secondState, "1");

		a.addTransition(secondState, firstState, "0");
		a.addTransition(secondState, firstState, "1");
		
		a = a.determinize3();
		
		assertTrue(a.run("0101110"));
	}
	
	@Test
	public void testDeterminize2EmptySet() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		
		
		a.addTransition(firstState, secondState, "0");

		a.addTransition(secondState, secondState, "0");
		
		a = a.determinize2();
		
		assertFalse(a.run("0101110"));
		assertTrue(a.run("0"));
		assertTrue(a.run("00000000"));
		assertFalse(a.run("00000001000000000"));
	}
	
	@Test
	public void testDeterminize3EmptySet() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		
		
		a.addTransition(firstState, secondState, "0");

		a.addTransition(secondState, secondState, "0");
		
		a = a.determinize3();
		
		assertFalse(a.run("0101110"));
		assertTrue(a.run("0"));
		assertTrue(a.run("00000000"));
		assertFalse(a.run("00000001000000000"));
	}
	
	@Test
	public void testIsDFA() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		
		a.addTransition(firstState, firstState, "0");
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, secondState, "1");

		a.addTransition(secondState, firstState, "0");
		a.addTransition(secondState, firstState, "1");
		
		assertFalse(a.isDFA());
		a = a.determinize();
		assertTrue(a.isDFA());
	}
	
	@Test
	public void testSmallUnion() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		//All words ending with a 1
		a.addTransition(firstState, firstState, "0");
		a.addTransition(firstState, secondState, "1");
		a.addTransition(secondState, firstState, "0");
		a.addTransition(secondState, secondState, "1");
		
		PresburgerAutomaton b = factory.getAutomaton(new String[]{"x"});
		
		State firstStateB = b.addState("First");
		State secondStateB = b.addState("Second");
		secondStateB.setFinal(true);
		firstStateB.setInitial(true);
		//All words ending with a 0
		b.addTransition(firstStateB, firstStateB, "1");
		b.addTransition(firstStateB, secondStateB, "0");
		b.addTransition(secondStateB, firstStateB, "1");
		b.addTransition(secondStateB, secondStateB, "0");
		
		assertTrue(a.run("010110101"));
		assertFalse(a.run("0101101010"));
		assertFalse(b.run("010110101"));
		assertTrue(b.run("0101101010"));
		
		PresburgerAutomaton c = b.union(a);
		
		assertTrue(c.run("010110101"));
		assertTrue(c.run("0101101010"));
	}
	
	@Test
	public void testBigUnion() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x","y"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		//All words ending with a 1
		a.addTransition(firstState, firstState, "00");
		a.addTransition(firstState, secondState, "10");
		a.addTransition(firstState, firstState, "01");
		a.addTransition(firstState, secondState, "11");
		
		a.addTransition(secondState, firstState, "00");
		a.addTransition(secondState, secondState, "10");
		a.addTransition(secondState, firstState, "01");
		a.addTransition(secondState, secondState, "11");
		
		PresburgerAutomaton b = factory.getAutomaton(new String[]{"x","y"});
		
		State firstStateB = b.addState("First");
		State secondStateB = b.addState("Second");
		secondStateB.setFinal(true);
		firstStateB.setInitial(true);
		//All words ending with a 0
		b.addTransition(firstStateB, firstStateB, "10");
		b.addTransition(firstStateB, secondStateB, "00");
		b.addTransition(firstStateB, firstStateB, "11");
		b.addTransition(firstStateB, secondStateB, "01");
		
		b.addTransition(secondStateB, firstStateB, "10");
		b.addTransition(secondStateB, secondStateB, "00");
		b.addTransition(secondStateB, firstStateB, "11");
		b.addTransition(secondStateB, secondStateB, "01");
		
		assertTrue(a.run("0101101010"));
		assertTrue(a.run("0101101011"));
		assertFalse(a.run("0101101000"));
		assertFalse(a.run("0101101001"));
		
		assertFalse(b.run("0101101010"));
		assertFalse(b.run("0101101011"));
		assertTrue(b.run("0101101000"));
		assertTrue(b.run("0101101001"));
		
		PresburgerAutomaton c = b.union(a);
				
		assertTrue(c.run("0101101010"));
		assertTrue(c.run("0101101011"));
		assertTrue(c.run("0101101000"));
		assertTrue(c.run("0101101001"));
	}
	
	@Test
	public void testNFAUnion() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		//All words ending with a 1
		a.addTransition(firstState, firstState, "0");
		a.addTransition(firstState, secondState, "1");
		a.addTransition(firstState, firstState, "1");
		a.addTransition(secondState, firstState, "0");
		a.addTransition(secondState, secondState, "1");
		
		PresburgerAutomaton b = factory.getAutomaton(new String[]{"x"});
		
		State firstStateB = b.addState("First");
		State secondStateB = b.addState("Second");
		secondStateB.setFinal(true);
		firstStateB.setInitial(true);
		//All words ending with a 0
		b.addTransition(firstStateB, firstStateB, "1");
		b.addTransition(firstStateB, secondStateB, "1");
		b.addTransition(firstStateB, secondStateB, "0");
		b.addTransition(secondStateB, firstStateB, "1");
		b.addTransition(secondStateB, secondStateB, "0");
		
		assertTrue(a.run("010110101"));
		assertFalse(a.run("0101101010"));
		assertFalse(b.run("010110101"));
		assertTrue(b.run("0101101010"));
		
		PresburgerAutomaton c = b.union(a);
		
		assertTrue(c.run("010110101"));
		assertTrue(c.run("0101101010"));
	}
	
	
	@Test
	public void testIntersection() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		//All words without restriction
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, secondState, "1");
		a.addTransition(secondState, secondState, "0");
		a.addTransition(secondState, secondState, "1");
		
		PresburgerAutomaton b = factory.getAutomaton(new String[]{"x"});
		
		State firstStateB = b.addState("First");
		State secondStateB = b.addState("Second");
		secondStateB.setFinal(true);
		firstStateB.setInitial(true);
		//All words ending with a 0
		b.addTransition(firstStateB, firstStateB, "1");
		b.addTransition(firstStateB, secondStateB, "0");
		b.addTransition(secondStateB, firstStateB, "1");
		b.addTransition(secondStateB, secondStateB, "0");
		
		assertTrue(a.run("010110101"));
		assertTrue(a.run("0101101010"));
		assertFalse(b.run("010110101"));
		assertTrue(b.run("0101101010"));
		
		//should be all words ending with 0
		PresburgerAutomaton c = b.intersection(a);
		
//		System.out.println(c.printAutomaton());
		
		assertFalse(c.run("010110101"));
		assertTrue(c.run("0101101010"));
	}
	
	//TODO: Do more extensive testing on NFAs.
	@Test
	public void testNFAIntersection() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		//All words without restriction
		a.addTransition(firstState, secondState, "0");
		a.addTransition(secondState, secondState, "0");
		a.addTransition(secondState, secondState, "1");
		
		PresburgerAutomaton b = factory.getAutomaton(new String[]{"x"});
		
		State firstStateB = b.addState("First");
		State secondStateB = b.addState("Second");
		secondStateB.setFinal(true);
		firstStateB.setInitial(true);
		//All words ending with a 0
		b.addTransition(firstStateB, firstStateB, "1");
		b.addTransition(firstStateB, firstStateB, "0");
		b.addTransition(firstStateB, secondStateB, "0");
		b.addTransition(secondStateB, firstStateB, "1");
		b.addTransition(secondStateB, secondStateB, "0");
		
		assertTrue(a.run("010110101"));
		assertTrue(a.run("0101101010"));
		assertFalse(b.run("010110101"));
		assertTrue(b.run("0101101010"));
		
		//should be all words ending with 0
		PresburgerAutomaton c = b.intersection(a);
		
//		System.out.println(c.printAutomaton());
		
		assertFalse(c.run("010110101"));
		assertTrue(c.run("0101101010"));
	}
	
	
	@Test
	public void testDFANot() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		secondState.setFinal(true);
		firstState.setInitial(true);
		//All words without restriction
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, firstState, "1");
		a.addTransition(secondState, secondState, "0");
		a.addTransition(secondState, firstState, "1");

		assertTrue(a.run("0100010"));
		assertFalse(a.run("010110101"));
		a = a.not();
		assertFalse(a.run("0100010"));
		assertTrue(a.run("010110101"));
	}
	
	@Test
	public void testNFANot() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		State thirdState = a.addState("Third");
		
		secondState.setFinal(true);
		firstState.setInitial(true);
		
		//All words without restriction
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, secondState, "1");
		a.addTransition(firstState, thirdState, "1");
		
		a.addTransition(secondState, secondState, "0");
		a.addTransition(secondState, secondState, "1");
		
		a.addTransition(thirdState, thirdState, "0");
		a.addTransition(thirdState, thirdState, "1");
		

		assertTrue(a.run("0100010"));
		assertTrue(a.run("1010110101"));
		assertFalse(a.run(""));
		a = a.not();
		assertFalse(a.run("0100010"));
		assertFalse(a.run("1010110101"));
		assertFalse(a.run(""));
	}
	
	@Test
	public void testMinimize() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		State thirdState = a.addState("Third");
		State fourthState = a.addState("Fourth");
		
		fourthState.setFinal(true);
		firstState.setInitial(true);
		
		//All words without restriction
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, fourthState, "1");
		
		a.addTransition(secondState, fourthState, "0");
		a.addTransition(secondState, thirdState, "1");
		
		a.addTransition(thirdState, fourthState, "0");
		a.addTransition(thirdState, fourthState, "1");
		
		a.addTransition(fourthState, fourthState, "0");
		a.addTransition(fourthState, fourthState, "1");
		
		assertTrue(a.run("010"));
		assertTrue(a.run("00"));
		assertFalse(a.run("0"));
		assertFalse(a.run(""));
		
		a.minimize();
		
		assertTrue(a.run("010"));
		assertTrue(a.run("00"));
		assertTrue(a.run("0"));
		assertTrue(a.run(""));
	}
	
	@Test
	public void testMinimizePossible() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		State thirdState = a.addState("Third");
		State fourthState = a.addState("Fourth");
		
		fourthState.setFinal(true);
		firstState.setInitial(true);
		
		//All words without restriction
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, thirdState, "1");
		
		a.addTransition(secondState, fourthState, "0");
		a.addTransition(secondState, fourthState, "1");
		
		a.addTransition(thirdState, fourthState, "0");
		a.addTransition(thirdState, fourthState, "1");
		
		a.addTransition(fourthState, fourthState, "0");
		a.addTransition(fourthState, fourthState, "1");
		
		assertFalse(a.run("0"));
		assertFalse(a.run("1"));
		assertTrue(a.run("00"));
		assertTrue(a.run("10"));
		assertTrue(a.run("01"));
		assertTrue(a.run("11"));
		assertTrue(a.run("000"));
		assertTrue(a.run("100"));
		assertTrue(a.run("001"));
		assertTrue(a.run("101"));
		assertTrue(a.run("010"));
		assertTrue(a.run("110"));
		assertTrue(a.run("010"));
		assertTrue(a.run("101"));
		
		a.minimize();
	
		assertTrue(a.run("0"));
		assertTrue(a.run("1"));
		assertTrue(a.run("00"));
		assertTrue(a.run("10"));
		assertTrue(a.run("01"));
		assertTrue(a.run("11"));
		assertTrue(a.run("000"));
		assertTrue(a.run("100"));
		assertTrue(a.run("001"));
		assertTrue(a.run("101"));
		assertTrue(a.run("010"));
		assertTrue(a.run("110"));
		assertTrue(a.run("010"));
		assertTrue(a.run("101"));
		
	}
	
	@Test
	public void testCount1() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		State thirdState = a.addState("Third");
		State fourthState = a.addState("Fourth");
		State trash = a.addState("Trash");
		
		thirdState.setFinal(true);
		secondState.setFinal(true);
		fourthState.setFinal(true);
		firstState.setInitial(true);
		
		//All words without restriction
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, thirdState, "1");
		
		a.addTransition(secondState, fourthState, "0");
		a.addTransition(secondState, fourthState, "1");
		
		a.addTransition(thirdState, fourthState, "0");
		a.addTransition(thirdState, fourthState, "1");
		
		a.addTransition(fourthState, trash, "0");
		a.addTransition(fourthState, trash, "1");
		
		a.addTransition(trash, trash, "0");
		a.addTransition(trash, trash, "1");
		
		System.out.println(a.getSatCount());
	}

	
	@Test
	public void testClone() {
		PresburgerAutomatonFactory factory = PresburgerAutomatonFactory.init(new String[]{"x","y","z"});
		PresburgerAutomaton a = factory.getAutomaton(new String[]{"x"});
		
		State firstState = a.addState("First");
		State secondState = a.addState("Second");
		State thirdState = a.addState("Third");
		State fourthState = a.addState("Fourth");
		State trash = a.addState("Trash");
		
		thirdState.setFinal(true);
		secondState.setFinal(true);
		fourthState.setFinal(true);
		firstState.setInitial(true);
		
		//All words without restriction
		a.addTransition(firstState, secondState, "0");
		a.addTransition(firstState, thirdState, "1");
		
		a.addTransition(secondState, fourthState, "0");
		a.addTransition(secondState, fourthState, "1");
		
		a.addTransition(thirdState, fourthState, "0");
		a.addTransition(thirdState, fourthState, "1");
		
		a.addTransition(fourthState, trash, "0");
		a.addTransition(fourthState, trash, "1");
		
		a.addTransition(trash, trash, "0");
		a.addTransition(trash, trash, "1");
		
		PresburgerAutomaton b = a.clone();
		
		assertTrue(b.run("010010101") == a.run("010010101"));
		assertTrue(b.run("") == a.run(""));
		assertTrue(b.run("0110111") == a.run("0110111"));
	}
}
