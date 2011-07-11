package BA.Solver.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import BA.Automaton.PresburgerAutomaton;
import BA.Automaton.PresburgerAutomatonFactory;
import BA.Automaton.State;
import BA.Server.SolverRequest;
import BA.Solver.PresburgerSolver;
import BA.Solver.Exceptions.InvalidFormulaException;
import BA.Solver.Exceptions.TooManyVariablesException;


public class PresburgerSolverTest {

	private static final String sessionId = "TEST";
	
	@Test
	public void testEqual() {
	
		String equation = "x==4";
		String type = "All";
		
		int numSol = 1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testSmallerThan() {
	
		String equation = "x<4";
		String type = "All";
		
		int numSol = 4;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testBiggerThan() {
	
		String equation = "x>4";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testLessOrEqual() {
	
		String equation = "x<=4";
		String type = "All";
		
		int numSol = 5;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void testBiggerOrEqual() {
	
		String equation = "x>=4";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAnd() {
	
		String equation = "x==4 && y==2";
		String type = "All";
		
		int numSol = 1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			System.out.println("##################");
			System.out.println(s.getAutomaton());
			System.out.println("##################");
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOr() {
	
		String equation = "x==4 || y==2";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBigOr() {
	
		String equation = "x==1 || x==2 ||x==3 ||x==4 ||x==5 ||x==6 ||x==7 ||x==8";
		String type = "All";
		
		int numSol = 8;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExists() {
	
		String equation = "Ex: x==4 && y==2";
		String type = "All";
		
		int numSol = 1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	 
	 @Test
	public void testNegOr() {
	
		String equation = "x!=4 || y!=2";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	 
	@Test
	public void testAll() {
	
		String equation = "Ax: x==4 && y==2";
		String type = "All";
		
		int numSol = 0;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testForAll() {
	
		String equation = "&&[i=1..5] ix[i]==4i";
		String type = "All";
		
		int numSol = 1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testForOr() {
	
		String equation = "||[i=1..5] ix[i]==4i";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCancelOut() {
	
		String equation = "x<=4 && x>4";
		String type = "All";
		
		int numSol = 0;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			System.out.println(s.getAutomaton());
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testOptimizeEqual() {
	
		String equation = "x<=4 && x>=4";
		String type = "All";
		
		int numSol = 1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBrakets() {
	
		String equation = "(((((x==4)))))";
		String type = "All";
		
		int numSol = 1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAndOr() {
	
		String equation = "x==4 && (x==3 || y<=2)";
		String type = "All";
		
		int numSol = 3;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrCancel() {
	
		String equation = "x<=4 || x>=4";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAndCancelDuplicate() {
	
		String equation = "x==4 && x==4";
		String type = "All";
		
		int numSol = 1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAndCancelFalse() {
	
		String equation = "x==4 && x==5";
		String type = "All";
		
		int numSol = 0;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMultiExists() {
	
		String equation = "Ex[1]yz:x[1]==4 && y==5 && z==6 && w==1";
		String type = "All";
		
		int numSol = 1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMultipleAnd() {
	
		String equation = "x+y>=0 && x == 5 && z<=23";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrDifferentTypes() {
		
		String equation = "u==1 || u<=4";
		String type = "All";
		
		int numSol = 5;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrDifferentTypes2() {
		
		String equation = "u==1 || u!=4";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOrDifferentTypes3() {
		
		String equation = "u==1 || u!=1";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTautology() {

		String equation = "Ay: y + 0 == y";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDivisibleBy2() {
		
		String equation = "Ek: 2k == x";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testUnequal() {
		
		String equation = "x != y && !(x == y)";
		String type = "All";
		
		int numSol = -1;
		
		SolverRequest s = new SolverRequest(0,equation,0,sessionId);
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0);
		
		try {
			solver.solve(s);
			assertTrue(numSol == s.getNumberOfSolutions());
		} catch (TooManyVariablesException e) {
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			e.printStackTrace();
		}	
	}
}
