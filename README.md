## Overview
Kata project for SOLENT.
This is a basic project about moving some mower on a lawn in order to mow it.
There could be a lot of improvements such as handling exception or development methodology (creating a dev branch to develop first).
Furthermore, it's look like there is an error in the expected result of the sample. 
You were expecting 1 3 N `5 1` E, but it's look like the actual result is 1 3 N `1 5` E.
Thanks. This project was funny!

## Project details
Can be found in [KATA TONDEUSE](kata-tondeuse-java-v2.pdf)

## Building
`mvn clean package`

## Run project
if the `filename.txt` file is at the root of this project, you can use this command
`mvn exec:java -Dexec.mainClass="com.github.romankh3.maventemplaterepository.MavenTemplateRepository" -Dexec.args="filename.txt"`

## Author
* Florian AINADOU - [flopiroman](https://github.com/flopiroman)

