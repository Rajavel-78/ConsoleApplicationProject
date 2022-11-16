package view;
import controler.SetupController;
import java.util.Scanner;
public class SetupLibrary {
	Scanner scan=new Scanner(System.in);
	private SetupController setupController;

	SetupLibrary() {
		setupController = new SetupController();
	}

	public void init() {
		boolean isSetupCompleted = setupController.isSetuped();
		isSetupCompleted=false;
		if(isSetupCompleted) {
			System.out.println("Library setup already completed");

		}else {
			System.out.println("Library has to be setuped");
			System.out.println("1 Add Book\n2 ViewBook List\n3 removeBook\n4 Book transaction List\n5 mantain Book\n---SELECT YOUR OPTION--");
			ManageUsers user=new ManageUsers();
			user.menu();
			
		}
	}
}