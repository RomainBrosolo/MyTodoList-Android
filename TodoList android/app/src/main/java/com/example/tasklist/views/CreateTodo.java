package com.example.tasklist.views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tasklist.R;
import com.example.tasklist.entities.TodoEntitie;
import com.example.tasklist.entities.TodoListEntitie;

import java.util.Calendar;
import java.util.Date;

public class CreateTodo extends Fragment {
    private DatePicker datePicker;
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Button btnSubmit;
    private Button btnReset;
    private TodoListEntitie viewModel;

    public CreateTodo() {
        // Required empty public constructor
        viewModel = new TodoListEntitie();
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container ,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.createtodo_layout, container , false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        this.datePicker = (DatePicker) getView().findViewById(R.id.datePicker);
        this.editTextTitle = (EditText) getView().findViewById(R.id.editTextTitle);
        this.editTextDescription = (EditText) getView().findViewById(R.id.editTextDescription);
        this.btnSubmit = (Button) getView().findViewById(R.id.btnAdd);
        this.btnReset = (Button) getView().findViewById(R.id.btnReset);

        this.btnSubmit.setOnClickListener(new View.OnClickListener() {
            private CreateTodo createTodo;

            @Override
            public void onClick(View view) {
                createTodo.createTask();
                Toast.makeText(getContext(), "Todo '" + editTextTitle.getText().toString() + "' added to list !", Toast.LENGTH_LONG).show();
            }

            public View.OnClickListener init(CreateTodo createTodo) {
                this.createTodo = createTodo;

                return this;
            }
        }.init(this));

        this.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextTitle.setText("");
                editTextDescription.setText("");
            }
        });
    }


    public void createTask() {
        Date date = CalendarDatePicker().getTime();
        String title = this.editTextTitle.getText().toString();
        String description = this.editTextDescription.getText().toString();


        this.viewModel.addTodo(new TodoEntitie(title, description, date));
    }

    private Calendar CalendarDatePicker() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar;
    }
}
