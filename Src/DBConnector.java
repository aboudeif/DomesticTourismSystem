import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnector {
    private static boolean DEBUG = App.DEBUG;
    private static Connection CONNECTION;
    private static String DBInstance;
    private static String DBName;
    private static String DBAccount;
    private static String DBPassword;

    private static void readDBInfo() throws Exception{
        BufferedReader csvReader = new BufferedReader( new FileReader(".\\Src\\DBInfo.csv"));
        while (true) {
            String row = csvReader.readLine();
            if(row == null) break;
            String[] data = row.split(",");

            // do something with the data
            if(data[0].equals("DataBaseInstance")){
                DBConnector.DBInstance = data[1];
            }else if(data[0].equals("DataBaseName")){
                DBConnector.DBName = data[1];
            }else if(data[0].equals("DataBaseAccount")){
                DBConnector.DBAccount = data[1];
            }else if(data[0].equals("DataBasePassword")){
                DBConnector.DBPassword = data[1];                
            }else{
                System.err.println("Faild To Read Attribute From CSV!");
            }
        }
        csvReader.close();
        if(DEBUG){
            System.out.println("Instance Name: " + DBInstance);
            System.out.println("DataBase Name: " + DBName);
            System.out.println("DataBase Account: " + DBAccount);
            System.out.println("DataBase Password: " + DBPassword);
        }
    }

    public static void connectToDB() throws Exception{
        // String dbURL = "jdbc:sqlserver://HAZEM;databaseName=learndb";
        String dbURL = "jdbc:sqlserver://" + DBInstance + ";databaseName=" + DBName;
        String user = DBAccount;
        String pass = DBPassword;
        CONNECTION = DriverManager.getConnection(dbURL, user, pass);
        if(CONNECTION == null){
            System.out.println("Faild To Connect To DataBase!");
        }
    }

    public static Connection getConnection() throws Exception{
        if(DBInstance == null || DBName == null || DBAccount == null || DBPassword == null){
            readDBInfo();
        }
        if(CONNECTION == null || CONNECTION.isClosed()){
            connectToDB();
        }
        return CONNECTION;
    }

    public static boolean checkAgentPassword(String userName, String userPassword) throws Exception{
        Statement statement = CONNECTION.createStatement();
        String quereyString = "SELECT [usrID], [password] FROM [Agent] WHERE [usrID] = '" + userName +
        "' COLLATE SQL_Latin1_General_CP1_CS_AS AND [password] = '" + userPassword +
         "' COLLATE SQL_Latin1_General_CP1_CS_AS;";

        if(DEBUG) System.out.println(quereyString);
        
        ResultSet rs = statement.executeQuery(quereyString);
        return rs.next();
    }

    /*
    // public static void main(String[] args) throws Exception {
        // Statement statement = DBConnector.getConnection().createStatement();
        // ResultSet rs = statement.executeQuery("SELECT * FROM [Student];");
        // while (rs.next()) {
        //     String strData = "";
        //     int id = rs.getInt("ID");
        //     String nid = rs.getString("NID");
        //     String name = rs.getString("Name");
        //     int trackID = rs.getInt("TrackID");
        //     double salary = rs.getDouble("Salary");
        //     strData = "ID: " + id + ", " + "NID: " + nid + ", " + "Name: " + name + ", " + "TrackID: " + trackID + ", " + "Salary: " + salary;
        //     System.out.println(strData);
        // }
    // }
    */
}
