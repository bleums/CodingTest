import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ascensor {

	public static int TOPFLOOR = 29;
	private static ArrayList<Integer> stops = new ArrayList<Integer>();;
	private static int startingPoint = 0;;
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	private static Map<Integer, String> control = new HashMap<Integer, String>();


	public Ascensor() {
		super();
	}
	


	public static void main(String[] args) throws IOException {
		
		
		int contador = 0;
		
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader (entrada);
		String cadena = "";
		System.out.println("Name:");
		

		try {
//			cadena = input.readLine();
//			System.out.println("\n");

			while((cadena = input.readLine()) != null) {
			contador++;
			
			cadena = cadena.replace("[","");
			cadena = cadena.replace("]","");
			cadena = cadena.replace(",","");
			cadena = cadena.replace("{","");
			cadena = cadena.replace("}","");

			System.out.println(contador);
			System.out.println(cadena);
			
			control.put(contador,cadena);
			
//			cadena = input.readLine();
			if(contador >=3) {
				break;
			}
			}
			
			input.close();
			entrada.close();

			
			assignValues(control);
		
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}catch	(NumberFormatException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());

		}finally {
			input.close();
			entrada.close();
		}
		


        
    }



	private static void assignValues(Map<Integer, String> control2) {
		System.out.println("ENTRANDO");
		String[] floors = splitting(control2.get(1), " ");
		String[] initial = splitting(control2.get(2), " ");
		String[] input = splitting(control2.get(1), " ");

		//Assigning values for floors entered
		for (int i = 0; i < input.length; i++) {
			String[] output = splitting(input[i], ":");
			try {
				int key = Integer.parseInt(output[0]);
				int value = Integer.parseInt(output[1]);

				map.put(key, value);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		//Assigning values for stops of the elevator
		for (int i = 0; i < floors.length; i++) {
			try {
				int value = Integer.parseInt(floors[i]);
				stops.add(value);
			}catch(NumberFormatException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		try {
			int value = Integer.parseInt(initial[0]);
			startingPoint = value;
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}

		

	}
	
	private static String[] splitting(String arr, String splitter) {
		String[] splitted = arr.split(splitter);
		return splitted;
	}
	
	
}
