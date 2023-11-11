package data;

// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class DictionaryCommandLine {
    private final DictionaryManagement dictionaryManagement;

    // Hàm chạy giao diện chính
    public void dictionaryAdvanced() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to My Application!");
            System.out.println("[0] Exit");
            System.out.println("[1] Add");
            System.out.println("[2] Remove");
            System.out.println("[3] Update");
            System.out.println("[4] Display");
            System.out.println("[5] Lookup");
            System.out.println("[6] Search");
            System.out.println("[7] Game");
            System.out.println("[8] Import from file");
            System.out.println("[9] Export to file");

            System.out.print("Your action: ");
            String userAction = scanner.nextLine();

            if (userAction.matches("[0-9]")) {
                int action = Integer.parseInt(userAction);

                switch (action) {
                    case 0:
                        System.out.println("Exiting the application.");
                        scanner.close();
                        System.exit(0);
                        break;
                    case 1:
                        // Thêm từ
                        dictionaryManagement.insertFromCommandLine();
                        System.out.println("Word added successfully!");
                        break;
                    case 2:
                        // Xóa từ
                        break;
                    case 3:
                        // Sửa từ
                        break;
                    case 4:
                        // Hiển thị danh sách từ
                        showAllWords();
                        break;
                    case 5:
                        // Tra cứu
                        break;
                    case 6:
                        // Tìm kiếm
                        break;
                    case 7:
                        // Truy cập phần Game
                        break;
                    case 8:
                        // Nhập danh sách từ từ tệp
                        break;
                    case 9:
                        // Xuất dữ liệu danh sách từ ra tệp
                        break;
                    default:
                        System.out.println("Action not supported. Please enter a valid number (0-9).");
                        break;
                }
            } else {
                System.out.println("Action not supported. Please enter a valid number (0-9).");
            }
        }
    }

    // Hàm khởi tạo
    public DictionaryCommandLine() {
        dictionaryManagement = new DictionaryManagement();
    }

    // Hàm hiện ra toàn bộ từ
    public void showAllWords() {
        ArrayList<Word> words = dictionaryManagement.getDictionary().getAllWords();
        words.sort(Comparator.comparing(Word::getWordTarget));

        System.out.println("No | English | Vietnamese");
        for (int i = 0; i < words.size(); i++) {
            Word word = words.get(i);
            System.out.println((i + 1) + " | " + word.getWordTarget() + " | " + word.getWordExplain());
        }
    }

    // Chương trình chính
    public static void main(String[] args) {
        DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();
        dictionaryCommandLine.dictionaryAdvanced();
    }
}

