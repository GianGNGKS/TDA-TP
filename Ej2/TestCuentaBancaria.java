/*
1-Verificar si el programa funciona correctamente.

2-Reemplazar el archivo Fecha.java con el archivo Fecha.java del ejercicio anterior que modificaron.

3-Crear un método mostrarDatosCuentasyMovimiento que muestre los datos de todas las cuentas bancarias,
con el saldo actual y la fecha del último movimiento en formato fecha larga. Utilizar este método para 
mostrar los datos luego de realizar las operaciones solicitadas en los siguientes puntos.
--------------------------------------------------------------------------------------------------------
4-Crear 2 nuevas cuentas bancarias solicitando los datos al usuario, asignándole a ambas un saldo de $ 
20000 al momento de su creación. -----Modifique el TDA para lograr este objetivo al momento de crear las cuentas bancarias. 

5-Tomar los recaudos necesarios para que la nueva cuenta no tenga un número de cuenta ya existente.

6-Solicite al usuario las operaciones a realizar (retirar o depositar X cantidad de dinero) de la cuenta N, 
donde N sea el número de la cuenta que ingresa el usuario. 

7-Deberá verificar si la cuenta existe en el arreglo.

8-Si existe, verificar que la operación pueda realizarse. Emitir un mensaje si fue exitoso o no.
 */

import java.util.Scanner;

/**
 *
 * @author ccarrasco
 */
public class TestCuentaBancaria {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		float retiro;
		CuentaBancaria[] arregloCB = new CuentaBancaria[3];
		CuentaBancaria[] arregloCBNuevas = new CuentaBancaria[2];
		Fecha fechaCreacion = new Fecha(10, 9, 2020);
		Fecha hoy = new Fecha(12, 9, 2023);
		arregloCB[0] = new CuentaBancaria(1111, "CC", "Nacion", 25111111, fechaCreacion);
		arregloCB[1] = new CuentaBancaria(2222, "CA", "BPN", 28333333, fechaCreacion);
		arregloCB[2] = new CuentaBancaria(3333, "CC", "Itau", 36555555, fechaCreacion);
		System.out.println("Las cuentas ingresadas son : ");
		mostrarDatosCuentas(arregloCB);
		arregloCB[0].depositar(1500, hoy);
		arregloCB[1].depositar(2500, hoy);
		arregloCB[2].depositar(3800, hoy);
		arregloCB[2].depositar(1500, hoy);
		arregloCB[1].depositar(2600, hoy);
		System.out.println("------------------------------------");
		mostrarDatosCuentas(arregloCB);
		/*
		 * retiro = 8000;
		 * 
		 * if (!arregloCB[0].retirar(retiro, hoy))
		 * mostrarSaldoInsuficiente(arregloCB[0]);
		 * 
		 * retiro = 800;
		 * 
		 * if (!arregloCB[0].retirar(retiro, hoy))
		 * mostrarSaldoInsuficiente(arregloCB[0]);
		 * 
		 * retiro = 1800;
		 * 
		 * if (!arregloCB[1].retirar(retiro, hoy))
		 * mostrarSaldoInsuficiente(arregloCB[1]);
		 * 
		 * retiro = 7000;
		 * 
		 * if (!arregloCB[2].retirar(retiro, hoy))
		 * mostrarSaldoInsuficiente(arregloCB[2]);
		 */
	}

	private static void mostrarSaldoInsuficiente(CuentaBancaria cuenta) {
		System.out.println("Saldo insuficiente para retirar. Su saldo es de: " + cuenta.getSaldo());
	}

	private static void mostrarDatosCuentas(CuentaBancaria[] arrCb) {
		for (int i = 0; i < arrCb.length; i++) {
			System.out.println(arrCb[i].toString() + " - Saldo Actual: " + arrCb[i].getSaldo()
					+ " - Fecha de último movimiento: " + arrCb[i].getFechaUltimoMov().fechaLarga());
		}
	}

}
/*
 * 3-Crear un método mostrarDatosCuentasyMovimiento que muestre los datos de
 * todas las cuentas bancarias,
 * con el saldo actual y la fecha del último movimiento en formato fecha larga.
 * Utilizar este método para
 * mostrar los datos luego de realizar las operaciones solicitadas en los
 * siguientes puntos.
 */