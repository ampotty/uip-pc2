// https://github.com/ampotty/uip-pc2/Ejemplos/OOP

package no.tengo.naa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int opcion = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Articulo> inventario = new ArrayList<>();
        inventario.add(new Articulo("1", "Papel", 0.05, 0.10, 50));
        inventario.add(new Articulo("2", "Piedra", 2.50, 0.01, 2));

        while (opcion != 4) {
            System.out.println("\n\n¡Bienvenido a No Tengo Naa!");
            System.out.println("SISTEMA DE INVENTARIO - MENÚ");
            System.out.println("1. Consultar\n2. Añadir\n3. Borrar\n4. Salir");
            System.out.print("OPCION: ");
            try {
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("DATA BASURA");
            } catch (Exception e) {
                System.out.println("ERROR DESCONOCIDO");
            }

            switch (opcion) {
                case 1:
                    String b = "";
                    boolean encontrado = false;
                    if (inventario.size() == 0) {
                        System.out.println("No hay articulos en el inventario.");
                    } else {
                        do {
                            try {
                                System.out.print("ID: ");
                                b = br.readLine();
                            } catch (Exception e) {
                                System.out.println("ID inválido. Intente nuevamente");
                            }
                        } while (b.equals("") || b.equals(" ") || b.equals("-"));
                        for (Articulo a : inventario) {
                            if (b.equals(a.getId())) {
                                encontrado = true;
                                System.out.println("Encontré el artículo");
                                System.out.println("ID = " + a.getId());
                                System.out.println("Nombre = " + a.getNombre());
                                System.out.println("Peso = " + a.getPeso());
                                System.out.println("Precio Unitario = $" + a.getPrecioUnitario());
                                System.out.println("Cantidad = " + a.getCantidad());
                            }
                        }
                        if (encontrado == false) {
                            System.out.println("Mala suerte lapecillo");
                        }
                    }
                    break;
                case 2:
                    String i = "", n = "";
                    double p = 0.0, pu = 0.0;
                    int c = 0;
                    do {
                        try {
                            System.out.print("ID: ");
                            i = br.readLine();
                        } catch (Exception e) {
                            System.out.println("ID inválido. Intente nuevamente");
                        }
                    } while (i.equals("") || i.equals(" ") || i.equals("-"));
                    do {
                        try {
                            System.out.print("Nombre: ");
                            n = br.readLine();
                        } catch (Exception e) {
                            System.out.println("Nombre inválido. Intente nuevamente");
                        }
                    } while (i.equals("") || i.equals(" ") || i.equals("-"));
                    do {
                        try {
                            System.out.print("Peso: ");
                            p = Double.parseDouble(br.readLine());
                        } catch (Exception e) {
                            System.out.println("Peso inválido. Intente nuevamente");
                        }
                    } while (p <= 0);
                    do {
                        try {
                            System.out.print("Precio Unitario: ");
                            pu = Double.parseDouble(br.readLine());
                        } catch (Exception e) {
                            System.out.println("Precio unitario inválido. Intente nuevamente");
                        }
                    } while (pu <= 0);
                    do {
                        try {
                            System.out.print("Cantidad: ");
                            c = Integer.parseInt(br.readLine());
                        } catch (Exception e) {
                            System.out.println("Cantidad inválida. Intente nuevamente");
                        }
                    } while (c <= 0);
                    Articulo a = new Articulo(i, n, p, pu, c);
                    inventario.add(a);
                    break;
                case 3:
                    b = "";
                    encontrado = false;
                    if (inventario.size() == 0) {
                        System.out.println("No hay articulos en el inventario.");
                    } else {
                        System.out.println("Lista de Articulos");
                        for (Articulo x : inventario) {
                            System.out.println(x.getId() + " - " + x.getNombre());
                        }
                        do {
                            try {
                                System.out.print("ID del articulo a borrar: ");
                                b = br.readLine();
                            } catch (Exception e) {
                                System.out.println("ID inválido. Intente nuevamente");
                            }
                        } while (b.equals("") || b.equals(" ") || b.equals("-"));
                        for (Articulo x : inventario) {
                            if (b.equals(x.getId())) {
                                encontrado = true;
                                inventario.remove(x);
                            }
                        }
                        if (encontrado == false) {
                            System.out.println("Mala suerte lapecillo");
                        }
                    }
                    break;
                case 4:
                    System.out.print("¡Hasta luego!");
                    break;
                default:
                    System.out.println("ERROR :: Opción inválida.");
                    break;
            }
        }

        System.out.println("Vamos pa lante!");
    }
}











