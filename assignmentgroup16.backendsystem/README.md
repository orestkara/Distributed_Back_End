# Distributed Systems Group 16-Project 4, Back-End User Guide
A back end web application about leasehold handling in the context of DIT HUA course 'Distributed Systems'

# Languages and Tools
![image](https://user-images.githubusercontent.com/125285882/219948605-33a0e523-99f6-423f-a69f-cf4572262e18.png)
![image](https://user-images.githubusercontent.com/125285882/219948640-73b4554d-a5be-4592-9154-0c35f27473c3.png)
![image](https://user-images.githubusercontent.com/125285882/219948650-a544831e-fd31-489f-8c71-1b7049610d25.png)
![image](https://user-images.githubusercontent.com/125285882/219948662-dafb1dd2-ab5e-43ec-adfd-9dd984ff7338.png)
<img width="28" alt="beaver" src="https://user-images.githubusercontent.com/125285882/219949166-d7232de3-3b5e-4589-b67a-443fab075bf3.png">

# Run Locally

Χρήση κάποιου IDE όπως το IntelliJ ή το Eclipse. Προτιμάται το Intellij


# Installation Manual
Αρχικά θα πρέπει να γίνει clone το project στο intellij από το github. Ανοίγουμε το Intellij και πάμε VCS->Get From Version Control κάνουμε
paste το URL του repository. Ύστερα πρέπει να ορίσουμε το project ως maven project (Configure->Convert to Maven Project) και επιλέγουμε
Maven--> Update Project από το menu που εμεφανίζεται με δεξί-κλικ στο project.
Έπειτα πρέπει να ελέγξουμε ότι το αρχείο application properties είναι σωστά ορισμένο, πρέπει να έχει τα παρακάτω:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/leaseholds?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false
spring.datasource.username=postgres
spring.datasource.password=pass123
spring.sql.init.platform=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

Η εφαρμογή προϋποθέτει την ύπαρξη κάποιας βάσης δεδομένων. Επιλέχθηκε postgreSQL βάση. Θα πρέπει να κατεβάσουμε και εγκαταστήσουμε το
server ώστε να μπορεί η εφαρμογή να συνδεθεί με τη βάση. Ορίστε το link:https://www.postgresql.org/download/
Επιλέγουμε την επιλογή ανάλογα με το λογισμικό μας και εγκαθηστούμε τη βάση. Κάποια credentials:
```
Default username=postgres 
Password for postgres=pass123

For admin, username=admin
Password for admin=admin123
```

Το schema της βάσης βρίσκεται στο αρχείο src/resources/schema.sql και τα δεδομένα προς χρήση και επεξεργασία που θα γίνουν insert στη βάση
στο αρχείο src/resources/data.sql

Εκτελόντας τα παραπάνω queries με κάποιο shell δομείται η βάση της εφαρμογής σωστά.

H HTTP server port έχει οριστεί ως server.port=8080

Με τα παραπάνω έχουμε ανοίξει την ερφαρμογή μας, κατεβάσει, εγκαταστήσει και ορίσει τη βάση της με τα κατάλληλα credentials. 

Για την εκτέλεση της εφαρμογής κάνουμε δεξί κλικ στο αρχείο src/main/java/backend_system/assignmentgroup16/backendsystem/Application.java
και επιλέγουμε run.
Μετά μπορούμε να έχουμε πρόσβαση στην ερφαρμογή ανόγοντας κάποιο browser και "χτυπώντας" το URL localhost:8080.
Έτσι ολοκληρώνεται η εκτέλεση του back-end της εφαρμογής μας.

# Test with postman tool

Testing του REST API καθώς και των αιτημάτων των controllers μπορούμε να κάνουμε μέσω του Postman, αποστέλοντας αιτήματα
στέλνοντας και λαμβάνοντας αντικείμενα JSON.

# Front-End

Περισσότερες λεπτομέρειες για τη λειτουργία του fron και τη λειτουργικότητά του από τους χρήστες μπορείτε να βρείτε
στα αντίστοιχα εγχειρίδια χρήσης.



# Group
21857 Αικατερίνη Μαζιώτη

21564 Καραγιάννης Ορέστης

216110 Αικατερίνη Κολιοπούλου


