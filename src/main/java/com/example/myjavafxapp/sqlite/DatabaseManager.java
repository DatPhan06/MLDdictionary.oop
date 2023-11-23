package com.example.myjavafxapp.sqlite;

import java.sql.*;

public class DatabaseManager {

    private static final Connection connection = SQLiteConnector.connect();



    public DatabaseManager() throws SQLException {
    }


    public static void createTable() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS English (Id INTEGER PRIMARY KEY, Word varchar(255), Type varchar(255), Meaning varchar(255), Pronunciation varchar(255), Example varchar(255), Synonym varchar(255), Antonyms varchar(255));";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertData(String word, String type, String meaning, String pronunciation, String example, String synonym, String antonyms) {
        try {
            String sql = "INSERT INTO English (Word, Type, Meaning, Pronunciation, Example, Synonym, Antonyms) VALUES (?, ?, ?, ?, ?, ?, ?);";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, word);
                statement.setString(2, type);
                statement.setString(3, meaning);
                statement.setString(4, pronunciation);
                statement.setString(5, example);
                statement.setString(6, synonym);
                statement.setString(7, antonyms);

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static String searchWord(String wordSearch) {
        try {
            StringBuilder resultBuilder = new StringBuilder();
            String sql = "SELECT * FROM English WHERE Word = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, wordSearch); // Sử dụng tham số để tránh SQL injection

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {

                        String word = resultSet.getString("Word");
                        String type = resultSet.getString("Type");
                        String meaning = resultSet.getString("Meaning");
                        String pronunciation = resultSet.getString("Pronunciation");
                        String example = resultSet.getString("Example");
                        String synonym = resultSet.getString("Synonym");
                        String antonyms = resultSet.getString("Antonyms");

                        // Xây dựng nội dung cho StringBuilder
                        resultBuilder.append("Word: ").append(word).append("\n");
                        resultBuilder.append("Type: ").append(type).append("\n");
                        resultBuilder.append("Meaning: ").append(meaning).append("\n");
                        resultBuilder.append("Pronunciation: ").append(pronunciation).append("\n");
                        resultBuilder.append("Example: ").append(example).append("\n");
                        resultBuilder.append("Synonym: ").append(synonym).append("\n");
                        resultBuilder.append("Antonyms: ").append(antonyms).append("\n");
                        return resultBuilder.toString();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
//            sql = sql + wordSearch;
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                try (ResultSet resultSet = statement.executeQuery()) {
//                    while (resultSet.next()) {
//                        String word = resultSet.getString("Word");
//                        String type = resultSet.getString("Type");
//                        String meaning = resultSet.getString("Meaning");
//                        String pronunciation = resultSet.getString("Pronunciation");
//                        String example = resultSet.getString("Example");
//                        String synonym = resultSet.getString("Synonym");
//                        String antonyms = resultSet.getString("Antonyms");
//
//                        System.out.println("Word: " + word);
//                        System.out.println("Type: " + type);
//                        System.out.println("Meaning: " + meaning);
//                        System.out.println("Pronunciation: " + pronunciation);
//                        System.out.println("Example: " + example);
//                        System.out.println("Synonym: " + synonym);
//                        System.out.println("Antonyms: " + antonyms);
//                        System.out.println("-----------------------------");
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

}
