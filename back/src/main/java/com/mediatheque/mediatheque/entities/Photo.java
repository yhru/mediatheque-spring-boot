package com.mediatheque.mediatheque.entities;

import javax.persistence.*;

@Entity(name = "Photo") // on map notre class pour dire que c'est une entité
@Table(name = "photo")
public class Photo {

    //Création des properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    //------------------------------------------//
    @Column(
            name = "name",
            columnDefinition = "TEXT"
    )
    private String file_name;
    //------------------------------------------//
    @Column(
            name = "resolution",
            columnDefinition = "TEXT"
    )
    private String resolution;
    //------------------------------------------//
    @Column(
            name = "data_in_picture",
            columnDefinition = "TEXT"
    )
    private String dataInPicture;

    //Constructeur
    public Photo(String name, String resolution, String dataInPicture) {
        this.file_name = name;
        this.resolution = resolution;
        this.dataInPicture = dataInPicture;
    }

    public Photo() {
    }


    //Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String name) {
        this.file_name = name;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDataInPicture() {
        return dataInPicture;
    }

    public void setDataInPicture(String dataInPicture) {
        this.dataInPicture = dataInPicture;
    }

    //ToString

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", name='" + file_name + '\'' +
                ", resolution='" + resolution + '\'' +
                ", dataInPicture='" + dataInPicture + '\'' +
                '}';
    }

}
