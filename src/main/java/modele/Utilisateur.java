package modele;

import connexion_bdd.connexion_bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Utilisateur {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private boolean estConnecte = false;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom) {
        setNom(nom);
        setPrenom(prenom);
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

    public void connexionUser (Utilisateur user) throws Exception {
        Connection con = connexion_bdd.getConnection();
        PreparedStatement req = con.prepareStatement("SELECT * FROM user WHERE email=? and password=?");
        req.setString(1,user.getEmail());
        req.setString(2,user.getPassword());
        ResultSet res = req.executeQuery();
        if (res.next()){
            user.setId(res.getInt("id_user"));
            user.setNom(res.getString("nom"));
            user.setPrenom(res.getString("prenom"));
            System.out.println("Bienvenue "+ user.getPrenom()+ " (id: "+ user.getId()+")");
            this.estConnecte=true;
        }
        else{
            System.out.println("Email ou password incorrect. Veuillez essayer à nouveau.");
            this.estConnecte=false;
        }
    }

    public void inscription(String nom, String prenom, String email, String mdp) throws Exception {
        Connection con = connexion_bdd.getConnection();
        PreparedStatement req = con.prepareStatement("INSERT INTO user(nom,prenom,email,mdp) VALUES (?,?,?,?)");
        req.setString(1, nom);
        req.setString(2, prenom);
        req.setString(3, email);
        req.setString(4, mdp);
        req.executeUpdate();
    }

    /*public String afficherUser () throws Exception {
        ArrayList<Utilisateur> userList = new ArrayList<Utilisateur>();

        Connection con = connexion_bdd.getConnection();
        PreparedStatement req = con.prepareStatement("SELECT * FROM user");
        ResultSet res = req.executeQuery();
        while (res.next()){
            Utilisateur user = new Utilisateur();
            user.setId(res.getInt("id_user"));
            user.setNom(res.getString("nom"));
            user.setPrenom(res.getString("prenom"));

            userList.add(user);
        }
        return userList.toString();
    }*/


}
