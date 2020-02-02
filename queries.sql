## Part 1: Test it with SQL

SELECT * FROM techjobs.job;

## Part 2: Test it with SQL

SELECT name FROM techjobs.employer
WHERE (location = "St. Louis City");

## Part 3: Test it with SQL

ALTER TABLE techjobs.job
DROP COLUMN employer;

## Part 4: Test it with SQL

SELECT *
FROM techjobs.skill
INNER JOIN techjobs.job_skills
ON techjobs.skill.id = techjobs.job_skills.skills_id
ORDER BY name asc;

