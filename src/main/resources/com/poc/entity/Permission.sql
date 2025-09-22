FIND_PERMISSIONS_BY_ROLE =
SELECT
    p.id,
    p.code,
    p.description
FROM
    permission p
        JOIN role_permission rp ON p.id = rp.permission_id
WHERE
    rp.role_id = :roleId