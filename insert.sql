INSERT INTO mst_category (category_name) VALUES
("収納"),
("家具"),
("調理器具"),
("小物");

INSERT INTO mst_product(product_name, product_name_kana, category_id, price, image_full_path) VALUES
("本棚", "ほんだな", 1, 2990, "/img/bookshelf.jpg"),
("キッチンラック", "きっちんらっく", 1, 3990, "/img/kitchen_rack.jpg"),
("ソファ", "そふぁ", 2, 16900, "/img/sofa.jpg"),
("椅子", "いす", 2, 4490, "/img/chair.jpg"),
("テーブル", "てーぶる", 2, 14900, "/img/table.jpg"),
("照明", "しょうめい", 2, 4990, "/img/light.jpg"),
("カーテン", "かーてん", 2, 6690, "/img/curtain.jpg"),
("包丁", "ほうちょう", 3, 3045, "/img/kitchen_knife.jpg"),
("鍋", "なべ", 3, 2490, "/img/cooking_pot.jpg"),
("菜箸", "さいばし", 3, 299, "/img/chopstick.jpg"),
("キャンドル", "きゃんどる", 4, 799, "/img/candle.jpg"),
("フォトフレーム", "ふぉとふれーむ", 4, 1518, "/img/photo_frame.jpg"),
("鏡", "かがみ", 4, 1990, "/img/mirror.jpg");

INSERT INTO mst_user(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender) VALUES
("yamada@gmail.com", "yamada123", "山田", "太郎", "やまだ", "たろう", 0),
("sato@gmail.com", "sato123", "佐藤", "次郎", "さとう", "じろう", 0),
("tanaka@gmail.com", "tanaka123", "田中", "三郎", "たなか", "さぶろう", 0),
("takahashi@gmail.com", "takahashi123", "高橋", "花子", "たかはし", "はなこ", 1);

INSERT INTO mst_destination(user_id, family_name, first_name, tel_number, address, status) VALUES
(1, "山田", "太郎", "1123456789", "東京", 1),
(2, "佐藤", "次郎", "2123456789", "東京", 1),
(2, "木村", "一子", "3123456789", "大阪", 1),
(3, "田中", "三郎", "4123456789", "京都", 1),
(3, "伊藤", "四郎", "5123456789", "沖縄", 0);