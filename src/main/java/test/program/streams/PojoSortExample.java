package test.program.streams;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PojoSortExample {

    public static class YourPojo {
        private String fieldName;
        private int age;

        public YourPojo(String fieldName, int age) {
            this.fieldName = fieldName;
            this.age = age;
        }

        public String getFieldName() {
            return fieldName;
        }
        
		public int getAge() {
			return age;
		}

        @Override
        public String toString() {
            return "YourPojo{" +
                    "fieldName='" + fieldName + '\'' +
                    '}';
        }


    }

    public static void main(String[] args) {
        // Create a list of YourPojo objects
    	YourPojo y1 = new YourPojo("C", 10);
    	YourPojo y2 = new YourPojo("A", 11);
    	YourPojo y3 = new YourPojo("B", 12);
        List<YourPojo> pojoList = new ArrayList<PojoSortExample.YourPojo>();
        pojoList.add(y1);
        pojoList.add(y2);
        pojoList.add(y3);

        // Sort the list based on the fieldName
        List<YourPojo> sortedList = pojoList.stream()
                .sorted(Comparator.comparing(YourPojo::getFieldName))
                .collect(Collectors.toList());

        // Print the sorted list
        sortedList.forEach(System.out::println);
    }
}
