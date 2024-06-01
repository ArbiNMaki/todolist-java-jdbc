package aplikasi.todolist.db;

import aplikasi.todolist.db.Repository.TodoListRepository;
import aplikasi.todolist.db.Repository.TodoListRepositoryImpl;
import aplikasi.todolist.db.Service.TodoListService;
import aplikasi.todolist.db.Service.TodoListServiceImpl;
import aplikasi.todolist.db.View.TodoListView;

public class AplikasiTodoListV2 {
    public static void main(String[] args) {
        // Logic untuk Data
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();

        // Logic untuk Business
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        // Logic untuk View/UI
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
