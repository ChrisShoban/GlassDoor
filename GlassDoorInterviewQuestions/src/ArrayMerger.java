import java.util.Arrays;


public class ArrayMerger {

	public static int[] merge(int[] sorted1, int[] sorted2) {
		int[] result = new int[sorted1.length + sorted2.length];
		int i = 0;
		int j = 0;
		int curr = 0;
		while(i < sorted1.length && j < sorted2.length) {
			result[curr++] = (sorted1[i] < sorted2[j])?sorted1[i++]:sorted2[j++];
		}
		while(i != sorted1.length) {
			result[curr++] = sorted1[i++];
		}
		while(j != sorted2.length) {
			result[curr++] = sorted2[j++];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] sorted1 = new int[]{2,4,6,9,13,19,20,21,23,24};
		int[] sorted2 = new int[]{1,5,10,11,12};
		System.out.println(Arrays.toString(merge(sorted1, sorted2)));
	}
}
