package Test4;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JsonSerializer {

	public static void main(String[] args) {
		
		Car car = new Car("Ford", "F150", "2018");
		JsonSerializer serializer = new JsonSerializer();
		try {
			serializer.serialize(car);
		} catch (JsonSerializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String serialize(Object object)throws JsonSerializationException{
		try {
			Class<?> objectClass = object.getClass();
			Map<String,String> jsonElements = new HashMap<>();
			for(Field field: objectClass.getDeclaredFields()) {
				field.setAccessible(true);
				if(field.isAnnotationPresent(JsonField.class)) {
					jsonElements.put(getSerializedKey(field), (String)field.get(object));
				}
			}
			System.out.println(toJsonString(jsonElements));
			return toJsonString(jsonElements);
		}catch(IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		return "";
	}

	private String getSerializedKey(Field field) {
		String annotationValue = field.getAnnotation(JsonField.class).value();
		if(annotationValue.isEmpty()) {
			return field.getName();
		}
		return annotationValue;
	}

	private String toJsonString(Map<String, String> jsonElements) {
		String elements= jsonElements.entrySet()
				.stream()
				.map(entry->"\""+entry.getKey()+"\":\""+entry.getValue()+"\"")
				.collect(Collectors.joining(","));
		return "{"+elements+"}";
	}

}
