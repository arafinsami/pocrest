FIND_ROLES_BY_USER =
SELECT
    r.id,
    r.name
FROM
    role r
        JOIN user_role ur ON r.id = ur.role_id
WHERE
    ur.user_id = :userId