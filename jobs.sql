CREATE TABLE IF NOT EXISTS `easyjobs`.`client_data` (`id` INT unsigned NOT NULL auto_increment,`name` TEXT NOT NULL,`address` TEXT NOT NULL,`email_id` TEXT NOT NULL,`contact` VARCHAR(13) NOT NULL,`web_address` TEXT NULL,`user_name` VARCHAR(45) NOT NULL UNIQUE,`password` VARCHAR(45) NOT NULL,`created_at` VARCHAR(45) NULL,`updated_at` VARCHAR(45) NULL,PRIMARY KEY (`id`))

CREATE TABLE IF NOT EXISTS `easyjobs`.`applicant_data`(`id` INT unsigned NOT NULL auto_increment,`name` TEXT NOT NULL,`address` TEXT NOT NULL,`contact` VARCHAR(13) NOT NULL,`email_id` TEXT NOT NULL,`qualification` TEXT NOT NULL,`certification_training` TEXT NULL,`experience` VARCHAR(45) NOT NULL,`resume` TEXT NULL,`user_name` VARCHAR(45) NOT NULL UNIQUE,`password` VARCHAR(45) NOT NULL,`job_type_preference` VARCHAR(45) NULL,`open_for_relocation` TINYINT NULL,`current_salary` VARCHAR(45) NULL,`expected_salary` VARCHAR(45) NULL,`created_at` VARCHAR(45) NULL,`updated_at` VARCHAR(45) NULL,PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `easyjobs`.`job_data` (`id` INT unsigned NOT NULL auto_increment PRIMARY KEY,`title` TEXT NOT NULL,`location` TEXT NOT NULL,`type` VARCHAR(45) NOT NULL,`qualification` TEXT NULL,`experience` VARCHAR(45) NULL,`skills` TEXT NULL,`description` TEXT NULL,`start_date_time` TEXT NULL,`end_date_time` TEXT NULL,`budget` VARCHAR(45) NULL,`job_client_id` INT unsigned NOT NULL,`created_at` VARCHAR(45) NULL,`updated_at` VARCHAR(45) NULL,CONSTRAINT `fk_job` FOREIGN KEY (`job_client_id`) REFERENCES `client_data` (`id`));



insert into client_data(name,address,email_id,contact,web_address,user_name,password) values(1,'jobtest','pathankot','job@gmail.com','9878709697','www.jobsdata.com','job_user','job_test');

insert into job_data(title,location,type,qualification,experience,skills,description,start_date_time,end_date_time,budget,job_client_id) values('software developer','pathankot','hourly','B.tech','1 to 4 years','java,android','we need a java developer','26/01/2019 12:00:00 pm','30/01/2019 5:00:00 pm','5k','1');
















' Dont create this table
CREATE TABLE IF NOT EXISTS `easyjobs`.`project_data` (`id` INT unsigned NOT NULL auto_increment,`name` TEXT NOT NULL,`start_date_time` TEXT NOT NULL,`end_date_time` TEXT NOT NULL,`client_name` TEXT NOT NULL,`project_duration` TEXT NOT NULL,`project_location` TEXT NOT NULL,`created_at` VARCHAR(45) NULL,`updated_at` VARCHAR(45) NULL,PRIMARY KEY (`id`));