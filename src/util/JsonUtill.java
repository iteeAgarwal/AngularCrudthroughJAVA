package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtill 
{
	private static ObjectMapper objectMapper;
	static
	{
		objectMapper=new ObjectMapper();
	}
public static String convertJavaToJson(Object obj)
{
	String jsonString=" ";
	try {
		jsonString = objectMapper.writeValueAsString(obj);
		System.out.println(jsonString);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return jsonString;
	}
}
