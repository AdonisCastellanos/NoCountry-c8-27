INSERT INTO appdb.`user`
(country, date_created, email, last_updated, name, password, phone)
VALUES('Marte', now(), 'admin@admin.com', now(), 'admin', 'admin', '+9994146541232');

INSERT INTO appdb.`user`
(country, date_created, email, last_updated, name, password, phone)
VALUES('Venezuela', now(), 'test@test.com', now(), 'test', 'test', '+584146541232');


INSERT INTO appdb.company
(address, city, country, date_created, email, last_updated, logo, name, phone, validation)
VALUES('la luna', 'crater', 'espacio', now(), 'democompany@compani.com', now(), '', 'Demo Company', '+9991234571', 0);


INSERT INTO appdb.user_company
(user_id, company_id)
VALUES(2, 1);


INSERT INTO appdb.comment
(body, date_created, last_updated, rate, company_id, user_id)
VALUES('esta empresa es lo maximo', now(), now(), 5,  1, 1);

INSERT INTO appdb.job_offer
(date_created, description, expiration_date, last_updated, max_salary, min_salary, `position`, title, company_id)
VALUES(now(), 'trabajo como mesero en el bar moon bar ubicado en un crater lunar', null, now(), '1000', '200', 'camarero', 'Camarero para MoonBar', 1);

INSERT INTO appdb.job_offer
(date_created, description, expiration_date, last_updated, max_salary, min_salary, `position`, title, company_id)
VALUES(now(), 'trabajo como cocinero en el bar moon bar ubicado en un crater lunar', null, now(), '2000', '1000', 'cocinero', 'Cocinero para MoonBar', 1);

