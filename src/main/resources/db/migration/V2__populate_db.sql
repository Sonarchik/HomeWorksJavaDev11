INSERT INTO Client (name)
 VALUES
    ('Roman Borziy'),
    ('Jonny Deph'),
    ('Alex Prostoy'),
    ('Antonio Vdumchiviy'),
    ('Nikola Tesla'),
    ('Romanio Nudnii'),
    ('Mari Christmas'),
    ('Alex Smitt'),
    ('Boris Ant'),
    ('Nik Tekstolit');

INSERT INTO Planet (id, name)
 VALUES
    ('JUP238', 'Jupiter'),
    ('SAT64', 'Saturn'),
    ('MARS6', 'Mars'),
    ('VEN', 'Venus'),
    ('URAN', 'Uranus');

INSERT INTO Ticket (created_at, client_id, from_planet_id, to_planet_id)
 VALUES
    ('2023-03-10 10:30:00', 1, 'MARS6', 'VEN'),
    ('2023-03-10 11:00:00', 2, 'VEN', 'MARS6'),
    ('2023-03-10 12:00:00', 3, 'MARS6', 'JUP238'),
    ('2023-03-10 13:00:00', 4, 'SAT64', 'URAN'),
    ('2023-03-10 14:00:00', 5, 'JUP238', 'SAT64'),
    ('2023-03-10 15:00:00', 6, 'VEN', 'JUP238'),
    ('2023-03-10 16:00:00', 7, 'MARS6', 'SAT64'),
    ('2023-03-10 17:00:00', 8, 'URAN', 'JUP238'),
    ('2023-03-10 18:00:00', 9, 'JUP238', 'MARS6'),
    ('2023-03-10 19:00:00', 10, 'URAN', 'SAT64');