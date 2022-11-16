package controler;

import model.LibraryDatabase;

public class SetupController {
	public boolean isSetuped() {
		return LibraryDatabase.getInstance().getBookList().size()>0;
	}
}
