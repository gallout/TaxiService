package interfaces;

import java.util.List;

public interface DAO <Entity, Key> {
    void create(Entity model);
    List<Entity> read ();
    Entity readById(Key key);
    Entity  readbyBrand  (String key);
    List<Entity> readAllByBrand (String key);
    void update(Key key, Entity model);
    void delete(Key key);
}
