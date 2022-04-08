package connexion_bdd;

import java.sql.Connection;
import java.sql.DriverManager;

public class connexion_bdd {
    static Connection maConnexion;
    static String url = "jdbc:mysql://localhost:3306/ale_hme_todolist?serverTimezone=UTC";
    static String user = "root";
    static String password = "";

    public static Connection getConnection() throws Exception{
        if(maConnexion == null){
            maConnexion = DriverManager.getConnection(url,user,password);
        }
        return maConnexion;
    }
}
