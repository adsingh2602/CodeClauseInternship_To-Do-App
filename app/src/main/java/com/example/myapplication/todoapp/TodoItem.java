package com.example.myapplication.todoapp;

// TodoItem.java

public class TodoItem {
    private String taskName;
    private boolean isCompleted;

    public TodoItem(String taskName) {
        this.taskName = taskName;
        this.isCompleted = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
