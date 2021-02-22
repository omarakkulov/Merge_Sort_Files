package ru.akkulov.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyIntMethods {
    public static int[] getArray(byte[] buffer, int count) {
        StringBuilder sb = new StringBuilder();
        int result;
        List<Integer> tmpList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            if (buffer[i] >= 'a' && buffer[i] <= 'z' || buffer[i] >= 'A' && buffer[i] <= 'Z') {
                sb.setLength(0);
                continue;
            }
            if (i == count - 1 && buffer[i] != 10) {
                sb.append(Character.getNumericValue(buffer[i]));
                result = Integer.parseInt(sb.toString());
                sb.setLength(0);
                tmpList.add(result);
            }
            if (buffer[i] != 10 && buffer[i] != 13) {
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

        int[] resultArray = new int[tmpList.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = tmpList.get(i);
        }
        return resultArray;
    }

    public static int[] merge_sort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        // (left) - массив arr со значениями от первого элемента, до середины (mid),
        // то есть левая часть основного массива
        int[] left = merge_sort(Arrays.copyOfRange(arr, 0, mid));
        // (right) - массив arr со значениями от mid, до конечного, то есть правая часть
        int[] right = merge_sort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge_arrays(left, right);
    }

    public static int[] merge_arrays(int[] a, int[] b) {
        // Создадим результирующий массив, в который будем сливать два наших массива со входа
        int[] resultArray = new int[a.length + b.length];

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
            if (a[i] < b[j]) {
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

    //    public static void sendCorrectly(String fileName, byte[] buffer, int count, int tmp, Writer outputStream) {
//        StringBuilder sb = new StringBuilder();
//        try {
//            for (int i = 0; i < count; i++) {
//                if (buffer[i] != 10) {
//                    sb.append(Character.getNumericValue(buffer[i]));
//                } else {
//                    int result = Integer.parseInt(sb.toString());
//                    if (tmp <= result) {
//                        tmp = result;
//                        sb.setLength(0);
//                        outputStream.write(result + "\n");
//                    } else {
//                        System.out.println("Число " + result + " нарушает порядок сортировки в файле " + fileName + ", удаляем его");
//                        sb.setLength(0);
//                        continue;
//                    }
//                }
//                if (i == count - 1) {
//                    int result = Integer.parseInt(sb.toString());
//                    if (tmp <= result) {
//                        tmp = result;
//                        sb.setLength(0);
//                        outputStream.write(result + "\n");
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Ошибка записи");
//            e.printStackTrace();
//        }
//    }

//    public static List<Integer> merge_sort_list(int[] arr) {
//        int[] tmp = new int[arr.length()];
//        for (int i = 0; i < tmp.length; i++) {
//            tmp[i] = arr.get(i);
//        }
//
//        if (tmp.length == 1) {
//            List<Integer> list = new ArrayList<>();
//            list.add(tmp[0]);
//            return list;
//        }
//        int mid = tmp.length / 2;
//        // (left) - массив arr со значениями от первого элемента, до середины (mid),
//        // то есть левая часть основного массива
//        int[] left = merge_sort_list(Arrays.copyOfRange(tmp, 0, mid));
//        // (right) - массив arr со значениями от mid, до конечного, то есть правая часть
//        int[] right = merge_sort_list(Arrays.copyOfRange(tmp, mid, tmp.length));
//        // В итоге сливаем два полученных массива
//        return merge_arrays(left, right);
//
//
//        return merge_lists(left, right);
//    }

//    public static List<Integer> merge_lists(List<Integer> a, List<Integer> b) {
//        // Создадим результирующий массив, в который будем сливать два наших массива со входа
//        Integer[] resultArray = new Integer[a.size() + b.size()];
//
//        // i, j  - индексы для перебора массивов a и b
//        int i = 0, j = 0;
//        // tmp - индекс для перебора результирующего массива (resultArray)
//        int tmp = 0;
//
//        // Реализация слияния представляет собой цикл, в котором resultArray[tmp] присваивается либо a[i] , либо b[j]
//        // с последующим увеличением tmp и индекса использованного подмассива. Если i или j достигает конца своего подмассива,
//        // то значение resultArray[tmp] присваивается из другого подмассива; в противном случае присваивается меньшее
//        // из значений a[i] или b[j]. В конце концов все значения из двух подмассивов будут скопированы в resultArray[]
//
//
//        // Проверяем в цикле условие, пока указатели одного из двух массивов
//        // не привысят длину одного из массивов, будет выполняться условие, где идет сравнение двух элементов из
//        // массива a и массива b с индексами i и j, соответсвенно,
//        // и в начало результирующего массива вставляется наименьший элемент из этих списков
//        while (i < a.size() && j < b.size()) {
//            if (a.get(i) < b.get(j)) {
//                resultArray[tmp] = a.get(i);
//                i++;
//            } else {
//                resultArray[tmp] = b.get(j);
//                j++;
//            }
//            tmp++;
//        }
//        // Случай, когда индекс i не дошел до конца списка a, значит в конец результирующего массива
//        // (то есть начиная с индекса tmp) вставляются элементы массива a, начиная с индекса i
//        if (i < a.size()) {
//            for (; i < a.size(); i++) {
//                resultArray[tmp] = a.get(i);
//                tmp++;
//            }
//        }
//        // Такой же обратный случай, как выше, только с индексом j и массивом b
//        if (j < b.size()) {
//            for (; j < b.size(); j++) {
//                resultArray[tmp] = b.get(j);
//                tmp++;
//            }
//        }
//        // Возвращаем отсортированный массив
//        ArrayList<Integer> result = new ArrayList<>();
//        Collections.addAll(result, resultArray);
//        return result;
//    }
}