package crud.app.dao;

import crud.app.dao.mapper.UserMapper;
import crud.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM table_coffee";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
