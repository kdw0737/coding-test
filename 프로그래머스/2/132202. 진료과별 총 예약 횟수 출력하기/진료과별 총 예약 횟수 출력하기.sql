-- 코드를 입력하세요
SELECT MCDP_CD AS "진료과코드", COUNT(*) AS "5월예약건수"
FROM APPOINTMENT
WHERE to_char(APNT_YMD,'YYYY-MM') = '2022-05'
GROUP BY MCDP_CD
ORDER BY "5월예약건수", "진료과코드"