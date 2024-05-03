package Task08_1;

/**
 *
 * There is no Java programming in this task, but you need to run the SQL after
 * starting the Java DB Server. Please follow the instructions given in this
 * task.
 */
public class NoProgramming {

    public static String tableCreation = "CREATE  TABLE BOOK  (BOOKID  INT,   TITLE   VARCHAR(50),   CATEGORY   VARCHAR(20),   PRICE   FLOAT);";
    public static String insertData = "INSERT INTO BOOK VALUES (1, 'Slum Dog Millionaire', 'Fiction', 19.90),\n"
            + "(2, 'Run Mummy Run', 'Fiction', 28.00),\n"
            + "(3, 'The Land of Painted Caves', 'Fiction', 15.40),\n"
            + "(4, 'Cook with Jamie', 'Non-fiction', 55.20),\n"
            + "(5, 'Far Eastern Odyssey', 'Non-fiction', 24.90),\n"
            + "(6, 'Open', 'Non-fiction', 33.60),\n"
            + "(7, 'Big Java', 'Textbook', 55.00),\n"
            + "(8, 'Financial Accounting', 'Textbook', 24.80);";

    public static String selectData = "SELECT * FROM BOOK; ";

    public static void main(String[] args) {
        System.out.println(tableCreation);
        System.out.println(insertData);
        System.out.println(selectData);
    }

}
