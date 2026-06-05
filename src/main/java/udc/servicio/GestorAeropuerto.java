package udc.servicio;

import udc.modelo.PasajeroEmbarque;
import java.util.*;

public class GestorAeropuerto {
    private List<PasajeroEmbarque> pasajeros;
    private Queue<PasajeroEmbarque> pendientes;
    private Deque<PasajeroEmbarque> historial;
    private Map<String, PasajeroEmbarque> indicePorCodigo;

    public GestorAeropuerto() {
        pasajeros = new ArrayList<>();
        pendientes = new LinkedList<>();
        historial = new ArrayDeque<>();
        indicePorCodigo = new HashMap<>();
    }

    public void registrarPasajero(PasajeroEmbarque pasajero) {

        if (indicePorCodigo.containsKey(
                pasajero.getCodigoReserva())) {

            throw new IllegalArgumentException(
                    "Ya existe un pasajero con ese codigo."
            );
        }

        pasajeros.add(pasajero);

        pendientes.offer(pasajero);

        indicePorCodigo.put(
                pasajero.getCodigoReserva(),
                pasajero
        );
    }

    public void procesarSiguientePasajero() {

        PasajeroEmbarque procesado = pendientes.poll();

        if (procesado == null) {
            throw new IllegalStateException(
                    "No hay pasajeros pendientes."
            );
        }

        procesado.setEstado("PROCESADO");

        historial.push(procesado);
    }

    public List<PasajeroEmbarque> obtenerPasajeros() {
        return pasajeros;
    }

    public Queue<PasajeroEmbarque> obtenerPendientes() {
        return pendientes;
    }

    public Deque<PasajeroEmbarque> obtenerHistorial() {
        return historial;
    }
}
