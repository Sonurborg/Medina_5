package Code;
 
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
    
    private static JSONParser jsonParser = new JSONParser();
    
    @SuppressWarnings("unchecked")
    /**
     * Metodo read intenta leer archivo zapatillas.json a uno JSONArray recibido de
     * obectToArray y ejecuta el metodo parseSnickerObject por cada objeto del JSONArray.
     */
    public static void read(){
        try {
            JSONArray snickersList = objectToArray(fileReader("zapatillas.json"));
            snickersList.forEach( snk -> parseSnickerObject( (JSONObject) snk ) );
            
        } catch (Exception e) {
            System.out.println("Error, no fue posible leer el archivo");
        }
    }
    
    /**
     * Metodo fileReader recibe una ruta path y retorna un SONObject
     * obtenido de leer el archivo en la ruta.
     * 
     * @param path Ruta del archivo .json a leer
     * @return JSONObject obtenido del archivo en la ruta dada.
     * @throws Exception 
     */
    private static JSONObject fileReader(String path) throws Exception{
        return (JSONObject) jsonParser.parse(new String(Files.readAllBytes(Paths.get(path))));
    }
 
    /**
     * Metodo objectToArray recibe un JSONObject para transformarlo a JSONArray.
     * @param JSONObject a transformar
     * @return JSONArray transformado desde @param JSONObject
     */
    private static JSONArray objectToArray(JSONObject obj){
        return (JSONArray) obj.get("zapatillas");
    }
    
    /**
     * Metodo parseSnickerObject recibe un JSONObject y lo transforma a un objeto
     * Snicker.
     * 
     * @param snicker JSONObject a transformar a objeto Snicker.
     */
    private static void parseSnickerObject(JSONObject snicker){
        Main.snickers.add(new Snicker((String) snicker.get("marca"),(String) snicker.get("modelo"),(String) snicker.get("color")));
    }
    
    /**
     * Metodo putSnicker recibe un objeto Snicker e intenta sobreescribir sus atributos en el
     * archivo zapatillas.json.
     * 
     * @param snicker Zapatilla a poner en el archivo.
     */
    public static void putSnicker(Snicker snicker){
        try {
            JsonWriter(addObject(objectToArray(fileReader("zapatillas.json")),snicker));
        } catch (Exception e) {
            System.out.println("Error, no fue posible sobreescribir el archivo");
        }
    }
    
    /**
     * Metodo addObject recibe un JSONArray y un objeto Snicker para devolver un JSONObject
     * con los datos existentes mas los atributos de Snicker.
     * 
     * @param snickersList JSONArray con los JSONObject de las zapatillas
     * @param snicker Objeto Snicker a agregar al JSONArray.
     * @return JSONObject con los datos de snickerList y snicker.
     */
    private static JSONObject addObject(JSONArray snickersList,Snicker snicker){
        snickersList.add(snicker.toJson());    
        JSONObject snickersObject = new JSONObject();
        snickersObject.put("zapatillas", snickersList);
        return snickersObject;
    }
    
    /**
     * Metodo JsonWriter recibe un JSONObject y lo sobreescribe en el archivo zapatillas.json.
     * @param snickersList JSONObject con todas las zapatillas a sobreescribir.
     * @throws Exception 
     */
    private static void JsonWriter(JSONObject snickersList) throws Exception{
        FileWriter file = new FileWriter("zapatillas.json");
        file.write(snickersList.toJSONString());
        file.flush();
    }
}