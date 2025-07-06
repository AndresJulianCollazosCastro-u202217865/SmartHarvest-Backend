INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO users (user_name, user_email, user_password, user_location) VALUES ('user1','user1@quantumcorpsage.io','$2a$12$jqbpQ7YwVFhCHvevcgI6WO9dYFZu9Ud.MsdFHjTrZlzt4.UtwmuXe', 'Lima');
INSERT INTO users (user_name, user_email, user_password, user_location) VALUES ('admin','admin@quantumcorpsage.io','$2a$12$jqbpQ7YwVFhCHvevcgI6WO9dYFZu9Ud.MsdFHjTrZlzt4.UtwmuXe', 'Arequipa');
INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);

INSERT INTO crop ( crop_name, crop_type, crop_ubication, crop_area, crop_start_date, crop_end_date, next_crop_id, user_id) VALUES ( 'Maíz Amarillo', 'Grano', 'Valle de San Juan', 12.5, '2025-04-01', '2025-08-15', NULL, 1);
INSERT INTO crop ( crop_name, crop_type, crop_ubication, crop_area, crop_start_date, crop_end_date, next_crop_id, user_id) VALUES ( 'Arroz Integral', 'Grano', 'Ica Central', 20.0, '2025-03-20', '2025-07-30', NULL, 1);
INSERT INTO crop ( crop_name, crop_type, crop_ubication, crop_area, crop_start_date, crop_end_date, next_crop_id, user_id) VALUES ( 'Tomate Cherry', 'Hortaliza', 'Huánuco Norte', 5.0, '2025-05-10', '2025-09-01', NULL, 1);
INSERT INTO crop ( crop_name, crop_type, crop_ubication, crop_area, crop_start_date, crop_end_date, next_crop_id, user_id) VALUES ( 'Papa Andina', 'Tubérculo', 'Puno Alta', 15.0, '2025-02-15', '2025-06-10', NULL, 1);
INSERT INTO crop ( crop_name, crop_type, crop_ubication, crop_area, crop_start_date, crop_end_date, next_crop_id, user_id) VALUES ( 'Quinua Real', 'Cereal', 'La Libertad Oeste', 10.0, '2025-04-20', '2025-09-05', NULL, 1);

INSERT INTO cost (cost_concept, cost_amount, crop_id) VALUES ( 'Semillas de Maíz amarillo híbrido', 150.00, 1);
INSERT INTO cost ( cost_concept, cost_amount, crop_id) VALUES ( 'Fertilizante NPK 14-14-14', 200.50, 1);
INSERT INTO cost (cost_concept, cost_amount, crop_id) VALUES ( 'Riego por goteo (instalación)', 500.00, 2);
INSERT INTO cost ( cost_concept, cost_amount, crop_id) VALUES ( 'Plántulas de Tomate Cherry', 75.25,  3);
INSERT INTO cost ( cost_concept, cost_amount, crop_id) VALUES ( 'Control biológico de plagas (Trichoderma)', 120.00, 4);

INSERT INTO weatheralerts ( userid, wa_title, wa_description, wa_date, wa_type, wa_estate, visible) VALUES (1, 'Alerta de sequía',     'Período de baja humedad esperado los próximos 10 días', '2025-05-25 09:30:00', 'CRITICO', 'NUEVA', TRUE);
INSERT INTO weatheralerts ( userid, wa_title, wa_description, wa_date, wa_type, wa_estate, visible) VALUES ( 1, 'Lluvias intensas',     'Probabilidad de lluvias por encima del promedio',      '2025-06-01 14:00:00', 'ADVERTENCIA',    'NUEVA', TRUE);
INSERT INTO weatheralerts ( userid, wa_title, wa_description, wa_date, wa_type, wa_estate, visible) VALUES ( 1, 'Heladas nocturnas',    'Temperaturas por debajo de 0°C durante la madrugada', '2025-06-03 22:00:00', 'CRITICO',   'NUEVA', TRUE);

INSERT INTO historical_data ( user_id, h_date, crop_id, wa_id) VALUES ( 1, '2025-05-26', 1, 1);
INSERT INTO historical_data ( user_id, h_date, crop_id, wa_id) VALUES (1, '2025-06-02', 2, 2);
INSERT INTO historical_data ( user_id, h_date, crop_id, wa_id) VALUES ( 1, '2025-06-04', 3, 3);

