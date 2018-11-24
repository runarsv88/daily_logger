#!/bin/bash
./make.sh
echo "Running Daily Logger!"
java -cp target/classes main
