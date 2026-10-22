SELECT ri.FOOD_TYPE, ri.REST_ID, ri.REST_NAME, ri.FAVORITES
FROM REST_INFO ri JOIN
    (
        SELECT FOOD_TYPE, MAX(FAVORITES) max_favorites
        FROM REST_INFO
        GROUP BY FOOD_TYPE
    ) as max_favorites
ON ri.FOOD_TYPE = max_favorites.FOOD_TYPE and ri.FAVORITES = max_favorites.max_favorites
ORDER BY ri.FOOD_TYPE desc