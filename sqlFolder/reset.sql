# Auto Identity reset
ALTER TABLE users AUTO_INCREMENT = 1;
SET @COUNT = 0;
UPDATE users SET id = @COUNT := @COUNT + 1;

ALTER TABLE boards AUTO_INCREMENT = 1;
SET @COUNT = 0;
UPDATE boards SET id = @COUNT := @COUNT + 1;

ALTER TABLE board_top_categories AUTO_INCREMENT = 1;
SET @COUNT = 0;
UPDATE board_top_categories SET id = @COUNT := @COUNT+1;

ALTER TABLE board_middle_categories AUTO_INCREMENT = 1;
SET @COUNT = 0;
UPDATE board_middle_categories SET id = @COUNT := @COUNT + 1;

ALTER TABLE board_bottom_categories AUTO_INCREMENT = 1;
SET @COUNT = 0;
UPDATE board_bottom_categories SET id = @COUNT := @COUNT + 1;

ALTER TABLE alerts AUTO_INCREMENT = 1;
SET @COUNT = 0;
UPDATE alerts SET id = @COUNT := @COUNT + 1;

ALTER TABLE comments AUTO_INCREMENT = 1;
SET @COUNT = 0;
UPDATE comments SET id = @COUNT := @COUNT + 1;

ALTER TABLE hardware_categories AUTO_INCREMENT = 1;
SET @COUNT = 0;
UPDATE hardware_categories SET id = @COUNT := @COUNT + 1;

ALTER TABLE s3files AUTO_INCREMENT = 1;
SET @COUNT = 0;
UPDATE s3files SET id = @COUNT := @COUNT + 1;
