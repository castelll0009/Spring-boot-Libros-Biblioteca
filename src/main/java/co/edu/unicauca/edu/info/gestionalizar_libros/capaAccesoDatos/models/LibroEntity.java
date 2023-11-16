package co.edu.unicauca.edu.info.gestionalizar_libros.capaAccesoDatos.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class LibroEntity {
    private Integer CodigoLibro;
	private String nombreLibro;
	private String autor;
	private String genero;
	private Date createAt;

    public LibroEntity(){
    
}
}

