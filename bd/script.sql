drop DATABASE if exists aidid;
CREATE DATABASE IF NOT EXISTS aidid;
USE aidid;

drop table if exists donation;
drop table if exists membership;
drop table if exists project;
drop table if exists project_participation;
drop table if exists project_project_participations;
drop table if exists role;
drop table if exists solidarity_history;
drop table if exists solidarity_history_donations;
drop table if exists solidarity_history_memberships;
drop table if exists solidarity_history_project_participations;
drop table if exists user;
drop table if exists user_donations;
drop table if exists user_memberships;
drop table if exists user_projects;
drop table if exists user_roles;

CREATE TABLE `donation` (
  `id` bigint(20) NOT NULL auto_increment,
  `amount` float NOT NULL,
  `created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `organization_id` bigint(20) DEFAULT NULL,
  `organization_user_name` varchar(255) DEFAULT NULL,
  `solidarity_history_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `membership` (
  `id` bigint(20) NOT NULL auto_increment,
  `amount` float NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `ending_date` datetime DEFAULT NULL,
  `organization_id` bigint(20) DEFAULT NULL,
  `organization_user_name` varchar(255) DEFAULT NULL,
  `periodicity` int(11) NOT NULL,
  `solidarity_history_id` bigint(20) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `project` (
  `id` bigint(20) NOT NULL auto_increment,
  `ending_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `organization_id` bigint(20) DEFAULT NULL,
  `organization_user_name` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `project_type` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `project_participation` (
  	`id` bigint(20) NOT NULL auto_increment,
  	`contact_email` varchar(255) DEFAULT NULL,
  	`contact_phone` int(11) DEFAULT NULL,
  	`description` varchar(255) DEFAULT NULL,
  	`project_id` bigint(20) DEFAULT NULL,
  	`solidarity_history_id` bigint(20) DEFAULT NULL,
	 PRIMARY KEY (id)
);


CREATE TABLE `project_project_participations` (
 	`project_id` bigint(20) NOT NULL,
  	`project_participations_id` bigint(20) NOT NULL,
  	foreign key (project_id)
	references project(id) on delete cascade,
	foreign key (project_participations_id)
	references project_participation(id) on delete cascade
);

CREATE TABLE `user` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `activity_type` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `solidarity_history_id` bigint(20) DEFAULT NULL,
	`role` varchar(31) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user_donations` (
	`organization_id` bigint(20) NOT NULL,
  	`donations_id` bigint(20) NOT NULL,
	foreign key (organization_id)
	references user(id) on delete cascade,
	foreign key (donations_id)
	references donation(id) on delete cascade
);

CREATE TABLE `user_memberships` (
  `organization_id` bigint(20) NOT NULL,
  `memberships_id` bigint(20) NOT NULL,
 	foreign key (organization_id)
	references user(id) on delete cascade,
	foreign key (memberships_id)
	references membership(id) on delete cascade
);

CREATE TABLE `user_projects` (
  `organization_id` bigint(20) NOT NULL,
  `projects_id` bigint(20) NOT NULL,
 	foreign key (organization_id)
	references user(id) on delete cascade,
	foreign key (projects_id)
	references project(id) on delete cascade
);

CREATE TABLE `solidarity_history` (
  `id` bigint(20) NOT NULL auto_increment,
  `collaborator_id` bigint(20) DEFAULT NULL,
  `collaborator_user_name` varchar(255) DEFAULT NULL,
  	PRIMARY KEY (`id`),
	foreign key (collaborator_id)
	references user(id) on delete cascade
);



CREATE TABLE `solidarity_history_donations` (
  `solidarity_history_id` bigint(20) NOT NULL,
  `donations_id` bigint(20) NOT NULL,
	foreign key (solidarity_history_id)
	references solidarity_history(id) on delete cascade,
	foreign key (donations_id)
	references donation(id) on delete cascade
);

CREATE TABLE `solidarity_history_memberships` (
  `solidarity_history_id` bigint(20) NOT NULL,
  `memberships_id` bigint(20) NOT NULL,
  	foreign key (solidarity_history_id)
	references solidarity_history(id) on delete cascade,
	foreign key (memberships_id)
	references membership(id) on delete cascade
);

CREATE TABLE `solidarity_history_project_participations` (
  `solidarity_history_id` bigint(20) NOT NULL,
  `project_participations_id` bigint(20) NOT NULL,
	foreign key (solidarity_history_id)
	references solidarity_history(id) on delete cascade,
	foreign key (project_participations_id)
	references project_participation(id) on delete cascade
); 



