package ru.akkulov.integers;

import ru.akkulov.general.MyIntMethods;

import java.io.*;

public class ForIntegers {
    // To read one numeric file
    public void read1IntegerFile(String inFile, String outFile) {
        try (FileInputStream in = new FileInputStream("..\\files\\" + inFile);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("..\\files\\" + outFile)), 4096);
        ) {
            // Create a buffer with bytes, into which we will write bytes from the file
            byte[] buffer = new byte[4096];
            // The number of bytes that will be read by the read method from in
            int count;
            while (in.available() > 0) {
                count = in.read(buffer);
                // Creates an array of numbers from the buffer, sorted by the merge method
                int[] sortedArray = MyIntMethods.merge_sort(MyIntMethods.getArray(buffer, count));
                // Write each element of this array to the output stream
                for (int i : sortedArray) {
                    out.write(i + "\n");
                }
            }
            System.out.println("Successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File \"" + inFile + "\" not found, enter a valid file name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for reading two numeric files
    public void read2IntegerFile(String inFile1, String inFile2, String outFile) {
        try (FileInputStream in1 = new FileInputStream("..\\files\\" + inFile1);
             FileInputStream in2 = new FileInputStream("..\\files\\" + inFile2);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("..\\files\\" + outFile)), 4096);
        ) {
            byte[] bufferIn1 = new byte[1024];
            byte[] bufferIn2 = new byte[1024];
            int count1;
            int count2;
            int[] sortArray1 = null;
            int[] sortArray2 = null;
            int[] resultArray = null;
            // Creates two sorted arrays from two files, then they are sorted among themselves, as a result
            // create a new sorted array from the two previous arrays
            while (true) {
                if (in1.available() > 0) {
                    count1 = in1.read(bufferIn1);
                    sortArray1 = MyIntMethods.merge_sort(MyIntMethods.getArray(bufferIn1, count1));
                }

                if (in2.available() > 0) {
                    count2 = in2.read(bufferIn2);
                    sortArray2 = MyIntMethods.merge_sort(MyIntMethods.getArray(bufferIn2, count2));
                }

                if (sortArray1 != null && sortArray2 != null) {
                    resultArray = MyIntMethods.merge_arrays(sortArray1, sortArray2);
                }

                // We put each number into the exit stream
                if (resultArray != null) {
                    for (int i : resultArray) {
                        out.write(i + "\n");
                    }
                }

                if (in1.read() == -1 && in2.read() == -1) {
                    break;
                }
            }
            System.out.println("Successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("One of the files was not found, please enter a valid filename");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // To read 3 numeric files
    public void read3IntegerFile(String inFile1, String inFile2, String inFile3, String outFile) {
        try (FileInputStream in1 = new FileInputStream("..\\files\\" + inFile1);
             FileInputStream in2 = new FileInputStream("..\\files\\" + inFile2);
             FileInputStream in3 = new FileInputStream("..\\files\\" + inFile3);
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("..\\files\\" + outFile)), 4096);
        ) {
            // Three buffers are also created, then three sorted arrays, and at the end one large sorted, numbers
            // which we put into the output stream
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
                    sortArray1 = MyIntMethods.merge_sort(MyIntMethods.getArray(bufferIn1, count1));
                }

                if (in2.available() > 0) {
                    count2 = in2.read(bufferIn2);
                    sortArray2 = MyIntMethods.merge_sort(MyIntMethods.getArray(bufferIn2, count2));
                }

                if (in3.available() > 0) {
                    count3 = in3.read(bufferIn3);
                    sortArray3 = MyIntMethods.merge_sort(MyIntMethods.getArray(bufferIn3, count3));
                }

                if (sortArray1 != null && sortArray2 != null && sortArray3 != null) {
                    tmpArray = MyIntMethods.merge_arrays(sortArray1, sortArray2);
                    resultArray = MyIntMethods.merge_arrays(tmpArray, sortArray3);
                }

                if (resultArray != null) {
                    for (int i : resultArray) {
                        out.write(i + "\n");
                    }
                }

                if (in1.read() == -1 && in2.read() == -1 && in3.read() == -1) {
                    System.out.println("Successfully!");
                    break;
                }
            }
            System.out.println("Successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("One of the files was not found, please enter a valid filename");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File read error");
        }
    }
}
