public class Task4Excursion {

	public static int getNextIndex(int[] arr, int val, int startIndex) {
		for(int i = startIndex; i >= 0; i--) {
			if(arr[i] == val) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean swap(int[] arr, int posx, int posy) {
		if(arr[posx] == arr[posy]) {
			return false;
		}
		int temp = arr[posx];
		arr[posx] = arr[posy];
		arr[posy] = temp;
		return true;
	}
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		
		String line = io.getWord();
		int linLen = line.length();
		int[] swapLine = new int[linLen];
		long swaps = 0;
		
		int oneCount = 0;
		int twoCount = 0;
		int lastTwo = 0;
		
		int lastOne = 0;
		int distTwoOne = 0;
		
		for(int i = 0; i < linLen; i++) {
			if(line.charAt(i) == '1') {
				swapLine[i] = 1;
				oneCount += 1;
				lastOne = i;
				distTwoOne = twoCount;
			}
			else if(line.charAt(i) == '2') {
				swapLine[i] = 2;
				twoCount += 1;
				lastTwo = i;
			}
		}
		int twoIndex = linLen - 1;
		int oneIndex = twoIndex - twoCount;
		
		int lastIndex = lastTwo + 1;
		for(int z = 0; z < twoCount; z++) {
			if(lastIndex == 0) {
				break;
			}
			
			lastIndex = getNextIndex(swapLine, 2, lastIndex - 1);
			
			if(lastIndex == -1) {
				break;
			}
			for(int movInd = lastIndex; movInd < twoIndex; movInd++) {
				if(swap(swapLine, movInd, movInd + 1)) {
					swaps += 1;
				}
				else {
					break;
				}
			}
			twoIndex -= 1;
		}
		
		lastIndex = lastOne - distTwoOne + 1;
		for(int y = 0; y < oneCount; y++) {
			if(lastIndex == 0) {
				break;
			}
			
			lastIndex = getNextIndex(swapLine, 1, lastIndex - 1);
			
			if(lastIndex == -1) {
				break;
			}
			
			for(int movInd = lastIndex; movInd < oneIndex; movInd++) {
				if(swap(swapLine, movInd, movInd + 1)) {
					swaps += 1;
				}
				else {
					break;
				}
			}
			oneIndex -= 1;
		}
		System.out.println(swaps);
		io.close();
	}
}
