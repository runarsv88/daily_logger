#!/bin/bash
echo "Compiling Daily Logger project!"
javac -cp ".:lib/jaco-mp3-player-0.9.3.jar" -sourcepath src/main/java -d target/classes src/main/java/main.java
