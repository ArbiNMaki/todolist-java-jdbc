package aplikasi.todolist.db.Service;

public interface TodoListService {
    void showTodoList();

    void addTodoList(String todo);

    void removeTodoList(Integer number);
}