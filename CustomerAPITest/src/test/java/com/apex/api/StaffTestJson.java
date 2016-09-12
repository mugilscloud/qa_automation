package com.apex.api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.apex.bean.Staff;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StaffTestJson {
	@Test(priority = 1)
	public void convertJsonToJavaObject() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Staff staff = mapper.readValue(new File("staff1.json"), Staff.class);

		System.out.println(staff);
	}

	@Test(priority = 2)
	public void convertJavaObjectToJson() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Staff staff = createStaffObject();
		File file = new File("staff1.json");
		mapper.writeValue(file, staff);
		System.out.println(file.getAbsolutePath());
		System.out.println(staff);
	}

	private Staff createStaffObject() {
		Staff staff = new Staff();
		staff.setAge(30);
		staff.setName("Yazhini");
		staff.setPosition("Tester");
		staff.setSalary(8000);
		List<String> skills = new ArrayList<String>();
		skills.add("Java");
		skills.add("Selenium");
		staff.setSkills(skills);
		return staff;
	}
}
