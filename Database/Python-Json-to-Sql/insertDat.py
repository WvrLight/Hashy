#https://www.pythonforthelab.com/blog/storing-data-with-sqlite/
#insert rows AKA inserting data into the table

#inserting values into tables, adding values into tables

#https://www.sitepoint.com/getting-started-sqlite3-basic-commands/

import sqlite3

conn = sqlite3.connect('database.db')
cur = conn.cursor()
cur.execute('CREATE TABLE experiments1 (name VARCHAR, description VARCHAR)')
conn.commit()

#conn.close()

#Adding data into a database
cur.execute('INSERT INTO experiments1 ( name, email, website_url, comment ) VALUES ( 'Shivam Mamgain', 'xyz@gmail.com', 'shivammg.blogspot.com', 'Great tutorial for beginners.')')
conn.commit()
#Adding data into a database
#cur.execute('INSERT INTO experiments1 (name, description) values ("Aquiles", "My experiment description")')
#conn.commit()

#cur.execute('INSERT INTO experiments1 (name, description) VALUES (?, ?)',
            ('Another User', 'Another Experiment, even using " other characters"'))
#conn.commit()

