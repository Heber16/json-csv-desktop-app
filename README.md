# JSON to CSV Converter

This project is a Java desktop application that reads data from a JSON file and converts it into a CSV file using Jackson and OpenCSV libraries.

---

## Technologies Used

- Java 17
- Maven
- Jackson (for JSON parsing)
- OpenCSV (for CSV writing)
- JUnit 5 (for unit testing)

---

## Project Structure

json-csv-app/
├── pom.xml
├── src/
│ ├── main/java/com/heber/jsoncsv/
│ │ ├── Main.java
│ │ ├── JsonReader.java
│ │ └── CsvWriter.java
│ └── test/java/com/heber/jsoncsv/
│ ├── JsonReaderTest.java
│ └── CsvWriterTest.java
└── src/main/resources/
└── datos.json

---

## How to Run

Clone the repository:

```bash
git clone https://github.com/your-username/json-csv-app.git
Open the project in IntelliJ IDEA.

Run the Main.java class.

This will read src/main/resources/datos.json and generate src/main/resources/datos.csv.

Check the generated CSV file.
