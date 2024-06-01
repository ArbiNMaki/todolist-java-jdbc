package aplikasi.todolist.db.Repository;

import aplikasi.todolist.db.Entity.TodoList;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TodoListRepositoryImpl implements TodoListRepository {

    public TodoList[] data = new TodoList[10];
    private DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull() {
        var isFull = true;
        for(int i = 0; i < data.length; i++) {
            if(data[i] == null) {
                // Model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull() {
        // Jika isFull, kita resize ukuran array 2x lipat
        if(isFull()) {
            var temp = data;
            data = new TodoList[data.length * 2];

            for(int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todolist) {
        String sql = "INSERT INTO todolist(todo) VALUES (?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, todolist.getTodo());
            statement.executeUpdate();
        } catch(SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer number) {
        if((number - 1) >= data.length) {
            return false;
        } else if(data[number - 1] == null) {
            return false;
        } else {
            for(int i = ( number - 1); i < data.length; i++) {
                if(i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
