package parcial.isil.repository;

import java.util.List;

public interface BaseRepository <T,ID>{
    void save(T t);
    void update(T t);
    void delete(ID id);

    List<T>getAll();
    T getById(ID id);
}
