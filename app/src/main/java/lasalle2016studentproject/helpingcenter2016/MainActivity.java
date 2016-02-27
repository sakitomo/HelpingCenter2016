package lasalle2016studentproject.helpingcenter2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button[] arrBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrBtn = new Button[9];
        arrBtn[0] = (Button)findViewById(R.id.myBtn1);
        arrBtn[1] = (Button)findViewById(R.id.myBtn2);
        arrBtn[2] = (Button)findViewById(R.id.myBtn3);
        arrBtn[3] = (Button)findViewById(R.id.myBtn4);
        arrBtn[4] = (Button)findViewById(R.id.myBtn5);
        arrBtn[5] = (Button)findViewById(R.id.myBtn6);
        arrBtn[6] = (Button)findViewById(R.id.myBtn7);
        arrBtn[7] = (Button)findViewById(R.id.myBtn8);
        arrBtn[8] = (Button)findViewById(R.id.myBtn9);

        for (Button btn : arrBtn) {
            btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MySelectedCenter.class);
        int i = 0;

        for (Button btn : arrBtn) {
            ++i;
            if (btn.getId() == v.getId()) {
                intent.putExtra("serviceId", i);
                break;
            }
        }

        startActivity(intent);
    }
}
