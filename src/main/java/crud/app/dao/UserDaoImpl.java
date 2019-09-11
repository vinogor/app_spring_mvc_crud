package crud.app.dao;

import crud.app.dao.mapper.UserMapper;
import crud.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        String sql = "INSERT INTO schema_coffee.table_coffee (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());
    }

    @Override
    public User getById(int id) {
        String sql = "SELECT * FROM schema_coffee.table_coffee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM schema_coffee.table_coffee";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE schema_coffee.table_coffee SET name = ?, email = ?, age = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM schema_coffee.table_coffee WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
