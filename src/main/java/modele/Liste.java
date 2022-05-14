package modele;

import connexion_bdd.connexion_bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Liste {
    int id;
    String nom;
    private connexion_bdd coBdd = new connexion_bdd();

    public Liste(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Liste(String nom, int id){
        setNom(nom);
        setId(id);
    }

    public Liste() {

    }

    public Liste(int id) {
        setId(id);
    }

    public Liste(String nom){
        setNom(nom);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Liste> afficherListe(){
        ArrayList<Liste> listes = new ArrayList<Liste>();
        Liste liste;
        String sql = "Select * from liste";
        PreparedStatement req;
        try {
            req = coBdd.getConnection().prepareStatement(sql);
            ResultSet res = req.executeQuery();
            while (res.next()){
                liste = new Liste (res.getInt("id_liste"),res.getString("nom"));
                listes.add(liste);
            }
        }catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

        return listes;
    }

    public void ajouterListe(){
        String sql;
        PreparedStatement req;
        sql = "INSERT INTO `liste`(`nom`) VALUES (?)";
        try {
            req = coBdd.getConnection().prepareStatement(sql);
            req.setString(1, this.getNom());
            req.executeUpdate();
        }catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void modifierListe() throws SQLException {
        String sql;
        PreparedStatement req;
        sql = "UPDATE liste SET `nom`=? WHERE id_liste=?";
        try {
            req = coBdd.getConnection().prepareStatement(sql);
            req.setString(1, this.getNom());
            req.setInt(2, this.getId());
            req.executeUpdate();
        }catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void supprimerListe() throws SQLException {
        if (getId() > 0){
            String sql = "DELETE FROM liste where id_liste=?;";
            PreparedStatement pstm = coBdd.getConnection().prepareStatement(sql);
            pstm.setInt(1, this.getId());
            pstm.executeUpdate();
        }
    }

    @Override
    public String toString() {
        return id +" - "+ nom;
    }
}
