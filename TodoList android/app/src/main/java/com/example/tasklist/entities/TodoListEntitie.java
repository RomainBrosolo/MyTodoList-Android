package com.example.tasklist.entities;

import com.example.tasklist.adapters.TodoListAdapter;

import java.util.ArrayList;
import java.util.List;

public class TodoListEntitie {
    private static final List<TodoEntitie> TASK_ENTITIES_LIST = new ArrayList<TodoEntitie>();
    private static TodoListAdapter adapter;

    public TodoListEntitie() {
        super();
    }

    public void addTodo(TodoEntitie todoEntitie) {
        TASK_ENTITIES_LIST.add(todoEntitie);

        if (adapter != null)
            adapter.notifyItemInserted(TASK_ENTITIES_LIST.size()-1);
    }

    public void removeTodo(TodoEntitie todoEntitie) {
        int index = TASK_ENTITIES_LIST.indexOf(todoEntitie);
        TASK_ENTITIES_LIST.remove(todoEntitie);

        if (adapter != null)
            adapter.notifyItemRemoved(index);
    }

    public void setTodoDone(TodoEntitie todoEntitie, boolean isDone)
    {
        int index = TASK_ENTITIES_LIST.indexOf(todoEntitie);

        if (isDone)
        {
            TASK_ENTITIES_LIST.get(index).setDone();
        } else
        {
            TASK_ENTITIES_LIST.get(index).setUndone();
        }

        if (adapter != null)
            adapter.notifyItemChanged(index);
    }

    public List<TodoEntitie> getTodoList() {
        return TASK_ENTITIES_LIST;
    }

    public TodoListEntitie setAdapter(TodoListAdapter adapter)
    {
        this.adapter = adapter;

        return this;
    }
}
