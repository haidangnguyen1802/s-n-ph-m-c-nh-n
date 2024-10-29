package hunre.it.lecturers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "giang_vien")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_giang_vien", nullable = false)
    private String lecturerCode;

    @Column(name = "ho_va_ten", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "so_dien_thoai", nullable = false)
    private String phoneNumber;

    @Column(name = "khoa_giang_day", nullable = false)
    private String faculty;

    @Column(name = "chuyen_nganh", nullable = false)
    private String subject;
    

	public Lecturer() {
		
	}
	public Lecturer(Integer id, String lecturerCode, String fullName, String email, String phoneNumber, String faculty,
			String subject) {
		this.id = id;
		this.lecturerCode = lecturerCode;
		this.fullName = fullName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.faculty = faculty;
		this.subject = subject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLecturerCode() {
		return lecturerCode;
	}

	public void setLecturerCode(String lecturerCode) {
		this.lecturerCode = lecturerCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
    
    
}
