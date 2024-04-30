package ru.gb.jseminar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Task1 {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        System.out.println(Double.toString(task1.getPercentUniqueValues(task1.initArray(10))));

    }

    // Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24.
    public int[] initArray(int arraySise){
        int[] arr = new int[arraySise];
        Random random = new Random();

        for (int i = 0; i < arraySise; i++){
            arr[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    // Создайте метод, в который передайте заполненный выше массив и с помощью Set вычислите процент уникальных
    // значений в данном массиве и верните его в виде числа с плавающей запятой.
    // Для вычисления процента используйте формулу:
    // процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.
    public double getPercentUniqueValues(int[] array){
        Set<Integer> set = new HashSet<>();
        for (int item: array){
            set.add(item);
        }
        int len = array.length;
        if (len == 0) return 0;
        double res = set.size() * 100 / len;
        
        return res;
    }
}
