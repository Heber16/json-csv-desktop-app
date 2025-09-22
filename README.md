# JSON to CSV Converter - Sprint 3

## Description
This Java program converts JSON files into CSV files.  
It includes reading JSON, transforming the data into a CSV-compatible format, and writing the output file.

The program allows configuring file names and the CSV delimiter through command-line arguments.

---

## Requirements
- Java 8 or higher
- OpenCSV (dependency included in the project)

---

## Usage

### Compilation
If the project is not compiled yet, you can use IntelliJ or Maven as needed.

### Execution
From the console or IntelliJ, run:

```bash
java -jar proyecto.jar <input.json> <output.csv> <delimiter>

<input.json> → path of the JSON file to read

<output.csv> → path of the CSV file to create

<delimiter> → character used to separate columns (e.g., , or ;)

Example:

java -jar proyecto.jar src/main/resources/datos.json src/main/resources/data.csv ";"

Expected output
Reading JSON from: src/main/resources/datos.json
Transforming data...
Writing CSV to: src/main/resources/data.csv with delimiter ';'
Process completed successfully!

Project structure
src/main/java/com/heber/jsoncsv/
    ├── Main.java
    ├── JsonReader.java
    ├── CsvWriter.java
    └── DataTransformer.java

Implemented functionalities

Reading JSON files

Transforming JSON data into CSV

Writing CSV files with configurable delimiter

Configurable parameters from the command line

Error handling and progress messages

Complete JavaDoc documentation