FIND_BY_EMAIL =
SELECT
    id,
    first_name,
    last_name,
    email,
    password
FROM
    app_user
WHERE
    email = :email