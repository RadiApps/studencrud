package in.app.onlineassisment.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * Person generated by hbm2java
 */
@Entity
@Table(name = "person")
public class Person  {

	private Integer id;
	private PersonType personType;
	private int studentCode;
	private String fname;
	private String lname;
	private int gender;
	private char isUser;
	private int gradeYear;
	private String email;
	private String password;
	private String phoneNumber;
	private Date birthDate;
	private Date createdDate;

	public Person() {
	}

	public Person(PersonType personType, int studentCode, String fname, String lname, int gender, char isUser,
			int gradeYear,String email,String password,String phoneNumber,Date birthDate, Date createdDate) {
		this.personType = personType;
		this.studentCode = studentCode;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.isUser = isUser;
		this.gradeYear = gradeYear;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.createdDate = createdDate;
	}

	
	@PrePersist
	protected void onCreate() {
	    if (createdDate == null) { createdDate = new Date(); }
	}
	
	@Id
	@Column(name = "ID")
    @GeneratedValue(generator = "seq-generator")
    @GenericGenerator(name = "seq-generator", strategy = "in.app.onlineassisment.Utils.SequenceGenerator")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_TYPE_ID", nullable = false)
	public PersonType getPersonType() {
		return this.personType;
	}

	public void setPersonType(PersonType personType) {
		this.personType = personType;
	}

	@Column(name = "STUDENT_CODE")
	public int getStudentCode() {
		return this.studentCode;
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}

	@Column(name = "FNAME", nullable = false, length = 50)
	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	@Column(name = "LNAME", nullable = false, length = 50)
	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Column(name = "GENDER", nullable = false)
	public int getGender() {
		return this.gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Column(name = "IS_USER", nullable = false, length = 1)
	public char getIsUser() {
		return this.isUser;
	}

	public void setIsUser(char isUser) {
		this.isUser = isUser;
	}

	@Column(name = "GRADE_YEAR", nullable = false)
	public int getGradeYear() {
		return this.gradeYear;
	}

	public void setGradeYear(int gradeYear) {
		this.gradeYear = gradeYear;
	}

	@Column(name = "EMAIL", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD", length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Column(name = "PHONE_NUM", length = 20)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTH_DATE", length = 19)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19   )
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



}
