-- 1. Tambahkan ‘Electronic Arts’ sebagai publisher baru ke tabel publisher.
INSERT INTO publisher (id, publisher_name)
VALUES (11, 'Electronic Arts');


-- 2. Ubah tahun rilis dari permainan dengan ID 3 menjadi 2013.
UPDATE game_platform
SET release_year = 2013
WHERE id = 3;


-- 3. Tampilkan nama-nama game yang dirilis pada tahun 2010 dan memiliki total penjualan terbesar di seluruh region. Sertakan nama-nama region dan total penjualan masing-masing game.
SELECT g.game_name, r.region_name, SUM(rs.num_sales) AS total_sales
FROM game_platform gp
JOIN game g ON gp.game_publisher_id = g.id
JOIN region_sales rs ON gp.id = rs.game_platform_id
JOIN region r ON rs.region_id = r.id
WHERE gp.release_year = 2010
GROUP BY g.game_name, r.region_name
ORDER BY total_sales DESC;


-- 4. Tampilkan nama-nama game yang dirilis pada platform dengan ID 5 dan dimiliki oleh publisher dengan ID 6. Update judul game-game tersebut dengan menambahkan kata "Special Edition" pada akhir judul.
SELECT g.game_name
FROM game g
JOIN game_publisher gp ON g.id = gp.game_id
JOIN game_platform gpl ON gp.id = gpl.game_publisher_id
WHERE gpl.platform_id = 5 AND gp.publisher_id = 6;

UPDATE game
SET game_name = CONCAT(game_name, ' Special Edition')
WHERE id IN (
    SELECT g.id
    FROM game g
    JOIN game_publisher gp ON g.id = gp.game_id
    JOIN game_platform gpl ON gp.id = gpl.game_publisher_id
    WHERE gpl.platform_id = 5 AND gp.publisher_id = 6
);


-- 5. Tampilkan nama-nama platform yang memiliki lebih dari 2 game.
SELECT p.platform_name AS platform_name
FROM platform p
JOIN game_platform gpl ON p.id = gpl.platform_id
GROUP BY p.platform_name
HAVING COUNT(gpl.game_publisher_id) > 2;


-- 6. Tampilkan nama-nama publisher yang memiliki game dengan genre "Role-Playing".
SELECT DISTINCT pub.publisher_name
FROM publisher pub
JOIN game_publisher gp ON pub.id = gp.publisher_id
JOIN game g ON gp.game_id = g.id
JOIN genre gen ON g.genre_id = gen.id
WHERE gen.genre_name = 'Role-Playing';


-- 7. Tampilkan nama-nama region yang memiliki total penjualan lebih dari 10.
SELECT r.region_name
FROM region r
JOIN region_sales rs ON r.id = rs.region_id
GROUP BY r.id, r.region_name
HAVING SUM(rs.num_sales) > 10;


-- 8. Tampilkan daftar nama game yang memiliki genre "Action" atau "Adventure".
-- Cara 1
SELECT g.game_name
FROM game g
JOIN genre gen ON g.genre_id = gen.id
WHERE gen.genre_name = 'Action' OR gen.genre_name = 'Adventure';

-- Cara 2
SELECT g.game_name
FROM game g
JOIN genre ge ON g.genre_id = ge.id
WHERE ge.genre_name IN ('Action', 'Adventure');


-- 9. Tampilkan nama game, nama platform, dan tahun rilis game. Jika tahun rilis lebih dari 2010, tampilkan "Terbaru" dalam kolom "Status", jika tidak tampilkan "Lama".
SELECT g.game_name, p.platform_name, gpl.release_year,
      CASE
        WHEN gpl.release_year > 2010
          THEN 'Terbaru'
        ELSE 'Lama'
      END AS Status
FROM game g
JOIN game_publisher gp ON g.id = gp.game_id
JOIN game_platform gpl ON gp.id = gpl.game_publisher_id
JOIN platform p ON gpl.platform_id = p.id;


-- 10. Tampilkan nama publisher dan jumlah game yang diterbitkan oleh masing-masing publisher. Kolom "Jumlah Game" harus menampilkan "0" jika tidak ada game yang diterbitkan oleh publisher tersebut.
SELECT pub.publisher_name, COUNT(g.id) AS "Jumlah Game"
FROM publisher pub
LEFT JOIN game_publisher gp ON pub.id = gp.publisher_id
LEFT JOIN game g ON gp.game_id = g.id
GROUP BY pub.publisher_name
ORDER BY pub.publisher_name;


-- 11. Tampilkan nama game, nama publisher, dan total penjualan game di seluruh region. Jika total penjualan lebih dari 20, tampilkan "Sangat Populer", jika tidak tampilkan "Cukup Populer".
SELECT g.game_name, pub.publisher_name, SUM(rs.num_sales) AS total_sales,
      CASE
        WHEN SUM(rs.num_sales) > 20
          THEN 'Sangat Populer'
        ELSE 'Cukup Populer'
      END AS Status
FROM game g
JOIN game_publisher gp ON g.id = gp.game_id
JOIN game_platform gpl ON gp.id = gpl.game_publisher_id
JOIN region_sales rs ON gpl.id = rs.game_platform_id
JOIN publisher pub ON gp.publisher_id = pub.id
GROUP BY g.game_name, pub.publisher_name
ORDER BY total_sales DESC;


-- 12. Tampilkan nama platform dan total penjualan di semua wilayah.
SELECT p.platform_name, SUM(rs.num_sales) AS total_sales
FROM platform p
JOIN game_platform gpl ON p.id = gpl.platform_id
JOIN region_sales rs ON gpl.id = rs.game_platform_id
GROUP BY p.platform_name
ORDER BY total_sales ASC;


-- 13. Tampilkan jumlah game yang memiliki genre "Racing".
SELECT COUNT(g.id) AS "Jumlah Game"
FROM game g
JOIN genre gen ON g.genre_id = gen.id
WHERE gen.genre_name = 'Racing';


-- 14. Tampilkan nama game, nama publisher, dan rata-rata penjualan game di seluruh region. Jika rata-rata penjualan lebih dari 10, tampilkan "Populer", jika tidak tampilkan "Tidak Populer".
SELECT g.game_name, pub.publisher_name, AVG(rs.num_sales) AS avg_sales,
      CASE
        WHEN AVG(rs.num_sales) > 10
          THEN 'Populer'
        ELSE 'Tidak Populer'
      END AS Status
FROM game g
JOIN game_publisher gp ON g.id = gp.game_id
JOIN game_platform gpl ON gp.id = gpl.game_publisher_id
JOIN region_sales rs ON gpl.id = rs.game_platform_id
JOIN publisher pub ON gp.publisher_id = pub.id
GROUP BY g.game_name, pub.publisher_name
ORDER BY avg_sales DESC;


-- 15. Tampilkan nama game, nama platform, dan total penjualan game di seluruh region. Jika total penjualan lebih dari 50, tampilkan "Laris Manis", jika tidak tampilkan "Tidak Laris Manis".
SELECT g.game_name, p.platform_name, SUM(rs.num_sales) AS total_sales,
      CASE
        WHEN SUM(rs.num_sales) > 50
          THEN 'Laris Manis'
        ELSE 'Tidak Laris Manis'
      END AS Status
FROM game g
JOIN game_platform gp ON g.id = gp.id
JOIN platform p ON gp.platform_id = p.id
JOIN region_sales rs ON gp.id = rs.game_platform_id
GROUP BY g.id, g.game_name, p.platform_name
ORDER BY total_sales DESC;
