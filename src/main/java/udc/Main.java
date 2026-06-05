package udc;

import udc.modelo.PasajeroEmbarque;
import udc.servicio.GestorAeropuerto;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestorAeropuerto gestor = new GestorAeropuerto();
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== SISTEMA AEROPUERTO - UNIDAD 3 =====");
            System.out.println("1. Registrar pasajero");
            System.out.println("2. Ver todos los pasajeros registrados");
            System.out.println("3. Ver pasajeros pendientes");
            System.out.println("4. Procesar siguiente pasajero");
            System.out.println("5. Ver historial de procesados");
            System.out.println("6. Buscar pasajero por codigo usando Map");
            System.out.println("7. Buscar pasajero por nombre usando Stream");
            System.out.println("8. Filtrar pasajeros por estado usando Stream");
            System.out.println("9. Ordenar pasajeros usando Stream");
            System.out.println("10. Ver estadisticas usando Stream y Map");
            System.out.println("11. Ver agrupamientos usando Stream y Map");
            System.out.println("12. Cancelar pasajero pendiente");
            System.out.println("13. Deshacer ultimo procesamiento");
            System.out.println("14. Ver cantidad de pasajeros");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Codigo de reserva: ");
                    String codigo = teclado.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Destino: ");
                    String destino = teclado.nextLine();

                    System.out.print("Aerolinea: ");
                    String aerolinea = teclado.nextLine();

                    PasajeroEmbarque pasajero = new PasajeroEmbarque(
                            codigo, nombre, destino, aerolinea, "PENDIENTE"
                    );

                    gestor.registrarPasajero(pasajero);

                    System.out.println("Pasajero registrado correctamente.");
                    break;
                case 2:
                    gestor.obtenerPasajeros()
                            .forEach(System.out::println);
                    break;
                case 3:
                    gestor.obtenerPendientes()
                            .forEach(System.out::println);

                    System.out.println(
                            "Total pendientes: "
                                    + gestor.totalPendientes()
                    );
                    break;
                case 4:
                    gestor.procesarSiguientePasajero();

                    System.out.println(
                            "Pasajero procesado correctamente."
                    );
                    break;
                case 5:
                    gestor.obtenerHistorial()
                            .forEach(System.out::println);

                    System.out.println(
                            "Total procesados: "
                                    + gestor.totalProcesados()
                    );
                    break;
                case 6:
                    System.out.print("Codigo de reserva: ");
                    String codigoBuscar = teclado.nextLine();

                    PasajeroEmbarque encontrado =
                            gestor.buscarPorCodigo(codigoBuscar);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Pasajero no encontrado.");
                    }
                    break;
                case 7:
                    System.out.print("Nombre: ");
                    String nombreBuscar = teclado.nextLine();

                    PasajeroEmbarque pasajeroNombre =
                            gestor.buscarPorNombre(nombreBuscar);

                    if (pasajeroNombre != null) {
                        System.out.println(pasajeroNombre);
                    } else {
                        System.out.println("Pasajero no encontrado.");
                    }
                    break;
                case 8:
                    System.out.print("Estado: ");
                    String estado = teclado.nextLine();

                    gestor.filtrarPorEstado(estado)
                            .forEach(System.out::println);
                    break;
                case 9:
                    gestor.ordenarPorNombre()
                            .forEach(System.out::println);
                    break;
                case 10:
                    System.out.println("=== ESTADISTICAS POR ESTADO ===");
                    System.out.println(gestor.obtenerEstadisticasPorEstado());
                    break;
                case 11:
                    System.out.println(
                            gestor.agruparPorAerolinea()
                    );

                    break;
                case 12:
                    System.out.print("Codigo de reserva: ");
                    String codigoCancelar = teclado.nextLine();

                    gestor.cancelarPasajero(codigoCancelar);

                    System.out.println("Pasajero cancelado.");
                    break;
                case 13:
                    gestor.deshacerUltimoProcesamiento();

                    System.out.println(
                            "Ultimo procesamiento deshecho."
                    );
                    break;
                case 14:
                    System.out.println("Total pasajeros: " + gestor.totalPasajeros());
                    System.out.println("Total pendientes: " + gestor.totalPendientes());
                    System.out.println("Total procesados: " + gestor.totalProcesados());
                    System.out.println("Total en Map: " + gestor.totalRegistradosMap());
                    break;
                case 15:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 15);

        teclado.close();
    }
}