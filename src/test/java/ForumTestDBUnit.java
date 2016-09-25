/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.valsesia.forum.controllers.TopicoController;
import com.valsesia.forum.controllers.UsuarioController;
import com.valsesia.forum.models.Topico;
import com.valsesia.forum.models.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jvalsesia
 */
public class ForumTestDBUnit {

    JdbcDatabaseTester jdtUsuario;
    JdbcDatabaseTester jdtTopico;

    public ForumTestDBUnit() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        try {
            jdtUsuario = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5432/coursera", "jvalsesia", "hell0123", "public");
            jdtUsuario.setDataSet(new XmlDataSet(ForumTestDBUnit.class.getClassLoader().getResourceAsStream("UsuarioTodosDataSet.xml")));

            jdtUsuario.onSetup();

        } catch (DataSetException ex) {
            Logger.getLogger(ForumTestDBUnit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ForumTestDBUnit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ForumTestDBUnit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testeRanking() throws Exception {
        // 1- recuperou database em onSetup

        // 2- atualizou tabela
        UsuarioController uc = new UsuarioController();
        List<Usuario> ranking = uc.ranking();
        try {
            // rankingDataSet
            IDataSet expectedDataset = new XmlDataSet(ForumTestDBUnit.class.getClassLoader().getResourceAsStream("UsuarioRankingDataSet.xml"));
            ITable exprectedTable = expectedDataset.getTable("usuario");
            for (int i = 0; i < exprectedTable.getRowCount(); i++) {
                assertEquals(exprectedTable.getValue(i, "login").toString(), ranking.get(i).getLogin());
            }
        } catch (Exception ex) {
            Logger.getLogger(ForumTestDBUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testeInserirUsuario() throws Exception {
        // 1- recuperou database em onSetup

        // 2- atualizou tabela
        UsuarioController uc = new UsuarioController();
        Usuario u = new Usuario();
        u.setLogin("ctully");
        u.setEmail("ctully@tully.com");
        u.setNome("Catelyn Tully");
        u.setSenha("FamilyDutyHonor");
        u.setPontos(83);
        uc.inserir(u);

        try {
            // 3- pega DB apos atualizacao da tabela
            IDataSet curreDataSet = jdtUsuario.getConnection().createDataSet();
            ITable currentTable = curreDataSet.getTable("usuario");

            // 4- compara com o recuperarDaXML
            IDataSet expectedDataset = new XmlDataSet(ForumTestDBUnit.class.getClassLoader().getResourceAsStream("UsuarioInserirDataSet.xml"));
            ITable expectedTable = expectedDataset.getTable("usuario");

            Assertion.assertEquals(expectedTable, currentTable);

        } catch (Exception ex) {
            Logger.getLogger(ForumTestDBUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testeRecuperarUsuario() throws Exception {
        UsuarioController uc = new UsuarioController();
        Usuario u = uc.recuperar("dtargaryen");

        try {
            // XML
            IDataSet expectedDataset = new XmlDataSet(ForumTestDBUnit.class.getClassLoader().getResourceAsStream("UsuarioRecuperDataSet.xml"));
            ITable exprectedTable = expectedDataset.getTable("usuario");

            assertEquals(String.valueOf(exprectedTable.getValue(0, "login")), u.getLogin());

        } catch (Exception ex) {
            Logger.getLogger(ForumTestDBUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testeAdicionarPontos() throws Exception {
        // 1- recuperou database em onSetup

        // 2- atualizou tabela
        UsuarioController uc = new UsuarioController();
        uc.adicionarPontos("jlannister", 90);

        try {

            // 3- pega DB apos atualizacao da tabela
            IDataSet curreDataSet = jdtUsuario.getConnection().createDataSet();
            ITable currentTable = curreDataSet.getTable("usuario");

            // 4- compara com o recuperarDaXML
            IDataSet expectedDataset = new XmlDataSet(ForumTestDBUnit.class.getClassLoader().getResourceAsStream("UsuarioAtualizaDataSet.xml"));
            ITable expectedTable = expectedDataset.getTable("usuario");

            Assertion.assertEquals(expectedTable, currentTable);
        } catch (Exception ex) {
            Logger.getLogger(ForumTestDBUnit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
