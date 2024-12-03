
-- query the number of currencies in the databae
SELECT COUNT(id) AS abbreviation_count 
FROM currency;

-- query to retrieve the currency with highest rate
SELECT id, abbreviation, MAX(rate) AS highest_rate 
FROM currency;
