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
    // Default value for sorting is ascending
    public static String sortOrder = "-a";

    public static void init(String[] args) {
        inFiles = new ArrayList<>();
        int tmp = 0;
        // We loop through the array, reaching the output file, it will stop the loop, knowing from which element
        // start input files with tmp variable
        if (args.length == 0 || args.length == 1 || args.length == 2) {
            System.out.println("Invalid input data");
        }
        for (String arg : args) {
            if (arg.contains(".txt")) {
                outFile = arg;
                tmp++;
                break;
            }
            // Compare the given lines with the ones we need, then increase tmp++
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
        // The case when we ran through the array, but did not find the output file there
        if (tmp == args.length) {
            System.out.println("No input files, please add!");
            return;
        }
        if (!args[tmp - 1].contains(".txt")) {
            System.out.println("File \"" + args[tmp - 1] + "\" is not exist");
            return;
        }
        // We go through the input files and add them to the sheet for later adding them to the methods of the required classes
        for (int i = tmp; i < args.length; i++) {
            if (args[i].contains(".txt")) {
                inFiles.add(args[i]);
                inFilesCount++;
            } else {
                System.out.println("File \"" + args[i] + "\" is not exist");
            }
        }
    }

    // Method for reading files :)
    public static void readFiles() {
        // This checks if the file is a number
        if (CommandWindowHelper.isInteger) {
            // Next, a class object is created that works with numeric expressions
            ForIntegers integers = new ForIntegers();
            // Then three conditions are met. Based on the length of the file, we enter the elements we need from the command line into the input data of the corresponding methods
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
            // Otherwise, if it is a string file, perform similar actions as shown above
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
