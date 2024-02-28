------------------------ Selection par une colonne { dependant de plusieurs critères }

1- Join all with value 0
------------------------
    SELECT ..., ... FROM table_1, table_2;

2 - Get Real value with few data in the principal table
-------------------------------------------------------
    SELECT ...

3 - Union all with the real question
------------------------------------
    union : efface les doublons
    union all : n` efface pas les doublon


----------------------- Selection d` intervalle de date
year = EXTRACT(EPOCH FROM age((emp.date_embauche)::timestamp with time zone)) / 31536000
\\ age((emp.date_embauche)::timestamp with time zone)) 
    - function which required one parameter (timestamp type)
    - function which calculate the difference between the current date and the date given as parameter
\\ EPOCH time is the number of seconds that have elapsed 
    - since 00:00:00 Thursday, 1 January 1970, 
    - Coordinated Universal Time (UTC), minus leap seconds.
\\ 31536000 = (60 second * 60 minute * 24 hour * 365 day)