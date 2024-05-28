package moviles2.mi_aplicacion_2.data;

import android.content.ContentValues;
import android.database.Cursor;
import moviles2.mi_aplicacion_2.data.HuspedContract.HuespedEntry;
import moviles2.mi_aplicacion_2.data.TelefonoContract.TelefonoEntry;

public class Telefono {
    private long cedula;
    private long telefono;

    public Telefono(long nombre, long telefono) {
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put( HuespedEntry.col_nombre, cedula);
        values.put( TelefonoEntry.col_telefono, telefono);
        return values;
    }

    public Telefono(Cursor cursor){
        this.cedula = cursor.getLong( cursor.getColumnIndex( HuespedEntry.col_nombre ) );
        this.telefono = cursor.getLong( cursor.getColumnIndex( TelefonoEntry.col_telefono ) );
    }
    public long getUsuario() {
        return cedula;
    }

    public long getTelefono() {
        return telefono;
    }
}
