#!/bin/bash
echo "Compiling Daily Logger project!"
javac -cp "." --module-path "/Users/runar/programming/library/javafx-sdk-11.0.1/lib/" --add-modules=javafx.controls,javafx.fxml -sourcepath "src/main/java" -d "target/classes" src/main/java/main.java
