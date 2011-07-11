package BA.Logic;

public enum Element{

	ALL(1), EX(2), AND(3), OR(4), IMPL(5),VAR(6),NEG(7),LT(8),LEQ(9),GT(10),GEQ(11),EQ(12),NEQ(13),TRUE(14),FALSE(15),DELETE(16);

	private int num = 0;
	
	private Element(int i) {
		this.num = i;
	}
	
	public int getToken() {
		return this.num;
	}
	
	public boolean isEqual(Element x) {
		return this.num == x.num;
	}
	
	public String toString() {

		if (this.num == 2) {
			return "E ";
		}
		if (this.num == 3) {
			return "AND";
		}
		if (this.num == 4) {
			return "OR";
		}
		if (this.num == 7) {
			return "!";
		}
		if (this.num == 8) {
			return "<";
		}
		if (this.num == 9) {
			return "<=";
		}
		if (this.num == 10) {
			return ">";
		}
		if (this.num == 11) {
			return ">=";
		}
		if (this.num == 12) {
			return "==";
		}
		if (this.num == 13) {
			return "!=";
		}
		if (this.num == 14) {
			return "TRUE";
		}
		if (this.num == 15) {
			return "FALSE";
		}
		if (this.num == 16) {
			return "DELETE";
		}
		System.out.println(this.num);
		return "";
	}
	
}
