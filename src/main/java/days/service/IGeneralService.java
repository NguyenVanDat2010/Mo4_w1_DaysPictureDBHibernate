package days.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findOne(Long id);

    T save(T model);

    List<T> save(List<T> models);

    boolean exists(Long id);

    List<T> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(T model);

    void delete(List<T> models);

    void deleteAll();
}
