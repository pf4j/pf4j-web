package org.rmrodrigues.pf4j.demo.csv.plugin.model;

import java.util.Date;
import org.jsefa.csv.annotation.CsvDataType;
import org.jsefa.csv.annotation.CsvField;

/**
 * The Class PersonCSV.
 * 
 * @author rmrodrigues
 */
@CsvDataType()
public class PersonCSV {

	/** The first name. */
	@CsvField(pos = 1)
	private String firstName;

	/** The last name. */
	@CsvField(pos = 2)
	private String lastName;

	/** The age. */
	@CsvField(pos = 3)
	private int age;

	/** The birthdate. */
	@CsvField(pos = 4)
	private Date birthdate;

	/** The address. */
	@CsvField(pos = 5, format = "dd/MM/yyyy")
	private String address;

	/**
	 * Instantiates a new person csv.
	 * 
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param age
	 *            the age
	 * @param birthdate
	 *            the birthdate
	 * @param address
	 *            the address
	 */
	public PersonCSV(String firstName, String lastName, int age,
			Date birthdate, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.birthdate = birthdate;
		this.address = address;
	}

	/**
	 * Instantiates a new person csv.
	 */
	public PersonCSV() {
		super();
	}

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * 
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the age.
	 * 
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 * 
	 * @param age
	 *            the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the birthdate.
	 * 
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * Sets the birthdate.
	 * 
	 * @param birthdate
	 *            the new birthdate
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 * 
	 * @param address
	 *            the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
