package moviles2.mi_aplicacion_2.data;

import android.provider.BaseColumns;

public class HuspedContract {
    public static abstract class HuespedEntry implements BaseColumns {
        public static final String TABLE_NAME = "huesped";
        public static final String col_cedula = "cedula";
        public static final String col_nombre = "name";
        public static final String col_email = "email";
        public static final String col_nacionalidad = "nacionalidad";
        public static final String col_password = "password";
    }
}
