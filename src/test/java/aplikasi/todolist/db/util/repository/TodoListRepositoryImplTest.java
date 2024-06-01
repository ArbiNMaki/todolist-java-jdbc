package aplikasi.todolist.db.util.repository;

import aplikasi.todolist.db.Entity.TodoList;
import aplikasi.todolist.db.Repository.TodoListRepository;
import aplikasi.todolist.db.Repository.TodoListRepositoryImpl;
import aplikasi.todolist.db.util.DatabaseUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

public class TodoListRepositoryImplTest {
    private HikariDataSource dataSource;
    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        TodoList todoList = new TodoList();
        todoList.setTodo("Kalista");

        todoListRepository.add(todoList);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
