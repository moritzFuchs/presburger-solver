package BA.Solver.Test;


import org.junit.Test;

import BA.Server.SolverRequest;
import BA.Solver.PresburgerSolver;
import BA.Solver.Exceptions.InvalidFormulaException;
import BA.Solver.Exceptions.TooManyVariablesException;

public class PresburgerSolverBenchmark {

	
	private boolean minimize = false;
	
	private String[] alphabet = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n"};
	private Integer GENERIC_TEST_TOUGHNESS = 1;
	
	@Test(timeout=60000) 
	public void alternateQuant() {
		String equation = "";
		String equation2 = "";
		
		for (int i=0;i<alphabet.length && i<2;i+=2) {
			equation += "A"+alphabet[i]+":";
			equation += "E"+alphabet[i+1]+":";
			
			equation2+= alphabet[i] + "-";
			equation2+= alphabet[i+1] + "+";
		}
		
		
		String input = equation + equation2.substring(0 , equation2.length()-1) + "== 0";
		String type = "One";
		
		System.out.println(input);
		
		SolverRequest s = new SolverRequest(0,input,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(timeout=90000)
	public void testLGS1() {
		String input="";
		for (int i=0;i<GENERIC_TEST_TOUGHNESS;i++) {
			input+= "(";
		}
		boolean start = true;
		for (int i=alphabet.length-2-GENERIC_TEST_TOUGHNESS;i<alphabet.length-1;i++) {
			if (start) {
				input += alphabet[i]+"+"+alphabet[i+1]+"<=1 && ";
				start = false;
			} else
				input += alphabet[i]+"+"+alphabet[i+1]+"<=1) && ";
		}
		
		input = input.substring(0,input.length()-4);
		
		String type = "One";
				
		SolverRequest s = new SolverRequest(0,input,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test(timeout=60000)
	public void testGenericIntSize() {
		String input="";
		
		//State-Space grows with int1
		int int1 = 10;
		int int2 = int1+1;
		int int3 = 0;
		
		input = int1 + "x-" + int2 + "y == " + int3;
		
		String type = "One";
				
		SolverRequest s = new SolverRequest(0,input,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	@Test(timeout=60000) 
	public void altaricBench01() {
		String equation = "Ez:x==11z && Ez:y==7z && Ez:w==5z && Ez:s==3z";
		String type = "One";
				
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	@Test(timeout=60000) 
	public void altaricBench02() {
		String equation = "31x-13y >= 0 && 45x-4y-11z >= 0 && 27y-11w >= 0";
		String type = "One";
				
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	@Test(timeout=60000) 
	public void altaricBench03() {

		String equation = "x - 1024y + 357z - 111t >= 0 && u==3";
		String type = "One";
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0,true,this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} 
	
	@Test(timeout=60000) 
	public void altaricBench04() {

		String equation = "10231  x - 10221  y >= 0";
		String type = "One";
		
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0,true,this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test(timeout=60000)
	public void altaricBench05() {

		String equation = "123x -1051y >= 0 && Ez:y==123z";
		String type = "One";
		
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0,true,this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test(timeout=60000) 
//	public void altaricBench06() {
//
//		String equation = "(7x[0]-4x[1]-1x[2]+9x[3]+10x[4]<0 && -9x[0]+5x[1]+2x[2]-10x[3]+7x[4]<1 && 7x[0]-4x[1]-1x[2]+9x[3]+6x[4]<0 && -9x[0]+5x[1]-2x[2]-11x[3]+7x[4]<1"+
//		 " && Ek: -10x[0]-7x[1]+3x[2]+1x[3]-8x[4]<11 && x[1] == 5k) || "+
//		   "(-9x[0]+5x[1]-2x[2]-11x[3]+7x[4]<2 && 8x[0]-4x[1]+1x[2]+9x[3]-6x[4]<0 && 9x[0]+6x[1]-2x[2]+11x[3]+7x[4]<2 && -10x[0]+7x[1]+4x[2]-1x[3]+9x[4]<11)"; 
//		
//		String type = "One";
//	
//		
//		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
//		s.setSolType(type);
//		
//		PresburgerSolver solver = new PresburgerSolver(0);
//		
//		try {
//			solver.solve(s);
//		} catch (TooManyVariablesException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidFormulaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	 
	@Test(timeout=60000) 
	public void altaricBench07() {

		String equation = "4x[0]-2x[1]+1x[2]+1x[3]-3x[4]-2x[5]+1x[6]-4x[7]-3x[8]+1x[9]+1x[10]-3x[11]+2x[12]+3x[13]-1x[14]+1x[15]+3x[16]-2x[17]-1x[18]+4x[19]-3x[20]-2x[21]+1x[22]+4x[23]-2x[24]+1x[25]+1x[26]-3x[27]+2x[28]+1x[29]-4x[30]-3x[31]+1x[32]-1x[33]-3x[34]+2x[35]+1x[36]<4"; 
		
		String type = "One";
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(timeout=60000) 
	public void altaricBench08() {

		String equation = "11111x - y < 0"; 
		
		String type = "One";
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(timeout=60000) 
	public void altaricBench09() {

		String equation = "1511x - 1023y + 3570z - 1111t - 1943u >= 0"; 
		
		String type = "One";
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(timeout=60000) 
	public void altaricBench10() {

		String equation = "(Ez:w==7z) && (Ez:x==5z) && (Ez:y==3z)"; 
		
		String type = "One";
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test(timeout=60000) 
	public void altaricBench11() {

		String equation = "Ez:y==3z";
		String type = "One";
		
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(timeout=60000) 
	public void altaricBench12() {

		String equation = "x+y-y==5";
		String type = "One";
		
		
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(timeout=60000) 
	public void altaricBench13() {

		String equation = "(Ez:w==7z) && (Ez:x==5z) && (Ez:y==3z) && w+x==y";
		String type = "One";
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(timeout=60000) 
	public void altaricBench14() {

		String equation = "((Ez:w==7z) && (Ez:x==5z) && (Ez:y==3z)) && w+x==3+y";
		String type = "One";
		
		SolverRequest s = new SolverRequest(0,equation,0, "TEST");
		s.setSolType(type);
		
		PresburgerSolver solver = new PresburgerSolver(0 , true , this.minimize);
		
		try {
			solver.solve(s);
		} catch (TooManyVariablesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
