/*
3-Corregir los errores formales del código si los hubiera de acuerdo a lo solicitado en la materia 
(documentación, retornos de variables, etc.)
 */

/**
 * @author ccarrasco
 **/
public class Fecha {

	// Atributos
	private int dia;
	private int mes;
	private int anio;

	// Constructores
	public Fecha() {
		this.dia = 1;
		this.mes = 1;
		this.anio = 1900;
	}

	public Fecha(int elDia, int elMes, int elAnio) {
		this.dia = elDia;
		this.mes = elMes;
		this.anio = elAnio;
	}

	// Métodos Comportamiento
	// Observadores
	public int getDia() {
		return this.dia;
	}

	public int getMes() {
		return this.mes;
	}

	public int getAnio() {
		return this.anio;
	}

	public String fechaLarga() {
		return (this.dia + " de " + mesLetras() + " de " + this.anio);
	}

	public String fechaCorta() {
		return toString();
	}

	public boolean equals(Fecha otraFecha) {
		return (this.dia == otraFecha.getDia() && this.mes == otraFecha.getMes() && this.anio == otraFecha.getAnio());

	}

	// Modificadores
	public void setDia(int elDia) {
		if (elDia > 31 || elDia < 1) {
			this.dia = 0;
		} else {
			if (elDia < 29)
				this.dia = elDia;
			else {
				switch (this.dia) {
					case 29:
						if (this.mes == 2) {
							if (esBisiesto())
								this.dia = elDia;
							else
								this.dia = 0;
						} else
							this.dia = elDia;
						break;
					case 30:
						if (this.mes == 2)
							this.dia = 0;
						else
							this.dia = elDia;
						break;
					case 31:
						if (this.mes == 2 || this.mes == 11 || this.mes == 4 || this.mes == 6 || this.mes == 9)
							this.dia = 0;
						else
							this.dia = elDia;
						break;
				}
			}
		}
	}

	public void setDia(int elDia, int elMes, int elAnio) {
		if (elDia > 31 || elDia < 1) {
			this.dia = 0;
		} else {
			if (elDia < 29)
				this.dia = elDia;
			else {
				switch (this.dia) {
					case 29:
						if (elMes == 2) {
							if (esBisiesto(elAnio))
								this.dia = elDia;
							else
								this.dia = 0;
						} else
							this.dia = elDia;
						break;
					case 30:
						if (elMes == 2)
							this.dia = 0;
						else
							this.dia = elDia;
						break;
					case 31:
						if (elMes == 2 || elMes == 11 || elMes == 4 || elMes == 6 || elMes == 9)
							this.dia = 0;
						else
							this.dia = elDia;
						break;
				}
			}
		}
	}

	public void setMes(int elMes) {
		if (elMes > 0 && elMes < 13) {
			this.mes = elMes;
		} else {
			this.mes = 0;
		}
	}

	public void setAnio(int elAnio) {
		this.anio = elAnio;
	}

	public String toString() {
		return this.dia + "/" + this.mes + "/" + this.anio;
	}

	// Propios del Tipo
	public boolean esBisiesto() {
		return ((this.anio % 4 == 0) && ((this.anio % 100 != 0) || (this.anio % 400 == 0)));

	}

	public static boolean esBisiesto(int elAnio) {
		return ((elAnio % 4 == 0) && ((elAnio % 100 != 0) || (elAnio % 400 == 0)));
	}

	/* Calcula la cantidad de dias transcurridos desde el primer dia del año */
	public int diasTranscurridos() {
		int diasAcumulados = 0;
		int diasEnUltimoMes = obtenerDiasEnMes(this.mes, this.anio);
		// recorre hasta el anteúltimo mes
		for (int i = 1; i < this.mes; i++) {
			diasAcumulados = diasAcumulados + obtenerDiasEnMes(i, this.anio);
		}
		// si los dias no están en el último día del último mes,
		// entonces se suman esos a los días acumulados de meses anteriores.
		// sino, solo se suman los días del último mes.
		if (this.dia < diasEnUltimoMes) {
			diasAcumulados = diasAcumulados + this.dia;
		} else {
			diasAcumulados = diasAcumulados + diasEnUltimoMes;
		}
		return diasAcumulados;
	}

