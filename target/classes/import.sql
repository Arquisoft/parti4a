

INSERT INTO asw.usuarios (id, apellidos, contrasena, direccion_postal, email, fecha_nacimiento, nacionalidad, nombre, numero_identificativo, is_admin) VALUES ('1', 'García Larteregui', '2088948c702d6fb94bfa4f4bf314341013730d6da4338507e1be3e5f3b8ccddd9d874faecf00923fe6e26cbd67f0322d9d8e4f6ab8d04704c7f13496dc63a5cb', 'Gijón', 'pelayo@gmail.com', '1994/05/25', 'Española', 'Pelayo', '511236', FALSE);
INSERT INTO asw.usuarios (id, apellidos, contrasena, direccion_postal, email, fecha_nacimiento, nacionalidad, nombre, numero_identificativo, is_admin) VALUES ('2', 'Fernandez Alvarez', '2088948c702d6fb94bfa4f4bf314341013730d6da4338507e1be3e5f3b8ccddd9d874faecf00923fe6e26cbd67f0322d9d8e4f6ab8d04704c7f13496dc63a5cb', 'Oviedo', 'pedro@gmail.com', '1994/05/25', 'Española', 'Pedro', '51123684585T', FALSE);

INSERT INTO asw.usuarios (id, apellidos, contrasena, direccion_postal, email, fecha_nacimiento, nacionalidad, nombre, numero_identificativo, is_admin) VALUES ('3', 'Administrador del sistema', '2088948c702d6fb94bfa4f4bf314341013730d6da4338507e1be3e5f3b8ccddd9d874faecf00923fe6e26cbd67f0322d9d8e4f6ab8d04704c7f13496dc63a5cb', 'Oviedo', 'admin@gmail.com', '1994/05/25', 'Española', 'Admin', '5112368458f5T', TRUE);

INSERT INTO asw.usuarios (id, apellidos, contrasena, direccion_postal, email, fecha_nacimiento, nacionalidad, nombre, numero_identificativo, is_admin) VALUES ('4', 'Concejal', '2088948c702d6fb94bfa4f4bf314341013730d6da4338507e1be3e5f3b8ccddd9d874faecf00923fe6e26cbd67f0322d9d8e4f6ab8d04704c7f13496dc63a5cb', 'Gijón', 'concejal@gmail.com', '1994/05/25', 'Española', 'Concejal', '511236', FALSE);

INSERT INTO asw.categoria (id, nombre) VALUES ('1', 'Infraestructuras');
INSERT INTO asw.categoria (id, nombre) VALUES ('2', 'Jardines');
INSERT INTO asw.categoria (id, nombre) VALUES ('3', 'Transportes');
INSERT INTO asw.categoria (id, nombre) VALUES ('4', 'Deportes');
INSERT INTO asw.categoria (id, nombre) VALUES ('5', 'Recogida de basuras');
INSERT INTO asw.categoria (id, nombre) VALUES ('6', 'Saneamiento');

INSERT INTO  asw.categoria (id, nombre) VALUES('7','Medio ambiente');
INSERT INTO  asw.categoria (id, nombre) VALUES('8','Carreteras');
INSERT INTO  asw.categoria (id, nombre) VALUES('9','Aparcamiento');
INSERT INTO  asw.categoria (id, nombre) VALUES('10','Edificios');
INSERT INTO  asw.categoria (id, nombre) VALUES('11','Centros comerciales');
INSERT INTO  asw.categoria (id, nombre) VALUES('12','Animales');


INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo) VALUES ('1', 'Creación de parada de autobus cubierta en Llamaquique', 'Marquesina Llamaquique', '3','0', '1', '1','2015/05/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo)VALUES ('2', 'Plantacion de nuevos arboles en el Campo San Francisco', 'Nuevos arboles', '13','0', '2', '1','2014/05/14',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo)VALUES ('3', 'Implantación de lineas de autobus al nuevo HUCA', 'Lineas de bus Nuevo HUCA', '1','0', '3', '1','2013/05/16',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo) VALUES ('4', 'Somos demasiados runners en la ciudad', 'Nuevo estadio de atletismo', '6','0', '4', '1','2017/01/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo) VALUES ('5', 'La hora de recogida de basuras en invierno es demasiado tarde', 'Ampliacion de horario de recogida', '0','0', '5', '1','2017/05/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo) VALUES ('6', 'Las alcantarillas funcionan muy mal', 'Mejoras alcantarillado', '1','0', '6', '1','2017/02/12',FALSE);

INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('7','Incluir el coste energético de las casas en su valoración de mercado','Coste energético casas', '0','0', '7', '1','2012/07/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('8','Activar ayudas a la eficiencia energética para apoyar la rehabilitación','Ayudas', '0','0', '7', '1','2016/12/1',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('9','Establecer un IVA reducido para los biocombustibles sólidos y las calderas de biomasa','IVA', '0','0', '7', '1','2011/04/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('11','Fomentar la colaboración público privada en la gestión de los bosques','Gestión bosques', '0','0', '7', '1','2014/07/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('12','Introducir planes de eficiencia para reducir la huella de carbono de los edificios de uso público','Eficiencia', '0','0', '7', '1','2012/06/06',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('13','Introducir peajes “inteligentes” que promuevan el transporte colectivo y el uso de vehículos de bajas emisiones', 'Peajes','0','0',  '7', '1','2012/05/25',FALSE);

INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('14','Construcción o instalación de vestuarios y aseos en los campos de fútbol situados al sur de la Fuenfresca','Campos de fútbol', '0','0', '8', '1','1999/05/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('15','Reducir el precio por aparcar en la zona verde y zona azul', 'Precio','0','0', '9', '1','2016/09/29',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('16','Retirada de zona verde y zona azul en Tetuán, Barrio del Pilar y Ventilla','Retirar zona verde', '0', '0', '9', '1','2015/09/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('17','Urbanizar con zonas verdes mediana Paseo de la Castellana','Urbanizar', '0', '0', '9', '1','1994/05/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('18','Ampliar la zona VERDE del estacionamiento regulado', 'Ampliar zona verde','0', '0', '9', '1','1994/05/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('19','Eliminar zonas verdes en el entorno del Museo Reina Sofía','Eliminar', '0', '0', '9', '1','1994/05/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, votos_Positivos, votos_Negativos, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('20','Ampliar el horario de la zona verde e incluir los domingos','Ampliar horario', '0', '0', '9', '1','1994/05/25',FALSE);

INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('21','SUBAN A NIVEL 2 ESTRUCTURAL EL EDIFICIO ESPAÑA','Subir nivel','10', '1','1994/05/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('22','Rehabilitar edificios de viviendas sin gastar dinero publico ni privado.','Rehabilitar','10', '1','2014/04/26',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('23','instalación gratuita de ascensores en edificios viejos de mínimo 4 plantas','Ascensores','10', '1','2017/02/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('24','Acceso a lugares y edificios históricos que están cerrados al público','Edificios históricos','10', '1','2015/09/09',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('25','Pagar subvenciones de Rehabilitación Edificios y Ascensor en el Centro','Subvenciones','10', '1','2016/05/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('26','Alquiler vivienda edificios vacios','Alquiler','10', '1','2001/05/25',FALSE );
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('27','Abastecimiento de los edificios de carácter publico por medio de energía solar','Energía solar','10', '1','2016/04/01',FALSE);

INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('28','Difundir Animales de el Centro de Protección Animal CPA "La Fortuna "','Difusión de animales','12', '1','1994/05/25',FALSE );
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('29','centros veterinarios gratuitos , cuidado de animales que viven en la calle','Veterinarios','12', '1','2002/05/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('30','vacuna antirrabica animales compañia','Vacuna','12', '1','2014/06/14',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('31','Madrid necesita una nueva Ordenanza de Tenencia Animales Domésticos','Ordenanza','12', '1','2005/04/25',FALSE);
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('32','hOSPITAL PÚBLICO PARA ANIMALES Y MASCOTAS LEGALES','hospital','12', '1','2016/05/25',FALSE );
INSERT INTO asw.sugerencia (id, contenido, nombre, categoria_id,usuario_id,fecha_creacion,consiguio_el_minimo ) VALUES('33','Madrid tolerancia cero contra el maltrato animal','Madrid','12', '1','2016/08/06',FALSE);

INSERT INTO asw.comentario (id, contenido, sugerencia_id,usuario_id) VALUES ('1', 'Me parece correctisimo', '0','1');
INSERT INTO asw.comentario (id, contenido, sugerencia_id,usuario_id) VALUES ('2', 'Que la soterren ya que estamos', '1','2');

INSERT INTO asw.comentario (id, contenido, sugerencia_id,usuario_id) VALUES ('3', 'Para que quieres saber eso? xd', '2','2');
INSERT INTO asw.comentario (id, contenido, sugerencia_id,usuario_id) VALUES ('4', 'Por un Oviedo verde', '2','1');

INSERT INTO asw.comentario (id, contenido, sugerencia_id,usuario_id) VALUES ('5', 'No se, yo siempre le echo 20', '3','1');
INSERT INTO asw.comentario (id, contenido, sugerencia_id,usuario_id) VALUES ('6', 'A mi me vendria genial', '3','2');

INSERT INTO asw.comentario (id, contenido, sugerencia_id,usuario_id) VALUES ('7', '¿Pero qué me estas container?', '4','2');
INSERT INTO asw.comentario (id, contenido, sugerencia_id,usuario_id) VALUES ('8', 'Cuando hace calor huele fatal', '4','1');

INSERT INTO asw.comentario (id, contenido, sugerencia_id,usuario_id) VALUES ('9', 'Todo genial', '5','2');

INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('1', '1');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('1', '2');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('1', '3');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('1', '4');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('1', '5');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('1', '6');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('1', '7');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('1', '8');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('1', '9');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('1', '10');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('2', '11');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('2', '12');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('2', '13');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('2', '14');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('2', '15');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('2', '16');
INSERT INTO asw.voto (sugerencia_id, citizen_id) VALUES ('2', '17');

INSERT INTO asw.configuracion (id, palabras_no_permitidas, minimo_votos) VALUES ('1', 'polla@@puta', '200');
