set path="C:\Program Files\Java\jdk-13.0.1\bin";
cd D:\Knowledge\IntelliJ_IDEA_Projects\Merge_Sort\src

javac ru/akkulov/command_window/CommandWindowHelper.java
javac ru/akkulov/general/MyIntMethods.java
javac ru/akkulov/general/MyStrMethods.java
javac ru/akkulov/integers/ForIntegers.java
javac ru/akkulov/strings/ForStrings.java
javac ru/akkulov/Main.java

:start
set /p params=Arguments: 

java ru.akkulov.Main %params%

goto start

pause