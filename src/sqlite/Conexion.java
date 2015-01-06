package sqlite;

import android.content.ContentValues;
import com.example.conect4.DBhelper;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion {



	private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    
    public Conexion(Context c) {
        ourcontext = c;
    }

    public Conexion abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String name) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.JUGADOR_NOMBRE, name);
        database.insert(DBhelper.TABLE_MEMBER, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelper.JUGADOR_ID,
                DBhelper.JUGADOR_NOMBRE
        };
        Cursor c = database.query(DBhelper.TABLE_MEMBER, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }


}