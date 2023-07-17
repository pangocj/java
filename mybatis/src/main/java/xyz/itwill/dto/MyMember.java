package xyz.itwill.dto;

//create table mymember(id varchar2(50) primary key, name varchar2(50),phone varchar2(20), email varchar2(100));

public class MyMember {
	private String id;
	private String name;
	private String phone;
	private String address;
	
	public MyMember() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
