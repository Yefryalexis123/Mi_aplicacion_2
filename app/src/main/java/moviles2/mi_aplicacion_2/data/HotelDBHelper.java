package moviles2.mi_aplicacion_2.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Build;
import moviles2.mi_aplicacion_2.data.TelefonoContract.TelefonoEntry;
import moviles2.mi_aplicacion_2.data.SpaContract.SpaEntry;

import androidx.annotation.Nullable;

import moviles2.mi_aplicacion_2.data.HuspedContract.HuespedEntry;
public class HotelDBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "hotel";
    private static final int DATABASE_VERSION = 1;
    public HotelDBHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ HuespedEntry.TABLE_NAME + " (" +
                HuespedEntry.col_cedula+" NUMERIC PRIMARY KEY, " +
                HuespedEntry.col_nombre+" TEXT NOT NULL, " +
                HuespedEntry.col_email+" TEXT NOT NULL, " +
                HuespedEntry.col_nacionalidad+" TEXT NOT NULL, " +
                HuespedEntry.col_password+" TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TelefonoEntry.TABLE_NAME + "("+
                HuespedEntry.col_cedula+" NUMERIC NOT NULL PRIMARY KEY, " +
                TelefonoEntry.col_telefono+ " NUMERIC(12,0) NOT NULL PRIMARY KEY,"+
                "PRIMARY KEY("+HuespedEntry.col_cedula+","+TelefonoEntry.col_telefono+"),"+
                "FOREIGN KEY ("+HuespedEntry.col_cedula+") " +
                "REFERENCES "+ HuespedEntry.TABLE_NAME + "("+ HuespedEntry.col_cedula+") " +
                "ON DELETE CASCADE)");

        sqLiteDatabase.execSQL(" CREATE TABLE " + SpaEntry.TABLE_NAME + "("+
                SpaEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                SpaEntry.col_nombre_husped + " TEXT NOT NULL, "+
                HuespedEntry.col_cedula + "NUMERIC NOT NULL,"+
                SpaEntry.col_fecha + " DATE NOT NULL, "+
                SpaEntry.col_tratamiento + " TEXT NOT NULL, " +
                SpaEntry.col_email + " TEXT NOT NULL," +
                TelefonoEntry.col_telefono + "NUMERIC NOT NULL,"+

                "FOREIGN KEY (" + HuespedEntry.col_cedula + ")" +
                "REFERENCES " +HuespedEntry.TABLE_NAME + "(" +HuespedEntry.col_cedula + ")," +

                "FOREIGN KEY (" + HuespedEntry.col_cedula + ")" +
                "REFERENCES " + TelefonoEntry.TABLE_NAME + "(" +TelefonoEntry.col_cedula+"), " +

                "FOREIGN KEY (" + TelefonoEntry.col_telefono + ")" +
                "REFERENCES " +TelefonoEntry.TABLE_NAME + "(" +TelefonoEntry.col_telefono + ")" +
                "ON DELETE CASCADE)");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
                db.setForeignKeyConstraintsEnabled(true);
            }else{
                db.execSQL(" PRAGMA foreign_keys=ON");
            }
        }
    }

    public long saveHuesped(Huesped huesped, Telefono telefono) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert(
                HuespedEntry.TABLE_NAME,
                null,
                huesped.toContentValues());
        return saveTelefono( telefono );
    }

    public long saveTelefono(Telefono telefono){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(
                TelefonoEntry.TABLE_NAME,
                null,
                telefono.toContentValues());
    }

    public Cursor getTodosHuesped() {
        return getReadableDatabase()
                .query(
                        HuespedEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getUsuarioTelefono(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        String tables = HuespedEntry.TABLE_NAME+" INNER JOIN "+TelefonoEntry.TABLE_NAME+
                " on "+HuespedEntry.TABLE_NAME+"."+HuespedEntry.col_nombre+" = "+TelefonoEntry.TABLE_NAME+"."+HuespedEntry.col_nombre;
        builder.setTables( tables);
        //String columnas[] = new String["user","name","tel"];
        //return builder.query( db, columnas,null,null,null,null,null );
        return builder.query( db, null,null,null,null,null,null );
    }

    public Cursor getHuespedByUser(String user) {
        Cursor c = getReadableDatabase().query(
                HuespedEntry.TABLE_NAME,
                null,
                HuespedEntry.col_nombre + " LIKE ?",
                new String[]{user},
                null,
                null,
                null);
        return c;
    }

    public Cursor getHuespedByUser(String user, String password) {
        Cursor c = getReadableDatabase().query(
                HuespedEntry.TABLE_NAME,
                null,
                HuespedEntry.col_nombre + " LIKE ? AND "+HuespedEntry.col_password + " LIKE ?",
                new String[]{user,password},
                null,
                null,
                null);
        return c;
    }
    public int deleteHuesped(String user) {
        return getWritableDatabase().delete(
                HuespedEntry.TABLE_NAME,
                HuespedEntry.col_nombre + " LIKE ?",
                new String[]{user});
    }

    public int updateHuesped(Huesped huesped, String user) {
        return getWritableDatabase().update(
                HuespedEntry.TABLE_NAME,
                huesped.toContentValues(),
                HuespedEntry.col_nombre + " LIKE ?",
                new String[]{user}
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
