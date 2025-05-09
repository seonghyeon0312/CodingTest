-- 코드를 작성해주세요
SELECT ID, FISH_NAME, LENGTH FROM FISH_INFO, FISH_NAME_INFO
WHERE LENGTH IN (SELECT MAX(LENGTH) FROM FISH_INFO GROUP BY FISH_TYPE HAVING LENGTH IS NOT NULL)
AND FISH_INFO.FISH_TYPE = FISH_NAME_INFO.FISH_TYPE;