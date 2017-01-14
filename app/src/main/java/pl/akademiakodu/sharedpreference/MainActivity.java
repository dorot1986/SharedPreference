package pl.akademiakodu.sharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.button)
            Button button;
    @BindView(R.id.buttonSave)
            Button buttonSave;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        preferences = getSharedPreferences("loginData", Activity.MODE_PRIVATE);
    }

    private void saveData(){
        SharedPreferences.Editor editor = preferences.edit();
        //editor.remove(); - usuwamy dany klucz
        editor.putString("login", "oskaraka");
        editor.putString("password", "mojeHaslo");
        //editor.apply(); - zapisanie danych do tła
        editor.commit(); // zapisuje dane na dysku

    }

    private void loadData(){
        String login = preferences.getString("login", "BrakLoginu");
        String password = preferences.getString("password", "BrakHasla");
        Log.e("debug", login + ": " + password);
    }

    @OnClick(R.id.button)
    public void onClickLoad (){
        loadData();
    }

    @OnClick(R.id.buttonSave)
    public void onClickSave(){
        saveData();
    }
}
