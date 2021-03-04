DROP TABLE IF EXISTS somministrazioneVaccini;

CREATE TABLE somministrazioneVaccini
(
  id INTEGER AUTO_INCREMENT  PRIMARY KEY,
  data_somministrazione DATE NOT NULL,
  area VARCHAR(250) DEFAULT NULL,
  totale INTEGER NOT NULL,
  sesso_maschile INTEGER NOT NULL,
  sesso_femminile INTEGER NOT NULL,
  categoria_operatori_sanitari_sociosanitari INTEGER NOT NULL,
  categoria_personale_non_sanitario INTEGER NOT NULL,
  categoria_ospiti_rsa INTEGER NOT NULL,
  categoria_over80 INTEGER NOT NULL,
  categoria_forze_armate INTEGER NOT NULL,
  categoria_personale_scolastico INTEGER NOT NULL,
  prima_dose INTEGER NOT NULL,
  seconda_dose INTEGER NOT NULL,
  codice_NUTS1 VARCHAR(250) NOT NULL,
  codice_NUTS2 VARCHAR(250) NOT NULL,
  codice_regione_ISTAT INTEGER NOT NULL,
  nome_area VARCHAR(250) NOT NULL
)
AS
SELECT NULL,*
FROM CSVREAD('src\\main\\resources\\datiSomministrazioni.csv',null);


DROP TABLE IF EXISTS summaryVaccini;

CREATE TABLE summaryVaccini
(
  id INTEGER AUTO_INCREMENT  PRIMARY KEY,
  area VARCHAR(250) DEFAULT NULL,
  dosi_somministrate INTEGER NOT NULL,
  dosi_consegnate INTEGER NOT NULL,
  percentuale_somministrazione FLOAT NOT NULL,
  ultimo_aggiornamento DATE NOT NULL,
  codice_NUTS1 VARCHAR(250) NOT NULL,
  codice_NUTS2 VARCHAR(250) NOT NULL,
  codice_regione_ISTAT INTEGER NOT NULL,
  nome_area VARCHAR(250) NOT NULL
)
AS
SELECT NULL,*
FROM CSVREAD('src\\main\\resources\\datiResoconto.csv',null);

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


