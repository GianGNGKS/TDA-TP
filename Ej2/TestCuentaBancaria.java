
import java.util.Scanner;
import java.util.Random;

public class TestCuentaBancaria {

	public static void main(String[] args) {
		int respuesta = 0;
		Scanner msc = new Scanner(System.in);
		CuentaBancaria[] arregloCB = new CuentaBancaria[5];

		Fecha fechaCreacion = new Fecha(10, 9, 2020);
		Fecha hoy = new Fecha(12, 9, 2023);

		System.out.println("Cuentas originales.");
		arregloCB[0] = new CuentaBancaria(1111, "CC", "Nacion", 25111111, fechaCreacion);
		arregloCB[1] = new CuentaBancaria(2222, "CA", "BPN", 28333333, fechaCreacion);
		arregloCB[2] = new CuentaBancaria(3333, "CC", "Itau", 36555555, fechaCreacion);

		System.out.println("Las cuentas ingresadas son : ");

		for (int i = 0; i < 3; i++) {
			System.out.println(arregloCB[i].toString() + " y su saldo es: " + arregloCB[i].getSaldo());
		}
		arregloCB[0].depositar(1500, hoy);
		arregloCB[1].depositar(2500, hoy);
		arregloCB[2].depositar(3800, hoy);
		arregloCB[2].depositar(1500, hoy);
		arregloCB[1].depositar(2600, hoy);
		float retiro;

		retiro = 8000;

		if (!arregloCB[0].retirar(retiro, hoy))
			mostrarSaldoInsuficiente(arregloCB[0]);

		retiro = 800;

		if (!arregloCB[0].retirar(retiro, hoy))
			mostrarSaldoInsuficiente(arregloCB[0]);

		retiro = 1800;

		if (!arregloCB[1].retirar(retiro, hoy))
			mostrarSaldoInsuficiente(arregloCB[1]);

		retiro = 7000;

		if (!arregloCB[2].retirar(retiro, hoy))
			mostrarSaldoInsuficiente(arregloCB[2]);

		// nuevas 2 cuentas agregadas por consigna.
		System.out.println("-----------------------------------");
		System.out.println("Se crearan 2 cuentas;");
		arregloCB[3] = crearCuenta(fechaCreacion, arregloCB);
		arregloCB[4] = crearCuenta(fechaCreacion, arregloCB);
		System.out.println("-----------------------------------");
		mostrarDatosCuentas(arregloCB);
		System.out.println("-----------------------------------");

		// menu con respuesta, si es 1 sale del programa.
		while (respuesta != 1) {
			generarMenu(arregloCB);
			System.out.println("Desea salir? 1-Si 2-No");
			respuesta = msc.nextInt();
		}

	}

	public static void generarMenu(CuentaBancaria[] arr) {
		Scanner gsc = new Scanner(System.in);
		float monto;
		int dia, mes, anio;
		Fecha fechaOperacion;
		System.out.println("Ingrese el nro de cuenta:");
		int nroCuenta = gsc.nextInt();
		// verifica que la cuenta exista, por consigna.
		while (!verificarSiExisteCuenta(arr, nroCuenta)) {
			System.out.println("El numero de cuenta ingresado no existe. Ingrese nuevamente: ");
			nroCuenta = gsc.nextInt();
		}
		int posicion = buscarCuenta(arr, nroCuenta);
		System.out.println("Ingrese la opcion deseada: ");
		System.out.println("1- Depositar");
		System.out.println("2- Retirar");
		System.out.println("3- Mostrar datos de las cuentas");
		System.out.println("4- Ultimo movimiento");
		int respuesta = gsc.nextInt();
		// opciones por menu para depositar, retirar, mostrar datos de las cuentas y
		// mostrar el último movimiento.
		switch (respuesta) {
			case 1:
				System.out.println("Ingrese el monto a depositar: ");
				monto = gsc.nextFloat();
				System.out.println("Ingrese la fecha de deposito: ");
				System.out.println("Ingrese el dia: ");
				dia = gsc.nextInt();
				System.out.println("Ingrese el mes: ");
				mes = gsc.nextInt();
				System.out.println("Ingrese el anio: ");
				anio = gsc.nextInt();
				fechaOperacion = new Fecha(dia, mes, anio);
				arr[posicion].depositar(monto, fechaOperacion);
				System.out.println("Operación exitosa. El nuevo balance de: " + arr[posicion].getNumero() + " es: "
						+ arr[posicion].getSaldo() + "\n");
				break;
			case 2:
				System.out.println("Ingrese el monto a retirar: ");
				monto = gsc.nextFloat();
				System.out.println("Ingrese la fecha de retiro: ");
				System.out.println("Ingrese el dia: ");
				dia = gsc.nextInt();
				System.out.println("Ingrese el mes: ");
				mes = gsc.nextInt();
				System.out.println("Ingrese el anio: ");
				anio = gsc.nextInt();
				fechaOperacion = new Fecha(dia, mes, anio);
				if (!arr[posicion].retirar(monto, fechaOperacion)) {
					mostrarSaldoInsuficiente(arr[posicion]);
				} else {
					System.out.println("Operación exitosa. El nuevo balance de: " + arr[posicion].getNumero() + " es: "
							+ arr[posicion].getSaldo() + "\n");
				}
				break;
			case 3:
				mostrarDatosCuentas(arr);
				break;
			case 4:
				System.out.print("El último movimiento fue el: ");
				mostrarMovimiento(arr[posicion]);
				break;
			default:
				break;
		}

	}

