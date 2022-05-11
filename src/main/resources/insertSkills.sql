--delete from spe_database.skills;
insert ignore into spe_database.skills(skill) values ("ReactJS"),("SpringBoot"),("Java"),("Python3"),("C++"),("Git"),("MongoDB"),("MySQL"),("AngularJS"),("HTML"),("CSS"),("Javascript"),("Node JS"),("Express"),("Postgres");

insert ignore into spe_database.authorities(authority) values ("profile_user:add"),("profile_user:read"),("profile_user:write"),("project_user:write"),("project_user:update"),("project_user:delete"),("post_user:write"),("post_user:update"),("post_user:delete");

