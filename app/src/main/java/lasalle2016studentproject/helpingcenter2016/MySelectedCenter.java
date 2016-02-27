package lasalle2016studentproject.helpingcenter2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import lasalle2016studentproject.helpingcenter2016.BasisClasses.HelpService;
import lasalle2016studentproject.helpingcenter2016.BasisClasses.OfficeHour;
import lasalle2016studentproject.helpingcenter2016.DataManagement.DataManager;

public class MySelectedCenter extends AppCompatActivity {

    public static String myTitle = "";
    private HelpService service;
    private ViewGroup vg;
    private TextView tvDesc;
    private ImageView ivLogo;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_selected_center);

        DataManager.openConnection(this);

        int serviceId = getIntent().getIntExtra("serviceId", 0);
        service = DataManager.loadHelpService(serviceId);

        myTitle = service.getServiceName();
        setTitle(myTitle);
        getSupportActionBar().setElevation(0);

        vg = (ViewGroup)findViewById(R.id.tl_bottom);
        tvDesc = (TextView)findViewById(R.id.tvDesc);
        tvDesc.setText(service.getDesc());
        ivLogo = (ImageView)findViewById(R.id.imgLogo);
        switch(serviceId){
            case 1:
                ivLogo.setImageResource(R.drawable.ic_help_black_36dp);
                break;
            case 2:
                ivLogo.setImageResource(R.drawable.ic_record_voice_over_black_48dp);
                break;
            case 3:
                ivLogo.setImageResource(R.drawable.ic_favorite_black_24dp);
                break;
            case 4:
                ivLogo.setImageResource(R.drawable.ic_local_hospital_black_48dp);
                break;
            case 5:
                ivLogo.setImageResource(R.drawable.ic_account_black);
                break;
            case 6:
                ivLogo.setImageResource(R.drawable.ic_frencht_black_48dp1);
                break;
            case 7:
                ivLogo.setImageResource(R.drawable.ic_english_black_48dp1);
                break;
            case 8:
                ivLogo.setImageResource(R.drawable.ic_english_black_48dp2);
                break;
            case 9:
                ivLogo.setImageResource(R.drawable.ic_frencht_black_48dp2);
                break;
        }

        displayTable(serviceId);
    }

    private void displayTable(int id) {
        ArrayList<OfficeHour> list = DataManager.loadServiceHours(id);
        String[] arrDay = {getString(R.string.day1), getString(R.string.day2), getString(R.string.day3), getString(R.string.day4), getString(R.string.day5)};

        int i = 0;

        if( id == 6 || id == 7){
            getLayoutInflater().inflate(R.layout.table_head_2cols, vg);
            for (OfficeHour hour : list) {
                getLayoutInflater().inflate(R.layout.table_row_2cols, vg);

                TableRow tr = (TableRow) vg.getChildAt(++i);
                ((TextView) (tr.getChildAt(0))).setText(arrDay[hour.getDay() - 1]);
                ((TextView) (tr.getChildAt(1))).setText(hour.getStartTime() + "-" + hour.getEndTime());
            }
        } else {
            getLayoutInflater().inflate(R.layout.table_head_3cols, vg);
            for (OfficeHour hour : list) {
                getLayoutInflater().inflate(R.layout.table_row_3cols, vg);

                TableRow tr = (TableRow) vg.getChildAt(++i);
                ((TextView) (tr.getChildAt(0))).setText(hour.getStaffName());
                ((TextView) (tr.getChildAt(1))).setText(arrDay[hour.getDay() - 1]);
                ((TextView) (tr.getChildAt(2))).setText(hour.getStartTime() + "-" + hour.getEndTime());
            }
        }
    }
}
