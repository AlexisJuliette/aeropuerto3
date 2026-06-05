package udc;

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
                    System.out.println("Registro en desarrollo...");
                    break;
                case 2:
                    gestor.obtenerPasajeros().forEach(System.out::println);
                    break;
                case 3:
                    gestor.obtenerPendientes().forEach(System.out::println);
                    break;
                case 4:
                    gestor.procesarSiguientePasajero();
                    System.out.println("Pasajero procesado correctamente.");
                    break;
                case 5:
                    gestor.obtenerHistorial().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Busqueda Map en desarrollo...");
                    break;
                case 7:
                    System.out.println("Busqueda Stream en desarrollo...");
                    break;
                case 8:
                    System.out.println("Filtro Stream en desarrollo...");
                    break;
                case 9:
                    gestor.ordenarPorNombre().forEach(System.out::println);
                    break;
                case 10:
                    System.out.println(gestor.obtenerEstadisticasPorEstado());
                    break;
                case 11:
                    System.out.println(gestor.agruparPorAerolinea());
                    break;
                case 12:
                    System.out.println("Cancelacion en desarrollo...");
                    break;
                case 13:
                    gestor.deshacerUltimoProcesamiento();
                    System.out.println("Ultimo procesamiento deshecho.");
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