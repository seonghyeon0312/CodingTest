-- 코드를 입력하세요
-- 1. START_DATE 기준 2022-08 ~ 2022-10인 데이터에서 CAR_ID 별 총 빌린 횟수가 5이상인 자동차만 구하기
-- 2. 이때 구한 CAR_ID로 해당되는 자동차들의 월별 빌린 횟수 구하기
-- 3. 결과는 월을 기준으로 오름차순, CAR_ID를 기준으로 내림차순으로 정렬. 그리고 특정 월에 빌린 횟수가 0이면 제외

SELECT MONTH(START_DATE) as MONTH, CAR_ID, COUNT(*) as RECORDS FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (SELECT car_id FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE DATE(START_DATE) between '2022-08-01' and '2022-10-31'
GROUP BY CAR_ID having count(*) >= 5) AND DATE(START_DATE) BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY MONTH(START_DATE), CAR_ID
ORDER BY MONTH(START_DATE), CAR_ID DESC;