	public String mesLetras() {
		String[] mesEnLetras = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		return (mesEnLetras[this.mes - 1]);
	}

	/*
	 * Este método verifica si la fecha es posterior a la fecha que recibe por
	 * parámetro.
	 */
	public boolean esFechaPosterior(Fecha otraFecha) {
		boolean esMayor = false;
		if (this.anio > otraFecha.anio) {
			esMayor = true;
		} else if (this.anio == otraFecha.anio) {
			if (this.mes > otraFecha.mes) {
				esMayor = true;
			} else if (this.mes == otraFecha.mes) {
				if (this.dia > otraFecha.dia) {
					esMayor = true;
				} else {
					esMayor = false;
				}
			}
		}
		return esMayor;
	}

	/*
	 * Este método verifica que la fecha es anterior a la fecha que recibe por
	 * parámetro
	 */
	public boolean esFechaAnterior(Fecha otraFecha) {
		boolean esMenor = false;
		if (this.anio < otraFecha.anio) {
			esMenor = true;
		} else if (this.anio == otraFecha.anio) {
			if (this.mes < otraFecha.mes) {
				esMenor = true;
			} else if (this.mes == otraFecha.mes) {
				if (this.dia < otraFecha.dia) {
					esMenor = true;
				} else {
					esMenor = false;
				}
			}
		}
		return esMenor;
	}

	/* Retorna una nueva fecha, sumándole los dias pasados por parámetro */
	public Fecha calculaFecha(int cantidadDias) {
		int nuevoDia = this.dia;
		int nuevoMes = this.mes;
		int nuevoAnio = this.anio;
		int diasEnUltimoMes = obtenerDiasEnMes(this.mes, this.anio);
		int diasAcumulados= this.dia+cantidadDias;
		// repite mientras la cantidad de días + los días de la fecha ya existente sean mayores 
		//a la cantidad de dias en el último mes
		//Si la cantidad es mayor, se reinicia la cuenta en el mes siguiente.
		//Si los meses son mayores a 12, se incrementa un año y se comienza desde enero.
		while (diasAcumulados > diasEnUltimoMes) {
			diasAcumulados = diasAcumulados - diasEnUltimoMes;
			nuevoMes++;
			if (nuevoMes > 12) {
				nuevoMes = 1;
				nuevoAnio++;
			}
			diasEnUltimoMes = obtenerDiasEnMes(nuevoMes, nuevoAnio);
		}
		nuevoDia = diasAcumulados;
		return new Fecha(nuevoDia, nuevoMes, nuevoAnio);
	}

	public boolean esFechaValida() {
		// comprueba que el año sea mayor a 0 para simplicidad.
		boolean esFechaValida = false;
		if (this.anio > 0) {
			// comprueba que el mes sea mayor a 0 y menor a 13
			if (this.mes > 0 && this.mes < 13) {
				// comprueba que el día sea mayor a 0 y menor a la cantidad de días del mes
				if (this.dia > 0 && this.dia <= obtenerDiasEnMes(this.mes, this.anio)) {
					esFechaValida = true;
				} else {
					esFechaValida = false;
				}
			} else {
				esFechaValida = false;
			}
		} else {
			esFechaValida = false;
		}
		return esFechaValida;
	}

	public static int obtenerDiasEnMes(int mes, int anio) {
		int diasEnMes;
		switch (mes) {
			case 2:
				if (esBisiesto(anio)) {
					diasEnMes = 29;
				} else {
					diasEnMes = 28;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				diasEnMes = 30;
				break;
			default:
				diasEnMes = 31;
				break;
		}
		return diasEnMes;
	}
}