#https://www.pythonforthelab.com/blog/storing-data-with-sqlite/
#insert rows AKA inserting data into the table

#inserting values into tables, adding values into tables

import sqlite3

conn = sqlite3.connect('insert.db')
cur = conn.cursor()
cur.execute('CREATE TABLE experiments1 (name VARCHAR, description VARCHAR)')
conn.commit()

#conn.close()

#Adding data into a database
cur.execute('INSERT INTO experiments1 (name, description) values ("Aquiles", "My experiment description")')
conn.commit()

cur.execute('INSERT INTO experiments1 (name, description) VALUES (?, ?)',
            ('Another User', 'Another Experiment, even using " other characters"'))
conn.commit()

