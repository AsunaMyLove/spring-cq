drop table PCR_CHARACTER_RANK;

CREATE TABLE `PCR_CHARACTER_RANK` (
  `ID` varchar(10) NOT NULL,
  `name` varchar(40) NOT NULL,
  `chinese_name` varchar(40),
  `rank` varchar(5),
  `url` varchar(100),
  `img_url` varchar(100),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

