package view;

public class LoginView {

	public static void main(String[] args) {
		LoginView view=new LoginView();
		view.operation();
	}
	public void operation() {
		System.out.println("------------------------\n-------CONTACTS-------");
	   UserView user=new UserView();
	   user.userMenu();
	   
	}

}
