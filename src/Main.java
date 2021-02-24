import ru.akkulov.command_window.CommandWindowHelper;
import ru.akkulov.integers.ForIntegers;
import ru.akkulov.strings.ForStrings;

public class Main {
    public static void main(String[] args) {
//        1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;
//        2. тип данных (-s или -i), обязательный;
//        3. имя выходного файла, обязательное;
//        4. остальные параметры – имена входных файлов, не менее одного.
//        Примеры запуска из командной строки для Windows:
//        sort-it.exe -i -a out.txt in.txt (для целых чисел по возрастанию)
//        sort-it.exe -s out.txt in1.txt in2.txt in3.txt (для строк по возрастанию)
//        sort-it.exe -d -s out.txt in1.txt in2.txt (для строк по убыванию)


//        long startTime = System.nanoTime();
//        ForIntegers numbers = new ForIntegers();
//        numbers.read1IntegerFile("in1.txt", "out.txt");
//        numbers.read2IntegerFile("in2.txt", "in3.txt", "out.txt");
//        numbers.read3IntegerFile("in1.txt", "in2.txt", "in3.txt", "out.txt");

//        ForStrings strings = new ForStrings();
//        strings.read1StringFile("in1.txt", "out.txt");
//        strings.read2StringFile("in1.txt", "in2.txt", "out.txt");
//        strings.read3StringFile("in1.txt", "in2.txt", "in3.txt", "out.txt");
//        System.out.println((System.nanoTime() - startTime));

        CommandWindowHelper.init(args);
        CommandWindowHelper.readFiles();
    }
}

