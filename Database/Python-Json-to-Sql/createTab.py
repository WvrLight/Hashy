#creating a table in a database
#create a a table  named file
#create a table
#"execute() will only execute a single SQL statement. 
#If you try to execute more than one statement with it, 
#it will raise a Warning. Use executescript() if you want to execute multiple SQL statements with one call."

import sqlite3
from sqlite3 import Error


def create_connection(db_file):
    """ create a database connection to the SQLite database
        specified by db_file
    :param db_file: database file
    :return: Connection object or None
    """
    conn = None
    try:
        conn = sqlite3.connect(db_file)
        return conn
    except Error as e:
        print(e)

    return conn


def create_table(conn, create_table_sql):
    """ create a table from the create_table_sql statement
    :param conn: Connection object
    :param create_table_sql: a CREATE TABLE statement
    :return:
    """
    try:
        c = conn.cursor()
        c.execute(create_table_sql)
    except Error as e:
        print(e)


def main():
    database = r"database.db"

    sql_create_projects_table = """ CREATE TABLE IF NOT EXISTS projects (
                                        id integer PRIMARY KEY,
                                        name text NOT NULL,
                                        begin_date text,
                                        end_date text
                                    ); """

    sql_create_tasks_table = """CREATE TABLE IF NOT EXISTS tasks (
                                    id integer PRIMARY KEY,
                                    name text NOT NULL,
                                    priority integer,
                                    status_id integer NOT NULL,
                                    project_id integer NOT NULL,
                                    begin_date text NOT NULL,
                                    end_date text NOT NULL,
                                    FOREIGN KEY (project_id) REFERENCES projects (id)
                                );"""
                                
    sql_create_file_table = """CREATE TABLE IF NOT EXISTS file (
                                    root brunk branch leaves flowers
                                );"""
    
    sql_create_twitter1_table = """CREATE TABLE twitter1 (
                                    post_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 
                                    name TEXT NOT NULL, 
                                    email TEXT NOT NULL, 
                                    website_url TEXT NULL, 
                                    comment TEXT NOT NULL
                                );"""
                                
    # create a database connection
    conn = create_connection(database)

    # create tables
    if conn is not None:
        # create projects table
        #create_table(conn, sql_create_projects_table)

        # create tasks table
        #create_table(conn, sql_create_tasks_table)
        
        # create file table
        #create_table(conn, sql_create_file_table)
        
        #create twitter1 table
        create_table(conn, sql_create_twitter1_table)
    else:
        print("Error! cannot create the database connection.")


if __name__ == '__main__':
    main()
