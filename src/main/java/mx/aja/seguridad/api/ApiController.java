package mx.aja.seguridad.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.aja.seguridad.dto.DtoUsuarioPyme;
import mx.aja.seguridad.service.UsuarioSrv;

@RestController
@RequestMapping("/api/v0/seguridad")
public class ApiController {

	@Autowired
	private UsuarioSrv usuarioSrv;
	
    /*Agregar usuario*/
    @PostMapping(path = "/pymes", produces = "application/json")
    public ResponseEntity<DtoUsuarioPyme> addUsuario(@RequestBody DtoUsuarioPyme request) {
    	DtoUsuarioPyme user = usuarioSrv.add(request);
    	return new ResponseEntity<>(user, user != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
    
    /*Agregar usuario*/
    @PostMapping(path = "/pymes/isok", produces = "application/json")
    public ResponseEntity<Boolean> isOk(@RequestBody DtoUsuarioPyme request) {
    	boolean user = usuarioSrv.isOk(request);
    	return new ResponseEntity<>(user, user ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
