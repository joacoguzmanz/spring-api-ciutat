package guzman.joaquin.ciutat.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Ciutats")
public class Ciutat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_Ciutat_Id")
    private int id;

    @Column(name = "Nom_Ciutat", length = 45, unique = true, nullable = false)
    private String nom;

    @Column(name = "Prefix_Telefonic", nullable = false)
    private int prefixTel;

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

    public int getPrefixTel() {
        return prefixTel;
    }

    public void setPrefixTel(int prefixTel) {
        this.prefixTel = prefixTel;
    }
}
