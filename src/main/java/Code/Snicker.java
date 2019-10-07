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
    
    public Snicker(String marca, String model, String color){
        this.marca=marca;
        this.modelo=model;
        this.color=color;
    }
    
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
    
    public void showSnicker(){
        System.out.println("Marca: "+marca+", Modelo: "+modelo+", Color: "+color);
    }
}
