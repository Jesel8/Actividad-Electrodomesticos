import models.Electrodomestico;
import models.Lavadora;
import models.Television;

public class Main {

    public static void main(String[] args) {

        // Creamos el array de Electrodomesticos con 10 posiciones.
        Electrodomestico[] electrodomesticos = new Electrodomestico[10];

        // Asignamos objetos que queremos de cada clase al array con valores variados.
        electrodomesticos[0] = new Electrodomestico(200, 15, "rojo", 'C');
        electrodomesticos[1] = new Lavadora(450, 40); // Carga por defecto
        electrodomesticos[2] = new Television(800, 25, "negro", 'B', 55, true); // TV de más de 40" con TDT
        electrodomesticos[3] = new Electrodomestico(); // Por defecto
        electrodomesticos[4] = new Lavadora(600, 85, "gris", 'A', 40); // Lavadora de carga grande
        electrodomesticos[5] = new Television(250, 10); // TV por defecto
        electrodomesticos[6] = new Electrodomestico(150, 30, "azul", 'D');
        electrodomesticos[7] = new Lavadora(300, 25, "blanco", 'E', 20); // Carga pequeña
        electrodomesticos[8] = new Television(1200, 35, "negro", 'A', 80, true); // TV muy grande con TDT
        electrodomesticos[9] = new Electrodomestico(50, 2, "rojo", 'F');

        // Inicializamos las variables para guardar las sumas de los precios.
        double sumaElectrodomesticos = 0;
        double sumaLavadoras = 0;
        double sumaTelevisiones = 0;

        // Anadimos un encabezado para la lista de precios individuales
        System.out.println("--- Desglose de precios individuales ---");

        // Recorremos el array para calcular los precios.
        for (int i = 0; i < electrodomesticos.length; i++) {

            Electrodomestico e = electrodomesticos[i];
            double precioFinal = e.precioFinal();

            // Usamos 'instanceof' para identificar el tipo de objeto Y MOSTRAR SU PRECIO.
            if (e instanceof Lavadora) {
                System.out.println("Item " + (i + 1) + " (Lavadora): " + precioFinal + " €");
                sumaLavadoras += precioFinal;
            } else if (e instanceof Television) {
                System.out.println("Item " + (i + 1) + " (Televisión): " + precioFinal + " €");
                sumaTelevisiones += precioFinal;
            }
            // Este 'else' es para los objetos que son solo 'Electrodomestico' y no una subclase.
            else {
                System.out.println("Item " + (i + 1) + " (Electrodoméstico): " + precioFinal + " €");
            }

            // La suma total de Electrodomesticos siempre se realiza.
            sumaElectrodomesticos += precioFinal;
        }

        // Mostramos los resultados finales por consola.
        System.out.println("\n--- Resumen total de precios ---");
        System.out.println("Suma del precio de todas las Lavadoras: " + sumaLavadoras + " €");
        System.out.println("Suma del precio de todas las Televisiones: " + sumaTelevisiones + " €");
        System.out.println("-------------------------------------------------");
        System.out.println("Suma total de TODOS los Electrodomésticos: " + sumaElectrodomesticos + " €");
    }
}