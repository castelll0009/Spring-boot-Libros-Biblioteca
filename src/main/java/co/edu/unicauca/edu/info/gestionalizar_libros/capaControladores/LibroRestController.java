package co.edu.unicauca.edu.info.gestionalizar_libros.capaControladores;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.edu.info.gestionalizar_libros.fachadaServices.DTO.ClienteDTO;
import co.edu.unicauca.edu.info.gestionalizar_libros.fachadaServices.services.ClienteServicempl;

@RestController
@RequestMapping("/api")
public class LibroRestController {
    @Autowired
	private ClienteServicempl usuarioService;

	@GetMapping("/listar")
	public List<ClienteDTO> index() {
		return usuarioService.ListarLibros();
		
	
	}
	@GetMapping("/consultar/{id}")
	public ClienteDTO show(@PathVariable Integer id){
		ClienteDTO objtCliente = null;
		objtCliente = usuarioService.ConsultarLibro(id);
		return objtCliente;
	}
	public String getMessageParametros(@RequestParam String nombreLibro,
			@RequestParam String autor) {
		String msg = String.format("buscando un libro por nombre: %s, autor: %s", nombreLibro, autor);
		System.out.println(msg);
		return msg;
	}

	@PostMapping("/libros/adicionarLibros/") 
	public ClienteDTO create(@RequestBody ClienteDTO usuario) {
		ClienteDTO objUsuario = null;
		objUsuario = usuarioService.AdicionarLibro(usuario);
		return objUsuario;
	}

	@PutMapping("/librosB/{CodigoLibro}")
	public ClienteDTO ActualizarLibro(@RequestBody ClienteDTO usuario, @PathVariable Integer CodigoLibro) {
		ClienteDTO objUsuario = null;
		ClienteDTO usuarioActual = usuarioService.ActualizarLibro(CodigoLibro, objUsuario);
		if (usuarioActual != null) {
			objUsuario = usuarioService.ActualizarLibro(CodigoLibro, usuarioActual);
		}
		return objUsuario;
	}

	@DeleteMapping("/eliminar/{codigo}")
	public Boolean EliminarLibro(@PathVariable Integer codigo) {
		Boolean bandera = false;
		ClienteDTO usuarioActual = usuarioService.ConsultarLibro(codigo);
		if (usuarioActual != null) {
			bandera = usuarioService.EliminarLibro(codigo);
		}
		return bandera;

	}

	@GetMapping("/usuarios/listarLibros")
	public void listaDeLibros(@RequestHeader Map<String, String> headers) {
		System.out.println("libros");
		headers.forEach((key, value) -> {
			System.out.println(String.format("libros '%s' = %s", key, value));
		});
	}

}

	

