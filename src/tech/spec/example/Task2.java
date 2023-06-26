package tech.spec.example;
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void run() {

        List<Integer> arr = Task1.generate(30);

        System.out.println("Начальный массив: "+arr);
        getCount(arr);

    }
    public static void getCount(List<Integer> list) {

        Map<Integer, Integer> arr = new HashMap<>();

        for (Integer intA : list) {

            if (arr.containsKey(intA)) {

                arr.compute(intA, (a, b) -> b + 1);

            } else {
                arr.put(intA, 1);
            }

        }

        int max = Collections.max(arr.values());

        arr = arr.entrySet().stream().filter(a -> a.getValue() == max).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> a : arr.entrySet()) {

            System.out.println("Число: " + a.getKey() + " Встречается: " + a.getValue()+" раз");

        }
    }

}
