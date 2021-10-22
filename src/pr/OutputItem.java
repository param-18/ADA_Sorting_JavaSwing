package pr;

public class OutputItem {

	private InputArray inputArray;
	private String sortType;
	private long time;
	
	private int[] sortedArray;
	public OutputItem(InputArray inputArray, String sortType, long time , int[] sortedArray) {
		this.sortedArray = sortedArray;
		this.inputArray = inputArray;
		this.sortType = sortType;
		this.time = time;
	}
	public InputArray getInputArray() {
		return this.inputArray;
	}
	public String getSortType() {
		return this.sortType;
	}
	public long getTime() {
		return this.time;
	}
	public int[] getSortedArray() {
		return this.sortedArray;
	}
	
}
