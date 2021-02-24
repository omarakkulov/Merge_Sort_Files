package ru.akkulov.command_window;

import ru.akkulov.integers.ForIntegers;
import ru.akkulov.strings.ForStrings;

import java.util.ArrayList;
import java.util.List;

public class CommandWindowHelper {
    public static boolean isInteger;
    public static String outFile;
    public static List<String> inFiles;
    public static int inFilesCount;
    public static String sortOrder = "-a";

    public static void init(String[] args) {
        inFiles = new ArrayList<>();
        int tmp = 0;
        // Прогоняемся в цикле по массиву, дойдя до выходного файла, будет останавливать цикл, зная с какого элемента
        // начинаются входные файлы с помощью переменной tmp
        for (String arg : args) {
            if (arg.contains(".txt")) {
                outFile = arg;
                tmp++;
                break;
            }
            // Сравниваем поданные строки с нужными для нас, далее увеличиваем tmp++
            switch (arg) {
                case "-a":
                    sortOrder = "-a";
                    tmp++;
                    break;
                case "-d":
                    sortOrder = "d";
                    tmp++;
                    break;
                case "-i":
                    isInteger = true;
                    tmp++;
                    break;
                case "-s":
                    isInteger = false;
                    tmp++;
                    break;
            }
        }
        // Случай, когда по массиву пробежались, но не нашли там выходной файл
        if (tmp == args.length) {
            System.out.println("Нет входных файлов, добавьте!");
            return;
        }
        // Пробегаемся по входным файлам и добавляем их в лист для последующего добавления их в методы нужных классов
        for (int i = tmp; i < args.length; i++) {
            if (args[i].contains(".txt")) {
                inFiles.add(args[i]);
                inFilesCount++;
            }
        }
    }

    public static void readFiles() {
        if (CommandWindowHelper.isInteger) {
            ForIntegers integers = new ForIntegers();
            if (CommandWindowHelper.inFilesCount == 1) {
                integers.read1IntegerFile(CommandWindowHelper.inFiles.get(0),
                        CommandWindowHelper.outFile);
            } else if (CommandWindowHelper.inFilesCount == 2) {
                integers.read2IntegerFile(CommandWindowHelper.inFiles.get(0),
                        CommandWindowHelper.inFiles.get(1),
                        CommandWindowHelper.outFile);
            } else if (CommandWindowHelper.inFilesCount == 3) {
                integers.read3IntegerFile(CommandWindowHelper.inFiles.get(0),
                        CommandWindowHelper.inFiles.get(1),
                        CommandWindowHelper.inFiles.get(2),
                        CommandWindowHelper.outFile);
            }
        } else {
            ForStrings strings = new ForStrings();
            if (CommandWindowHelper.inFilesCount == 1) {
                strings.read1StringFile(CommandWindowHelper.inFiles.get(0),
                        CommandWindowHelper.outFile,
                        CommandWindowHelper.sortOrder);
            } else if (CommandWindowHelper.inFilesCount == 2) {
                strings.read2StringFile(CommandWindowHelper.inFiles.get(0),
                        CommandWindowHelper.inFiles.get(1),
                        CommandWindowHelper.outFile,
                        CommandWindowHelper.sortOrder);
            } else if (CommandWindowHelper.inFilesCount == 3) {
                strings.read3StringFile(CommandWindowHelper.inFiles.get(0),
                        CommandWindowHelper.inFiles.get(1),
                        CommandWindowHelper.inFiles.get(2),
                        CommandWindowHelper.outFile,
                        CommandWindowHelper.sortOrder);
            }
        }
    }
}
