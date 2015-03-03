    CREATE TABLE diseases (
     _id INTEGER PRIMARY KEY AUTOINCREMENT,
     name TEXT NOT NULL,
     substance TEXT NOT NULL,
     source TEXT NOT NULL,
     effect TEXT NOT NULL,
     side_effect TEXT NOT NULL
    );

   INSERT INTO diseases (name,substance,source,effect,side_effect) VALUES ("cold","vitamin C","cole,citrus","protect from infections","none");
   INSERT INTO diseases (name,substance,source,effect,side_effect) VALUES ("cold","Echinachea","plant-herb","alithies","not for children under the age of 4");