package test.program.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class CountingExample {

	public static void main(String[] args) {
		List<TestTwist> twists = new ArrayList<TestTwist>();
		
		TestTwist twist1 = new TestTwist(1000L, "abc", "800111", 202518L, 202505L, 200L);
		twists.add(twist1);
		TestTwist twist2 = new TestTwist(1001L, "def", "800112", 202519L, 202505L, 200L);
		twists.add(twist2);
		TestTwist twist3 = new TestTwist(1002L, "abc", "800111", 202518L, 202505L, 50L);
		twists.add(twist3);
		TestTwist twist4 = new TestTwist(1003L, "abc", "800114", 202520L, 202505L, 100L);
		twists.add(twist4);
		TestTwist twist5 = new TestTwist(1006L, "abc", "800111", 202518L, 202505L, 100L);
		twists.add(twist5);
		TestTwist twist6 = new TestTwist(1007L, "abc", "800111", 202518L, 202506L, 100L);
		twists.add(twist6);

	            
//	   TestTwist singleVal = containsValue(twists, 202518L, 202505L, "800111");
//	   System.out.println(singleVal);
		
		removeDuplicates(twists);
		
		// Print final list
        twists.forEach(System.out::println);
		
	}

	private static void removeDuplicates(List<TestTwist> twists) {
		// Set to track first occurrences of wkNo
        Set<String> seenWkNos = ConcurrentHashMap.newKeySet();

        twists.removeIf(twist -> !seenWkNos.add(twist.getWkNo()+ "-" + twist.getMonNo()));
        twists.sort(Comparator.comparingLong(TestTwist::getWkNo));

        
	}
	
	private static TestTwist containsValue(List<TestTwist> twists, Long wkNo, Long monNo, String mfgCode) {
	    List<TestTwist> filtered = twists.stream()
	        .filter(t -> t.getMfgCode().equals(mfgCode) &&
	                     t.getWkNo().equals(wkNo) &&
	                     t.getMonNo().equals(monNo))
	        .collect(Collectors.toList());

	    if (filtered.isEmpty()) return null;

	    TestTwist first = filtered.get(0);
	    long totalQty = filtered.stream().mapToLong(TestTwist::getQty).sum();

	    // Return a new TestTwist object or update the first one (depending on your requirement)
	    return new TestTwist(
	        first.getId(),         // or null if ID is not needed
	        first.getCode(),
	        first.getMfgCode(),    // or prod8D if prod8D == mfgCode
	        first.getWkNo(),
	        first.getMonNo(),
	        totalQty
	    );
	}


}

class TestTwist {
	Long id;
	String code;
	String mfgCode;
	Long wkNo;
	Long monNo;
	Long qty;
	
	public TestTwist() {
	}
	

	public TestTwist(Long id, String code, String mfgCode, Long wkNo, Long monNo, Long qty) {
		super();
		this.id = id;
		this.code = code;
		this.mfgCode = mfgCode;
		this.wkNo = wkNo;
		this.monNo = monNo;
		this.qty = qty;
	}



	public Long getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public String getMfgCode() {
		return mfgCode;
	}
	public Long getQty() {
		return qty;
	}
	public Long getWkNo() {
		return wkNo;
	}
	public Long getMonNo() {
		return monNo;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setMfgCode(String mfgCode) {
		this.mfgCode = mfgCode;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	public void setWkNo(Long wkNo) {
		this.wkNo = wkNo;
	}
	public void setMonNo(Long monNo) {
		this.monNo = monNo;
	}


	@Override
	public String toString() {
		return "TestTwist [id=" + id + ", code=" + code + ", mfgCode=" + mfgCode + ", wkNo=" + wkNo + ", monNo=" + monNo
				+ ", qty=" + qty + "]";
	}
	
	
}

class GroupKey {
    private final String mfgCode;
    private final Long wkNo;
    private final Long monNo;

    public GroupKey(String mfgCode, Long wkNo, Long monNo) {
        this.mfgCode = mfgCode;
        this.wkNo = wkNo;
        this.monNo = monNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupKey)) return false;
        GroupKey key = (GroupKey) o;
        return Objects.equals(mfgCode, key.mfgCode)
            && Objects.equals(wkNo, key.wkNo)
            && Objects.equals(monNo, key.monNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mfgCode, wkNo, monNo);
    }
}


//Map<String, Long> groupedSums = twists.stream()
//.collect(Collectors.groupingBy(
//    t -> t.getMfgCode() + "-" + t.getWkNo() + "-" + t.getMonNo(),
//    Collectors.summingLong(TestTwist::getQty)
//));
//
//// Print results
//groupedSums.forEach((key, sum) -> {
//System.out.println("Group: " + key + " -> Qty Sum: " + sum);
//});
//
//Collection<TestTwist> result = twists.stream()
//    .collect(Collectors.groupingBy(
//        t -> new GroupKey(t.getMfgCode(), t.getWkNo(), t.getMonNo()),
//        Collectors.collectingAndThen(
//            Collectors.toList(),
//            list -> {
//                TestTwist first = list.get(0);
//                long totalQty = list.stream().mapToLong(TestTwist::getQty).sum();
//                return new TestTwist(
//                    first.getId(),      // or null, or first.getId()
//                    first.getCode(),    // keep representative code
//                    first.getMfgCode(),
//                    first.getWkNo(),
//                    first.getMonNo(),
//                    totalQty
//                );
//            }
//        )
//    ))
//    .values();
//
//// Output
//result.forEach(t -> {
//    System.out.println("Mfg: " + t.getMfgCode() + ", WkNo: " + t.getWkNo()
//        + ", MonNo: " + t.getMonNo() + ", Qty Sum: " + t.getQty());
//});   
