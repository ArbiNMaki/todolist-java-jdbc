package aplikasi.todolist.db;

import aplikasi.todolist.db.TodoList.Repository.TodoListRepository;
import aplikasi.todolist.db.TodoList.Repository.TodoListRepositoryImpl;
import aplikasi.todolist.db.TodoList.Service.TodoListService;
import aplikasi.todolist.db.TodoList.Service.TodoListServiceImpl;
import aplikasi.todolist.db.TodoList.View.TodoListView;

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
