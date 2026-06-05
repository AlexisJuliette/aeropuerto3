package udc.modelo;

public class PasajeroEmbarque {
    private String codigoReserva;
    private String nombre;
    private String destino;
    private String aerolinea;
    private String estado;

    public PasajeroEmbarque(String codigoReserva,String nombre,String destino,String aerolinea,String estado) {

        this.codigoReserva = codigoReserva;
        this.nombre = nombre;
        this.destino = destino;
        this.aerolinea = aerolinea;
        this.estado = estado;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
