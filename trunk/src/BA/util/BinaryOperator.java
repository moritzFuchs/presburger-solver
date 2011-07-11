package BA.util;

public enum BinaryOperator {
    
	AND("^") {
        @Override public boolean apply(boolean x1, boolean x2) {
            return x1 && x2;
        }
    },
    
    OR("v") {
        @Override public boolean apply(boolean x1, boolean x2) {
            return x1 || x2;
        }
    },

    DIFF("x") {
        @Override public boolean apply(boolean x1, boolean x2) {
            return x1 && !x2;
        }
    },
    
    IMPL("=>") {
        @Override public boolean apply(boolean x1, boolean x2) {
            return !x1 || x2;
        }
    };
    
    
    private final String text;
    
    private BinaryOperator(String text) {
        this.text = text;
    }
    
    public abstract boolean apply(boolean x1, boolean x2);
    
    @Override public String toString() {
        return text;
    }
}
	

