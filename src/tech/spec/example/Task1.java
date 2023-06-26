package tech.spec.example;
import java.util.*;

public class Task1 {

    public static void run() {


        List<Integer> arr = generate(20);
        System.out.println("Начальный массив: "+arr);
        sortArr(arr);
        System.out.println("Отсортированный массив: "+arr);
    }
    public static List<Integer> generate(int length){
        Random random = new Random();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            arr.add(random.nextInt(10));
        }
        return arr;
    }
    private static List<Integer> sortArr(List<Integer> list){
        Collections.sort(list,(a,b)->{
            boolean first_Odd = a % 2 != 0;
            boolean second_Odd = b % 2 != 0;

            if (first_Odd && !second_Odd) {
                return -1;
            } else if (!first_Odd && second_Odd) {
                return 1;
            } else if (first_Odd && second_Odd) {
                return a.compareTo(b);
            } else if (a == 0 && b != 0) {
                return -1;
            } else if (a != 0 && b == 0) {
                return 1;
            } else {
                return b.compareTo(a);
            }

        });

        return list;
    }

}
