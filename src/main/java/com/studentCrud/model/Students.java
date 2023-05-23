package com.studentCrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity    //use for storing in database
@Table(name="Students")  //Add table name present in your database
public class Students {
		
			@Id 		//Primary Key 
			@GeneratedValue(strategy = GenerationType.IDENTITY)  //Only Accept Unique Value not Duplicate value
			private Long stdid;
			
			@Column(name="std_name") //column map with data base
			private String std_name;
			
			@Column(name="std_phone") //column map with data base
			private long std_phone;
			
			@Column(name="std_age") //column map with data base
			private int std_age;
			
			@Column(name="std_city") //column map with data base
			private String std_city;
			
			
			
			//--------------Getter Setter-----------

			public Long getStdid() {
				return stdid;
			}

			public void setStdid(Long stdid) {
				this.stdid = stdid;
			}

			public String getStd_name() {
				return std_name;
			}

			public void setStd_name(String std_name) {
				this.std_name = std_name;
			}

			public long getStd_phone() {
				return std_phone;
			}

			public void setStd_phone(long std_phone) {
				this.std_phone = std_phone;
			}

			public int getStd_age() {
				return std_age;
			}

			public void setStd_age(int std_age) {
				this.std_age = std_age;
			}

			public String getStd_city() {
				return std_city;
			}

			public void setStd_city(String std_city) {
				this.std_city = std_city;
			}
			
			
			
		//	------------Constructor -----------------------

			public Students(Long stdid, String std_name, long std_phone, int std_age, String std_city) {
				super();
				this.stdid = stdid;
				this.std_name = std_name;
				this.std_phone = std_phone;
				this.std_age = std_age;
				this.std_city = std_city;
			}
			
			
			//	------------Constructor without parameter-----------------------

			public Students() {
				
			}
			
			
			//	------------to String Method -----------------------


			@Override
			public String toString() {
				return "Students [stdid=" + stdid + ", std_name=" + std_name + ", std_phone=" + std_phone + ", std_age="
						+ std_age + ", std_city=" + std_city + "]";
			}
			
			
			
			
	

}
