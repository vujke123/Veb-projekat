insert into KORISNIK (id,korisnicko_ime,lozinka,ime,prezime,kontakt_broj,email,datum_rodjenja,uloga,aktivan) values (1,'vujke123','test','Jovan','Vujic','123456','vujic502@gmail.com','20-01-1999',0,true);
insert into KORISNIK (id,korisnicko_ime,lozinka,ime,prezime,kontakt_broj,email,datum_rodjenja,uloga,aktivan) values (2,'vujkeza','test','Marko','Vujic','1234','marko502@gmail.com','31-06-1997',1,false );
insert into KORISNIK (id,korisnicko_ime,lozinka,ime,prezime,kontakt_broj,email,datum_rodjenja,uloga,aktivan) values (3,'buba','test','Ljubisa','Novakovic','1234567','buba@gmail.com','19-07-1997',2,true);

insert into TRENING (id, naziv, opis, tip_treninga, trajanje, ocena) values (1,'OlP','Kosovska 44','066/380-368','olp@gmail.com','5');
insert into TRENING (id, naziv, opis, tip_treninga, trajanje, ocena) values (2,'Full gym','Radnicka 15','062/116-5495','fullgym@gmail.com', '0');

insert into FITNES_CENTAR (id, naziv, adresa, br_tel_centrale,email) values (1,'trening1','trcanje po traci','kardio','1h i 30min');
insert into FITNES_CENTAR (id, naziv, adresa, br_tel_centrale,email) values (2,'trening2','dizanje tegova','snaga','1h');

insert into SALA(id, kapacitet, oznaka_sale, fitnes_centar_id) values (1,35,'MIA21',2);
insert into SALA(id, kapacitet, oznaka_sale, fitnes_centar_id) values (2,15,'L13',1);

insert into ODRZAVANJE_TRENINGA(id, dan,vreme, cena_karte, fitnes_id, trening_id) values (1, '2021-05-25', '17:00', '500din',1,2);

INSERT INTO sobe_odrzavanje(soba_id , odrzavanje_id) values (1, 1);

INSERT into ODRADJEN_TRENING( ocena, clan_id, trening_id ) values (6,3,2);

insert into REZERVACIJE(clan_id, odrzavanje_id) values (3,1);
