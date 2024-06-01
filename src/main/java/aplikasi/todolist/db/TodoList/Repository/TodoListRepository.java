package aplikasi.todolist.db.TodoList.Repository;

import aplikasi.todolist.db.TodoList.Entity.TodoList;

public interface TodoListRepository {
    TodoList[] getAll();

    void add(TodoList todolist);

    boolean remove(Integer number);
}
