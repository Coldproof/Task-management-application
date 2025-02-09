package com.meritek.task.management.app.repository;

import com.fasterxml.jackson.databind.util.RawValue;
import com.meritek.task.management.app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
