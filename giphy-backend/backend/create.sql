--     private String id; // from the database
--     private String url; // for the image
--     private String giphyId; // from the API
--     private String rating;
--     private String description;
--     private String title;
--     private String  userName;
--     private int height;
--     private int width;

DROP TABLE IF EXISTS giphy;

CREATE TABLE giphy (
	id SERIAL PRIMARY KEY,
	url varchar(100),
	giphy_id varchar(50),
	rating varchar(5),
	description varchar(1000),
	title varchar(100),
	user_name varchar(100),
	height int,
	width int
);