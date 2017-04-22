package es.uniovi.asw.business;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import es.uniovi.asw.dto.CitizenDTO;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.util.exception.CitizenException;

@Component("Participants")
public class Participant implements GetParticipantInfo {

	@Override
	public CitizenDTO getPR(String email, String contrasena) {
		Citizen citizen = null;
		CitizenDTO citizenDTO = null;
		try {
			citizen = new DBManagement(email, DigestUtils.sha512Hex(contrasena)).getPP();

			if (citizen != null)
				citizenDTO = new CitizenDTO(citizen.getNombre(), citizen.getApellidos(), citizen.getEmail(),
						citizen.getFechaNacimiento(), citizen.getDireccionPostal(), citizen.getNacionalidad(),
						citizen.getNumeroIdentificativo());
		} catch (CitizenException e) {
			// citizenDTO = new CitizenDTO("Alan", "Padierna",
			// "alan@correo.com", null, "TT", "España", "09448754D");
			e.getMessage();
		}
		return citizenDTO;
	}
	
}
