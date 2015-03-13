    CREATE TABLE diseases (
     _id INTEGER PRIMARY KEY AUTOINCREMENT,
     name TEXT NOT NULL,
     substance TEXT NOT NULL,
     source TEXT NOT NULL,
     effect TEXT NOT NULL,
     side_effect TEXT NOT NULL,
     category TEXT NOT NULL
    );

        CREATE TABLE esubstances (
         _id INTEGER PRIMARY KEY AUTOINCREMENT,
         name TEXT NOT NULL,
         compound TEXT NOT NULL,
         attribute TEXT NOT NULL,
         side_effect TEXT NOT NULL,
         category TEXT NOT NULL
        );




   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("cold","vitamin C","cole,citrus","protect from infections","none","0-2-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("cold","Echinachea","plant-herb","alithies","not for children under the age of 4","0-2-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("elafria kapsimata","prwteines tupou alvouminwn","aspradi augvn","einai proteines megalis viologikis a3ias-kati allo","none","1-3");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("ponodontos","mh steroeidh antiflegmonodi","farmakeutika skeusmata","analgitiki kai antipiretiki drash","kardiaka episodia","3");




   INSERT INTO esubstances (name,compound,attribute,side_effect,category) VALUES("E100","curcumin","color,yellow","safe","0");
   INSERT INTO esubstances (name,compound,attribute,side_effect,category) VALUES("E101","riboflavin (vitamin B2)","color,yellow","safe","0");
   INSERT INTO esubstances (name,compound,attribute,side_effect,category) VALUES("E101a","Phosphate riboflavin","color,yellow","probably genetic modifier","1");
   INSERT INTO esubstances (name,compound,attribute,side_effect,category) VALUES("E102","Tarzanini","color,yellow","dangerous-possible allergic reaction especially for patients with asthma, attention when combined with aspirin-forbidden in countries of Western world","2-3");