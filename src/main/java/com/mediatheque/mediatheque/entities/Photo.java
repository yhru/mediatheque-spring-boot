package com.mediatheque.mediatheque.entities;


import javax.persistence.*;
import java.util.Arrays;
import java.util.Map;

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
    private String name;
    //------------------------------------------//
    @Column(
            name = "resolution"
    )
    private long resolution;
    //------------------------------------------//
    @ElementCollection
    @Column(
            name = "data_in_picture"
    )
    private Map<Integer, String> dataInPicture;
    //------------------------------------------//
    @Lob
    @Column(
            name = "image",
            length = 1000
    )
    private byte[] image;


    //Constructeur
    public Photo(String name, long resolution, Map<Integer, String>dataInPicture, byte[] image) {
        this.name = name;
        this.resolution = resolution;
        this.dataInPicture = dataInPicture;
        this.image = image;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getResolution() {
        return resolution;
    }

    public void setResolution(long resolution) {
        this.resolution = resolution;
    }

    public Map<Integer, String> getDataInPicture() {
        return dataInPicture;
    }

    public void setDataInPicture(Map<Integer, String> dataInPicture) {
        this.dataInPicture = dataInPicture;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


    //ToString
    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resolution=" + resolution +
                ", dataInPicture=" + dataInPicture +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
