import java.util.Arrays;

public class Task4ExcursionRetry {
	
	//Normal merge sort with inversion counting
	public long merge(int[] arr, int[] left, int[] right) {
		int l = 0; int r = 0; long inv = 0;
		while(l < left.length || r < right.length) {
			//If we reached the end of left, then just copy the right in
			if(l == left.length) {
				arr[l + r] = right[r];
				r++;
			}
			//Or if we reached the end of right just copy the left in
			else if(r == right.length) {
				arr[l + r] = left[l];
				l++;
			}
			else if(left[l] <= right[r]) {
				arr[l + r] = left[l];
				l++;	
			}
			else {
				arr[l + r] = right[r];
				inv += left.length - l;
				r++;
			}
		}
		return inv;
	}
	
	public long mergesort(int[] arr) {
		if(arr.length < 2) {
			return 0;
		}
		
		int mid = (arr.length + 1) / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		
		return mergesort(left) + mergesort(right) + merge(arr, left, right);
	}
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		
		String line = io.getWord();
		int linLen = line.length();
		int[] swapLine = new int[linLen];
		long swaps = 0;
		
		for(int i = 0; i < linLen; i++) {
			if(line.charAt(i) == '1') {
				swapLine[i] = 1;
			}
			else if(line.charAt(i) == '2') {
				swapLine[i] = 2;
			}
		}
		Task4ExcursionRetry sI = new Task4ExcursionRetry();
		System.out.println(sI.mergesort(swapLine));
		io.close();
	}
}
