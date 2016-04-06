package clases;

public class Ciudad {
	private int codigo;
	private String nombre;
	

	public Ciudad( int codigo, String destino){
		
		this.codigo = codigo;
		this.nombre = nombre;
		
	
		
	}
		
	
				
	public Ciudad(int codigo) {
		super();
		this.codigo = codigo;
	}



	public Ciudad() {
		super();
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

