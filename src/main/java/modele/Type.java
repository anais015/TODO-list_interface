package modele;

import connexion_bdd.connexion_bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Type {
    int id;
    String nom;
    private connexion_bdd coBdd = new connexion_bdd();

    public Type(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Type(String nom, int id){
        setNom(nom);
        setId(id);
    }

    public Type(){

    }

    public Type(int id){
        setId(id);
    }

    public Type(String nom){
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



    public ArrayList<Type> afficherType(){
        ArrayList<Type> types = new ArrayList<Type>();
        Type type;
        String sql = "Select * from type";
        PreparedStatement req;
        try {
            req = coBdd.getConnection().prepareStatement(sql);
            ResultSet res = req.executeQuery();
            while (res.next()){
                type = new Type (res.getInt("id_type"),res.getString("nom"));
                types.add(type);
            }
        }catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

        return types;
    }

    public void ajouterType(){
        String sql;
        PreparedStatement req;
        sql = "INSERT INTO `type`(`nom`) VALUES (?)";
        try {
            req = coBdd.getConnection().prepareStatement(sql);
            req.setString(1, this.getNom());
            req.executeUpdate();
        }catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void modifierType() {
        String sql;
        PreparedStatement req;
        sql = "UPDATE type SET `nom`=? WHERE `id_type`=?";
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

    public void supprimerType() throws SQLException {
        if (getId() > 0){
            String sql = "DELETE FROM type where id_type=?;";
            PreparedStatement pstm = coBdd.getConnection().prepareStatement(sql);
            pstm.setInt(1, this.getId());
            pstm.executeUpdate();
        }
    }

    @Override
    public String toString() {
        return  id + " - "+ nom;
    }
}
