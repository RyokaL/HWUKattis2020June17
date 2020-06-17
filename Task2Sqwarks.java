
public class Task2Sqwarks {

	//Bit naive, could certainly do better. May re-look later
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		
		int users = io.getInt();
		int links = io.getInt();
		int infectedIndex = io.getInt();
		int timeSteps = io.getInt();
		
		if(timeSteps <= 0) {
			System.out.println(0);
		}
		if(users <= 0) {
			System.out.println(0);
		}
		if(infectedIndex >= users) {
			System.out.println(0);
		}
		
		boolean[][] network = new boolean[users][users];
		long[] sqwarks = new long[users];
		boolean[] recSqwarks = new boolean[users];
		
		for(int m = 0; m < links; m++) {
			int x = io.getInt();
			int y = io.getInt();
			
			if(x == y) {
				continue;
			}
			
			network[x][y] = true;
			network[y][x] = true;
		}

		sqwarks[infectedIndex] = 1;
		recSqwarks[infectedIndex] = true;
		
		for(int t = 1; t <= timeSteps; t++) {
			long[] toAdd = new long[users];
			boolean[] nextRec = new boolean[users];
			for(int i = 0; i < users; i++) {
				if(recSqwarks[i]) {
					boolean[] connect = network[i];
					for(int j = 0; j < users; j++) {
						if(connect[j]) {
							toAdd[j] += sqwarks[i];
							nextRec[j] = true;
						}
					}
				}
			}
			recSqwarks = nextRec;
			sqwarks = toAdd;
		}
		
		long ans = 0;
		for(long i : sqwarks) {
			ans += i;
		}
		System.out.println(ans);
	}
}
