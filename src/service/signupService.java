package service;

import java.util.List;

import dao.SignUpDao;
import util.JsonUtill;

public class signupService {

	public static String getAllUser(String pnumber)
	{
		// TODO Auto-generated method stub
		SignUpDao signup=new SignUpDao();
		List list = signup.getAllUserDetail(pnumber);
		// The list value convert into JSOn by using JACKSON API
		System.out.println("HEY"+list);
				String userList=JsonUtill.convertJavaToJson(list);
				//return JsonList
				return userList;
	
	}

}
