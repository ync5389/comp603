package Task09_3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class MathQuiz extends JFrame {

    private JPanel userPanel = new JPanel();
    private JPanel calcPanel = new JPanel();
    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    private JTextField unInput = new JTextField(10);
    private JTextField pwInput = new JTextField(10);
    private JLabel wrongName = new JLabel("Wrong username or passwork!");

    private JLabel firstNumber = new JLabel();
    private JLabel secondNumber = new JLabel();
    private JLabel additionLabel = new JLabel("+");
    //private JTextField secondNumber = new JTextField(10);
    private JButton nextButton = new JButton("Next");
    private JButton quitButton = new JButton("Quit");
    private JButton loginButton = new JButton("Log in");

    private JTextField calcSolution = new JTextField(10);
    Connection conn = null;
    String url = "jdbc:derby:PlayerDB;create=true";  //url of the DB host

    String dbusername = "pdc";  //your DB username
    String dbpassword = "pdc";   //your DB password

    public String username = null;
    public String password = null;
    public int score = 0;
    int answer = 0;

    public MathQuiz() {
        this.dbsetup();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        userPanel.add(uName);
        userPanel.add(unInput);
        userPanel.add(pWord);
        userPanel.add(pwInput);
        userPanel.add(loginButton);
        this.add(userPanel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the login button");
                username = unInput.getText();
                password = pwInput.getText();
                if (username != null && password != null) {
                    if (checkName());
                    {
                        startQuiz();
                    }
                }
            }
        });

    }

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12), score INT)");
            }
            //statement.executeUpdate("INSERT INTO " + tableName + " VALUES('Fiction',0),('Non-fiction',10),('Textbook',20)");
            statement.close();

        } catch (Throwable e) {
            System.out.println("error");

        }
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {

            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            //Statement dropStatement=null;
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }

    void startQuiz() {

        newQuestion();
        calcPanel.add(firstNumber);
        calcPanel.add(additionLabel);
        calcPanel.add(secondNumber);

        calcPanel.add(calcSolution);
        calcPanel.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the next button");
                String userAnswer = calcSolution.getText();
                if (userAnswer.compareTo(answer + "") == 0) {
                    score += 10;
                    newQuestion();
                } else {
                    score -= 10;
                    newQuestion();
                }
                System.out.println(score);
            }
        });
        calcPanel.add(quitButton);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked the quit button");
                String userAnswer = calcSolution.getText();

                quitGame();
            }
        });
        this.getContentPane().removeAll();
        calcPanel.setVisible(true);
        this.add(calcPanel);
        this.revalidate();
        this.repaint();

    }

    public void newQuestion() {

        int num1 = getNumber();
        int num2 = getNumber();
        answer = num1 + num2;
        firstNumber.setText(num1 + "");
        secondNumber.setText(num2 + "=");
        calcSolution.setText("");
        calcPanel.repaint();

    }

    public int getNumber() {
        Random generator = new Random();
        int i = generator.nextInt(100);
        return i;
    }

    private boolean checkName() {
        boolean userCheck = false;
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password, score FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (rs.next()) {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");
                if (password.compareTo(pass) == 0) {
                    score = rs.getInt("score");
                    userCheck = true;
                } else {
                    userCheck = false;
                }
            } else {
                System.out.println("no such user");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "', '" + password + "', 0)");
                userCheck = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(MathQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userCheck;

    }

    void quitGame() {

        Statement statement;
        try {
            statement = conn.createStatement();
            statement.executeUpdate("UPDATE UserInfo SET score=" + score + " WHERE userid='" + username + "'");
            System.out.println(username + score);
            JPanel quitPanel = new JPanel();
            JLabel scoreLabel = new JLabel("Your score: " + score);
            quitPanel.add(scoreLabel);
            this.getContentPane().removeAll();
            //calcPanel.setVisible(true);
            this.add(quitPanel);
            this.revalidate();
            this.repaint();

        } catch (SQLException ex) {
            Logger.getLogger(MathQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
