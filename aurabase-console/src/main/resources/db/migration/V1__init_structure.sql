CREATE TABLE `tbl_gen_test` (
  `tst_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tst_name` varchar(50) NOT NULL,
  PRIMARY KEY (`tst_id`),
  UNIQUE KEY `tst_name_UNIQUE` (`tst_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tbl_gen_test2` (
  `tst_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tst_name` varchar(50) NOT NULL,
  `tst_surname` varchar(50) NOT NULL,
  `tst_tlfNumber` varchar(50) NOT NULL,
  `tst_address` varchar(50) NOT NULL,
  
  PRIMARY KEY (`tst_id`),
  UNIQUE KEY `tst_name_UNIQUE` (`tst_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE `aurabase`.`tbl_lang_app` (
  `app_id`  INT NOT NULL AUTO_INCREMENT ,
  `app_name` VARCHAR(10) NOT NULL ,
  `app_technology` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`app_id`) )ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE  TABLE `aurabase`.`tbl_lang_language` (
  `language_id` INT NOT NULL AUTO_INCREMENT ,
  `language_name` VARCHAR(15) NOT NULL ,
  `language_code` VARCHAR(2) NOT NULL ,
  PRIMARY KEY (`language_id`) )ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
  CREATE  TABLE `aurabase`.`tbl_lang_translation` (
  `translation_id` INT NOT NULL AUTO_INCREMENT ,
  `translation_key` VARCHAR(50) NOT NULL ,
  `translation_value` VARCHAR(50) NULL ,
  `translation_cDate` TIMESTAMP NOT NULL ,
  `translation_mDate` TIMESTAMP NULL ,
  `translation_id_app` INT NOT NULL ,
  `translation_id_language` INT NOT NULL ,
  PRIMARY KEY (`translation_id`) )ENGINE=InnoDB DEFAULT CHARSET=utf8;

  

