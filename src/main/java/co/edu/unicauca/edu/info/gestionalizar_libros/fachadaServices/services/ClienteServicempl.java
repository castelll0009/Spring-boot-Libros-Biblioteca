package co.edu.unicauca.edu.info.gestionalizar_libros.fachadaServices.services;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unicauca.edu.info.gestionalizar_libros.capaAccesoDatos.models.LibroEntity;
import co.edu.unicauca.edu.info.gestionalizar_libros.capaAccesoDatos.repositories.UsuarioRepository;
import co.edu.unicauca.edu.info.gestionalizar_libros.fachadaServices.DTO.ClienteDTO;

@Service
public class ClienteServicempl implements IClienteService {

    @Autowired
    private UsuarioRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ClienteDTO> ListarLibros() {
        List<LibroEntity> librosEntity = this.servicioAccesoBaseDatos.ListarLibros();
        List<ClienteDTO> librosDTO = modelMapper.map(librosEntity, new TypeToken<List<ClienteDTO>>() {}.getType());
        return librosDTO;
    }

    @Override
    public ClienteDTO ConsultarLibro(Integer codigoLibro) {
        LibroEntity libroEntity = this.servicioAccesoBaseDatos.ConsultarLibro(codigoLibro);

        if (libroEntity != null) {
            return modelMapper.map(libroEntity, ClienteDTO.class);
        } else {
            // Puedes manejar la situación donde el libro no se encuentra (por ejemplo, lanzar una excepción).
            throw new RuntimeException("Libro no encontrado con el código: " + codigoLibro);
        }
    }

    @Override
    public ClienteDTO AdicionarLibro(ClienteDTO libroDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'AdicionarLibro'");
    }

    @Override
    public ClienteDTO ActualizarLibro(Integer codigo, ClienteDTO libroDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'ActualizarLibro'");
    }

    @Override
    public boolean EliminarLibro(Integer codigo) {
        // Delegar la lógica al repositorio
        boolean eliminado = this.servicioAccesoBaseDatos.EliminarLibro(codigo);

        // Manejar la situación si el libro no se pudo eliminar
        if (!eliminado) {
            throw new RuntimeException("No se pudo eliminar el libro con el código: " + codigo);
        }

        return eliminado;
    }
}
