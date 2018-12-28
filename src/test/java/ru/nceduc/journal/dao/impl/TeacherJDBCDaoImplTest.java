package ru.nceduc.journal.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ru.nceduc.journal.dao.JournalDao;
import ru.nceduc.journal.dao.connector.ConnectorPostgre;
import ru.nceduc.journal.entity.Teacher;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.Assert.*;

public class TeacherJDBCDaoImplTest {

    private JournalDao<Teacher> dao;

    @Before
    public void setUp() throws Exception {
        dao = new TeacherJDBCDaoImpl();

        String host = "localhost";
        int port = 5432;
        String dbname = "test-postgres";
        String username = "user";
        String password = "userpas";
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + dbname;

        EmbeddedPostgres embeddedPostgres = new EmbeddedPostgres();
        embeddedPostgres.start(host,
                        port,
                        dbname,
                        username,
                        password);

        ConnectorPostgre.setUrl(url);
        ConnectorPostgre.setUsername(username);
        ConnectorPostgre.setPassword(password);
        Connection connection =  ConnectorPostgre.getInstance().getConnection();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void find() {
    }

    @Test
    public void add() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void update() {
    }
}