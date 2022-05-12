package connexion_bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connexion_bdd {
    private String url = "jdbc:mysql://localhost:3306/ale_hme_todolist?serverTimezone=UTC";
    private String user = "root";
    private String password = "";

    public Connection getConnection(){
        try {
            Connection cnx = DriverManager.getConnection(this.url,this.user,this.password);
            return cnx;

        } catch (SQLException e) {
            System.out.print("erreur");
            e.printStackTrace();
            return null;
        }
    }
}
