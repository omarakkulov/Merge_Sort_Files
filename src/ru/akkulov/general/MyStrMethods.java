package ru.akkulov.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStrMethods {
    public static String[] getArray(char[] buffer, int count) {
        // Пробегаемся по буферу и собираем наши строка посимвольно, занося каждую отдельную строку в новый элемент массива
        StringBuilder sb = new StringBuilder();
        String result;
        List<String> tmpList = new ArrayList<>();

        // Пробегаемся по тай части массива, в которой есть заполненные байты, соблюдая условия
        for (int i = 0; i < count; i++) {
            if (buffer[i] == 32) {
                continue;
            }
            if (i == count - 1 && buffer[i] != 10) {
                sb.append(buffer[i]);
                result = sb.toString();
                tmpList.add(result);
                sb.setLength(0);
            }
            if (buffer[i] != 10 && buffer[i] != 13) {
                sb.append(buffer[i]);
            } else if (buffer[i] == 13) {
                sb.append(0);
            } else {
                result = sb.toString();
                sb.setLength(0);
                tmpList.add(result);
            }
        }
        String[] resultArray = new String[tmpList.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = tmpList.get(i);
        }
        return resultArray;
    }

    public static String[] merge_sort(String[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        // (left) - массив arr со значениями от первого элемента, до середины (mid),
        // то есть левая часть основного массива
        String[] left = merge_sort(Arrays.copyOfRange(arr, 0, mid));
        // (right) - массив arr со значениями от mid, до конечного, то есть правая часть
        String[] right = merge_sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge_arrays(left, right);
    }

    public static String[] merge_arrays(String[] a, String[] b) {
        // Создадим результирующий массив, в который будем сливать два наших массива со входа
        String[] resultArray = new String[a.length + b.length];

        // i, j  - индексы для перебора массивов a и b
        int i = 0, j = 0;
        // tmp - индекс для перебора результирующего массива (resultArray)
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
            if (a[i].compareTo(b[j]) < 0) {
                resultArray[tmp] = a[i];
                i++;
            } else {
                resultArray[tmp] = b[j];
                j++;
            }
            tmp++;
        }
        // Случай, когда индекс i не дошел до конца списка a, поэтому в конец результирующего массива resultArray
        // (то есть начиная с индекса tmp) вставляются элементы массива a, начиная с индекса i
        if (i < a.length) {
            for (; i < a.length; i++) {
                resultArray[tmp] = a[i];
                tmp++;
            }
        }
        // Такой же обратный случай, как выше, только с индексом j и массивом b
        if (j < b.length) {
            for (; j < b.length; j++) {
                resultArray[tmp] = b[j];
                tmp++;
            }
        }
        // Возвращаем отсортированный массив
        return resultArray;
    }
}
