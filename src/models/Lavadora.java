package models;


//La clase Lavadora es una subclase de Electrodomestico. En la cual vamos a agregar la funcionalidad específica de la carga de la lavadora.

public class Lavadora extends Electrodomestico {

    // Constante para el valor por defecto de la carga.
    private static final int CARGA_POR_DEFECTO = 5;

    // Atributo propio de la clase Lavadora. El cual es privado para mantener la encapsulación.
    private int carga;

    //  CONSTRUCTORES

    public Lavadora(int precioBase, int peso, String color, char consumoEnergetico, int carga) {
        super(precioBase, peso, color, consumoEnergetico);
        this.carga = carga;
    }


    public Lavadora(int precioBase, int peso) {
        super(precioBase, peso);
        this.carga = CARGA_POR_DEFECTO;
    }


    public Lavadora() {
        super();
        this.carga = CARGA_POR_DEFECTO;
    }


    // MÉTODOS

    public int getCarga() {
        return carga;
    }

    @Override
    public int precioFinal() {
        // 1. Obtenemos el precio base + aumentos por consumo y peso llamando al metodo padre.
        int precioFinalPadre = super.precioFinal();

        // 2. Aplicamos la regla específica de la lavadora.
        if (this.carga > 30) {
            precioFinalPadre += 50;
        }

        // 3. Devolvemos el precio total final.
        return precioFinalPadre;
    }
}