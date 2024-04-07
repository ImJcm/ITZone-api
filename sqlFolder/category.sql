INSERT INTO itzone.board_top_categories (category_name, category_classification)
VALUES
    ('테스트 상위 카테고리명', '상위 카테고리');

INSERT INTO itzone.board_middle_categories (category_name, board_top_category_id, category_classification)
VALUES
    ('테스트 중위 카테고리명', 1, '중위 카테고리');

INSERT INTO itzone.board_bottom_categories (category_name, board_middle_category_id, category_classification)
VALUES
    ('테스트 하위 카테고리명', 1, '하위 카테고리');
