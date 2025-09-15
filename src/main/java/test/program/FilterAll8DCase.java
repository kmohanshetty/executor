package test.program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class FilterAll8DCase {
	public static void main(String [] args) {
		List<SalesForecastMonArchive> sellinLst = new ArrayList<SalesForecastMonArchive>();
		
		SalesForecastMonArchive monArchive3 = new SalesForecastMonArchive(6013L,"260600",null,"02662260",null,'2',202507L,0L,'1',null,'N');
		sellinLst.add(monArchive3);
		
		SalesForecastMonArchive monArchive1 = new SalesForecastMonArchive(6011L,"260600",null,"02662260",null,'2',202505L,100L,'1',null,'N');
		sellinLst.add(monArchive1);
		
		SalesForecastMonArchive monArchive4 = new SalesForecastMonArchive(6014L,"260600",null,"02662260",null,'2',202508L,0L,'1',null,'N');
		sellinLst.add(monArchive4);
		
		SalesForecastMonArchive monArchive2 = new SalesForecastMonArchive(6012L,"260600",null,"02662260",null,'2',202506L,0L,'1',null,'N');
		sellinLst.add(monArchive2);
		
		
		SalesForecastMonArchive monArchive5 = new SalesForecastMonArchive(6015L,"260600",null,"02662260",null,'2',202509L,0L,'1',null,'N');
		sellinLst.add(monArchive5);
		
		AtomicReference<Integer> currentSeihanMonth = new AtomicReference<Integer>(202504);
		
		List<SalesForecastMonArchive> get8DsFromSellinArchival = get8DsFromSellinArchival(sellinLst, currentSeihanMonth);
		
		get8DsFromSellinArchival.forEach(System.out::println);
	}
	
	private static List<SalesForecastMonArchive> get8DsFromSellinArchival(List<SalesForecastMonArchive> salesForecastMonArchives, AtomicReference<Integer> currentSeihanMonth) {
        Long currentMon = Long.valueOf(currentSeihanMonth.get());
        Set<String> qualifyingArchival = salesForecastMonArchives.stream()
                .filter(e -> e.getProd8D() != null)
                .collect(Collectors.groupingBy(SalesForecastMonArchive::getProd8D))
                .entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .filter(e -> e.getMonNo() > Long.valueOf(currentMon))
                        .allMatch(e -> e.getSellInQty() == 0))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        List<SalesForecastMonArchive> monArchiveList = salesForecastMonArchives.stream()
                .filter(e -> e.getProd8D() != null)
                .filter(e -> qualifyingArchival.contains(e.getProd8D()))
                .collect(Collectors.groupingBy(SalesForecastMonArchive::getProd8D,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingLong(SalesForecastMonArchive::getMonNo)),
                                Optional::get)))
                .values().stream()
                .sorted(Comparator.comparing(SalesForecastMonArchive::getProd8D))
                .collect(Collectors.toList());
        return monArchiveList;
    }
}
