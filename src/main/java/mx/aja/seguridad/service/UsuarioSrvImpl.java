package mx.aja.seguridad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.aja.seguridad.dto.DtoUsuarioPyme;
import mx.aja.seguridad.repository.UsuarioPymeRepo;

@Service
public class UsuarioSrvImpl implements UsuarioSrv {

	@Autowired
	private UsuarioPymeRepo usuarioRepo;

	@Override
	public DtoUsuarioPyme add(DtoUsuarioPyme user) {
		if(usuarioRepo.existsByCorreo(user.getCorreo())) {
			return null;
		}
		DtoUsuarioPyme userBd = usuarioRepo.save(user);
		userBd.setPassword(null);
		return userBd;
	}

	@Override
	public boolean isOk(DtoUsuarioPyme user) {
		DtoUsuarioPyme userBd = usuarioRepo.findByCorreo(user.getCorreo());
		return userBd != null && userBd.getPassword() != null && user.getPassword() != null && 
				userBd.getPassword().equals(user.getPassword());
	}

}
