package com.massane.mayele2021;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "cours",indices = @Index(value = {"id"},unique = true))
public class ModelCours {
    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @ColumnInfo(name = "id")
    String id;

    @SerializedName("libele")
    String libele;

    @SerializedName("image")
    String liensImage;

    @SerializedName("fichier")
    String lienFichier;

    @SerializedName("matiere")
    String matiere;

    @SerializedName("classe")
    String classe;

    @SerializedName("serie")
    String serie;

    @SerializedName("cycle")
    String cycle;

    @SerializedName("format_libelle")
    String format_cours;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getLiensImage() {
        return liensImage;
    }

    public void setLiensImage(String liensImage) {
        this.liensImage = liensImage;
    }

    public String getLienFichier() {
        return lienFichier;
    }

    public void setLienFichier(String lienFichier) {
        this.lienFichier = lienFichier;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getFormat_cours() {
        return format_cours;
    }

    public void setFormat_cours(String format_cours) {
        this.format_cours = format_cours;
    }
}
