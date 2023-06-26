package tech.spec.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void run() {
        int[] numbers = {17, 12, 11, 3, 9, 8};
        int groups = 3;
        int[] numbers2 = {17, 12, 10, 4, 9, 8};
        int groups2 = 2;
        int[] numbers3 = {17, 12, 11, 2, 9, 8};
        int groups3 = 3;
        int[] numbers4 = {17, 12, 11, 3, 9, 8};
        int groups4 = 0;
        int[] numbers5 = {17, 12, 11, 3, 9, 8};
        int groups5 = 2;
        int[] numbers6 = {};
        int groups6 = 3;
        distrNum(numbers, groups);
        distrNum(numbers2, groups2);
        distrNum(numbers3, groups3);
        distrNum(numbers4, groups4);
        distrNum(numbers5, groups5);
        distrNum(numbers6, groups6);
    }
    public static void distrNum(int[] num, int gps) {
       if (gps < 1 ){
            System.out.println("Исходный массив: " + Arrays.toString(num)+" Число групп: "+gps);
            System.out.println("Распределение невозможно. Неверное число групп\n");
            return;
        }
       if(num.length < 1){
           System.out.println("Исходный массив: " + Arrays.toString(num)+" Число групп: "+gps);
           System.out.println("Распределение невозможно. Пустой массив\n");
           return;
       }
        int sum = Arrays.stream(num).sum();

        if (sum % gps != 0) {
            System.out.println("Исходный массив: " + Arrays.toString(num)+" Число групп: "+gps);
            System.out.println("Распределение невозможно\n");
            return;
        }

        int target = sum / gps;

        List<List<Integer>> distr = new ArrayList<>();
        for (int i = 0; i < gps; i++) {
            distr.add(new ArrayList<>());
        }

        boolean possible = distrRec(num, target, 0, distr);
        if (possible) {
            System.out.println("Исходный массив: " + Arrays.toString(num)+" Число групп: "+gps);
            System.out.println("Результаты распределения:");
            for (List<Integer> a : distr) {
                System.out.print(a+" ");
            }
            System.out.print("\n\n");
        }
        else {
            System.out.println("Исходный массив: " + Arrays.toString(num)+" Число групп: "+gps);
            System.out.println("Невозможно распределить числа на заданное число групп.");
        }
    }

    private static boolean distrRec(int[] nums, int sum, int ind, List<List<Integer>> distr) {
        if (ind == nums.length) {
            for (List<Integer> group : distr) {
                if (group.stream().mapToInt(Integer::intValue).sum() != sum) {
                    return false;
                }
            }
            return true;
        }

        int num = nums[ind];

        for (List<Integer> a : distr) {
            if ((a.stream().mapToInt(Integer::intValue).sum() + num ) <= sum) {
                a.add(num);
                if (distrRec(nums, sum ,ind + 1, distr)) {
                    return true;
                }
                a.remove(a.size() - 1);
            }
        }

        return false;
    }
}
