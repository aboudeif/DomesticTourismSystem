


import java.time.LocalDate;


public class Tourist {
public static int total;	
private int regNo;
private String name;
private int age;
private String nationality;
private String phone;
private String email;
private boolean type;
private boolean gender;
private int[] regTravel;
private int[] prevTravel;
private String accURL;
private int partnerCode;
private double balance;
private LocalDate subscribDate;
private int cityCode;
private boolean status;

public Tourist() {this.subscribDate = java.time.LocalDate.now();total+=1;}
public Tourist(int regNo,String name,int age,String nationality,
		String phone,String email,boolean type,boolean gender,String accURL,
		int partnerCode,double balance,int cityCode,boolean status) {

	this.regNo = regNo;
	this.name = name;
	this.age= age;
	this.nationality = nationality;
	this.phone = phone;
	this.email = email;
	this.type = type;
	this.gender = gender;
	this.accURL = accURL;
	this.partnerCode = partnerCode;
	this.balance = balance;
	this.subscribDate = java.time.LocalDate.now();
	this.cityCode = cityCode;
	this.status = status;
	total+=1;
}

public void setRegNo(int regNo) { this.regNo = regNo; }
public int getRegNo() { return regNo; }

public void setName(String name) { this.name = name; }
public String getName() { return name; }

public void setAge(int age) { this.age = age; }
public int getAge() { return age; }

public void setNationality(String nationality) { this.nationality = nationality; }
public String getNationality() { return nationality; }

public void setPhone(String phone) { this.phone = phone; }
public String getPhone() { return phone; }

public void setEmail(String email) { this.email = email; }
public String getEmail() { return email; }

public void setType(boolean type) { this.type = type; }
public boolean getType() { return type; }

public void setGender(boolean gender) { this.gender = gender; }
public boolean getGender() { return gender; }

public void setAccURL(String accURL) { this.accURL = accURL; }
public String getAccURL() { return accURL; }

public void setPartnerCode(int partnerCode) { this.partnerCode = partnerCode; }
public int getPartnerCode() { return partnerCode; }

public void setBalance(double balance) { this.balance = balance; }
public double getBalance() { return balance; }

public LocalDate getSubscribDate() { return subscribDate; }

public void setCityCode(int cityCode) { this.cityCode = cityCode; }
public int getCityCode() { return cityCode; }

public void setStatus(boolean status) { this.status = status; }
public boolean getStatus() { return status; }

public void setRegTravel(int regTravel) { this.regTravel[this.regTravel.length] = regTravel; }
public int[] getRegTravel() { return regTravel; }

public void setPrevTravel(int  prevTravel) { this. prevTravel[this. prevTravel.length] =  prevTravel; }
public int[] getPrevTravel() { return prevTravel; }
}

