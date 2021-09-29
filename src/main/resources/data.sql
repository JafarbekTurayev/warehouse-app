insert into category(id, name, active, parent_category_id)
values (1, 'Elektronika', true, null),
       (2, 'Telefon', true, 1);
insert into measurement(id, name, active)
values (1, 'KG', true),
       (2, 'DONA', true);