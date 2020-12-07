SELECT DISTINCT  date, id_valute, char_code, name, value, nominal
FROM valute
WHERE date=(
    SELECT MAX(date) FROM valute);