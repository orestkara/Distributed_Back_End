INSERT INTO "user" VALUES
                       ('997209513','Orestis','Karagiannis','it21564@hua.gr','it21564','$2a$12$fnDMOA2cDdJmMAqQnXqUEuFATGL/FI.9vs04L.u8GHVa/rboCCm32',TRUE,'2102344092'),
                       ('800111851','Aikaterini','Koliopoulou','it216110@hua.gr','it216110','$2a$12$ZRjyk7DMxQe5xwkN0GvknebE.EOmC9AbGmL5x8QLmb.UQpJOrxZN6',TRUE,'2102558148'),
                       ('800255883','Aikaterini','Mazioti','it21857@hua.gr','it21857','$2a$12$DWxgTk8xO4OlUe5utjBIMecvOotYvld9zM/r9kl3weieUWY7JyEc.',TRUE,'2102624583'),
                       ('998322255','Andreas','Koklonis','it21901@hua.gr','it21901','$2a$12$P2xcswm1c4t3kQCxq1mBHePlGFy04.dLL4isIUsD/G/8/jHmhepfW',TRUE,'2102400184'),
                       ('099231270','Konstantinos','Sargiannis','root@hua.gr','root','$2a$12$phqilSBjj9CDRiQS0TaEv.tnLVIgZZUWxc76.kO2MSi.9Y1NxW7hG',TRUE,'2102210730');



INSERT INTO house VALUES
                      (1,'good condition apartment, 3rd floor, front facing, floor-through,construction 80,furnished, central heating, security door','Every month 500€','1 23456789-02 5',75,2,'997209513'),
                      (2,NULL,NULL,'3 98765423-02 5',NULL,1,'997209513'),
                      (3,NULL,'330€','6 45678912-03 5',50,NULL,'800111851'),
                      (4,'Great house, ideal for students. Close to center Dont miss!','300€','9 67890123-01 5',NULL,NULL,'800111851');

INSERT INTO contract VALUES
                         (1,'20/01/2023','Aikaterini Mazioti','800255883','it21857@hua.gr','2102624583','6 45678912-03 5','Must not have pets','01/02/2023-31/05/2023',2,330),
                         (2,'20/01/2023','Andreas Koklonis','998322255','it21901@hua.gr','2102400184','1 23456789-02 5','No smoking allowed','01/03/2023-31/06/2023',2,500),
                         (3,'20/01/2023','Andreas Koklonis','998322255','it21901@hua.gr','2102400184','3 98765423-02 5',NULL,NULL,0,NULL);


INSERT INTO users VALUES
                      ('root', '$2a$12$phqilSBjj9CDRiQS0TaEv.tnLVIgZZUWxc76.kO2MSi.9Y1NxW7hG', TRUE),
                      ('it21564', '$2a$12$fnDMOA2cDdJmMAqQnXqUEuFATGL/FI.9vs04L.u8GHVa/rboCCm32', TRUE),
                      ('it216110', '$2a$12$ZRjyk7DMxQe5xwkN0GvknebE.EOmC9AbGmL5x8QLmb.UQpJOrxZN6', TRUE),
                      ('it21857', '$2a$12$DWxgTk8xO4OlUe5utjBIMecvOotYvld9zM/r9kl3weieUWY7JyEc.', TRUE),
                      ('it21901', '$2a$12$P2xcswm1c4t3kQCxq1mBHePlGFy04.dLL4isIUsD/G/8/jHmhepfW', TRUE);





INSERT INTO authorities VALUES
                            ('root', 'ROLE_ADMIN'),
                            ('it21564', 'ROLE_LANDLORD'),
                            ('it216110', 'ROLE_LANDLORD'),
                            ('it21857', 'ROLE_TENANT'),
                            ('it21901', 'ROLE_TENANT');






