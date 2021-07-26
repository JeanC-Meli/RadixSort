import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void radixSort(int[] arr)
    {
        String[] cadenaString = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(cadenaString, '0');

        ArrayList<String> cadenaStringAux = new ArrayList<String>();
        Collections.addAll(cadenaStringAux, cadenaString);

        ArrayList<ArrayList<String>> multiArreglo = new ArrayList<ArrayList<String>>();

        for (int i = 0; i < 10; i++) {
            multiArreglo.add(new ArrayList<String>());
        }

        for (int i = 1; i <= StringUtil.maxLength(cadenaString); i++) {
            for (ArrayList<String> arrayLi:multiArreglo){
                arrayLi.clear();
            }
            for (String elemento:cadenaStringAux){
                int numeroEspecifico = Character.getNumericValue(elemento.charAt(elemento.length()-i));
                multiArreglo.get(numeroEspecifico).add(elemento);
            }
            cadenaStringAux.clear();
            for (ArrayList<String> arrayLi:multiArreglo){
                cadenaStringAux.addAll(arrayLi);
            }
        }

        cadenaString = cadenaStringAux.toArray(new String[0]);
        int[] numerosAux = StringUtil.toIntArray(cadenaString);

        System.arraycopy(numerosAux, 0, arr, 0, arr.length);

    }

    public static void main(String[] args)
    {
        int[] arr = {16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}
