Prerequisites: JDK > 7.0 installed.

This software is packaged with a build file. You may use gradlew (linux) or gradlew.bat (windows).

To build: gradlew clean

This runs builds the code and runs the unit tests.

To run: gradlew run

This uses gradle.properties to run the com.darkstar.ngram.Main.main() method with parameters.

You may modify gradle.properties to change the input. The first argument is a file on your file system.
The second argument is a number representing the maximum ngram to be found.

You may also run this by running the com.darkstar.ngram.Main.main() method.