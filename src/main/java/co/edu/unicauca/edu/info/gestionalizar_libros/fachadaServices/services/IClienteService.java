package co.edu.unicauca.edu.info.gestionalizar_libros.fachadaServices.services;

import java.util.List;
import co.edu.unicauca.edu.info.gestionalizar_libros.fachadaServices.DTO.ClienteDTO;
public interface IClienteService{
    public List<ClienteDTO>ListarLibros();
	public ClienteDTO ConsultarLibro(Integer CodigoLibro);
	public ClienteDTO AdicionarLibro(ClienteDTO Cliente);
	public ClienteDTO ActualizarLibro(Integer codigo, ClienteDTO usuario);
	public boolean EliminarLibro(Integer codigo);
}