INSERT INTO learningresources (userid, lr_title, lr_description, lr_category, lr_link) VALUES (1, 'Riego Inteligente con Inteligencia Artificial', 'Explica cómo robots y sensores permiten riego inteligente eficiente.', 'explicativo', 'https://www.youtube.com/watch?v=6WcvCDSU5CU');
INSERT INTO learningresources (userid, lr_title, lr_description, lr_category, lr_link) VALUES (1, '¿Qué es una imagen NDVI?', 'Definición e interpretación de NDVI para monitorear la salud vegetal.', 'informativo', 'https://www.youtube.com/watch?v=vBH_2EdfESE');
INSERT INTO learningresources (userid, lr_title, lr_description, lr_category, lr_link) VALUES (1, 'Regando SMART: RIEGO DE PRECISIÓN', 'Ejemplifica uso de datos y satélites para riego de precisión.', 'tutorial', 'https://www.youtube.com/watch?v=JLJ61dyMuRQ');
INSERT INTO learningresources (userid, lr_title, lr_description, lr_category, lr_link) VALUES (1, 'IA y sensores remotos para estimación del área sembrada', 'Uso de IA y sensores para medir plantaciones de arroz.', 'informativo', 'https://www.youtube.com/watch?v=c-vkCe8RGW8');
INSERT INTO learningresources (userid, lr_title, lr_description, lr_category, lr_link) VALUES (1, 'Uso de tecnología para un manejo eficiente del riego', 'Repasa tecnologías modernas para optimizar el riego agrícola.', 'explicativo', 'https://www.youtube.com/watch?v=FVQ4t8dARRs');




INSERT INTO recommendations ( user_id, crop_id, r_Title, r_Description, r_Category) VALUES (1, 1, 'Ajustar fertilización nitrogenada', 'Disminuir nitrógeno en un 10% debido a suelos con alta retención de humedad.', 'FERTILIZATION');
INSERT INTO recommendations ( user_id, crop_id, r_Title, r_Description, r_Category) VALUES (1, 1, 'Revisión de humedad del suelo', 'Usar tensiómetros para ajustar la frecuencia de riego.', 'IRRIGATION');
INSERT INTO recommendations ( user_id, crop_id, r_Title, r_Description, r_Category) VALUES (1, 1, 'Rotación con leguminosas', 'Plantación de frijol INIA en lote 3.', 'CROP_ROTATION');
INSERT INTO recommendations ( user_id, crop_id, r_Title, r_Description, r_Category) VALUES (1, 2, 'Riego nocturno controlado', 'Programar riegos entre las 20:00 y 4:00 para minimizar evaporación.', 'IRRIGATION');
INSERT INTO recommendations ( user_id, crop_id, r_Title, r_Description, r_Category) VALUES (1, 2, 'Aplicar silicio foliar', 'Mejorar resistencia a enfermedades del tallo con silicio semanal.', 'FERTILIZATION');
INSERT INTO recommendations ( user_id, crop_id, r_Title, r_Description, r_Category) VALUES (1, 2, 'Evitar siembra profunda', 'Mantener la profundidad de siembra entre 2 y 3 cm para germinación óptima.', 'CROP_ROTATION');
INSERT INTO recommendations ( user_id, crop_id, r_Title, r_Description, r_Category) VALUES ( 1, 3, 'Riego por goteo', 'Mejorar eficiencia hídrica y evitar enfermedades foliares.', 'IRRIGATION');
INSERT INTO recommendations ( user_id, crop_id, r_Title, r_Description, r_Category) VALUES ( 1, 4, 'Aplicar fertilización balanceada', 'Usar mezcla NPK 15-15-15 antes del aporque.', 'FERTILIZATION');
INSERT INTO recommendations ( user_id, crop_id, r_Title, r_Description, r_Category) VALUES ( 1, 4, 'Rotación con cebada', 'Cultivar cebada para romper el ciclo de patógenos del suelo.', 'CROP_ROTATION');

INSERT INTO supply (crop_id, supply_name, supply_quantity, supply_unit, supply_description) VALUES (1, 'Tubería de polietileno 16mm', 200, 'metros', 'Para sistema de riego por goteo.');
INSERT INTO supply (crop_id, supply_name, supply_quantity, supply_unit, supply_description) VALUES (2, 'Boquillas de goteo 4L/h',      500, 'unidades', 'Emitidores autocompensantes.');
INSERT INTO supply (crop_id, supply_name, supply_quantity, supply_unit, supply_description) VALUES (3, 'Estacas de bambú',             150, 'unidades', 'Soporte para cultivos trepadores.');
INSERT INTO supply (crop_id, supply_name, supply_quantity, supply_unit, supply_description) VALUES (4, 'Fertilizante Urea',            300, 'kg',      'Alta pureza, 46% N.' );

INSERT INTO support ( title, description, priority) VALUES ('Incidencia en sensor de humedad',    'El sensor MPS-6 no responde datos.',              'ALTA');
INSERT INTO support ( title, description, priority) VALUES ( 'Fallo en subida de datos satelitales','Interrupción en la API de satélite',             'MEDIA');
INSERT INTO support (title, description, priority) VALUES ('Error en módulo de alertas',         'Las notificaciones push no se envían a Android.',  'CRÍTICA');