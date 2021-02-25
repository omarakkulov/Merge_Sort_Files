package ru.akkulov.strings;

import ru.akkulov.general.MyStrMethods;

import java.io.*;

public class ForStrings {
    // Для чтения одного строкового файла
    public void read1StringFile(String inFile, String outFile, String sortOrder) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(inFile));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)), 4096);
        ) {
            // Создаем буфер с символами, в который будем записывать символы из файла
            char[] buffer = new char[4096];
            // Количество байт, которое будет прочтено методом read из in
            int count;
            while ((count = in.read(buffer)) >= 0) {
                // Создается массив строк из буфера, отсортированный методом слияния
                String[] sortedArray = MyStrMethods.merge_sort(MyStrMethods.getArray(buffer, count), sortOrder);
                // Заносим каждый элемент этого массива в выходной поток
                for (String i : sortedArray) {
                    out.write(i + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Folder not found, enter correct name!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения двух строковых файлов
    public void read2StringFile(String inFile1, String inFile2, String outFile, String sortOrder) {
        try (InputStreamReader in1 = new InputStreamReader(new FileInputStream(inFile1));
             InputStreamReader in2 = new InputStreamReader(new FileInputStream(inFile2));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)), 4096);
        ) {
            char[] bufferIn1 = new char[1024];
            char[] bufferIn2 = new char[1024];
            int count1;
            int count2;
            String[] sortArray1 = null;
            String[] sortArray2 = null;
            String[] resultArray = null;
            // Создается два отсортированных массива из двух файлов, далее они сортируются между собой, в итоге
            // создается новый отсортированый массив из двух прошлых массивов
            while (true) {
                if ((count1 = in1.read(bufferIn1)) > 0) {
                    sortArray1 = MyStrMethods.merge_sort(MyStrMethods.getArray(bufferIn1, count1), sortOrder);
                }

                if ((count2 = in2.read(bufferIn2)) > 0) {
                    sortArray2 = MyStrMethods.merge_sort(MyStrMethods.getArray(bufferIn2, count2), sortOrder);
                }

                if (sortArray1 != null && sortArray2 != null) {
                    resultArray = MyStrMethods.merge_arrays(sortArray1, sortArray2, sortOrder);
                }

                // Каждую строку заносим в поток выхода
                if (resultArray != null) {
                    for (String i : resultArray) {
                        out.write(i + "\n");
                    }
                }

                if (in1.read() == -1 && in2.read() == -1) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Folder not found, enter correct name!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Для чтения 3-х строковых файлов
    public void read3StringFile(String inFile1, String inFile2, String inFile3, String outFile, String sortOrder) {
        try (InputStreamReader in1 = new InputStreamReader(new FileInputStream(inFile1));
             InputStreamReader in2 = new InputStreamReader(new FileInputStream(inFile2));
             InputStreamReader in3 = new InputStreamReader(new FileInputStream(inFile3));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)), 4096);
        ) {
            // Так же создается три буфера, далее три отсортированных массива, а в конце один большой отсортированный, строки
            // которого заносим в выходной поток
            char[] bufferIn1 = new char[1024];
            char[] bufferIn2 = new char[1024];
            char[] bufferIn3 = new char[1024];
            int count1;
            int count2;
            int count3;
            String[] sortArray1 = null;
            String[] sortArray2 = null;
            String[] sortArray3 = null;
            String[] tmpArray;
            String[] resultArray = null;
            while (true) {
                if ((count1 = in1.read(bufferIn1)) > 0) {
                    sortArray1 = MyStrMethods.merge_sort(MyStrMethods.getArray(bufferIn1, count1), sortOrder);
                }

                if ((count2 = in2.read(bufferIn2)) > 0) {
                    sortArray2 = MyStrMethods.merge_sort(MyStrMethods.getArray(bufferIn2, count2), sortOrder);
                }

                if ((count3 = in3.read(bufferIn3)) > 0) {
                    sortArray3 = MyStrMethods.merge_sort(MyStrMethods.getArray(bufferIn3, count3), sortOrder);
                }

                if (sortArray1 != null && sortArray2 != null && sortArray3 != null) {
                    tmpArray = MyStrMethods.merge_arrays(sortArray1, sortArray2, sortOrder);
                    resultArray = MyStrMethods.merge_arrays(tmpArray, sortArray3, sortOrder);
                }

                if (resultArray != null) {
                    for (String i : resultArray) {
                        out.write(i + "\n");
                    }
                }

                if (in1.read() == -1 && in2.read() == -1 && in3.read() == -1) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Folder not found, enter correct name!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
