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
    private connexion_bdd coBdd;

    public Utilisateur() {
        coBdd = new connexion_bdd();
    }

    public Utilisateur connexion(String email, String password) {
        this.password = password;
        this.email = email;
        return null;
    }

    public Utilisateur(String nom, String prenom) {
        setNom(nom);
        setPrenom(prenom);
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

    public Utilisateur connexion() {
        Utilisateur user = null;
        String sql = "SELECT * FROM user WHERE email=? and password=?";
        PreparedStatement req;
        try {
            req = coBdd.getConnection().prepareStatement(sql);
            req.setString(1, getEmail());
            req.setString(2, getPassword());
            ResultSet res = req.executeQuery();
            if (res.next()) {
                user = new Utilisateur(res.getInt("id"), res.getString("nom"), res.getString("prenom"), res.getString("email"), res.getString("mdp"));
            }
        }   catch(SQLException e){
    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return user;
            }


}
