package com.interview.algorithm;




import lombok.var;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Bing ZHANG
 * @created 04/01/2022
 */
public class SelectSorting {

    public static int[] selectSort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return arr;
        }
        for(int i = 0; i < arr.length -1; i++) {
            int minimumIndex = i;
            for(int j = i+1; j < arr.length; j++) {
                minimumIndex = arr[j] < arr[minimumIndex] ? j : minimumIndex;
            }
            swap(arr, i, minimumIndex);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
//        int[] arr = selectSort(new int[]{2,6,4,1,7});
//        for(int i = 0; i <arr.length; i++ ) {
//            System.out.println(arr[i]);
//        }
        long start = 1644426000000L;
        long end = 1646110800000L;
        Instant instantStart = Instant.ofEpochMilli(start);
        ZonedDateTime startTime = ZonedDateTime.ofInstant(instantStart, ZoneId.of("America/Toronto"));
        System.out.println("Start time is " + startTime.toString());
        Instant instantEnd = Instant.ofEpochMilli(end);
        ZonedDateTime endTime = ZonedDateTime.ofInstant(instantEnd, ZoneId.of("America/Toronto"));
        System.out.println("end time is " + endTime.toString());

        List<ArrayList<String>> temp = new ArrayList<ArrayList<String>>(Arrays.asList(new ArrayList<String>(Arrays.asList("MNL", "TAG")), new ArrayList<String>(Arrays.asList("CEB", "TAC")), new ArrayList<String>(Arrays.asList("TAG", "CEB")), new ArrayList<String>(Arrays.asList("TAC", "BOR"))));
        Map<String, String> collect = temp.stream()
                .collect(Collectors.toMap(a -> a.get(0), a -> a.get(1)));
        collect.size();
    }

    public static String findRoutes(ArrayList<ArrayList<String>> routes) {
        Map<String, String> travelMap = routes.stream()
                .collect(Collectors.toMap(route -> route.get(0), route -> route.get(1)));
        List<String> routeInfos = getRoute(travelMap);
        String output = "";
        for(String stop : routeInfos) {
            output = output + stop + ", ";
        }
        output = output.substring(0, output.length() - 2);
        return output;
    }

    private static List<String> getRoute(Map<String, String> travelMap)
    {
        Map<String, String> keyValueReversed = new HashMap<String, String>();

        for (Map.Entry<String,String> entry: travelMap.entrySet())
            keyValueReversed.put(entry.getValue(), entry.getKey());

        List<String> route = new ArrayList<>();
        for (Map.Entry<String,String> entry: travelMap.entrySet())
        {
            if (!keyValueReversed.containsKey(entry.getKey()))
            {
                route.add( entry.getKey());
                break;
            }
        }

        if (route.size() == 0)
        {
            System.out.println("Invalid Input");
            return route;
        }
        String from = route.get(0);
        String nextTo = travelMap.get(from);
        while (nextTo != null)
        {
            route.add(nextTo);
            nextTo = travelMap.get(nextTo);
        }
        return route;
    }

    public static int shiftedDiff(String first, String second) {
        if(first == null || second == null || first.isEmpty() || second.isEmpty() || first.length() != second.length()) {
            return -1;
        }
        if(first.equals(second)) {
            return 0;
        }
        String doubleFirst = first + first;
        int index = 0;
        if(doubleFirst.contains(second)) {
            index = doubleFirst.indexOf(second);
            return first.length() - index;
        }
        return -1;
    }

    public static String orderWeight(String string) {
        List<String> numbers = Arrays.asList(string.split(" "));
        numbers.sort(new OrderComparator());
        String output = "";
        for(String num : numbers) {

            output = output + num + " ";
        }
        return output;
    }

    public static class OrderComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int weight1 = getWeight(o1);
            int weight2 = getWeight(o2);

            if(weight1 == weight2) {
                return o1.compareTo(o2);
            } else {
                return weight1 < weight2 ? -1 : 1;
            }
        }
    }
    public static int getWeight(String number) {
        int weight = 0;
        for(char a : number.toCharArray()) {
            weight += Integer.parseInt(String.valueOf(a));
        }

        return weight;
    }

}
