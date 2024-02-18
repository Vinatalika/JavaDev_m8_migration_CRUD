SELECT project.ID, project.START_DATE, project.FINISH_DATE,
       DATEDIFF('MONTH', project.START_DATE, project.FINISH_DATE) AS duration_in_months
FROM project
WHERE DATEDIFF('MONTH', project.START_DATE, project.FINISH_DATE) = (
    SELECT MAX(DATEDIFF('MONTH', START_DATE, FINISH_DATE)) FROM project
);
