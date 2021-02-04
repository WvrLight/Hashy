
Please refer here for commands: https://www.sqlitetutorial.net/sqlite-commands/
<br>
Creating sqlite database via python: https://www.sqlitetutorial.net/sqlite-python/creating-database/
<br>
Printing the SQite3 table: https://www.sqlitetutorial.net/sqlite-tutorial/sqlite-describe-table/
<br>
Creating multiple columns: https://www.sqlitetutorial.net/sqlite-create-table/
<br>
Sample database: https://www.sqlitetutorial.net/sqlite-sample-database/
<br>
Further commands: https://www.sqlitetutorial.net/
<br>
Inserting values into table: https://www.pythonforthelab.com/blog/storing-data-with-sqlite/
<br>
SQlite select: https://www.sqlitetutorial.net/sqlite-select/
<br>
(Inserting)  Inserting values into table: https://www.sitepoint.com/getting-started-sqlite3-basic-commands/
<br>
Insert values into a SQLite table with a JSON column using Python: https://devopsheaven.com/sqlite/databases/json/python/api/2017/10/11/sqlite-json-data-python.html




``` sqlite> .schema albums - to show the contents of the table in raw format ```



<br>
Another way to show the structure of a table is to use the following PRAGMA command:
<br>

```ruby 
sqlite> .header on
sqlite> .mode column
sqlite> pragma table_info('albums');
``` 
<br>

On showing the data on the table"
```ruby
sqlite> .header on
sqlite> .mode column
sqlite> SELECT * FROM experiments1;
```

<br>

On conversion simple
```ruby
sqlite3 dummy.db
SQLite version 3.19.3 2017-06-27 16:48:08
Enter “.help” for usage hints.
sqlite> .mode csv
sqlite> .separator |
sqlite> .import dummy.csv ABC
sqlite> select * from ABC;
1|2|3
4|5|6
sqlite>
```

<h> Problem current:
  - 
  - how to remove a table in a database? 















https://docs.github.com/en/github/writing-on-github/creating-and-highlighting-code-blocks

