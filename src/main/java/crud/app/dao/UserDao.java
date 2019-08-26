package crud.app.dao;

// интерфейс описывающий как мы будем работать с БД

import crud.app.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

}
