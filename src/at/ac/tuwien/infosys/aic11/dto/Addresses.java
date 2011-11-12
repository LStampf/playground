package at.ac.tuwien.infosys.aic11.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Addresses {
	private String id;
	private String street;
	private String city;
	private String house;
	private String door;
	private String zipCode;

	@XmlAttribute(required = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(required = true)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@XmlElement(required = true)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement(required = true)
	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	@XmlElement(required = true)
	public String getDoor() {
		return door;
	}

	public void setDoor(String door) {
		this.door = door;
	}

	@XmlElement(name = "zip_code", required = true)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Addresses[");
		sb.append("id=" + id + ", ");
		sb.append("street=" + street + ", ");
		sb.append("city=" + city + ", ");
		sb.append("house=" + house + ", ");
		sb.append("door=" + door + ", ");
		sb.append("zipCode=" + zipCode);
		sb.append("]");
		return sb.toString();
	}

}
