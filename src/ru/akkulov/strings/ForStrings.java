package ru.akkulov.strings;

import ru.akkulov.general.MyStrMethods;

import java.io.*;

public class ForStrings {
    // To read one line file
    public void read1StringFile(String inFile, String outFile, String sortOrder) {
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("..\\files\\" + inFile));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("..\\files\\" + outFile)), 4096);
        ) {
            // Create a buffer with characters, into which we will write characters from the file
            char[] buffer = new char[4096];
            // The number of bytes that will be read by the read method from in
            int count;
            while ((count = in.read(buffer)) >= 0) {
                // Creates an array of strings from the buffer, sorted by the merge method
                String[] sortedArray = MyStrMethods.merge_sort(MyStrMethods.getArray(buffer, count), sortOrder);
                // Write each element of this array to the output stream
                for (String i : sortedArray) {
                    out.write(i + "\n");
                }
            }
            System.out.println("Successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File " + inFile + " not found, enter a valid file name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method for reading two string files
    public void read2StringFile(String inFile1, String inFile2, String outFile, String sortOrder) {
        try (InputStreamReader in1 = new InputStreamReader(new FileInputStream("..\\files\\" + inFile1));
             InputStreamReader in2 = new InputStreamReader(new FileInputStream("..\\files\\" + inFile2));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("..\\files\\" + outFile)), 4096);
        ) {
            char[] bufferIn1 = new char[1024];
            char[] bufferIn2 = new char[1024];
            int count1;
            int count2;
            String[] sortArray1 = null;
            String[] sortArray2 = null;
            String[] resultArray = null;
            // Creates two sorted arrays from two files, then they are sorted among themselves, as a result
            // create a new sorted array from the two previous arrays
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

                // Write each line to the exit stream
                if (resultArray != null) {
                    for (String i : resultArray) {
                        out.write(i + "\n");
                    }
                }

                if (in1.read() == -1 && in2.read() == -1) {
                    break;
                }
            }
            System.out.println("Successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Folder not found, enter correct name!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // To read 3 line files
    public void read3StringFile(String inFile1, String inFile2, String inFile3, String outFile, String sortOrder) {
        try (InputStreamReader in1 = new InputStreamReader(new FileInputStream("..\\files\\" + inFile1));
             InputStreamReader in2 = new InputStreamReader(new FileInputStream("..\\files\\" + inFile2));
             InputStreamReader in3 = new InputStreamReader(new FileInputStream("..\\files\\" + inFile3));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("..\\files\\" + outFile)), 4096);
        ) {
            // Three buffers are also created, then three sorted arrays, and at the end one large sorted, strings
            // which we put into the output stream
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
            System.out.println("Successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Folder not found, enter correct name!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
