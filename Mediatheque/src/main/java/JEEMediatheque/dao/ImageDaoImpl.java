package JEEMediatheque.dao;

import JEEMediatheque.entities.Image;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ImageDaoImpl implements imagedao {
    public static List<Image> images =new ArrayList<>();
    static {
        images.add(new Image(1, new String("Ordinateur portable"), 350));
        images.add(new Image(2, new String("Aspirateur Robot"), 500));
        images.add(new Image(3, new String("Table de Ping Pong"), 750));
    }
    @Override
    public List<Image> findAll() {
        return images;
    }

    @Override
    public Image findById(int id) {
        for (Image image : images) {
            if (image.getId() == id){
                return image;
            }
        }
        return null;
    }

    @Override
    public Image save(Image image) {
        images.add(image);
        return image;
    }
}
