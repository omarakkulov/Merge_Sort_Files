import java.io.*;

public class ForStrings {
//    public void read1IntegerFile(String inFile, String outFile) throws IOException {
//        try (FileInputStream inputStream = new FileInputStream(inFile);
//             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream), 4096);
//
//             FileOutputStream outputStream = new FileOutputStream(outFile);
//             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream), 4096);
//        ) {
//
//            String line;
//            int tmp;
//            int res = Integer.MIN_VALUE;
//
//            while ((line = reader.readLine()) != null) {
//                if (isInteger(line)) {
//                    tmp = Integer.parseInt(line);
//                } else {
//                    System.out.println("Файл " + inFile + ": " + "Обнаружена строка " + "\"" + line + "\"" + " среди чисел, остановка программы. Запустите программу через -s");
//                    break;
//                }
//                if (res <= tmp) {
//                    res = tmp;
//                    writer.write(res + "\n");
//                } else
//                    System.out.println("Файл " + inFile + ": Следующее число " + tmp + " меньше предыдущего " + res + ", поэтому его не учитываем");
//            }
//        }
//    }


    //    public void read2IntegerFile(String inFile1, String inFile2, String outFile) {
//        try (BufferedReader inFile1Reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile1)));
//             BufferedReader inFile2Reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile2)));
//             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
//        ) {
//            fixIntegerFile(inFile1);
//            int inFile1Size = this.countLinesInFile;
//            int tmpForAllFile1 = 0;
//            int tmp1ForList1 = 0;
//            ArrayList<Integer> list1 = new ArrayList<>();
//            this.countLinesInFile = 0;
//
//            fixIntegerFile(inFile2);
//            int inFile2Size = this.countLinesInFile;
//            int tmpForAllFile2 = 0;
//            int tmp2ForList2 = 0;
//            ArrayList<Integer> list2 = new ArrayList<>();
//
//            String line1;
//            String line2;
//
//            while (inFile1Reader.readLine() != null && inFile2Reader.readLine() != null) {
//
//            }
//
//            while (tmp1ForList1 != 100 || tmp1ForList1 != inFile1Size) {
//                line1 = inFile1Reader.readLine();
//                if (line1 == null) {
//                    break;
//                }
//                if (isInteger(line1)) {
//                    list1.add(Integer.parseInt(line1));
//                    tmp1ForList1++;
//                }
//            }
//
//
//            while (tmp2ForList2 != 100 || tmp2ForList2 != inFile2Size) {
//                line2 = inFile2Reader.readLine();
//                if (line2 == null) {
//                    break;
//                }
//                if (isInteger(line2)) {
//                    list2.add(Integer.parseInt(line2));
//                    tmp2ForList2++;
//                }
//
//            }
//
//            List<Integer> res = MyMethods.merge_lists(list1, list2);
//            for (Integer r : res) {
//                writer.write(r + "\n");
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Папка не найдена");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Ошибка чтения файла");
//        }
//    }

//    public void fixIntegerFile(String fileName, BufferedReader in, BufferedWriter out) {
//        try {
//            String line;
//            int tmp = Integer.MIN_VALUE;
//            while ((line = in.readLine()) != null) {
//                int result = Integer.parseInt(line);
//                if (tmp <= result) {
//                    out.write(result + "\n");
//                    countLinesInFile++;
//                    tmp = result;
//                } else {
//                    System.out.println("Число " + result + " нарушает порядок сортировки в файле " + fileName + ", удаляем его");
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Папка не найдена");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Ошибка чтения файла");
//        }
//    }

//    private void readFileLoop(BufferedReader r, BufferedWriter w) {
//        String line;
//        while (true) {
//            try {
//                if ((line = r.readLine()) != null) {
//                    w.write(line + "\n");
//                } else break;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public boolean isInteger(String s) {
//        try {
//            int res = Integer.parseInt(s);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }

//    public int getCountLinesInFile() {
//        return countLinesInFile;
//    }

    //    public void read3IntegerFiles(String inFile1, String inFile2, String inFile3, String outFile) {
//        try {
//            inputFiles.add(new BufferedReader(new InputStreamReader(new FileInputStream(inFile1))));
//            inputFiles.add(new BufferedReader(new InputStreamReader(new FileInputStream(inFile2))));
//            inputFiles.add(new BufferedReader(new InputStreamReader(new FileInputStream(inFile3))));
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
//
//            int[] tmpNumbers = new int[inputFiles.size()];
//            String line;
//            for (int i = 0; i < inputFiles.size(); i++) {
//                do {
//                    line = inputFiles.get(i).readLine();
//
//                } while ((line = inputFiles.get(i).readLine()) != null) {
//                    tmpLines[i] = line;
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Одно из введенных названий файла некорректно, перепроверьте");
//        } catch (IOException e) {
//            System.out.println("Ошибка чтения файла");
//        } finally {
//            for (BufferedReader r : inputFiles) {
//                cleanUp(r);
//            }
//        }
//    }

    //    public void cleanUp(Reader r) {
//        try {
//            r.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void cleanUp(Writer r) {
//        try {
//            r.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
