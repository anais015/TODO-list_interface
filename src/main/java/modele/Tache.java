package modele;

import connexion_bdd.connexion_bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Tache {
    int id;
    String nom;
    String description;
    Date deadline;
    boolean estTerminee=false;
    int ref_liste;
    int ref_type;
    private connexion_bdd coBdd = new connexion_bdd();

    public Tache(){

    }

    public Tache(int id){
        setId(id);
    }

    public Tache(int id, String nom, String description, Date deadline, int ref_liste, int ref_type, boolean estTerminee) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.deadline = deadline;
        this.estTerminee=false;
        this.ref_liste = ref_liste;
        this.ref_type = ref_type;
    }

    public Tache (int id, String nom, String description, Date deadline, boolean estTerminee, int ref_type, int ref_liste){
        setId(id);
        setNom(nom);
        setDescription(description);
        setDeadline(deadline);
        setEstTerminee(estTerminee);
        setRef_liste(ref_liste);
        setRef_type(ref_type);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean getEstTerminee() {
        return estTerminee;
    }

    public void setEstTerminee(boolean estTerminee) {
        this.estTerminee = estTerminee;
    }

    public int getRef_liste() {
        return ref_liste;
    }

    public void setRef_liste(int ref_liste) {
        this.ref_liste = ref_liste;
    }

    public int getRef_type() {
        return ref_type;
    }

    public void setRef_type(int ref_type) {
        this.ref_type = ref_type;
    }

    public ArrayList<Tache> afficherTache(){
        ArrayList<Tache> taches = new ArrayList<Tache>();
        Tache tache;
        String sql = "Select * from tache";
        PreparedStatement req;
        try {
            req = coBdd.getConnection().prepareStatement(sql);
            ResultSet res = req.executeQuery();
            while (res.next()){
                tache = new Tache (res.getInt("id_tache"),res.getString("nom"),
                        res.getString("description"),
                        res.getDate("deadline"),
                        res.getInt("ref_liste"),
                        res.getInt("ref_type"),
                        res.getBoolean("estTerminee"));
                taches.add(tache);
            }
        }catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }

        return taches;
    }

    public void supprimerTache() throws SQLException {
        if (getId() > 0){
            String sql = "DELETE FROM tache where id_tache=?;";
            PreparedStatement pstm = coBdd.getConnection().prepareStatement(sql);
            pstm.setInt(1, this.getId());
            pstm.executeUpdate();
        }
    }

    public void modifierTache() throws SQLException {
        String sql;
        PreparedStatement req;
        sql = "UPDATE tache SET `nom`=?, `description`=?, `deadline`=?, " +
                "`estTerminee`=?, `ref_liste`=?, `ref_type`=? WHERE id_liste=?";
        try {
            req = coBdd.getConnection().prepareStatement(sql);
            req.setString(1, this.getNom());
            req.setString(2, this.getDescription());
            req.setDate(3, (java.sql.Date) this.getDeadline());
            req.setBoolean(4, this.getEstTerminee());
            req.setInt(5, this.getRef_liste());
            req.setInt(6, this.getRef_type());
            req.setInt(7, this.getId());
            req.executeUpdate();
        }catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return id +" - "+ nom;
    }
}
