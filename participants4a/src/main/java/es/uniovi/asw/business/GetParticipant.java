package es.uniovi.asw.business;

import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.util.exception.CitizenException;

public interface GetParticipant {

	public Citizen getPP() throws CitizenException;

}
