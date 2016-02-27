package lasalle2016studentproject.helpingcenter2016.DataManagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import lasalle2016studentproject.helpingcenter2016.BasisClasses.HelpService;

/**
 * Created by sakitomo on 2016/02/26.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_Path;
    private static String DB_Name = "helpcenter.sqlite";
    private SQLiteDatabase myDatabase;
    private final Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_Name, null, 1);
        this.myContext = context;
        DB_Path = context.getFilesDir().getPath();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private boolean checkDatabase() {
        SQLiteDatabase checkDB = null;

        try {
            checkDB = SQLiteDatabase.openDatabase(DB_Path + DB_Name, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {

        }

        if (checkDB != null) checkDB.close();
        return checkDB != null ? true : false;
    }

    private void copyDatabase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_Name);
        OutputStream myOutput = new FileOutputStream(DB_Path + DB_Name);
        byte[] buffer = new byte[1024];

        int length;
        while((length = myInput.read(buffer)) > 0){
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDatabase() throws SQLException {
        String myPath = DB_Path + DB_Name;
        myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void ExeSQLData(String sql) throws SQLException{
        myDatabase.execSQL(sql);
    }

    public Cursor QueryData(String query) throws SQLException{
        return myDatabase.rawQuery(query,null);
    }

    @Override
    public synchronized void close() {
        if (myDatabase != null)
            myDatabase.close();
        super.close();
    }

    public void checkAndCopyDatabase(){
        boolean dbExist = checkDatabase();
        if (dbExist) {
            Log.d("TAG", "Database already exist");
        }else{
            this.getReadableDatabase();
            try {
                copyDatabase();
            }catch (IOException e){
                Log.d("TAG","Error copying database");
            }
        }
    }

    public void Update(HelpService thisService, ContentValues myCv){
        this.myDatabase.update("HelpService", myCv, "Service_ID = " + thisService.getServiceId(), null);
    }

}
