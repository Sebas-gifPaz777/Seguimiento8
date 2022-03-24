package model;

public class Country implements Comparable<Country> {

	private int goldM;
	private int silverM;
	private int bronzeM;
	private int goldF;
	private int silverF;
	private int bronzeF;
	private int goldA;
	private int silverA;
	private int bronzeA;
	private String nameC;
	
	public Country(String nameC, int goldM, int silverM, int bronzeM, int goldF, int silverF, int bronzeF) {
		this.nameC=nameC;
		this.goldM = goldM;
		this.silverM = silverM;
		this.bronzeM = bronzeM;
		this.goldF = goldF;
		this.silverF = silverF;
		this.bronzeF = bronzeF;
		goldA = goldM+goldF;
		silverA = silverF+silverM;
		bronzeA = bronzeF+bronzeM;
	}
	public int getGoldM() {
		return goldM;
	}
	public int getSilverM() {
		return silverM;
	}
	public int getBronzeM() {
		return bronzeM;
	}
	public int getGoldF() {
		return goldF;
	}
	public int getSilverF() {
		return silverF;
	}
	public int getBronzeF() {
		return bronzeF;
	}
	public int getGoldA() {
		return goldA;
	}
	public int getSilverA() {
		return silverA;
	}
	public int getBronzeA() {
		return bronzeA;
	}
	public String getNameC() {
		return nameC;
	}
	
	public String toStringM() {
		return nameC+" "+goldM+" "+silverM+" "+bronzeM;
	}
	
	public String toStringF() {
		return nameC+" "+goldF+" "+silverF+" "+bronzeF;
	}
	
	public String toStringA() {
		return nameC+" "+goldA+" "+silverA+" "+bronzeA;
	}
	
	@Override
	public int compareTo(Country o) {
		int result=this.goldF-o.goldF;
		if(result==0)
			result=this.silverF-o.silverF;
		if(result==0)
			result=this.bronzeF-o.bronzeF;
		if(result==0)
			result=this.nameC.compareTo(o.nameC);
		
		return result;
	}
	public int compareByTeam(Country o) {
		int result=this.goldA-o.goldA;
		if(result==0)
			result=this.silverA-o.silverA;
		if(result==0)
			result=this.bronzeA-o.bronzeA;
		if(result==0)
			result=this.nameC.compareTo(o.nameC);
		return result;
	}
}
