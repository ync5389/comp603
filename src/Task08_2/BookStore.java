package Task08_2;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookStore {

    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;

    public BookStore() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }

    public void connectBookStoreDB() {
        //use the conn, initialize database by creating BOOK Table and insert records
    }

    public void createPromotionTable() {
        /* You may need the following SQL statements for this method:

         * Create the table:
           CREATE TABLE PROMOTION (CATEGORY VARCHAR(20), DISCOUNT INT);

         * Insert records into the table: 
           INSERT INTO PROMOTION VALUES ('Fiction', 0),
           ('Non-fiction', 10),
           ('Textbook', 20);

         */

    }

    public ResultSet getWeekSpecial() {
        /* You may need the following SQL statements for this method:

        * Query multiple tables:
        
          SELECT TITLE, PRICE, DISCOUNT FROM BOOK, PROMOTION WHERE BOOK.CATEGORY=PROMOTION.CATEGORY;

         */

        ResultSet rs = null;

        return (rs);

    }

    public void createWeekSpecialTable(ResultSet rs) {
        try {

            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
