
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Connecting...");
		BusinessLogic access = new BusinessLogic();
		
		int ownerid = access.getOwnerID("CDN215L");
		System.out.println(access.getOwner(ownerid));
		
	}

}
