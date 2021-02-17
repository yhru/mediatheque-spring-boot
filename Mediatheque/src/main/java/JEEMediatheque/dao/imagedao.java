package JEEMediatheque.dao;

import JEEMediatheque.entities.Image;

import java.util.List;

public interface imagedao {

    public List<Image> findAll();

    public Image findById(int id);

    public Image save(Image image);
}
