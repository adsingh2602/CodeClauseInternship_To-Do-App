package com.example.myapplication.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTodoItem;
    private Button btnAdd;
    private ListView todoList;
    private ArrayList<String> todoItems;
    private ArrayAdapter<String> todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        editTodoItem = findViewById(R.id.editTodoItem);
        btnAdd = findViewById(R.id.btnAdd);
        todoList = findViewById(R.id.todoList);

        // Initialize the ArrayList to store To-Do items
        todoItems = new ArrayList<>();

        // Initialize the ArrayAdapter with the todoItems list
        todoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoItems);

        // Set the ArrayAdapter to the ListView
        todoList.setAdapter(todoAdapter);

        // Add Button click listener to add new items to the list
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = editTodoItem.getText().toString().trim();
                if (!newItem.isEmpty()) {
                    todoItems.add(newItem);
                    todoAdapter.notifyDataSetChanged();
                    editTodoItem.setText("");
                }
            }
        });

        // Register the ListView for the context menu
        registerForContextMenu(todoList);
    }

    // Create the context menu for the ListView
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // Handle context menu item selection (Delete option)
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_delete) {
            // Get the selected item position
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            int position = info.position;
            // Remove the task from the ArrayList
            todoItems.remove(position);
            // Notify the adapter that the data has changed
            todoAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }
}


