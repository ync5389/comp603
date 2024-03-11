package Task08_3;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleBookStore {

    SimpleDBManager dbManager;
    Connection conn;
    Statement statement;

    public SimpleBookStore() {
        dbManager = new SimpleDBManager();
        conn = dbManager.getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        SimpleBookStore sbs = new SimpleBookStore();

        try {
            sbs.statement.addBatch("CREATE  TABLE BOOK  (BOOKID  INT,   TITLE   VARCHAR(50),   CATEGORY   VARCHAR(20),   PRICE   FLOAT)");
            sbs.statement.addBatch("INSERT INTO BOOK VALUES (1, 'Slum Dog Millionaire', 'Fiction', 19.90),\n"
                    + "(2, 'Run Mummy Run', 'Fiction', 28.00),\n"
                    + "(3, 'The Land of Painted Caves', 'Fiction', 15.40),\n"
                    + "(4, 'Cook with Jamie', 'Non-fiction', 55.20),\n"
                    + "(5, 'Far Eastern Odyssey', 'Non-fiction', 24.90),\n"
                    + "(6, 'Open', 'Non-fiction', 33.60),\n"
                    + "(7, 'Big Java', 'Textbook', 55.00),\n"
                    + "(8, 'Financial Accounting', 'Textbook', 24.80)");
            sbs.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        sbs.closeConnection();
    }

    public void closeConnection() {
        this.dbManager.closeConnections();
    }

}
