package aplikasi.todolist.db.TodoList.Test.service;

import aplikasi.todolist.db.TodoList.Entity.TodoList;
import aplikasi.todolist.db.TodoList.Repository.TodoListRepository;
import aplikasi.todolist.db.TodoList.Repository.TodoListRepositoryImpl;
import aplikasi.todolist.db.TodoList.Service.TodoListService;
import aplikasi.todolist.db.TodoList.Service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Belajar Java Basic");
        todoListRepository.data[1] = new TodoList("Belajar Java Intermediate");
        todoListRepository.data[2] = new TodoList("Belajar Java Advance");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java Basic");
        todoListService.addTodoList("Belajar Java Intermediate");
        todoListService.addTodoList("Belajar Java Advance");

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java Basic");
        todoListService.addTodoList("Belajar Java Intermediate");
        todoListService.addTodoList("Belajar Java Advance");

        todoListService.showTodoList();

        todoListService.removeTodoList(5); // Tidak ada datanya, jadi Gagal
        todoListService.removeTodoList(2); // Ada datanya. jadi Sukses

        todoListService.showTodoList();
    }
}
