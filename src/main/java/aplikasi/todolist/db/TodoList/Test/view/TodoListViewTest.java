package aplikasi.todolist.db.TodoList.Test.view;

import aplikasi.todolist.db.TodoList.Repository.TodoListRepository;
import aplikasi.todolist.db.TodoList.Repository.TodoListRepositoryImpl;
import aplikasi.todolist.db.TodoList.Service.TodoListService;
import aplikasi.todolist.db.TodoList.Service.TodoListServiceImpl;
import aplikasi.todolist.db.TodoList.View.TodoListView;

public class TodoListViewTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar Java Basic");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Classes");

        todoListView.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.addTodoList();
        todoListService.showTodoList();

        todoListView.addTodoList();
        todoListService.showTodoList();
    }

    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar Java Basic");
        todoListService.addTodoList("Belajar Java OOP");
        todoListService.addTodoList("Belajar Java Standard Classes");

        todoListService.showTodoList();

        todoListView.removeTodoList();

        todoListService.showTodoList();
    }
}
