package moviles2.mi_aplicacion_2.data;

import android.provider.BaseColumns;

public class SpaContract {
    public static abstract class SpaEntry implements BaseColumns{
        public static final String TABLE_NAME = "Spa";
        public static final String col_nombre_husped = "nombre";
        public static final String col_fecha = "fecha_reserva";
        public static final String col_tratamiento = "tratamiento";
        public static final String col_duracion = "duracion_tratamiento";
        public static final String col_email = "email";
    }
}
