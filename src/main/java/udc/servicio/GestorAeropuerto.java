package udc.servicio;

import udc.modelo.PasajeroEmbarque;
import java.util.*;
import java.util.stream.Collectors;

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

    public PasajeroEmbarque buscarPorCodigo(String codigoReserva) {

        return indicePorCodigo.get(codigoReserva);
    }

    public boolean existeCodigo(String codigoReserva) {
        return indicePorCodigo.containsKey(codigoReserva);
    }

    public PasajeroEmbarque buscarPorNombre(String nombre) {

        return pasajeros.stream()
                .filter(p -> p.getNombre()
                        .equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public List<PasajeroEmbarque> filtrarPorEstado(String estado) {

        return pasajeros.stream()
                .filter(p -> p.getEstado()
                        .equalsIgnoreCase(estado))
                .toList();
    }

    public List<PasajeroEmbarque> ordenarPorNombre() {

        return pasajeros.stream()
                .sorted(Comparator.comparing(
                        PasajeroEmbarque::getNombre))
                .toList();
    }

    public List<PasajeroEmbarque> ordenarPorCodigoDesc() {

        return pasajeros.stream()
                .sorted(Comparator.comparing(
                                PasajeroEmbarque::getCodigoReserva)
                        .reversed())
                .toList();
    }

    public Map<String, Long> obtenerEstadisticasPorEstado() {

        return pasajeros.stream()
                .collect(Collectors.groupingBy(
                        PasajeroEmbarque::getEstado,
                        Collectors.counting()
                ));
    }

    public Map<String, List<PasajeroEmbarque>> agruparPorAerolinea() {

        return pasajeros.stream()
                .collect(Collectors.groupingBy(
                        PasajeroEmbarque::getAerolinea
                ));
    }

    public void cancelarPasajero(String codigoReserva) {

        PasajeroEmbarque pasajero =
                indicePorCodigo.get(codigoReserva);

        if (pasajero == null) {
            throw new IllegalArgumentException(
                    "No existe el pasajero."
            );
        }

        if (!pasajero.getEstado()
                .equalsIgnoreCase("PENDIENTE")) {

            throw new IllegalStateException(
                    "Solo se pueden cancelar pasajeros pendientes."
            );
        }

        pasajero.setEstado("CANCELADO");

        pendientes.removeIf(
                p -> p.getCodigoReserva()
                        .equalsIgnoreCase(codigoReserva)
        );
    }

    public void deshacerUltimoProcesamiento() {

        PasajeroEmbarque ultimo = historial.pop();

        ultimo.setEstado("PENDIENTE");

        pendientes.offer(ultimo);
    }

    public int totalPasajeros() {
        return pasajeros.size();
    }

    public int totalPendientes() {
        return pendientes.size();
    }

    public int totalProcesados() {
        return historial.size();
    }

    public int totalRegistradosMap() {
        return indicePorCodigo.size();
    }
}
