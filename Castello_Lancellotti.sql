Drop Database Castello_Lancellotti;
Create Database Castello_Lancellotti;
use Castello_Lancellotti;

Create Table Utente(
id_utente int primary key NOT NULL AUTO_INCREMENT,
nome varchar(30) not null,
cognome varchar(30) not null,
amministratore boolean not null,
telefono varchar(12) not null,
mail varchar(40) not null,
nome_utente varchar(20) not null,
password varchar(200) not null
);

Create Table Categoria(
id_categoria int primary key NOT NULL AUTO_INCREMENT,
nome varchar(20) not null,
link_immagine varchar(500) not null
);

Create Table Evento(
id_evento int primary key NOT NULL AUTO_INCREMENT,
id_categoria int not null,
foreign key (id_categoria) references Categoria(id_categoria) 
on update cascade
on delete cascade,
link_immagine varchar(500) not null,
descrizione varchar(1000) not null,
prezzo float not null,
nome varchar(30) not null
);

Create Table Data(
data date not null,
id_evento int not null,
foreign key (id_evento) references Evento(id_evento) 
on update cascade
on delete cascade,
primary key(data,id_evento)
);

Create Table Orario(
ora time not null,
data date not null,
foreign key(data) references Data(data)
on delete cascade
on update cascade,
id_evento int not null,
foreign key(id_evento) references Evento(id_evento)
on delete cascade
on update cascade,
primary key(ora,data,id_evento),
posti_disponibili int not null
);

Create Table Partecipare(
id_utente int not null,
foreign key(id_utente) references Utente(id_utente)
on delete cascade
on update cascade,
id_evento int not null,
foreign key(id_evento) references Evento(id_evento)
on delete cascade
on update cascade,
acquistato boolean not null,
quantita_biglietti int not null,
data_partecipazione date not null,
orario_partecipazione time not null,
prezzo float not null,
primary key(id_utente,id_evento)
);

Create Table Recensione(
id_utente int not null,
foreign key (id_utente) references Utente(id_utente)
on delete cascade
on update cascade,
id_evento int not null,
foreign key(id_evento) references Evento(id_evento)
on delete cascade
on update cascade,
commento char(200) not null,
valutazione int not null,
data_recensione date not null,
orario_recensione time not null,
primary key(id_utente,id_evento)
);

insert into Utente values
(1,"Antonio","Aschettino",true,3512134154,"antonionola2000@gmail.com","tony2000","1250b0408ac3042fb85c05aa607e8516ce661648"),
(2,"Lorenzo","Vecchione",false,3334455566,"lorenzo.vecchione@outlook.it","lore","17ba5986228ff62bfdb53772c52e156d5d063fa2"),
(3,"Marco","Castigliola",false,3345678231,"marco.castigliola@live.it","Casty","0fe682d7f941cff149ce9447f5ad9533a10b40ec"),
(4,"Luca","Del Piero",false,3329870564,"luca.delPiero@gmail.com","Pinturicchiu","28ad67034af91d29db761e68b0250cf74c2e7fa1"),
(5,"Maria","Napolitano",false,3215678342,"maria.napolitano@libero.it","maryNap","19fbf5a4dc377dcdb6ecf95a298885acf7bf1bf4");
#Aschettino1.   Vecchione2@     Castigliola3&   DelPiero4!  Napolitano5$


insert into Categoria values
(1,"Visita Standard","Images/visitaStandard.jpg"),
(2,"Evento Speciale","Images/evento.jpg"),
(3,"Spettacolo","Images/spettacolo.jpg"),
(4,"Concerto","Images/concerto.jpg");

insert into Evento values
(1,1,"Images/visitaDiGruppo.jpg","Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bb",30.89,"Visita di Gruppo"),
(2,1,"Images/visitaGuidata.jpg","Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bb",20.88,"Visita Guidata"),
(3,2,"Images/luminaInCastro.jpg","Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bb",10.88,"Lumina in Castro"),
(4,2,"Images/visitaCamere.jpg","Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bb",34.80,"VIsita alle Camere"),
(5,3,"Images/spettacoloCircense.jpg","Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bb",29.80,"Spettacolo Circense"),
(6,4,"Images/concertoTenori.jpg","Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bb",9.80,"Concerto Tenori"),
(7,1,"Images/visitaBorgo.jpg","Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bb",12.00,"Visita del Borgo"),
(8,2,"Images/incendioCastello.jpg","Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bb", 15.00,"Incendio del Castello"),
(9,3,"Images/giostraMedievale.jpg","Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb Bbbbbb bbbbb bbbbbb b bbbbbb bbbbbbbbb bbbbbbb bbbbbbb b bbbbbbbbb bb",9.80,"Giostra Medievale");




insert into Data values
("2020-11-30",1),
("2019-11-30",2),
("2030-11-30",1),
("2029-11-30",2),
("2014-05-30",3),
("2017-11-30",4),
("2011-11-30",5),
("2014-05-30",6);

insert into Orario values
("21:30:00","2020-11-30",1,20),
("23:30:00","2030-11-30",1,30),
("22:10:00","2029-11-30",2,40),
("15:10:00","2019-11-30",2,50),
("21:30:00","2014-05-30",3,100),
("23:30:00","2017-11-30",4,200),
("22:10:00","2011-11-30",5,150),
("16:10:00","2014-05-30",6,160),
("22:30:00","2030-11-30",1,180),
("19:10:00","2029-11-30",2,40),
("18:10:00","2019-11-30",2,20),
("15:30:00","2014-05-30",3,70);


insert into Partecipare values
(1,1,false,2,"2020-11-30","21:30:00",30.89),
(2,1,false,2,"2020-11-30","21:30:00",30.89),
(2,2,false,4,"2029-11-30","19:10:00",20.88),
(2,5,false,10,"2011-11-30","22:10:00",29.80),
(2,6,true,5,"2014-05-30","16:10:00",9.80),
(3,1,true,2,"2030-11-30","23:30:00",30.89),
(4,3,false,10,"2014-05-30","21:30:00",10.88),
(5,4,true,2,"2017-11-30","23:30:00",34.80);


insert into Recensione values
(1,1,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",4,"2020-12-12", "22:10:00"),
(2,1,"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",5,"2020-10-10","20:20:00"),
(2,2,"ccccccccccccccccccccccccccccccccccccc",1,"2019-02-02","17:30:20"),
(3,3,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",4,"2020-12-12", "22:10:00"),
(4,4,"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",5,"2020-10-10","20:20:00"),
(5,5,"ccccccccccccccccccccccccccccccccccccc",1,"2019-02-02","17:30:20");