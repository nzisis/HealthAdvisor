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



   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Cold","Vitamin C-natural-0-0","cole,citrus","protect from infections","none","0-2-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Cold","Echinachea -natural-0-0","plant-herb","alithies","not for children under the age of 4","0-2-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("High Fever","Paracetamol-chemical-0- Depon, panadol, apotel etc.","aspradi augvn","einai proteines megalis viologikis a3ias-kati allo","none","1-3");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("High Fever","Aspirin-chemical-Acetylsalicylic acid-0 ","farmakeutika skeusmata","analgitiki kai antipiretiki drash","kardiaka episodia","3");




   INSERT INTO esubstances (name,compound,attribute,side_effect,category) VALUES("E100","curcumin","color,yellow","safe","0");
   INSERT INTO esubstances (name,compound,attribute,side_effect,category) VALUES("E101","riboflavin (vitamin B2)","color,yellow","safe","0");
   INSERT INTO esubstances (name,compound,attribute,side_effect,category) VALUES("E101a","Phosphate riboflavin","color,yellow","probably genetic modifier","1");
   INSERT INTO esubstances (name,compound,attribute,side_effect,category) VALUES("E102","Tarzanini","color,yellow","dangerous-possible allergic reaction especially for patients with asthma, attention when combined with aspirin-forbidden in countries of Western world","2-3");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E474","Sucroglycerides","Emulcifier","possibly of animal origin-possibly genetically modified","6-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E475","Polyglycerol Esters of Fatty Acids","Emulsifier","possibly of animal origin-possibly genetically modified","6-1");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E476","Polyglycerol polyricinoleate","Emulsifier","possibly of animal origin-possibly genetically modified","6-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E477","Propane-1,2-Diol Esters of Fatty Acids","Emulsifier","Suspicious-possibly of animal origin-possibly genetically modified","9-6-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E478","Lactylated fatty acid esters of glycerol and propane-1","Emulsifier","Safe- possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E479b","Thermally oxidized soya bean oil interacted with mono- and diglycerides of fatty acids","Emulsifier","possibly of animal origin-possibly genetically modified","1-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E481","Sodium Stearoyl-2-Lactylate Emulsifier","Emulsifier","Safe-possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E482","Calcium Stearoyl-2-Lactylate Emulsifier","Emulsifier","Safe-possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E483","Stearyl Tartrate","Emulsifier","Safe-possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E491","Sorbitan monostearate","Emulsifier","possibly of animal origin-possibly genetically modified","1-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E492","Sorbitan tristearate","Emulsifier","possibly of animal origin-safe","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E493","Sorbitan monolaurate","Emulsifier","possibly of animal origin-safe","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E494","Sorbitan monooleate","Emulsifier","possibly of animal origin-safe","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E495","Sorbitan monopalmitate","Emulsifier","safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E500","Sodium Carbonate / Sodium Bicarbonate","Miscellaneous - Acids and Salts: Carbonates","safe","0");
