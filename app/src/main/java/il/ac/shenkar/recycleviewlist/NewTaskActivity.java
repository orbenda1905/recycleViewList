package il.ac.shenkar.recycleviewlist;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewTaskActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
    }

    public void sendData(View v) {
        String title = ((EditText)findViewById(R.id.taskTitle)).getText().toString();
        String titleDescription = ((EditText)findViewById(R.id.taskDescription)).getText().toString();

        if (title == "") {
            Toast.makeText(NewTaskActivity.this, "Please enter a title", Toast.LENGTH_LONG).show();
        }
        else {
            Intent intent = new Intent();
            intent.putExtra("title", title);
            intent.putExtra("description", titleDescription);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
