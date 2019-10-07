package Code;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static List<Snicker> snickers = new ArrayList<>();
    
    public static void main(String[] args){
        loadSnickers();
        menu();
    }
    
    /**
     * Metodo loadSnickers que ejecuta al metodo JsonReader.read para leer
     * los datos del archivo y almacenarlos en los objetos.
     */
    public static void loadSnickers(){
        JsonReader.read();
    }
    
    /**
     * Metodo menu ejecuta al metodo options mientras la selección
     * selection sea diferente de 3.
     */
    private static void menu(){
        int selection;
        do {
           selection=optionSel();
           options(selection);
        }while (selection!=3);
    }
    
    /**
     * Metodo optionSel imprime las opciones para el menú retorna un int correspondiente
     * a la opcion elegida.
     * 
     * @return input recibido de IntInputReader.
     */
    private static int optionSel() {
        System.out.println("Seleccione lo que desea realizar");
        System.out.println(" 1 - Mostrar Zapatillas");
        System.out.println(" 2 - Añadir Zapatilla");
        System.out.println(" 3 - Salir");
        return IntInputReader.input(1, 3);
    }
    
    /**
     * Metodo options recibe el int o y ejecuta el metodo correspondiente a la opcion seleccionada.
     * @param o recibido de la seleccion del menu.
     */
    private static void options(int o){
        if (o==1) showAll();
        if (o==2) createSnicker();
    }
    
    /**
     * Metodo createSnicker crea el objeto Snicker con los datos requeridos "Nike",
     * "AirForce1" y "Black".   Luego llama a JsonReader.putSnicker para añadir las
     * lineas requeridas al archivo .json.
     */
    private static void createSnicker(){
        snickers.add(new Snicker("Nike","AirForce1","Black"));
        JsonReader.putSnicker(snickers.get(snickers.size()-1));
        System.out.println("Zapatilla creada exitosamente");
    }
    
    /**
     * Metodo showAll se pasea por snickers y llama al método showSnicker de cada objeto
     * para imprimir los datos.
     */
    private static void showAll(){
        for (int i=0;i<snickers.size();i++) {
            snickers.get(i).showSnicker();
        }
    }
}