	// metodo creado para buscar la cuenta que fue enviada por parametro.
	public static int buscarCuenta(CuentaBancaria[] arreglo, int nroCuenta) {
		int posicion = -1;
		for (int i = 0; i < arreglo.length; i++) {
			if (arreglo[i].getNumero() == nroCuenta) {
				posicion = i;
			}
		}
		return posicion;
	}

	// metodo creado para verificar si la cuenta existe.
	public static boolean verificarSiExisteCuenta(CuentaBancaria[] arr, int nroCuenta) {
		boolean existe = false;
		int i = 0;
		while (!existe && i < arr.length && arr[i] != null) {
			if (arr[i].getNumero() == nroCuenta) {
				existe = true;
			}
			i++;
		}
		return existe;
	}

	// método hecho en test puesto que el arreglo está originalmente en este
	// archivo.
	private static CuentaBancaria crearCuenta(Fecha fechacreacion, CuentaBancaria[] arregloCB) {
		int NroCuenta = generarNumeroAleatorio(), documentoTitular;
		String tipoCuenta, banco;
		Fecha fechaCreacion = fechacreacion;
		Scanner sc = new Scanner(System.in);
		while (verificarSiExisteCuenta(arregloCB, NroCuenta)) {
			NroCuenta = generarNumeroAleatorio();
		}
		System.out.println("El nro de cuenta es :" + NroCuenta);
		System.out.println("Ingrese el tipo de cuenta: ");
		tipoCuenta = sc.nextLine();
		System.out.println("Ingrese el banco: (CC/CA)");
		banco = sc.nextLine();
		System.out.println("Ingrese el documento del titular: ");
		documentoTitular = sc.nextInt();
		return new CuentaBancaria(NroCuenta, tipoCuenta, banco, documentoTitular, fechaCreacion);
	}

	private static void mostrarSaldoInsuficiente(CuentaBancaria cuenta) {
		System.out.println("Saldo insuficiente para retirar. Su saldo es de: " + cuenta.getSaldo());
	}

	private static void mostrarDatosCuentas(CuentaBancaria[] arrCb) {
		for (int i = 0; i < arrCb.length; i++) {
			System.out.println(arrCb[i].toString() + " - Saldo Actual: " + arrCb[i].getSaldo());
		}
	}

	// nuevo método por consigna que incluye el último movimiento.
	public static void mostrarDatosCuentasyMovimiento(CuentaBancaria[] arrCb) {
		for (int i = 0; i < arrCb.length; i++) {
			System.out
					.println(arrCb[i].toString() + " - Saldo Actual: " + arrCb[i].getSaldo() + " - Ultimo Movimiento: "
							+ arrCb[i].getFechaUltimoMov().fechaLarga());
		}
	}

	// nuevo método que muestra el último movimiento.
	private static void mostrarMovimiento(CuentaBancaria cuentaBancaria) {
		System.out.println(cuentaBancaria.getFechaUltimoMov() + " - Saldo Actual: " + cuentaBancaria.getSaldo());
	}

	// método para obtener un nro de cuenta aleatorio.
	public static int generarNumeroAleatorio() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}
