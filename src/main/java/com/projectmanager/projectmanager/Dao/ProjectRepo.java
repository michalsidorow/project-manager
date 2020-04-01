package com.projectmanager.projectmanager.Dao;

import com.projectmanager.projectmanager.Dao.Entities.Project;
import com.projectmanager.projectmanager.Dto.ChartData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends PagingAndSortingRepository<Project,Long> {
    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT STAGE as label, COUNT(*) as value FROM PROJECT GROUP BY STAGE ")
    List<ChartData> getProjectStatus();

}
