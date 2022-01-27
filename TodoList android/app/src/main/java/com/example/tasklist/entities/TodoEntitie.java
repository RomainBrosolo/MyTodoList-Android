package com.example.tasklist.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TodoEntitie implements Serializable {

    private String title;
    private String description;
    private Date date;
    private boolean isDone = false;

    public TodoEntitie(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoEntitie todoEntitie = (TodoEntitie) o;
        return isDone == todoEntitie.isDone && Objects.equals(title, todoEntitie.title) && Objects.equals(description, todoEntitie.description)&& Objects.equals(date, todoEntitie.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, date, isDone);
    }
    public Date getDate() {
        return date;
    }
    public boolean isDone() {
        return isDone;
    }
    public void setDone() {
        isDone = true;
    }
    public void setUndone() {
        isDone = false;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
}
