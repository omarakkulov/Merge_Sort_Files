package ru.akkulov.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyIntMethods {
    // The output is an array of numbers from the byte array of the buffer
    public static int[] getArray(byte[] buffer, int count) {
        // Go through the buffer and collect our numbers character by character, putting each individual number into a new array element
        StringBuilder sb = new StringBuilder();
        int result;
        List<Integer> tmpList = new ArrayList<>();

        // We go through the secret part of the array, which has filled bytes, observing the conditions
        // Return the root and skip to a new line
        for (int i = 0; i < count; i++) {
            if (buffer[i] == 32 || buffer[i] == 13) {
                continue;
            }
            if (buffer[i] >= 'a' && buffer[i] <= 'z' || buffer[i] >= 'A' && buffer[i] <= 'Z') {
                sb.setLength(0);
                System.out.println("A non-numeric expression was found at the beginning of the file. Stopping the program. For string expressions, use \"-s\" in command line arguments!");
                System.out.println("The value 0 was sent to the file for output as invalid");
                return new int[]{0};
            }
            if (i == count - 1 && buffer[i] != 10) {
                sb.append(Character.getNumericValue(buffer[i]));
                result = Integer.parseInt(sb.toString());
                sb.setLength(0);
                tmpList.add(result);
            }
            if (buffer[i] != 10) {
                sb.append(Character.getNumericValue(buffer[i]));
            } else {
                String tmp = sb.toString();
                sb.setLength(0);
                try {
                    result = Integer.parseInt(tmp);
                    tmpList.add(result);
                } catch (NumberFormatException e) {
                    sb.setLength(0);
                }
            }
        }
        // Create the resulting array, which we output to the result
        int[] resultArray = new int[tmpList.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = tmpList.get(i);
        }
        return resultArray;
    }

    // Merge sort for numeric array
    public static int[] merge_sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        // (left) - array arr with values from the first element to the middle (mid),
        // that is, the left side of the main array
        int[] left = merge_sort(Arrays.copyOfRange(arr, 0, mid));
        // (right) - array arr with values from mid to final, that is, the right side
        int[] right = merge_sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge_arrays(left, right);
    }

    public static int[] merge_arrays(int[] a, int[] b) {
        // Create a resulting array into which we will merge our two arrays from the input
        int[] resultArray = new int[a.length + b.length];

        // i, j - indices for iterating over arrays a and b
        int i = 0, j = 0;
        // tmp - index for iterating over the resulting array (resultArray)
        int tmp = 0;

        // Реализация слияния представляет собой цикл, в котором resultArray[tmp] присваивается либо a[i] , либо b[j]
        // с последующим увеличением tmp и индекса использованного подмассива. Если i или j достигает конца своего подмассива,
        // то значение resultArray[tmp] присваивается из другого подмассива; в противном случае присваивается меньшее
        // из значений a[i] или b[j]. В конце концов все значения из двух подмассивов будут скопированы в resultArray[]


        // Проверяем в цикле условие, пока указатели одного из двух массивов
        // не привысят длину одного из массивов, будет выполняться условие, где идет сравнение двух элементов из
        // массива a и массива b с индексами i и j, соответсвенно,
        // и в начало результирующего массива вставляется наименьший элемент из этих массивов
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                resultArray[tmp] = a[i];
                i++;
            } else {
                resultArray[tmp] = b[j];
                j++;
            }
            tmp++;
        }
        // The case when the index i has not reached the end of the list a, therefore to the end of the resulting array resultArray
        // (that is, starting at index tmp) elements of array a are inserted starting at index i
        if (i < a.length) {
            for (; i < a.length; i++) {
                resultArray[tmp] = a[i];
                tmp++;
            }
        }
        // Same reverse case as above, only with index j and array b
        if (j < b.length) {
            for (; j < b.length; j++) {
                resultArray[tmp] = b[j];
                tmp++;
            }
        }
        // Return the sorted array
        return resultArray;
    }
}