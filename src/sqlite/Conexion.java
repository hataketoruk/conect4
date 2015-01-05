package sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper{
	String sql = "CREATE TABLE jugador(id INTEGER PRIMARY KEY AUTOINCREMENT , nombre TEXT, jugador TEXT)";
	public Conexion(Context context, String name, CursorFactory factory, int version){
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(sql);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	
		
	}
	public void InsertarJugador(SQLiteDatabase db, String nombre, String jugador){
		SQLiteStatement pst = db.compileStatement("INSERT INTO jugador(nombre,jugador)values(?,?)");
		pst.bindString(1, nombre);
		pst.bindString(2, jugador);
		pst.execute();
		
		
	}
	
}








