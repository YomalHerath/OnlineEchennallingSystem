package appointment.model;

public class Appointment {
	private int id;
	private String firstName;
	private String secondName;
	private String contact;
	private String doctorName;
	private String hospitalName;
	private String date;
	private String month;
	private String year;
	private int patientId;
	
	public Appointment() {
		
	}

	public Appointment(int id, String firstName, String secondName, String contact, String doctorName,
			String hospitalName, String date, String month, String year, int patientId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.contact = contact;
		this.doctorName = doctorName;
		this.hospitalName = hospitalName;
		this.date = date;
		this.month = month;
		this.year = year;
		this.patientId = patientId;
	}

	public Appointment(String firstName, String secondName, String contact, String doctorName, String hospitalName,
			String date, String month, String year, int patientId) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.contact = contact;
		this.doctorName = doctorName;
		this.hospitalName = hospitalName;
		this.date = date;
		this.month = month;
		this.year = year;
		this.patientId = patientId;
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

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", contact="
				+ contact + ", doctorName=" + doctorName + ", hospitalName=" + hospitalName + ", date=" + date
				+ ", month=" + month + ", year=" + year + ", patientId=" + patientId + "]";
	}
	
}