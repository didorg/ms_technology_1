-- PostgreSQL
-- 1
CREATE ROLE githubuser WITH
	LOGIN
	SUPERUSER
	CREATEDB
	CREATEROLE
	INHERIT
	REPLICATION
	CONNECTION LIMIT -1
	PASSWORD '**********';
-- 2
CREATE DATABASE orderms
    WITH
    OWNER = githubuser
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;