package moviles2.mi_aplicacion_2.data;

public class Spa {
    private long cedula;
    private String nombre_huesped;
    private String fecha_reserva;
    private String tipo_tratamiento;
    private int duracion_tratamiento;
    private String email_huesped;
    private long telefono;

    public Spa(long cedula, String nombre_huesped, String fecha_reserva, String tipo_tratamiento, int duracion_tratamiento, String email_huesped, long telefono) {
        this.cedula = cedula;
        this.nombre_huesped = nombre_huesped;
        this.fecha_reserva = fecha_reserva;
        this.tipo_tratamiento = tipo_tratamiento;
        this.duracion_tratamiento = duracion_tratamiento;
        this.email_huesped = email_huesped;
        this.telefono  = telefono;
    }

    public long getCedula(){
        return cedula;
    }
    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public String getTipo_tratamiento() {
        return tipo_tratamiento;
    }

    public int getDuracion_tratamiento() {
        return duracion_tratamiento;
    }

    public String getEmail_huesped() {
        return email_huesped;
    }

    public long getTelefono(){
        return telefono;
    }
}
