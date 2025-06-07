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

INSERT INTO learningresources ( userid, lr_title, lr_description, lr_category, lr_link) VALUES ( 1, 'Introducción a imágenes satelitales',  'Cómo interpretar NDVI y otros índices.',     'Satellite Data', 'https://quantumcorpsage.io/ndvi-guide');
INSERT INTO learningresources ( userid, lr_title, lr_description, lr_category, lr_link) VALUES ( 1, 'Análisis de suelos con Python',      'Script básico para clasificar pH y nutrientes.', 'Soil Analytics', 'https://github.com/QCS/soil-python');
INSERT INTO learningresources ( userid, lr_title, lr_description, lr_category, lr_link) VALUES ( 1, 'Modelos de predicción meteorológica', 'Uso de modelos ARIMA para forecast de lluvias.', 'Meteorology',     'https://qcs-blog.io/meteorology-arima');
INSERT INTO learningresources ( userid, lr_title, lr_description, lr_category, lr_link) VALUES ( 1, 'Buenas prácticas de riego',           'Optimización de riego por goteo y pivote central.', 'Irrigation',      'https://quantumcorpsage.io/irrigation');
INSERT INTO learningresources ( userid, lr_title, lr_description, lr_category, lr_link) VALUES (1, 'Fundamentos de machine learning',     'Curso gratuito de ML aplicado a agricultura.',  'Machine Learning', 'https://coursera.org/qcs-ml-agri');

INSERT INTO recommendations ( user_id, r_Title, r_Description, r_Category) VALUES ( 1, 'Ajustar dosis de nitrógeno', 'Reducir N en un 10% por alta humedad.',   'FERTILIZATION');
INSERT INTO recommendations ( user_id, r_Title, r_Description, r_Category) VALUES ( 1, 'Programar riegos nocturnos', 'Evitar horas de insolation máxima.',      'IRRIGATION');
INSERT INTO recommendations ( user_id, r_Title, r_Description, r_Category) VALUES ( 1, 'Rotación con leguminosas',   'Plantación de frijol INIA en lote 3.',   'CROP_ROTATION');

INSERT INTO supply (crop_id, supply_name, supply_quantity, supply_unit, supply_description) VALUES (1, 'Tubería de polietileno 16mm', 200, 'metros', 'Para sistema de riego por goteo.');
INSERT INTO supply (crop_id, supply_name, supply_quantity, supply_unit, supply_description) VALUES (2, 'Boquillas de goteo 4L/h',      500, 'unidades', 'Emitidores autocompensantes.');
INSERT INTO supply (crop_id, supply_name, supply_quantity, supply_unit, supply_description) VALUES (3, 'Estacas de bambú',             150, 'unidades', 'Soporte para cultivos trepadores.');
INSERT INTO supply (crop_id, supply_name, supply_quantity, supply_unit, supply_description) VALUES (4, 'Fertilizante Urea',            300, 'kg',      'Alta pureza, 46% N.' );

INSERT INTO support ( title, description, priority) VALUES ('Incidencia en sensor de humedad',    'El sensor MPS-6 no responde datos.',              'ALTA');
INSERT INTO support ( title, description, priority) VALUES ( 'Fallo en subida de datos satelitales','Interrupción en la API de satélite',             'MEDIA');
INSERT INTO support (title, description, priority) VALUES ('Error en módulo de alertas',         'Las notificaciones push no se envían a Android.',  'CRÍTICA');