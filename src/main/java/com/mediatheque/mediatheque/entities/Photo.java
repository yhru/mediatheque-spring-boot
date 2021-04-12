package com.mediatheque.mediatheque.entities;

import ai.djl.modality.cv.output.DetectedObjects;

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
<<<<<<< HEAD


    public Photo(Long id, String name, String resolution, String dataInPicture) {
        this.id = id;
        this.name = name;
=======
    public Photo(String name, String resolution, String dataInPicture) {
        this.file_name = name;
>>>>>>> 3f668d70c7465dc5c777237653227ae6abf5a2fb
        this.resolution = resolution;
        this.dataInPicture = dataInPicture;
    }

    public Photo() {
    }

    public Photo(String name, String resolution, String dataInPicture) {
//        this.id = id;
        this.name = name;
        this.resolution = resolution;
        this.dataInPicture = dataInPicture;
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
                ", dataInPicture=" + dataInPicture +
                '}';
    }
}
