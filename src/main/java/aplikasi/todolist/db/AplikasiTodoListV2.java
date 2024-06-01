package aplikasi.todolist.db;

import aplikasi.todolist.db.Repository.TodoListRepository;
import aplikasi.todolist.db.Repository.TodoListRepositoryImpl;
import aplikasi.todolist.db.Service.TodoListService;
import aplikasi.todolist.db.Service.TodoListServiceImpl;
import aplikasi.todolist.db.View.TodoListView;
import aplikasi.todolist.db.util.DatabaseUtil;

import javax.sql.DataSource;

public class AplikasiTodoListV2 {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();

        // Logic untuk Data
        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);

        // Logic untuk Business
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        // Logic untuk View/UI
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
