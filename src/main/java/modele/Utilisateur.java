package modele;

import connexion_bdd.connexion_bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Utilisateur {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private boolean estConnecte = false;
    private connexion_bdd coBdd = new connexion_bdd();


    public Utilisateur(String email, String mdp) {
        setEmail(email);
        setPassword(mdp);
    }

    public Utilisateur(String email, String mdp, String nom, String prenom) {
        setNom(nom);
        setPrenom(prenom);
        setEmail(email);
        setPassword(mdp);
    }

    public Utilisateur(int id, String nom, String prenom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return id + ". " + nom + " " + prenom + "\n";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstConnecte() {
        return estConnecte;
    }

    public void setEstConnecte(boolean estConnecte) {
        this.estConnecte = estConnecte;
    }

    public void inscription() throws SQLException {
        String sql = "INSERT INTO user ( `nom`, `prenom`, `email`,`password`) VALUES (?,?,?,?)";
        PreparedStatement req;

        req = coBdd.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        req.setString(1, getNom());
        req.setString(2, getPrenom());
        req.setString(3, getEmail());
        req.setString(4, getPassword());
        req.executeUpdate();
        ResultSet res = req.getGeneratedKeys();
        if(res.next())
        {
            int last_inserted_id = res.getInt(1);
            setId(last_inserted_id);
        }

    }

    public void connexion() {
        String sql = "SELECT * FROM user WHERE email=? and password=?";
        PreparedStatement req;
        try {
            req = coBdd.getConnection().prepareStatement(sql);
            req.setString(1, getEmail());
            req.setString(2, getPassword());
            System.out.println(this.getEmail());
            System.out.println(this.getPassword());
            ResultSet res = req.executeQuery();
            if (res.next()) {
                this.setPrenom(res.getString("prenom"));
                this.setNom(res.getString("nom"));
                this.setId(res.getInt("id_user"));
                System.out.println(this.getEmail());
                System.out.println(this.getNom());
                System.out.println(this.getId());
                System.out.println(this.getPrenom());
            }
        }catch(SQLException e){
    // TODO Auto-generated catch block
                    e.printStackTrace();
        }
    }


}
