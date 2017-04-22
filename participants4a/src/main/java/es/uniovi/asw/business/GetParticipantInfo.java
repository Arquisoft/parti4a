package es.uniovi.asw.business;

import es.uniovi.asw.dto.CitizenDTO;

public interface GetParticipantInfo {

	public CitizenDTO getPR(String email, String contrasena);

}
