import java.io.*;

public class ForNumbers {
    public void read1IntegerFile(String inFile, String outFile) {
        try (FileInputStream in = new FileInputStream(inFile);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)), 4096);
        ) {
            byte[] buffer = new byte[4096];
            int count = 0;
            while (in.available() > 0) {
                count = in.read(buffer);
                int[] sortedArray = MyMethods.merge_sort(MyMethods.getArray(buffer, count));
                for (int i : sortedArray) {
                    out.write(i + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, укажите корректное имя файла");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка записи");
        }
    }

    public void read2IntegerFile(String inFile1, String inFile2, String outFile) {
        try (FileInputStream in1 = new FileInputStream(inFile1);
             FileInputStream in2 = new FileInputStream(inFile2);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)), 4096);
        ) {
            byte[] bufferIn1 = new byte[1024];
            byte[] bufferIn2 = new byte[1024];
            int count1;
            int count2;
            int[] sortArray1 = null;
            int[] sortArray2 = null;
            int[] resultArray = null;
            while (true) {
                if (in1.available() > 0) {
                    count1 = in1.read(bufferIn1);
                    sortArray1 = MyMethods.merge_sort(MyMethods.getArray(bufferIn1, count1));
                }

                if (in2.available() > 0) {
                    count2 = in2.read(bufferIn2);
                    sortArray2 = MyMethods.merge_sort(MyMethods.getArray(bufferIn2, count2));
                }

                if (sortArray1 != null && sortArray2 != null) {
                    resultArray = MyMethods.merge_arrays(sortArray1, sortArray2);
                }

                if (resultArray != null) {
                    for (int i : resultArray) {
                        out.write(i + "\n");
                    }
                }

                if (in1.read() == -1 && in2.read() == -1) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Папка не найдена");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка чтения файла");
        }
    }

    public void read3IntegerFile(String inFile1, String inFile2, String inFile3, String outFile) {
        try (FileInputStream in1 = new FileInputStream(inFile1);
             FileInputStream in2 = new FileInputStream(inFile2);
             FileInputStream in3 = new FileInputStream(inFile3);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)), 4096);
        ) {
            byte[] bufferIn1 = new byte[2048];
            byte[] bufferIn2 = new byte[2048];
            byte[] bufferIn3 = new byte[2048];
            int count1;
            int count2;
            int count3;
            int[] sortArray1 = null;
            int[] sortArray2 = null;
            int[] sortArray3 = null;
            int[] tmpArray;
            int[] resultArray = null;
            while (true) {
                if (in1.available() > 0) {
                    count1 = in1.read(bufferIn1);
                    sortArray1 = MyMethods.merge_sort(MyMethods.getArray(bufferIn1, count1));
                }

                if (in2.available() > 0) {
                    count2 = in2.read(bufferIn2);
                    sortArray2 = MyMethods.merge_sort(MyMethods.getArray(bufferIn2, count2));
                }

                if (in3.available() > 0) {
                    count3 = in3.read(bufferIn3);
                    sortArray3 = MyMethods.merge_sort(MyMethods.getArray(bufferIn3, count3));
                }

                if (sortArray1 != null && sortArray2 != null && sortArray3 != null) {
                    tmpArray = MyMethods.merge_arrays(sortArray1, sortArray2);
                    resultArray = MyMethods.merge_arrays(tmpArray, sortArray3);
                }

                if (resultArray != null) {
                    for (int i : resultArray) {
                        out.write(i + "\n");
                    }
                }

                if (in1.read() == -1 && in2.read() == -1 && in3.read() == -1) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Папка не найдена");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка чтения файла");
        }
    }
}