package moviles2.mi_aplicacion_2.data;

public class TelefonoSpa {
    private String nombre_huesped;
    private String numero_telefonico;

    public TelefonoSpa(String nombre_huesped, String numero_telefonico) {
        this.nombre_huesped = nombre_huesped;
        this.numero_telefonico = numero_telefonico;
    }

    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public String getNumero_telefonico() {
        return numero_telefonico;
    }
}
