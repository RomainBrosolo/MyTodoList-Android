package com.example.tasklist.adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tasklist.views.Calendar;
import com.example.tasklist.views.CreateTodo;
import com.example.tasklist.views.TodoList;

public class TabbedLayout extends FragmentPagerAdapter {

    Context Context;
    int count_tab;

    public TabbedLayout(Context context , FragmentManager fragmentManager , int tabs) {
        super(fragmentManager);
        count_tab = tabs;
        Context = context;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TodoList();
            case 1:
                return new CreateTodo();
            case 2:
                return new Calendar();
            default:
                return new TodoList();

        }
    }

    @Override
    public int getCount() {
        return count_tab;
    }
}
