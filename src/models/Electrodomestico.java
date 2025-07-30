package models;

public class Electrodomestico {

    //Valores constantes los cuales rigen el problema
    private final String COLOR = "Blanco";
    private final char CONSUMO_ENERGETICO = 'F';
    private final int PRECIO_BASE = 100;
    private final int PESO = 5;
    protected int precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected int peso;

    //Inicio de constructores
    public Electrodomestico() { //contructor
        this.precioBase = PRECIO_BASE;
        this.color = COLOR;
        this.consumoEnergetico = CONSUMO_ENERGETICO;
        this.peso = PESO;
    }

    public Electrodomestico(int precioBase, int peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = COLOR;
        this.consumoEnergetico = CONSUMO_ENERGETICO;

    }

    public Electrodomestico(int precioBase, int peso, String color, char consumoEnergetico) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);

    }

    //METODOS

    public int getPrecioBase() {
        return precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public int getPeso() {
        return peso;
    }

    private char comprobarConsumoEnergetico(char letra) {
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F'};
        boolean flag = false;

        for (int i = 0; i < letras.length && !flag; i++) {
            if (letras[i] == letra) {
                flag = true;

            }
        }
        return (flag) ? letra : CONSUMO_ENERGETICO;

    }

    private String comprobarColor(String color) {
        String[] coloresValidos = {"blanco", "negro", "rojo", "azul", "gris"};
        for (String colorValido : coloresValidos) {
            if (colorValido.equalsIgnoreCase(color)) {
                return color; // Si lo encuentra, devuelve el color original
            }
        }
        return "Blanco"; // Si el bucle termina, es que no lo encontró
    }


    public int precioFinal() {
        int adicional = 0; // Cambiado a 'adicional' para mayor claridad
        switch (consumoEnergetico) {
            case 'A' -> adicional = 100;
            case 'B' -> adicional = 80;
            case 'C' -> adicional = 60;
            case 'D' -> adicional = 50;
            case 'E' -> adicional = 30;
            case 'F' -> adicional = 10;
        }
        if (this.peso >= 0 && this.peso < 20) {
            adicional += 10;
        } else if (this.peso >= 20 && this.peso < 50) {
            adicional += 50;
        } else if (this.peso >= 50 && this.peso < 80) {
            adicional += 80;
        } else if (this.peso >= 80) {
            adicional += 100;
        }
        // La corrección clave: sumar el costo adicional al precio base.
        return this.precioBase + adicional;
    }

}




