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
}
