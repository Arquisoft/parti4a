package es.uniovi.asw.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.commons.codec.digest.DigestUtils;

import es.uniovi.asw.dbupdate.CitizenFinder;
import es.uniovi.asw.dbupdate.util.Hibernate_Jpa;
import es.uniovi.asw.model.Citizen;
import es.uniovi.asw.util.exception.CitizenException;

public class DBManagement implements GetParticipant {
	private String email;
	private String contrasena;

	public DBManagement(String email, String contrasena) {
		this.email = email;
		this.contrasena = contrasena;
	}

	@Override
	public Citizen getPP() throws CitizenException {
		EntityManager mapper = Hibernate_Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		Citizen citizen = CitizenFinder.findByEmailPass(email, contrasena);
//		Citizen citizen = CitizenFinder.findByEmail(email);
		assertNotNull(citizen);
		mapper.persist(citizen);
//		System.out.println("Contraseña BD: "+ citizen.getContrasena());
//		System.out.println("Contrtaseña introducida: " + DigestUtils.sha512Hex(contrasena));
		trx.commit();
		mapper.close();
		return citizen;
	}

	private void assertNotNull(Citizen citizen) throws CitizenException {
		if (citizen == null)
			throw new CitizenException("No se hay un ciudadano con esas credenciales");
	}

}
