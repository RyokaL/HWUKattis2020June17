
public class Task1HangingOut {
	public static void main(String[] args) {
		Kattio io = new Kattio(System.in);
		
		int limit = io.getInt();
		int events = io.getInt();
		
		int countDisallowed = 0;
		int totalPeople = 0;
		
		for(int i = 0; i < events; i++) {
			String action = io.getWord();
			int people = io.getInt();
			if(action.equals("enter")) {
				if(totalPeople + people > limit) {
					countDisallowed++;
				}
				else {
					totalPeople += people;
				}
			}
			if(action.equals("leave")) {
				totalPeople -= people;
			}
		}
		
		System.out.println(countDisallowed);
	}
}
