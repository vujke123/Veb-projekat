insert into KORISNIK (id,korisnicko_ime,lozinka,ime,prezime,kontakt_broj,email,datum_rodjenja,uloga,aktivan) values (1,'vujke123','test','Jovan','Vujic','123456','vujic502@gmail.com','20-01-1999',1,true);
insert into KORISNIK (id,korisnicko_ime,lozinka,ime,prezime,kontakt_broj,email,datum_rodjenja,uloga,aktivan) values (2,'vujkeza','test4','Marko','Vujic','1234','marko502@gmail.com','31-06-1997',2,false );
insert into KORISNIK (id,korisnicko_ime,lozinka,ime,prezime,kontakt_broj,email,datum_rodjenja,uloga,aktivan) values (3,'buba','test1','Ljubisa','Novakovic','1234567','buba@gmail.com','19-07-1997',3,true);

insert into TRENING (id, naziv, opis, tip_treninga, trajanje, ocena, trener_id) values (1,'trening1','trcanje po traci','kardio','1h i 30min','3',2);
insert into TRENING (id, naziv, opis, tip_treninga, trajanje, ocena, trener_id) values (2,'trening2','dizanje tegova','snaga','1h','4.3',2);

insert into FITNES_CENTAR (id, naziv, adresa, br_tel_centrale,email) values (1,'FULL Gym', 'Dr.Sime 24, Novi Sad', '1234567','fullgym@gmail.com');
insert into FITNES_CENTAR (id, naziv, adresa, br_tel_centrale,email) values (2,'OLP', 'Strazilovska 9a, Novi Sad', '14609565','opl@gmail.com');

insert into SALA(id, kapacitet, oznaka_sale, fitnes_centar_id) values (1,35,'MIA21',2);
insert into SALA(id, kapacitet, oznaka_sale, fitnes_centar_id) values (2,15,'L13',1);

insert into ODRADJEN_TRENING(id, ocena, clan_id, trening_id,korisnik_id) values (1, 4.5, 3, 1, 3 );

insert  into ODRZAVANJE_TRENINGA(id, dan, cena_karte, sala_id) values (1, '13.5.2021', '500din',1);

insert into ODRZAVANJE_TRENINGA_SALE (odrzavanje_treninga_id, sale_id) values (1,2);

insert into PRIJAVLJEN_TRENING(id, clan_id, trening_id, korisnik_id, odrzavanje_treninga_id) values(1,3,2,3,1);