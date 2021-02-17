package JEEMediatheque.controller;

import JEEMediatheque.dao.imagedao;
import JEEMediatheque.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private imagedao imagedao;

    //Produits
    @GetMapping(value = "images")
    public List<Image> listeImages(){
        return imagedao.findAll();
    }

    //Produits/{id}
    @GetMapping(value = "images/{id}")
    public Image afficherImage(@PathVariable int id){
        return imagedao.findById(id);
    }

    @PostMapping(value = "/images")
    public ResponseEntity ajouterImage(@RequestBody Image image){
        Image image1 = imagedao.save(image);

        if (image == null){
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(image1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
