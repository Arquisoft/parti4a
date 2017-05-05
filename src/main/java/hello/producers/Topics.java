package hello.producers;

public class Topics {

	public final static String SEPARATOR = "@@"; // Separador entre los datos
													// que envia el producer en
													// el String

	public final static String CREATE_SUGGESTION = "CREATE_SUGGESTION"; // Cuando
																		// se
																		// crea
																		// una
																		// sugerencia

	public final static String COMMENT_SUGGESTION = "COMMENT_SUGGESTION"; // Comentar
																			// una
																			// sugerencia
																			// (Crea
																			// comentario
																			// y
																			// enlaza)

	public final static String POSITIVE_COMMENT_VOTE = "POSITIVE_COMMENT_VOTE"; // Para
																				// cuando
																				// se
																				// vota
																				// positivamente
																				// un
																				// comentario

	public final static String NEGATIVE_COMMENT_VOTE = "NEGATIVE_COMMENT_VOTE"; // Para
																				// cuando
																				// se
																				// vota
																				// negativamente
																				// un
																				// comentario

	public final static String POSITIVE_SUGGESTION_VOTE = "POSITIVE_SUGGESTION_VOTE"; // Cuando
																						// se
																						// vota
																						// positivamente
																						// una
																						// sugerencia

	public final static String NEGATIVE_SUGGESTION_VOTE = "NEGATIVE_SUGGESTION_VOTE"; // Cuando
																						// se
																						// vota
																						// negativamente
																						// una
																						// propuesta.
	public final static String SUGGESTION_GETS_MIN_VOTES = "SUGGESTION_GETS_MIN_VOTES"; // Cuando
																						// una
																						// sugerencia
																						// alcanza
																						// el
																						// minimo
																						// de
																						// votos.
}
