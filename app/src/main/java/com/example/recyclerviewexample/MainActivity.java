package com.example.recyclerviewexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText contentEdit, titleEdit;
    Button addBtn;
    ArrayList<Item> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        titleEdit = findViewById(R.id.titleInput);
        contentEdit = findViewById(R.id.contentInput);
        addBtn = findViewById(R.id.addBtn);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(),
                new LinearLayoutManager(getApplicationContext()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerAdapter adapter = new RecyclerAdapter(datas);

        adapter.setOnRecyclerItemClickListener(new RecyclerAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("아이템 삭제");
                builder.setMessage("삭제하시겠습니까?");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        datas.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        recyclerView.setAdapter(adapter);

        addBtn.setOnClickListener(v->{
            String content, title;
            title = titleEdit.getText().toString();
            content = contentEdit.getText().toString();

            Item item = new Item(title, content);
            datas.add(item);

            adapter.notifyDataSetChanged();
        });
        adapter.notifyDataSetChanged();
    }
}