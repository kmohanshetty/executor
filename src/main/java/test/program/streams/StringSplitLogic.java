package test.program.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitLogic {

	public static void main(String[] args) {
		int[] splitLengths = {4, 3, 3, 4, 4};
		List<String> PhlV1ToV5 = Arrays.asList("ABCDEFGHIJKLMNOPQR","ABCDEFGHIJKLMN","ABCDEFGHIJ","ABCDEFG","ABCD", "");
		
		for(String value : PhlV1ToV5) {
			List<String> result = splitStringByLengths(value, splitLengths);
			
			result.forEach(str -> System.out.println(str));	
			System.out.println("-------------------------");
			
			System.out.println(checkCondition(result));
		}
		
		

	}

	private static MyCreateUpdate checkCondition(List<String> result) {
		MyCreateUpdate createOrUpdate = new MyCreateUpdate();
		if(result != null && result.size() > 0 && result.size() == 5){
            createOrUpdate.setGroup1Code(result.get(0));
            createOrUpdate.setGroup2Code(result.get(1));
            createOrUpdate.setGroup3Code(result.get(2));
            createOrUpdate.setGroup4Code(result.get(3));
            createOrUpdate.setGroup5Code(result.get(4));
        }
        if(result != null && result.size() > 0 && result.size() == 4){
            createOrUpdate.setGroup1Code(result.get(0));
            createOrUpdate.setGroup2Code(result.get(1));
            createOrUpdate.setGroup3Code(result.get(2));
            createOrUpdate.setGroup4Code(result.get(3));
        }
        if(result != null && result.size() > 0 && result.size() == 3){
            createOrUpdate.setGroup1Code(result.get(0));
            createOrUpdate.setGroup2Code(result.get(1));
            createOrUpdate.setGroup3Code(result.get(2));
        }
        if(result != null && result.size() > 0 && result.size() == 2){
            createOrUpdate.setGroup1Code(result.get(0));
            createOrUpdate.setGroup2Code(result.get(1));
        }
        if(result != null && result.size() > 0 && result.size() == 1){
            createOrUpdate.setGroup1Code(result.get(0));
        }
        return createOrUpdate;
	}
	
	private static List<String> splitStringByLengths(String phlV1ToV5, int[] splitLengths) {
        final int[] currentIndex = {0};
        return Arrays.stream(splitLengths)
                .takeWhile(length -> currentIndex[0] < phlV1ToV5.length())
                .mapToObj(length -> {
                    int start = currentIndex[0];
                    int end = Math.min(start + length, phlV1ToV5.length());
                    currentIndex[0] = end;
                    return phlV1ToV5.substring(start, end);
                })
                .collect(Collectors.toList());
    }

	
}

class MyCreateUpdate {
	private String group1Code;
	private String group2Code;
	private String group3Code;
	private String group4Code;
	private String group5Code;
	public MyCreateUpdate() {}
	
	public MyCreateUpdate(String group1Code, String group2Code, String group3Code, String group4Code,String group5Code) {
		super();
		this.group1Code = group1Code;
		this.group2Code = group2Code;
		this.group3Code = group3Code;
		this.group4Code = group4Code;
		this.group5Code = group5Code;
	}

	public String getGroup1Code() {
		return group1Code;
	}
	public void setGroup1Code(String group1Code) {
		this.group1Code = group1Code;
	}
	public String getGroup2Code() {
		return group2Code;
	}
	public void setGroup2Code(String group2Code) {
		this.group2Code = group2Code;
	}
	public String getGroup3Code() {
		return group3Code;
	}
	public void setGroup3Code(String group3Code) {
		this.group3Code = group3Code;
	}
	public String getGroup4Code() {
		return group4Code;
	}
	public void setGroup4Code(String group4Code) {
		this.group4Code = group4Code;
	}

	public String getGroup5Code() {
		return group5Code;
	}

	public void setGroup5Code(String group5Code) {
		this.group5Code = group5Code;
	}

	@Override
	public String toString() {
		return "MyCreateUpdate [group1Code=" + group1Code + ", group2Code=" + group2Code + ", group3Code=" + group3Code
				+ ", group4Code=" + group4Code + ", group5Code=" + group5Code + "]";
	}
	
}
