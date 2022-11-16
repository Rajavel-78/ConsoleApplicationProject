package controler;

public class LoginControler {
	public boolean checkAdmin(String user,String password) {
		return user.equals("raja")&&password.equals(password)?true:false;
	}

}
