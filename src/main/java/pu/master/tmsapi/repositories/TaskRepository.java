package pu.master.tmsapi.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pu.master.tmsapi.models.entities.Task;
import pu.master.tmsapi.models.enums.TaskPriority;
import pu.master.tmsapi.models.enums.TaskStatus;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long>
{

    @Query("FROM Task t LEFT JOIN FETCH t.comments")
    List<Task> findAllTasks();

    List<Task> findTasksByTitleContaining(String title);
    List<Task> findTasksByPriorityLevelAndStatus(TaskPriority taskPriority, TaskStatus taskStatus);
    List<Task> findTasksByPriorityLevel(TaskPriority taskPriority);
    List<Task> findTasksByStatus(TaskStatus taskStatus);
    List<Task> findTasksByUsersId(long userId);

}
