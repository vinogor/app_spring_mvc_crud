package crud.app.dao;

// интерфейс описывающий как мы будем работать с БД

import crud.app.entity.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User getById(int id);

    List<User> findAll();

    void update(User user);

    void delete(int id);
}
