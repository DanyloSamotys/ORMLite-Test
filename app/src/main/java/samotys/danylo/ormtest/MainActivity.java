package samotys.danylo.ormtest;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import samotys.danylo.ormtest.data.Repo;
import samotys.danylo.ormtest.model.Data;


public class MainActivity extends Activity implements View.OnClickListener {

    @InjectView(R.id.input)
    EditText mEditText;
    @InjectView(R.id.textView)
    TextView mText;
    @InjectView(R.id.write)
    Button mButtonWrite;
    @InjectView(R.id.read)
    Button mButtonRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mButtonRead.setOnClickListener(this);
        mButtonWrite.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Repo repo = new Repo(MainActivity.this);
        int i = 0;
        switch (v.getId()) {
            case R.id.write:
                String dataString = mEditText.getText().toString();
                Data data = new Data(dataString);
                data.save(repo);
                mText.setText(data.getData());
                i++;
                break;
            case R.id.read:
                mText.setText(repo.Data.getByData(mEditText.getText().toString()).getId() + "");
                break;
        }
    }

}
