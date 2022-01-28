package patient.model;

public class Patient {
	private int id;
	private String firstName;
	private String lastName;
	private String Username;
	private String password;
	private String email;
	private String contact;
	
	public Patient(int id, String firstName, String lastName, String username, String password, String email, String contact) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		Username = username;
		this.password = password;
		this.email = email;
		this.contact = contact;
	}

	public Patient(String firstName, String lastName, String username, String password, String email, String contact) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Username = username;
		this.password = password;
		this.email = email;
		this.contact = contact;
	}

	public Patient() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Username=" + Username
				+ ", password=" + password + ", email=" + email + ", contact=" + contact
				+ "]";
	}
	
}
