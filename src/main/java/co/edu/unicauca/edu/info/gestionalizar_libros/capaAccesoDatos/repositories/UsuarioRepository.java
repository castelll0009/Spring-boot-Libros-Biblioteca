package co.edu.unicauca.edu.info.gestionalizar_libros.capaAccesoDatos.repositories;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.edu.info.gestionalizar_libros.capaAccesoDatos.models.LibroEntity;

@Repository
public class UsuarioRepository {
    private ArrayList<LibroEntity> listaDeLibros;
    
    public UsuarioRepository(){
        System.out.println("Invocando al contrsuctor sin parametros ");
        this.listaDeLibros= new ArrayList<LibroEntity>();
        cargarLibros();
    }
    public List<LibroEntity> ListarLibros() {
		System.out.println("Invocando a listaLibros");
		return this.listaDeLibros;
	}
    public LibroEntity ConsultarLibro(Integer codigo) {
		System.out.println("Invocando a consultar un libro");
		LibroEntity objLibro = null;

		for (LibroEntity Libro : listaDeLibros) {
			if (Libro.getCodigoLibro() == codigo) {
				objLibro = Libro;
				break;
			}
		}

		return objLibro;
	}
    public LibroEntity AdicionarLibro(LibroEntity Libro) {
		System.out.println("Invocando a Adicionar libro");
		LibroEntity objLibro = null;
		if (this.listaDeLibros.add(Libro)) {
			objLibro = Libro;
		}

		return objLibro;
	}
    public LibroEntity ActualizarLibro(Integer codigo, LibroEntity Libro) {
		System.out.println("Invocando a actualizar un libro en la biblioteca");
		LibroEntity objLibro = null;

		for (int i = 0; i < this.listaDeLibros.size(); i++) {
			if (this.listaDeLibros.get(i).getCodigoLibro() == codigo) {
				this.listaDeLibros.set(i, Libro);
				objLibro = Libro;
				break;
			}
		}

		return objLibro;
	}
    public boolean EliminarLibro(Integer codigo) {
		System.out.println("Invocando a eliminar un libro");
		boolean bandera = false;

		for (int i = 0; i < this.listaDeLibros.size(); i++) {
			if (this.listaDeLibros.get(i).getCodigoLibro() == codigo) {
				this.listaDeLibros.remove(i);
				bandera = true;
				break;
			}
		}

		return bandera;
	}
    private void cargarLibros() {
		System.out.println("Cargando Libros");
		LibroEntity objLibro1 = new LibroEntity(1, "Cien años de soledad", "Gabriel garcia Marquez", "Aventura", new Date());
		this.listaDeLibros.add(objLibro1);
        LibroEntity objLibro2 = new LibroEntity(2, "Juan Tenorio", "tenorio", "Drama", new Date());
		this.listaDeLibros.add(objLibro2);
        LibroEntity objLibro3 = new LibroEntity(3, "El Principito", "el Mismo", "Aventura", new Date());
		this.listaDeLibros.add(objLibro3);
        LibroEntity objLibro4 = new LibroEntity(4, "Guerra y paz", "Leon Telstoi", "Aventura", new Date());
		this.listaDeLibros.add(objLibro4);
		
	}

}
