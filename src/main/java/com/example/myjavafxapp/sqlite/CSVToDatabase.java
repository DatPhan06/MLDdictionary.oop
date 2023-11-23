package com.example.myjavafxapp.sqlite;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CSVToDatabase {

    private static final Connection connection = SQLiteConnector.connect();

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String csvFile = "src/main/resources/csv/E-Edictionary.csv"; // Đường dẫn tới file CSV

        System.out.println("123");
        insertDataFromCSV(connection, csvFile); // Đọc dữ liệu từ CSV và lưu vào cơ sở dữ liệu

    }


    static void insertDataFromCSV(Connection connection, String csvFile) throws SQLException, FileNotFoundException {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            String insertSQL = "INSERT INTO English (Word, Type, Meaning, Pronunciation, Example, Synonym, Antonyms) VALUES (?, ?, ?, ?, ?, ?, ?);";
            try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
                while ((nextLine = reader.readNext()) != null) {
                    // Bỏ qua dòng tiêu đề
                    reader.readNext();

                    while ((nextLine = reader.readNext()) != null) {
                        // Thiết lập giá trị cho các tham số của câu lệnh INSERT
                        statement.setString(1, nextLine[0]); // Word
                        statement.setString(2, nextLine[1]); // Type
                        statement.setString(3, nextLine[2]); // Meaning
                        statement.setString(4, nextLine[3]); // Pronunciation
                        statement.setString(5, nextLine[4]); // Example
                        statement.setString(6, ""); // Example
                        statement.setString(7, ""); // Example


                        statement.executeUpdate(); // Thực hiện câu lệnh INSERT
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
