package com.example.tasklist.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tasklist.R;
import com.example.tasklist.adapters.TodoListAdapter;
import com.example.tasklist.entities.TodoListEntitie;

public class TodoList extends Fragment {
    private TodoListEntitie viewModel;
    private RecyclerView todoList;

    public TodoList() {
        // Required empty public constructor
        viewModel = new TodoListEntitie();
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.todolist_layout, container , false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        this.todoList = (RecyclerView) view.findViewById(R.id.todoList);

        TodoListAdapter adapter = new TodoListAdapter(viewModel.getTodoList());
        viewModel.setAdapter(adapter);
        todoList.setAdapter(adapter);
        todoList.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
