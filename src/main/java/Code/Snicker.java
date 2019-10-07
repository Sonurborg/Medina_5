package Code;

import org.json.simple.JSONObject;

/**
 *
 * @author sonur
 */
public class Snicker {
    
    private String marca;
    private String modelo;
    private String color;
    
    /**
     * Objeto Snicker "Zapatilla", requiere de una marca,modelo y color para instanciarse.
     * @param marca String correspondiente a la marca de la zapatilla.
     * @param model String correspondiente al modelo de la zapatilla.
     * @param color String correspondiente al color de la zapatilla.
     */
    public Snicker(String marca, String model, String color){
        this.marca=marca;
        this.modelo=model;
        this.color=color;
    }
    
    /**
     * Metodo toJson crea un JSONObject y le pone los datos de la zapatilla actual.
     * @return JSONObject corresopndiente con el objeto Snicker actual.
     */
    public JSONObject toJson(){
        JSONObject snicker = new JSONObject();
        snicker.put("marca", marca);
        snicker.put("modelo", modelo);
        snicker.put("color", color);
        return snicker;
    }

    public String getMarca() {
        return marca;
    }
    public String getModelo(){
        return this.modelo;
    }
    public String getColor() {
        return color;
    }
    
    /**
     * Metodo showSnicker imprime en pantalla los datos de la zapatilla actual.
     */
    public void showSnicker(){
        System.out.println("Marca: "+marca+", Modelo: "+modelo+", Color: "+color);
    }
}
