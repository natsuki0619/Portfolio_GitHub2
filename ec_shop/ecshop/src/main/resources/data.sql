-- goodsテーブル
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (1, 'Tシャツ', 'goods01.png', '柔らかく快適なコットン素材で作られたカジュアルなTシャツです。' ,3600 ,10, 1);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (2, 'スカート', 'goods02.png', 'シンプルで上品なデザインのフレアスカート。どんなコーディネートにも合わせやすい。' ,2800 ,8, 1);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (3, '靴', 'goods03.png','歩きやすさとスタイリッシュさを兼ね備えたシューズ。通勤やお出かけに最適。' ,27000, 3, 1);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (4, 'ドレッサー', 'goods04.png','大容量収納付きのエレガントなドレッサー。朝の準備が楽しくなります。',160000, 2, 2);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (5, '棚', 'goods05.png', 'モダンデザインの多目的棚。リビングやオフィスの収納にぴったり。' ,280000, 5, 2);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (6, '照明', 'goods06.png', 'シンプルでモダンなデザインのLED照明。どんな部屋にもマッチします。' ,18000, 6, 2);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (7, 'トースター', 'goods07.png', 'サクサクのトーストが焼ける高機能トースター。朝食が楽しみになります。' ,10000, 15, 3);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (8, 'ヘッドフォン', 'goods08.png', '軽量設計で、高音質です。' ,30000, 3, 3);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (9, 'ミキサー', 'goods09.png', '強力なモーターでスムージーやスープが簡単に作れるミキサーです。' ,3400, 2, 3);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (10, 'アイシャドウ', 'goods10.png', '高発色で長持ちする、トレンディなカラーが揃ったアイシャドウパレット。' ,1450, 66, 4);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (11, 'リップ', 'goods11.png', '保湿成分配合で潤いをキープする、鮮やかなカラーのリップスティック。' ,980, 138, 4);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (12, '香水', 'goods12.png', 'フレッシュでエレガントな香りが一日中続く、上品なフレグランス。' ,1700, 15, 4);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (13, 'コップ', 'goods13.png', 'シンプルで使いやすいデザインのガラスコップ。日常使いに最適。' ,12800, 1, 5);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (14, '花瓶', 'goods14.png', '美しいフォルムとシンプルなデザインの花瓶。どんなお花も引き立てます。' ,1300, 13, 5);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (15, '観葉植物', 'goods15.png', '部屋の空気を浄化し、癒しをもたらす観葉植物。手入れも簡単。' ,2700, 14, 5);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (16, 'おもちゃ', 'goods16.png', '子供たちの創造力を刺激する、カラフルで楽しいおもちゃです。' ,880, 99, 6);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (17, 'ボール', 'goods17.png', '室内外で遊べる、耐久性に優れた多目的ボール。' ,580 ,100, 6);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (18, 'スライム', 'goods18.png', '柔らかくて伸びる、楽しい触感のスライム。ストレス解消にも最適。' ,300, 14, 6);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (19, 'パン', 'goods19.png', '外はカリッと中はふんわりの焼きたてパン。朝食やおやつにどうぞ。' ,280, 10, 7);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (20, 'ケーキ', 'goods20.png', 'ふんわりとしたスポンジと濃厚なクリームが特徴の美味しいケーキ。',450 ,18, 7);
INSERT IGNORE INTO goods (id, name, image_name, description, price, stock, category_id) VALUES (21, 'コーヒー豆', 'goods21.png', '豊かな香りと深い味わいが楽しめる、新鮮なコーヒー豆。毎日のリフレッシュに。' ,150, 77, 7);

-- roles
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_ADMIN');

-- users
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (1, '山田 太郎', 'ヤマダ タロウ', '123-4567', '東京都新宿区新宿1-1-1', '090-1234-5678', 'yamada_taro@demo.data.com', 'password', 1, 1);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (2, '佐藤 花子', 'サトウ ハナコウ', '123-4567', '神奈川県横浜市中区桜木町2-2-2', '090-1234-5678', 'satou_hanako@demo.data.com', 'password', 2, 1);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (3, '鈴木 次郎', 'スズキ ジロウ', '123-4567', '大阪府大阪市北区梅田3-3-3', '090-1234-5678', 'suzuki_ziro@demo.data.com', 'password', 1, 0);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (4, '高橋 愛', 'タカハシ アイ', '123-4567', '京都府京都市左京区銀閣寺町4-4-4', '090-1234-5678', 'takahasi_ai@demo.data.com', 'password', 1, 0);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (5, '伊藤 翔', 'イトウ ショウ', '123-4567', '福岡県福岡市中央区天神5-5-5', '090-1234-5678', 'itou_syo@demo.data.com', 'password', 1, 0);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (6, '渡辺 美咲', 'ワタナベ ミサキ', '123-4567', '福岡県福岡市中央区天神5-5-5', '090-1234-5678', 'watanabe_misaki@demo.data.com', 'password', 1, 0);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (7, '中村 健太', 'ナカムラ ケンタ', '123-4567', '北海道札幌市中央区大通西6-6-6', '090-1234-5678', 'nakamura_kenta@demo.data.com', 'password', 1, 0);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (8, '小林 真奈', 'コバヤシ マナ', '123-4567', '愛知県名古屋市中区栄7-7-7', '090-1234-5678', 'kobayasi_mana@demo.data.com', 'password', 1, 0);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (9, '加藤 大樹', 'カトウ ダイキ', '123-4567', '千葉県千葉市美浜区幕張9-9-9', '090-1234-5678', 'katou_daiki@demo.data.com', 'password', 1, 0);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (10, '吉田 純', 'ヨシダ ジュン', '123-4567', '埼玉県さいたま市浦和区高砂10-10-10', '090-1234-5678', 'yosida_zyun@demo.data.com', 'password', 1, 0);

