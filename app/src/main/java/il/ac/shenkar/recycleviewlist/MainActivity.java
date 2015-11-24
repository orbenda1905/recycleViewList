package il.ac.shenkar.recycleviewlist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends ActionBarActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private RecyclerView.LayoutManager layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);

        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                String title = data.getExtras().getString("title");
                String description = data.getExtras().getString("description");

                adapter.addTask(new Information(title, description));
            }
        }
    }

    public void createNewTask(View v) {
        Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
        startActivityForResult(intent, 1);
    }
}
