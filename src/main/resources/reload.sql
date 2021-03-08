DROP TABLE IF EXISTS contagi;

CREATE TABLE contagi
(
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  data VARCHAR(250) NOT NULL,
  stato VARCHAR(250) NOT NULL,
  codice_regione VARCHAR(250) NOT NULL,
  denominazione_regione VARCHAR(250) NOT NULL,
  lat FLOAT NOT NULL,
  long FLOAT NOT NULL,
  ricoverati_con_sintomi INTEGER NOT NULL,
  terapia_intensiva INTEGER NOT NULL,
  totale_ospedalizzati INTEGER NOT NULL,
  isolamento_domiciliare INTEGER NOT NULL,
  totale_positivi INTEGER NOT NULL,
  variazione_totale_positivi INTEGER NOT NULL,
  nuovi_positivi INTEGER NOT NULL,
  dimessi_guariti INTEGER NOT NULL,
  deceduti INTEGER NOT NULL,
  casi_da_sospetto_diagnostico INTEGER ,
  casi_da_screening INTEGER ,
  totale_casi INTEGER NOT NULL,
  tamponi INTEGER NOT NULL,
  casi_testati INTEGER NOT NULL,
  note VARCHAR(250),
  ingressi_terapia_intensiva INTEGER NOT NULL,
  note_test VARCHAR(250) ,
  note_casi VARCHAR(500) ,
  totale_positivi_test_molecolare INTEGER NOT NULL,
  totale_positivi_test_antigenico_rapido INTEGER NOT NULL,
  tamponi_test_molecolare INTEGER NOT NULL,
  tamponi_test_antigenico_rapido INTEGER NOT NULL,
  codice_nuts_1 VARCHAR(250) NOT NULL,
  codice_nuts_2 VARCHAR(250) NOT NULL
)
AS
SELECT NULL,*
FROM CSVREAD('src\\main\\resources\\datiContagi.csv',null);