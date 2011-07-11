package BA.util;

public enum IntegerOperator {
    
	SEQ("<=") {
        @Override public boolean apply(Integer x1, Integer x2) {
            return x1 <= x2;
        }
    },
    
    ST("<") {
    	@Override public boolean apply(Integer x1, Integer x2) {
    		return x1 < x2;
    	}
    },
    
    GEQ(">=") {
        @Override public boolean apply(Integer x1, Integer x2) {
            return x1 >= x2;
        }
    },
    
    GT(">") {
    	@Override public boolean apply(Integer x1, Integer x2) {
    		return x1 > x2;
    	}
    },
    
    EQ("==") {
        @Override public boolean apply(Integer x1, Integer x2) {
            return x1 == x2;
        }
    },
    
    NEQ("!=") {
        @Override public boolean apply(Integer x1, Integer x2) {
            return x1 != x2;
        }
    };
    
    
    private final String text;
    
    private IntegerOperator(String text) {
        this.text = text;
    }
    
    public abstract boolean apply(Integer x1, Integer x2);
    
    @Override public String toString() {
        return text;
    }
}
	

