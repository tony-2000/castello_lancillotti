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
descrizione varchar(500) not null,
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
(1,"Visita Standard","https://media.discordapp.net/attachments/804105488416505909/841992938883514388/Immagine22.png"),
(2,"Evento","https://media.discordapp.net/attachments/804105488416505909/841992938883514388/Immagine22.png"),
(3,"Spettacolo","https://media.discordapp.net/attachments/804105488416505909/841992938883514388/Immagine22.png"),
(4,"Concerto","https://media.discordapp.net/attachments/804105488416505909/841992938883514388/Immagine22.png");

insert into Evento values
(1,1,"https://images-ext-1.discordapp.net/external/IINrJtfwL-0m5Fnww7xxtBReHkqieKfYv7KIh0w2n4A/http/www.pngall.com/wp-content/uploads/2016/07/Sun-Download-PNG.png","bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",30.89,"visita di gruppo"),
(2,1,"https://images-ext-1.discordapp.net/external/AhX6Veq4e6fUFebklwsCnVKGgBsGIeEdupq0uZRsO5s/https/artbreeder.b-cdn.net/imgs/992a2d7573eac3145d18f25f.jpeg","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",20.88,"visita guidata"),
(3,2,"https://images-ext-2.discordapp.net/external/eY32VZPOxv21VG0NKLo3FvTMUh6SknEncUgPZ1-t-6A/https/artbreeder.b-cdn.net/imgs/56bb9e653a340d2dbf4085f5.jpeg","ddddddddddddddddddddddddddddddddddddd",10.88,"lumina in castro"),
(4,2,"https://images-ext-2.discordapp.net/external/lik5xyMXaGXCYDbpUni_D655wj-TA4jCN5QPFrbk4Is/https/artbreeder.b-cdn.net/imgs/f44af504d6a62d4349b6c2cf.jpeg","wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww",34.80,"visita alle camere"),
(5,3,"https://images-ext-1.discordapp.net/external/19oDotsgR1G-JaSmOKQ1zOMp7xJ40FNK3AmEqmxihFY/https/artbreeder.b-cdn.net/imgs/e8fc873295a5a2c678078c80.jpeg","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",29.80,"spettacolo circense"),
(6,4,"https://images-ext-1.discordapp.net/external/iZjV6z17f0mCpBcq324in9ZBWnk3EPgfZb_HfJsRslM/http/www.goodmorningimagesdownload.com/wp-content/uploads/2020/01/Cool-Whatsapp-DP-Images-64.jpg","tttttttttttttttttttttttttttttttttttttttt",9.80,"concerto tenori");



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
