# ΠΧ8 Καταγραφή Υπηρεσιών Οδοντιάτρων

__Πρωτεύων Actor:__
Διαχειριστής

__Ενδιαφερόμενοι:__

Οδοντίατρος: Θέλει να έχει τη δυνατότητα επιλογής της υπηρεσίας που προσέφερε σύντομα και εύκολα.

Πελάτης: Θέλει να έχει περιορισμένο αριθμό επιλογών να αναζητήσει, με βάση το πρόβλημα του. 

__Προϋποθέσεις:__

* Ο Διαχειριστής προϋποθέτει να γνωρίζει τις υπηρεσίες των οδοντιάτρων, ώστε να μπορεί να τις καταχωρίσει στο σύστημα.

* Ο Διαχειριστής προϋποθέτει να έχει συνδεθεί μέσω master login.

## Βασική Ροή

### Α) Δημιουργία Λογαριασμού
1. Ο διαχειριστής επιλέγει την "Καταγραφή Υπηρεσιών Οδοντιάτρων".
2. Συμπλήρωση νέας υπηρεσίας και καταχώρηση.

## Εναλλακτικές Ροές

*2α\. Συμπλήρωση υπηρεσίας οδοντίατρου, η οποία είναι ήδη στην λιστα επιλογών.*
1. Η διαδικασία καταγραφής δεν ολοκληρώνεται. Εμφανίζεται κατάλληλο μήνυμα λάθους στον διαχειριστή.
2. Ο διαχειριστής καλείται να δώσει νέα υπηρεσία ή να αποχωρήσει από την ενότητα.