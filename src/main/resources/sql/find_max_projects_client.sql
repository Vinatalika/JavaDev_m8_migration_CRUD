SELECT client.ID, client.NAME, COUNT(project.ID) AS project_count
FROM client
JOIN project ON client.ID = project.CLIENT_ID
GROUP BY client.ID, client.NAME
HAVING COUNT(project.ID) = (SELECT MAX(project_count) FROM (SELECT COUNT(ID) AS project_count FROM project GROUP BY CLIENT_ID));

