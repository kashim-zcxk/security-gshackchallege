package mx.aja.seguridad.service;

import mx.aja.seguridad.dto.DtoUsuarioPyme;

public interface UsuarioSrv {

	DtoUsuarioPyme add(DtoUsuarioPyme user);
	boolean isOk(DtoUsuarioPyme user);
	
}
