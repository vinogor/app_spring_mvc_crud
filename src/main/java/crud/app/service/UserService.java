package crud.app.service;

import crud.app.entity.User;

import java.util.List;

// это чтобы выделить отдельно бизнес логику

public interface UserService {

    List<User> findAll();

    void save(User user);

    User getById(int id);

    void update(User user);

    void delete(int id);
}
