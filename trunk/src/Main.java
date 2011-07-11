

import BA.Solver.PresburgerSolver;

public class Main {

	public static void main(String[] args) throws Exception {
                
                PresburgerSolver s = new PresburgerSolver(0);

//                s.solve("&& [i=1..5] Ex[i]: x[i]==i" , 0 , "5x+y","One");
                
//                s.solve("Exy(x==1&&y==2&&z==3)" , 0 , "5x+y","One");
                
                s.solve("_Even(x+y , z)" , 0 , "5x+y","One");
                
	}
	
	
}