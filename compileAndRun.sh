#!/bin/bash
./make.sh
echo "Running Daily Logger!"
java -cp target/classes --module-path "/Users/runar/programming/library/javafx-sdk-11.0.1/lib/" --add-modules=javafx.controls,javafx.fxml main 
