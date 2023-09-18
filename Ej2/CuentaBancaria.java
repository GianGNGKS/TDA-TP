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
		saldo = 20000;
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
		saldo -= importe;
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
		//agregada condición para revisar si existe algún saldo.
		if (dinero <= saldo && saldo>0)
			puedeRetirar = true;
		if (puedeRetirar) {
			decrementarSaldo(dinero);
			actualizarFechaMovimiento(fechaRetiro);
		}
		return puedeRetirar;
	}
}