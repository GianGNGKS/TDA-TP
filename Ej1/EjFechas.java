public class EjFechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fecha[] arrFechas1, arrFechas2;
        arrFechas1 = cargarArreglo();
        escribirFechas(arrFechas1);
        System.out.println("---------------------------------------------------");
        System.out.println("Todas Las fechas generadas son válidas? \t\t" + (fechasValidas(arrFechas1) ? "OK" : "Error"));
        System.out.println("El arreglo original está ordenado? \t\t\t" + (estaOrdenado(arrFechas1) ? "OK" : "Error"));
        System.out.println("---------------------------------------------------");
        System.out.println("---agregamos de a 10 días desde la fecha inicial---");
        arrFechas2 = modificarFechas(arrFechas1, 10);
        escribirFechas(arrFechas2);
        System.out.println("");
        System.out.println("Todas Las fechas generadas son válidas? \t\t" + (fechasValidas(arrFechas2) ? "OK" : "Error"));
        System.out.println("El nuevo arreglo está ordenado? \t\t\t" + (estaOrdenado(arrFechas2) ? "OK" : "Error"));
        System.out.println("---------------------------------------------------");
        System.out.println("---agregamos de a 100 días desde la fecha inicial-");
        arrFechas2 = modificarFechas(arrFechas1, 100);
        escribirFechas(arrFechas2);
        System.out.println("");
        System.out.println("Todas Las fechas generadas son válidas? \t\t" + (fechasValidas(arrFechas2) ? "OK" : "Error"));
        System.out.println("El nuevo arreglo está ordenado? \t\t\t" + (estaOrdenado(arrFechas2) ? "OK" : "Error"));
        System.out.println("---------------------------------------------------");
        escribirFechas(arrFechas2);
        System.out.println("---agregamos de a 1000 días desde la fecha inicial-");
        arrFechas2 = modificarFechas(arrFechas1, 1000);
        escribirFechas(arrFechas2);
        System.out.println("");
        System.out.println("Todas Las fechas generadas son válidas? \t\t" + (fechasValidas(arrFechas2) ? "OK" : "Error"));
        System.out.println("El nuevo arreglo está ordenado? \t\t\t" + (estaOrdenado(arrFechas2) ? "OK" : "Error"));
        System.out.println("");
        System.out.println("---Pruebas con fechas inválidas, todas deberían escribir 'Ok'---");
        Fecha unaFecha;
        unaFecha = new Fecha(34, 5, 2023);
        System.out.println("Fecha inválida: " + unaFecha.toString() + "\t\t\t\t" + (!unaFecha.esFechaValida() ? "Ok" : "Error"));
        unaFecha = new Fecha(20, 13, 2023);
        System.out.println("Fecha inválida: " + unaFecha.toString() + "\t\t\t\t" + (!unaFecha.esFechaValida() ? "Ok" : "Error"));
        unaFecha = new Fecha(0, 5, 2023);
        System.out.println("Fecha inválida: " + unaFecha.toString() + "\t\t\t\t" + (!unaFecha.esFechaValida() ? "Ok" : "Error"));
        unaFecha = new Fecha(-1, 5, 2023);
        System.out.println("Fecha inválida: " + unaFecha.toString() + "\t\t\t\t" + (!unaFecha.esFechaValida() ? "Ok" : "Error"));
        unaFecha = new Fecha(4, -1, 2023);
        System.out.println("Fecha inválida: " + unaFecha.toString() + "\t\t\t\t" + (!unaFecha.esFechaValida() ? "Ok" : "Error"));
        unaFecha = new Fecha(10, 10, -1);
        System.out.println("Fecha inválida: " + unaFecha.toString() + "\t\t\t\t" + (!unaFecha.esFechaValida() ? "Ok" : "Error"));
        unaFecha = new Fecha(10, 10, 0);
        System.out.println("Fecha inválida: " + unaFecha.toString() + "\t\t\t\t\t" + (!unaFecha.esFechaValida() ? "Ok" : "Error"));
        unaFecha = new Fecha(29, 2, 2021); // 2021 no es año bisiesto
        System.out.println("Fecha inválida: " + unaFecha.toString() + "\t\t\t\t" + (!unaFecha.esFechaValida() ? "Ok" : "Error"));
        unaFecha = new Fecha(29, 2, 1900); // 1900 no es año bisiesto
        System.out.println("Fecha inválida: " + unaFecha.toString() + "\t\t\t\t" + (!unaFecha.esFechaValida() ? "Ok" : "Error"));

    }

    public static void escribirFechas(Fecha[] arr) {
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " - ");
        }
        System.out.println(arr[i]);
    }

    public static Fecha[] modificarFechas(Fecha[] arr, int días) {
        Fecha[] arrRetorno = new Fecha[arr.length];
        arrRetorno[0] = arr[0].calculaFecha(días);
        for (int i = 1; i < arr.length; i++) {
            arrRetorno[i] = arr[i].calculaFecha(días);
        }
        return arrRetorno;
    }

    public static boolean fechasValidas(Fecha[] arr) {
        boolean validas = true;
        int i = 1;
        while (validas && i < arr.length) {
            validas = validas && arr[i].esFechaValida();
            i++;
        }
        return validas;
    }

    public static boolean estaOrdenado(Fecha[] arr) {
        boolean ordenado = true;
        int i = 1;
        while (ordenado && i < arr.length) {
            ordenado = ordenado && arr[i].esFechaPosterior(arr[i - 1]);
            i++;
        }
        return ordenado;
    }

    public static Fecha[] cargarArreglo() {
        Fecha[] arr = new Fecha[10];
        arr[0] = new Fecha(31, 1, 1978);
        arr[1] = new Fecha(1, 2, 2021);
        arr[2] = new Fecha(7, 3, 1960);
        arr[3] = new Fecha(20, 4, 1300);
        arr[4] = new Fecha(31, 5, 2050);
        arr[5] = new Fecha(5, 6, 2000);
        arr[6] = new Fecha(17, 7, 2001);
        arr[7] = new Fecha(22, 8, 1942);
        arr[8] = new Fecha(26, 9, 620);
        arr[9] = new Fecha(13, 10, 400);
        return arr;
    }
}
