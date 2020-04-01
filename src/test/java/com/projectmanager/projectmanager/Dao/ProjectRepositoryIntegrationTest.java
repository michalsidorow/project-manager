package com.projectmanager.projectmanager.Dao;

import com.projectmanager.projectmanager.Dao.Entities.Project;
import com.projectmanager.projectmanager.ProjectManagerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes= ProjectManagerApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,scripts = {"classpath:schema.sql","classpath:data.sql"})})
public class ProjectRepositoryIntegrationTest {

    @Autowired
    ProjectRepo projectRepo;

    @Test
    public void ifNewProjectSaved_ThenSucces(){
        Project project = new Project("new test project","Complete","test description");
        projectRepo.save(project);

        assertEquals(5,projectRepo.findAll().size());
    }
}
