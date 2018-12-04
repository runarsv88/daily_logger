#!/bin/bash
./make.sh
echo "Running Daily Logger!"
java -cp target/classes:lib/jaco-mp3-player-0.9.3.jar main 
