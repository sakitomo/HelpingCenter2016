package lasalle2016studentproject.helpingcenter2016.DataManagement;

import android.content.Context;
import android.database.Cursor;

import java.sql.SQLException;
import java.util.ArrayList;

import lasalle2016studentproject.helpingcenter2016.BasisClasses.HelpService;
import lasalle2016studentproject.helpingcenter2016.BasisClasses.OfficeHour;

/**
 * Created by sakitomo on 2016/02/26.
 */
public class DataManager {

    public static ArrayList<OfficeHour> listOfHours = new  ArrayList<>();
    private static DatabaseHelper dbHelper;

    public static void openConnection(Context context) {
        dbHelper = new DatabaseHelper(context);

        try {
            dbHelper.checkAndCopyDatabase();
            dbHelper.openDatabase();
        } catch (SQLException e) {

        }
    }

    public static HelpService loadHelpService(int serviceId)
    {
        try {
            Cursor cursor = dbHelper.QueryData("SELECT Service_Name,Desc FROM Helpservice where Service_Id = " + serviceId);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    String name = cursor.getString(0);
                    String desc = cursor.getString(1);
                    return new HelpService(serviceId, name, desc);
                }
            }
        } catch (SQLException e) {}

        return null;
    }

    public static ArrayList<OfficeHour> loadServiceHours(int serviceId)
    {
        ArrayList<OfficeHour> listOfOHs = new ArrayList<>();

        try {
            Cursor cursor = dbHelper.QueryData("SELECT * FROM Officehour where Service_Id = " + serviceId);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        int id = Integer.valueOf(cursor.getString(0));
                        String name = cursor.getString(1);
                        int day = cursor.getInt(2);
                        int start = cursor.getInt(3);
                        int end = cursor.getInt(4);

                        listOfOHs.add(new OfficeHour(id, name, day, start, end, serviceId));
                    } while (cursor.moveToNext());
                }
            }
        } catch (SQLException e) {}

        return listOfOHs;
    }
}
