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

/**
 *
 * @author ccarrasco
 */
public class CuentaBancaria {
	private int numero;
	private String tipo;
	private String banco;
	private int documentoTitular;
	private Fecha fechaCreacion;
	private Fecha fechaUltimoMov;
	private float saldo;

	// Constructor
	/* Crea un objeto de tipo cuenta Bancaria */

	public CuentaBancaria(int elNumero, String elTipo, String elBanco, int elDocumento, Fecha laFecha) {
		numero = elNumero;
		tipo = elTipo;
		banco = elBanco;
		documentoTitular = elDocumento;
		fechaCreacion = laFecha;
		fechaUltimoMov = laFecha;
		saldo = 0;
	}

	// Observadores
	public int getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public String getBanco() {
		return banco;
	}

	public int getDocumento() {
		return documentoTitular;
	}

	public Fecha getFechaCreacion() {
		return fechaCreacion;
	}

	public Fecha getFechaUltimoMov() {
		return fechaUltimoMov;
	}

	public float getSaldo() {
		return saldo;
	}

	// Modificadores

	public void setTipo(String elTipo) {
		tipo = elTipo;
	}

	public void setBanco(String elBanco) {
		banco = elBanco;
	}

	public void setDocumento(int elDocumento) {
		documentoTitular = elDocumento;
	}

	public void setFechaCreacion(Fecha laFecha) {
		fechaCreacion = laFecha;
	}

	public void setFechaUltimoMov(Fecha laFecha) {
		fechaUltimoMov = laFecha;
	}

	public void setSaldo(float elSaldo) {
		saldo = elSaldo;
	}

	// Devuelve un string con el saldo de la cuenta y la fecha del �ltimo movimiento
	public String getSaldoYMovimiento() {
		return "Su saldo es de $: " + saldo + " y su último movimiento fue el :" + fechaUltimoMov.fechaLarga();
	}

	// Devuelve un string con los datos de la cuenta.
	public String toString() {
		return tipo + " Nro: " + numero + " - Banco: " + banco + " - Titular: " + documentoTitular;
	}

	// Modificadores
	// Aumentará el valor del saldo segun el importe pasado por parámetro
	private void incrementarSaldo(float importe) {
		saldo += importe;
	}

	// Disminuirá el valor del saldo segun el importe pasado por parámetro
	private void decrementarSaldo(float importe) {
		saldo += importe;
	}

	// Modifica la fecha de ultimo movimiento con la fecha pasada por parámetro
	private void actualizarFechaMovimiento(Fecha unaFecha) {
		fechaUltimoMov = unaFecha;
	}

	// Propias del tipo
	/*
	 * Realiza un dep�sito en la cuenta: Aumenta el saldo de la cuenta y actualiza
	 * la fecha de último movimiento
	 */
	public void depositar(float dinero, Fecha fechaDeposito) {
		incrementarSaldo(dinero);
		actualizarFechaMovimiento(fechaDeposito);
	}

	/*
	 * Realiza un retiro de dinero en la cuenta y actualiza la fecha de último
	 * movimiento, siempre y cuando el dinero que hay en la cuenta sea mayor
	 * al importe que se quiere retirar. Si lo puede hacer, devuelve True, sino, no
	 * realiza la operación y devuelve false
	 */

	public boolean retirar(float dinero, Fecha fechaRetiro) {
		boolean puedeRetirar = false;
		if (dinero <= saldo)
			puedeRetirar = true;
		if (puedeRetirar) {
			decrementarSaldo(dinero);
			actualizarFechaMovimiento(fechaRetiro);
		}
		return puedeRetirar;
	}

	public void creaCuenta(){
		// Crear 2 nuevas cuentas bancarias solicitando los datos al usuario, asignándole a ambas un saldo de $ 
		// 20000 al momento de su creación. -----Modifique el TDA para lograr este objetivo al momento de crear 
		//las cuentas bancarias. 
		// Tomar los recaudos necesarios para que la nueva cuenta no tenga un número de cuenta ya existente.
	}
}