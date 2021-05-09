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
nome varchar(20) not null
);

Create Table Evento(
id_evento int primary key NOT NULL AUTO_INCREMENT,
id_categoria int not null,
foreign key (id_categoria) references Categoria(id_categoria) 
on update cascade
on delete cascade,
link_immagine varchar(200) not null,
descrizione varchar(500) not null,
prezzo float not null,
nome varchar(30) not null,
posti_disponibili int not null
);

Create Table Data(
data_inizio date not null,
id_evento int not null,
foreign key (id_evento) references Evento(id_evento) 
on update cascade
on delete cascade,
data_fine date not null,
primary key(data_inizio,id_evento)
);

Create Table Orario(
ora time not null,
data_inizio date not null,
foreign key(data_inizio) references Data(data_inizio)
on delete cascade
on update cascade,
id_evento int not null,
foreign key(id_evento) references Evento(id_evento)
on delete cascade
on update cascade,
primary key(ora,data_inizio,id_evento)
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
(001,"antonio","aschettino",true,3512134154,"antonionola2000@gmail.com","tony2000","Password001"),
(002,"Lorenzo","Vecchione",false,3334455566,"aaaaaaaaa@aaaa.com","lore","Password002");

insert into Categoria values
(001,"spettacolo"),
(002,"visita");

insert into Evento values
(10,001,"aaaaaaaa","bbbbbbbbbbbbbbbbbbbbbbb",30.89,"cccccc",20),
(20,002,"zzzzzzz","xxxxxxxxxxxxxxxx",20.88,"dddddddddd",10);

insert into Data values
("2020-11-30",10,"2020-12-05"),
("2019-11-30",10,"2019-12-05"),
("2018-05-30",20,"2018-06-05");

insert into Orario values
("21:30:00","2020-11-30",10),
("23:30:00","2020-11-30",10),
("22:10:00","2018-05-30",20),
("15:10:00","2019-11-30",10);

insert into Partecipare values
(001,10,false,2,"2020-11-30","21:30:00"),
(002,20,true,4,"2018-05-30","22:10:00"),
(002,10,false,10,"2019-11-30","15:10:00");

insert into Recensione values
(001,10,"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",4,"2020-12-12", "22:10:00"),
(002,10,"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",5,"2020-10-10","20:20:00"),
(002,20,"ccccccccccccccccccccccccccccccccccccc",1,"2019-02-02","17:30:20");
