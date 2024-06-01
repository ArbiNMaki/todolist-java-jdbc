package aplikasi.todolist.db.Repository;

import aplikasi.todolist.db.Entity.TodoList;

public interface TodoListRepository {
    TodoList[] getAll();

    void add(TodoList todolist);

    boolean remove(Integer number);
}
