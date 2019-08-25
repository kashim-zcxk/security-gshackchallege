package mx.aja.seguridad.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.aja.seguridad.dto.DtoUsuarioPyme;

public interface UsuarioPymeRepo extends MongoRepository<DtoUsuarioPyme, String> {

	DtoUsuarioPyme findByUsuarioId(String usuarioId);
	Boolean existsByCorreo(String correo);
	DtoUsuarioPyme findByCorreo(String correo);
}
