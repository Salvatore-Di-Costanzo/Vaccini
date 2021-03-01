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
FROM CSVREAD('C:\\Users\\sdicostanzo\\Desktop\\Vaccini\\src\\main\\resources\\dati.csv',null);


