import java.util.ArrayList;

public class Task3CoastLength {

	private class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void check(int[][] map, int x, int y, int h, int w) {
		if(map[x][y] == 0) {
			map[x][y] = 2;
		}
		else {
			return;
		}
		
		if(x > 0) {
			check(map, x - 1, y, h, w);
		}
		if(x < h - 1) {
			check(map, x + 1, y, h, w);
		}
		
		if(y > 0) {
			check(map, x, y - 1, h, w);
		}
		if(y < w - 1) {
			check(map, x, y + 1, h, w);
		}
	}
	
	public void printMap(int[][] map) {
		for(int[] row : map) {
			for(int i : row) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		Task3CoastLength sI = new Task3CoastLength();
		
		int height = io.getInt();
		int width = io.getInt();
		
		int[][] map = new int[height][width];
		
		for(int i = 0; i < height; i++) {
			String s = io.getWord();
			for(int j = 0; j < width; j++) {
				if(s.charAt(j) == '1') {
					map[i][j] = 1;
				}
			}
		}
		
		ArrayList<Point> reVisit = new ArrayList<Point>();
		
		for(int x = 0; x < height; x++) {
			for(int y = 0; y < width; y++) {
				if(map[x][y] == 0) {
					if(x == 0 || x == height - 1 || y == 0 || y == width - 1) {
						sI.check(map, x, y, height, width);
					}
				}
			}
		}
		long coastLength = 0;
		for(int x = 0; x < height; x++) {
			for(int y = 0; y < width; y++) {
				if(map[x][y] == 1) {
					if(x == 0 || map[x - 1][y] == 2) {
						coastLength += 1;
					}
					if(x == height - 1 || map[x + 1][y] == 2) {
						coastLength += 1;
					}
					if(y == 0 || map[x][y - 1] == 2) {
						coastLength += 1;
					}
					if(y == width - 1 || map[x][y + 1] == 2) {
						coastLength += 1;
					}
				}
			}
		}
		System.out.println(coastLength);
	}
}
