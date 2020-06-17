import java.util.Arrays;
import java.util.Collections;

public class Task5BAPC {
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		
		int tests = io.getInt();
		for(int t = 0; t < tests; t++) {
			String program = io.getWord();
			int listLen = io.getInt();
			String initList = io.getWord();
			String[] brokenList = initList.substring(1, initList.length() - 1).split(",");
		
			boolean rev = false;;
			int revDrops = 0;
			int drops = 0;
			
			for(int i = 0; i < program.length(); i++) {
				if(program.charAt(i) == 'R') {
					rev = !rev;
				}
				else if(program.charAt(i) == 'D') {
					if(rev) {
						revDrops += 1;
					}
					else {
						drops += 1;
					}
				}
			}
			
			if(revDrops + drops > listLen) {
				System.out.println("error");
			}
			else {
				String[] finalList = Arrays.copyOfRange(brokenList, drops, brokenList.length - revDrops);
				if(rev) {
					Collections.reverse(Arrays.asList(finalList));
					System.out.println(Arrays.toString(finalList).replaceAll(" ", ""));
				}
				else {
					System.out.println(Arrays.toString(finalList).replaceAll(" ", ""));
				}
			}
		}
		io.close();
	}
}
