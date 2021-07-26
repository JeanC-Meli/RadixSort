public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	// Ejemplo: replicate('x',5) ==> "xxxxx"
	public static String replicate(char c,int n)
	{
		return String.valueOf(c).repeat(Math.max(0, n));
	}

	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	// Ejemplo lpad("5",3,'0') ==> "005"
	public static String lpad(String s, int n, char c)
	{
		return replicate(c, (n - s.length())) + s;
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static String[] toStringArray(int[] arr)
	{
		String[] cadenaList = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			cadenaList[i] = String.valueOf(arr[i]);
		}
		return cadenaList;
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static int[] toIntArray(String[] arr)
	{
		int[] intList = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intList[i] = Integer.parseInt(arr[i]);
		}
		return intList;
	}

	// Retorna la longitud del elemento con mayor cantidad
	// de caracteres del array arr
	public static int maxLength(String[] arr)
	{
		int largoMaximo = 0;
		for (String i:arr){
			if (i.length() > largoMaximo){
				largoMaximo = i.length();
			}
		}
		return largoMaximo;
	}

	// Completa los elemento del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String[] arr, char c)
	{
		int largo = maxLength(arr);
		for (int i = 0; i < arr.length; i++) {
			String valorNuevo = lpad(arr[i], largo, c);
			arr[i] = valorNuevo;
		}
	}
}
