package moviles2.mi_aplicacion_2.data;

import android.provider.BaseColumns;

public class TelefonoContract {
    public static abstract class TelefonoEntry implements BaseColumns {
        public static final String TABLE_NAME = "telefono";
        public static final String col_cedula = "cedula";
        public static final String col_telefono = "telefono";
    }
}
