package com.example.tasklist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tasklist.R;
import com.example.tasklist.entities.TodoEntitie;
import com.example.tasklist.entities.TodoListEntitie;

import java.text.SimpleDateFormat;
import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView description;
        private final TextView date;
        private final CheckBox checkBox;
        private final Button btnDelete;
        private TodoEntitie todoEntitie = null;

        public ViewHolder(View view, TodoListEntitie model) {
            super(view);

            title = (TextView) view.findViewById(R.id.todoTitle);
            description = (TextView) view.findViewById(R.id.todoDescription);
            date = (TextView) view.findViewById(R.id.todoDate);
            checkBox = (CheckBox) view.findViewById(R.id.todoCheckBox);
            btnDelete = (Button) view.findViewById(R.id.btnDelete);

            checkBox.setOnClickListener(new View.OnClickListener() {
                private TodoListEntitie model;

                @Override
                public void onClick(View view) {
                    boolean checked = ((CheckBox) view).isChecked();

                    if (todoEntitie != null)
                        this.model.setTodoDone(todoEntitie, checked);
                }

                public View.OnClickListener init(TodoListEntitie model) {
                    this.model = model;

                    return this;
                }
            }.init(model));


            btnDelete.setOnClickListener(new View.OnClickListener() {
                private TodoListEntitie model;

                @Override
                public void onClick(View view) {
                    if (todoEntitie != null)
                        this.model.removeTodo(todoEntitie);
                }

                public View.OnClickListener init(TodoListEntitie model) {
                    this.model = model;

                    return this;
                }
            }.init(model));
        }

        public TextView getTitleTextView() { return title; }
        public TextView getDescriptionTextView() {
            return description;
        }
        public TextView getDateTextView() {
            return date;
        }
        public CheckBox getCheckBox() {
            return checkBox;
        }
        public void setTask(TodoEntitie todoEntitie) {
            this.todoEntitie = todoEntitie;
        }
    }

    private final List<TodoEntitie> todoEntitieList;

    public TodoListAdapter(List<TodoEntitie> todoEntitieList) {
        this.todoEntitieList = todoEntitieList;
    }

    @Override
    public int getItemCount() {
        return todoEntitieList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.detailtodo, viewGroup, false);

        return new ViewHolder(view, new TodoListEntitie().setAdapter(this));
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTitleTextView().setText(todoEntitieList.get(position).getTitle());
        viewHolder.getDescriptionTextView().setText(todoEntitieList.get(position).getDescription());

        SimpleDateFormat formater =  new SimpleDateFormat("dd-mm-yyyy");
        String dateformater = formater.format(todoEntitieList.get(position).getDate().getTime());

        viewHolder.getDateTextView().setText(dateformater);
        viewHolder.getCheckBox().setChecked(todoEntitieList.get(position).isDone());
        viewHolder.setTask(todoEntitieList.get(position));
    }
}
