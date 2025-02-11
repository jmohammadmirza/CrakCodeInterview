Tabke => Station

Field | Type
ID    | NUMBER
City  | VARCHAR2(21)
State | VARCHAR2(2)
Lat_N  | NUMBER
Long_W | NUMBER


WEATHER OBERVATION CENTER (MARKAZ ILA MAUSAM)

Q1. Query the list of CITY names from STATION that do not start with vowels and do not end with vowels. Your result cannot contain duplicates.

A1. (MS SQL)  SELECT DISTINCT City FROM Station WHERE City NOT LIKE '%A' AND City NOT LIKE '%E' AND City NOT LIKE '%I' AND City 
  NOT LIKE '%O' AND City NOT LIKE '%U'   AND City NOT LIKE 'A%' AND City NOT LIKE 'E%' AND 
  City NOT LIKE 'I%' AND City NOT LIKE 'O%' AND City NOT LIKE 'U%' ORDER BY City 

select distinct city from station where city  like '[^aeiou]%' and city  like '%[^aeiou]' order by city; 
______________________________________________________________________________________________________________________________________

Q2. Query the two cities in STATION with the shortest and longest CITY names, as well as their respective lengths 
  (i.e.: number of characters in the name).   If there is more than one smallest or largest city, 
  choose the one that comes first when ordered alphabetically.

  A2. SELECT City, LENGTH(City)
FROM (SELECT City
      FROM Station
     ORDER BY LENGTH(City), City)
WHERE ROWNUM = 1;
SELECT City, LENGTH(City)
FROM (SELECT City
      FROM Station
     ORDER BY LENGTH(City) DESC, City)
WHERE ROWNUM = 1;
_________________________________________________________________________________________________________________________________________
Q3. List the number of customers in each country, ordered by the country with the most customers first.
A3. 
  SELECT COUNT(CustomerID),Country FROM Customers GROUP BY Country ORDER BY COUNT(CustomerID) DESC;

_______________________________________________________________________________________________________________________________________





