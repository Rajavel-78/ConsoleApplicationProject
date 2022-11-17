package modal;

public class Contact {
	private String name;
	private String phoneNumber;
	private String email;
	private String dateOfBirth;
	private String relationship;
	private boolean favourites;
	private String address;
	public Contact(String name, String phoneNumber, String email, String dateOfBirth, String relationship,
			boolean favourites, String address) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.relationship = relationship;
		this.favourites = favourites;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public boolean isFavourites() {
		return favourites;
	}
	public void setFavourites(boolean favourites) {
		this.favourites = favourites;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void display() {
		System.out.println("NAME : "+name+"\nMOBILE NUMBER : "+phoneNumber+"\nEmail :"+email+"\nDATE OF BIRTH :"+dateOfBirth+"\nrelationShip :"
				+relationship+"\nfavorites :"+favourites+"\nADDRESS :"+address);
	}
}
