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


   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Cold","Vitamin C-natural-0-0","cole,citrus","absorbance of iron - protection of infections -accelares the wound healing- local antisypsia","none so far","0-2-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Cold","Echinachea -natural-0-0","plant Echinachea","antibiotic, antibacterial, antiinflammatory, excitatory properties - fight inflammations and infections (UTIs), colic and skin diseases (psoriasis, herpes, ulcers, wounds, burns, acne)","not for children under the age of 4 pregnant and breastfeeding women people who suffer from: tuberculosis, leukemia,autoimmune diseases - not recommended to: users of immunosuppressants such as cortisone cause the herb suppresses their action , When taken by mouth, there is chance of numbness and tingling in tongue ","0-2-4");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("High Fever","Paracetamol-chemical-0- Depon, panadol, apotel etc.","pharmaceutical formulations (pills, suppositories)","analgesic and antipyretic activity - antiinflammatory actions - no prescription required - relief of headaches and other pains, colds and flu","safe, most people don't show side effects at recommended doses max. 1000 mg per dose and 4000 mg per day  Overdosing is the major cause of acute liver injury","1-3");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("High Fever","Aspirin-chemical-Acetylsalicylic acid-0 ","pharmaceutical formulations (pills, suppositories)","analgesic and antipyretic activity - antiinflammatory actions - anticoagulant activity","dangerous to take a few days before surgery as several days after cause may cause profuse bleeding - doctor approval is required","3");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Flu","Vitamin C-natural -0-0","raw cabbage - citrus trees (lemos, orange, grape fruit)","absorbance of iron - protection of infections - accelares the wound healing -local antisypsia","none so far","0-2-3-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Flu","Paracetamol -chemical-0-trade names: Depon, panadol, apotel etc ","pharmaceutical formulations (pills, suppositories)","analgesic and antipyretic activity - antiinflammatory actions- no prescription required -relief of headaches and other pains, colds and flu","safe, most people don't  show side effects at recommended doses  max ,1000 mg per dose and 4000 mg per day.Overdosing is the major cause of acute liver injury","0-2-3-4");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Light burns","Alboumins and globoulins proteins- natural -0-0","egg whites","proteins with high biological value, assist in immediate removal of redness and pain caused by burning.Immediate action to restoration of burned skin","none so far","1-3");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Light burns","Aloe Vera-natural-0-0","herb - gel","antibiotic, antifungal and anti-inflammatory action,stimulates the immune system, calms the nervous system,cleans the intestines and detoxify the body.-soothing various skin irritations, such as burns, corns, scars, herpes.-Aloe is absorbed faster than water and thus the skin heals quickly.","Patients with diabetes who receive similar pharmacotherapy should be very careful since studies show that the use of oral aloe reduces blood sugar levels - In gel form and in overdose there is the case of suspension of the healing of severe postoperative scarring.","1-3");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Light headache","Paracetamol - chemical  -0-Depon, panadol, apotel etc.","pharmaceutical formulations (pills, suppositories).","analgesic and antipyretic activity - antiinflammatory actions - no prescription required - relief of headaches and other pains, colds and flu","safe, most people don't show side effects at recommended doses - max. 1000 mg per dose and 4000 mg per day - Overdosing is the major cause of acute liver injury","3");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Light headache"," Non steroidal antiinflammatory -chemical-selective inhibitors of COX2,mefenamic acid, lornoxicam, niflumic acid etc.- celebrex, arcoxia etc.","pharmaceutical formulations (pills, suppositories)-(aspirin, ibuprofen, nimesulide)","analgesic and antipyretic activity - antiinflammatory actions - relief of headaches and other pains - safer for the stomach (except aspirin)","associated with higher incidence of cardiovascular events - recommended consulting a doctor","3");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Toothache","Non steroidal antiinflammatory - chemical -selective inhibitors of COX2,mefenamic acid, lornoxicam, niflumic acid etc.- celebrex, arcoxia etc","pharmaceutical formulations (pills, suppositories) - (aspirin, ibuprofen, nimesulide)","analgesic and antipyretic activity - antiinflammatory actions - relief of headaches and other pains - safer for the stomach (except aspirin)","associated with higher incidence of cardiovascular events - recommended consulting a doctor","3-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Toothache","Essential oils rich in sulfur compounds - natural-0-0","garlic","Destroys bacteria. The juice of raw garlic helps to kill the infection from which can be derived Toothache (abscess)","Not suitable for people hypotensive.","3-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Toothache","NaCl - natural -0-0","cooking salt","stimulant and tonic - antiinflammatory actions","Not suitable for people hypertensive","3-4");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Pain menstruation","paracetamol  - chemical -0-Depon, panadol, apotel etc.","pharmaceutical formulations (pills, suppositories)","analgesic and antipyretic activity - antiinflammatory actions - no prescription required - relief of headaches and other pains, colds and flu","Overdosing is the major cause of acute liver injury","3");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Pain menstruation","Non steroidal antiinflammatory - chemical - selective inhibitors of COX2,mefenamic acid, lornoxicam, niflumic acid etc. -  celebrex, arcoxia etc.","pharmaceutical formulations (pills, suppositories)- (aspirin, ibuprofen, nimesulide)","analgesic and antipyretic activity - antiinflammatory actions - relief of headaches and other pains - safer for the stomach (except aspirin)","associated with higher incidence of cardiovascular events - recommended consulting a doctor","3");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Abdominal pain","anticonvulsants  - chemical - Mebeverine, otilonium, pinaverio, trimebutine -BUSCOPAN, GARAPEPSIN, etc.","pharmaceutical formulations (pills, suppositories)","analgesic and antipyretic activity - antiinflammatory actions - relief of headaches and other pains - relaxant action","Recommended consulting a doctor Because the pain of the abdomen may be due to diverse and potentially serious causes, the visit to the doctor is required.Advisable to avoid taking painkillers that may mask the real problem.","2-3");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Injuries pain"," Non steroidal antiinflammatory  - chemical - selective inhibitors of COX2, mefenamic acid, lornoxicam, niflumic acid etc - celebrex, arcoxia etc.","pharmaceutical formulations (pills, suppositories)-(aspirin, ibuprofen, nimesulide)","analgesic and antipyretic activity - antiinflammatory actions - relief of headaches and other pains - safer for the stomach (except aspirin)","associated with higher incidence of cardiovascular events - recommended consulting a doctor","3-4");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Productive cough"," Vitamin C - natural  - 0 - 0","raw cabbage - citrus trees (lemos, orange, grape fruit)","absorbance of iron -protection of infections - accelares the wound healing - local antisypsia","none so far","0-3-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Productive cough"," flavonoids - natural  - Quercetin - 0","onion juice","reducing symptoms of inflammatory conditions,helps to relieve congestion due to respiratory colds","none so far","0-3-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Productive cough"," ambroxol  - chemical   - 0 - 0","Pharmaceutical (syrups, lozenges)","mucolytic properties, facilitates removal of the secretions of the tracheobronchial tree, reducing the attitude of mucus resulting in improved breathing","Do not use during pregnancy and lactation - Possible cases of skin lesions and toxic epidermal necrosis temporalilly - In case of impaired renal function or severe liver disease  can be used only on medical advice. - Adverse effects: immune disorders, Skin and subcutaneous tissue,anaphylactic reactions, shock, angioedema, rash, urticaria, pruritus,dysgeusia, nausea, vomiting, diarrhea, indigestion, abdominal pain,dry mouth","0-3-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Productive cough"," Acetyl - chemical  - 0 - 0","pharmaceutical formulations (powder, granules,effervescent tablets)","mucolytic agent to reduce the viscosity of mucous secretions-antioxidative properties","none so far","0-3-4");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Productive cough"," Acetyl- natural  - 0 - 0","meat, eggs, wheat, broccoli, garlic, onions,red peppers)","mucolytic agent to reduce the viscosity of mucous secretions. - antioxidative properties ","none so far","0-3-4");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Dry cough"," voutamirate - chemical  - 0 - 0","pharmaceutical formulations (syrups)","non narcotic antitussive which acts in the center of cough,presents nonspecific anticholinergic and antispasmodic effect,which facilitates respiration","must be taken with great caution and only when it is dry cough as contraindicated in liquid cough (suppresses cough, encapsulates the phlegm and prevents expectoration with the risk of development of damages. Contraindication to administration is the possible existence of hypersensitivity to specific anticough.security during pregnancy or lactation is not certified.dependence cases have been reported, while in high doses, severe neurological disorders (seizures, chorea, brain edema, coma).","0-3");
   INSERT INTO diseases (name,substance,source,effect,side_effect,category) VALUES ("Dry cough"," pentoxyverin - chemical  - 0 - 0","pharmaceutical formulations(oral solution)","non narcotic cough suppressant that suppresses the cough center in the medulla, with additional local anesthetic action which reinforces the main central action. It also has mild spasmolytic and anticholinergic properties","Adverse reactions have been reported in less than 3% and was almost always mild and minimum cases necessitated discontinuation of therapy.The most commonly reported side effects include drowsiness, skin rash The most commonly reported side effects include drowsiness, skin rash vomiting, epigastric pain and diarrhea. Because acts on the CNS may cause respiratory depression, particularly in infants of less than 1 year and especially in premature.","0-3");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category)
   VALUES ("Otitis","Antibiotic for bacterial infection-chemical-Cefuroxime, cefprozil etc.-0","Pharmaceutical formulations (usually tablets)","Antibiotic bactericidal activity against a large number of commonpathogenic bacteria, including strains producing beta lactamases and is active against many strains resistant ampicillin andamoxycillin . The bactericidal action is due to inhibition composition of the cell wall of bacteria to bind basic proteins.","There is no experience of use in children younger than three months can affect the intestinal flora, resulting in less estrogen reabsorption and reduced efficacy combinations COC-Absorbed better after eating-Doctor approval is required","0-3-4");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category)
   VALUES ("Light Otitis","Paracetamol-chemical-0- Depon, panadol, apotel etc.","Pharmaceutical formulations (pills, suppositories)","Analgesic and antipyretic activity-Antiinflammatory actions-No prescription required-Relief of headaches and other pains, colds and flu","Safe-most people don't show side effects at recommended doses max. 1000 mg per dose and 4000 mg per day-Overdosing is the major cause of acute liver injury","0-3-4");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category)
   VALUES ("Light Otitis","Non steroidal antiinflammatory-chemical-selective inhibitors of COX2,mefenamic acid, lornoxicam, niflumic acid etc.- celebrex, arcoxia etc.","Pharmaceutical formulations (pills, suppositories)(aspirin, ibuprofen, nimesulide)","Analgesic and antipyretic activity-Antiinflammatory actions-Relief of headaches and other pains-Safer for the stomach (except aspirin)","Associated with higher incidence of cardiovascular events-Recommended consulting a doctor","0-3-4");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category)
   VALUES ("Light Otitis","Acetic acid-chemical-0-0","Pharmaceutical formulations (ear drops)","At densities of 2% to 5% is effective to external otitis especially caused by pseudomonas, or Aspergillus-It presents the advantage of being well tolerated-Does not cause or create resistant strains.","None so far-It should only be avoided by people who have (very rare) vinegar intolerance","0-3-4");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category)
   VALUES ("Dermatitis (Eczema)","Topical corticosteroids-chemical-flumetasone etc.-0","Pharmaceutical formulations (cream type)","Suppresses inflammatory reaction events such as edema, deposition of fibrin, the dilation of capillaries, the migration of leukocytes, the capillary proliferation, collagen deposition, proliferation of fibroblasts and scarring","Atrophy and thinning of the skin, telangiectasias, atrophic striae,purpura, perioral dermatitis, hypertrichosis, acneiform eruptions,allergic sensitization, worsening or masking infections.","1");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category)
   VALUES ("Dermatitis (Eczema)","Non steroidal antiinflammatory-chemical-selective inhibitors of COX2,mefenamic acid, lornoxicam, niflumic acid etc.-celebrex, arcoxia etc.","Pharmaceutical formulations (pills, suppositories)(aspirin, ibuprofen, nimesulide)","Analgesic and antipyretic activity-Antiinflammatory actions-Relief of headaches and other pains-Safer for the stomach (except aspirin)","Associated with higher incidence of cardiovascular events-Recommended consulting a doctor","1");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category)
   VALUES ("Sty in the eye","water - natural  - 0 - 0", "compresses with hot water","analgesic and antiinflammatory actions, relief of pain","none, not press the lid when touching the compress to the eye","3");

   INSERT INTO diseases (name,substance,source,effect,side_effect,category)
   VALUES ("Sty in the eye","chamomile- natural  - 0 - 0", "compresses with chamomile","analgesic and antiinflammatory actions, relief of pain","none, not press the lid when touching the compress to the eye","3");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E100","Curcumin","Color,Yellow and Orange","Safe","0");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E101","Riboflavin (Vitamin B2)","Color,Yellow and Orange","Safe","0");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E101a","Phosphate Riboflavin","Color,Yellow and Orange","Likely to be genetically modified (GM)","1");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E102","Tarzanini","Color,Yellow and Orange","Dangerous-Possible allergic reaction especially for patients with asthma, attention when combined with aspirin-Forbidden in countries of Western world","2-3-4");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E103","Alkanet, Alkannin","Color,Yellow and Orange","Forbidden in some parts of the western world! May increase hyperactivity inaffected children. Asthmatics sometimes react badly. Take care if you are sensitive to Aspirin.","3");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E104","Quinoline Yellow","Color,Yellow and Orange","Suspicious, May increase hyperactivity in affected children.","9");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E105","Fast Yellow AB","Color,Yellow and Orange","Forbidden","10");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E106","Riboflavin Sodium Phosphate","Color,Yellow and Orange","Safe","0");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E107","Yellow 2G","Color,Yellow and Orange","Possible allergic reaction","2");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E110","Orange GGN/ Sunset Yellow FCF","Color,Yellow and Orange","Dangerous, May increase hyperactivity in affected children. Take care if you are sensitive to Aspirin.","4");




   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E120","Cochineal / Carminic Acid","Color,Red","Dangerous-Possible allergic reaction-Animal origin","2-4-6");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E121","Orcein, Orchil","Color,Red","Forbidden","10");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E122","Carmoisine / Azorubine","Color,Red","suspicious, May increase hyperactivity in affected children. Asthmatics sometimes react badly. Take care if you are sensitive to Aspirin.","9");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E123","Amaranth","Color,Red","Very Dangerous may increase hyperactivity in affected children. Take care if you are sensitive to Aspirin.","4");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E124","Ponceau 4R / Cochineal Red A","Color,Red","Dangerous, may increase hyperactivity in affected children. Asthmatics sometimes react badly. Take care if you are sensitive to Aspirin.","4");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E125","Scarlet GN","Color,Red","Forbidden","10");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E126","Ponceau 6R","Color,Red","Forbidden","10");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E127","Erythrosine BS","Color,Red","Dangerous-Possible allergic reaction","4-2");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E128","Red 2G","Color,Red","Possible allergic reaction","2");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E129","Allura Red AC","Color,Red","Possible allergic reaction","2");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E130","Indanthrene blue RS","Color,Red","Forbidden","10");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E131","Patent Blue V","Color,Blue","May increase hyperactivity in affected children. Asthmatics sometimes react badly. Take care if you are sensitive to Aspirin. Be cautious if you suffer from allergies or intolerances.","2-5");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E132","Indigo Carmine / Idigotine","Color,Blue","May increase hyperactivity in affected children. Asthmatics sometimes react badly. Take care if you are sensitive to Aspirin. Be cautious if you suffer from allergies or intolerances.","2");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E133","IBrilliant Blue FCF","Color,Blue","Possible Allergic Reaction","2");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E140","Chlorophyll","Color,Green","Safe","0");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E141","Copper Complex of Chlorophyll","Color,Green","Suspicious-Likely to be genetically modified (GM)","1-9");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E142","Green S / Acid Brilliant Green BS","Color,Green","Cancer-Possible allergic reaction","2-5");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E150a","Caramel","Color,Brown and Black","Suspicious-Likely to be genetically modified (GM)","1-9");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E150b","Caustic sulphite Caramel","Color,Brown and Black","Likely to be genetically modified (GM)","1");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E150c","Ammonia Caramel","Color,Brown and Black","Likely to be genetically modified (GM)","1");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E150d","Sulphite ammonia Caramel","Color,Brown and Black","Likely to be genetically modified (GM)","1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E151","Black PN / Brilliant Black BN","Color,Brown and Black","Suspicious-Possible allergic reaction","2-9");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E152","Black 7984","Color,Brown and Black","Forbidden","10");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E153","Carbon Black / Vegetable Carbon (Charcoal)","Color,Brown and Black","Suspicious, may increase hyperactivity in affected children. Be
   cautious if you suffer from allergies or intolerances.","2-9-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E154","Brown FK","Color,Brown and Black","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E155","Brown ??","Color,Brown and Black","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E160a","Alpha, Beta, Gamma Carotene","Colour, Carotene derivative","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E160b","Annatto, Bixin, Norbixin","Colour, Carotene derivative","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E160c","Capsanthin / Capsorbin","Colour, Carotene derivative","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E160d","Lycopene","Colour, Carotene derivative","Likely to begenetically modified (GM)","1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E160e","Beta-8-carotenal Colour","Colour, Carotene derivative","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E160f","Ethyl ester of beta-8'-carotenic acid","Colour, Carotene derivative","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E161","Flavoxanthin","Color,Plant","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E161b","Lutein","Color,Plant","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E161c","Cryptoxanthin","Color,Plant","Likely to be genetically modified (GM)","1");




   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E161d","Rubixanthin","Color,Plant","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E161e","Violaxanthin","Color,Plant","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E161f","Rhodoxanthin","Color,Plant","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E161g","Canthaxanthin","Color,Plant","Likely to be genetically modified (GM)","1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E162","Beetroot Red / Betanin","Color,Plant","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E163","Anthocyanins","Color,Plant","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E170","Calcium Carbonate (Chalk)","Color,Inorganic","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E171","Titanium Dioxide","Color,Inorganic","Suspicious","9");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E172","Iron Oxides and Hydroxides","Color,Inorganic","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E173","Aluminium","Color,Inorganic","Suspicious","9");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E174","Silver","Color,Inorganic","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E175","Gold","Color,Inorganic","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E180","Pigment Rubine / Lithol Rubine BK","Color,Inorganic","Suspicious","9");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E181","Tannin","Color,Inorganic","Forbidden","10");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E200","Sorbic Acid","Preservative - Sorbic Acid and its salts","Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies","2-11-7");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E201","Soduim Sorbate","Preservative - Sorbic Acid and its salts","Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies","2-11-7");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E202","Potassium Sorbate","Preservative - Sorbic Acid and its salts","Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies","2-11-7");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E203","Calcium Sorbate","Preservative - Sorbic Acid and its salts","Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies","2-11-7");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E210","Benzoic Acid","Preservative - Sorbic Acid and its salts. Often added to milk products (cheese) and meat products.","Cancer-Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies-May increase hyperactivity in affected children. Asthmatics sometimes react
   badly. Be cautious if you suffer from allergies or intolerances.","2-11-7-5");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E211","Sodium Benzoate","Preservative - Sorbic Acid and its salts. Often added to milk products (cheese) and meat products.","Cancer-Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies-May increase hyperactivity in affected children. Asthmatics sometimes react
   badly. Be cautious if you suffer from allergies or intolerances.","2-11-7-5");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E212","Potassium Benzoate","Preservative - Sorbic Acid and its salts. Often added to milk products (cheese) and meat products.","Cancer-Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies-May increase hyperactivity in affected children. Asthmatics sometimes react badly. Be cautious if you suffer from allergies or intolerances.","2-11-7-5");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E213","Calcium Benzoate","Preservative - Sorbic Acid and its salts. Often added to milk products (cheese) and meat products.","Cancer-Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies-May increase hyperactivity in affected children. Asthmatics sometimes react badly. Be cautious if you suffer from allergies or intolerances.","2-11-7-5");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E214","Ethyl 4-hydroxybenzoate","Preservative - Sorbic Acid and its salts. Often added to milk products (cheese) and meat products.","Cancer-Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies-May increase hyperactivity in affected children. Asthmatics sometimes react badly. Be cautious if you suffer from allergies or intolerances.","2-11-7-5");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E215","Ethyl 4-hydroxybenzoate, Sodium Salt","Preservative - Sorbic Acid and its salts. Often added to milk products (cheese) and meat products.","Cancer-Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies-May increase hyperactivity in affected children. Asthmatics sometimes react badly. Be cautious if you suffer from allergies or intolerances.","2-11-7-5");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E216","Propyl 4-hydroxybenzoate","Preservative - Sorbic Acid and its salts. Often added to milk products (cheese) and meat products.",
   "Cancer-Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies-May increase hyperactivity in affected children. Asthmatics sometimes react badly. Be cautious if you suffer from allergies or intolerances.","2-11-7-5");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E217","Propyl 4-hydroxybenzoate, Sodium Salt","Preservative - Sorbic Acid and its salts. Often added to milk products (cheese) and meat products.","Cancer-Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies-May increase hyperactivity in affected children. Asthmatics sometimes react badly. Be cautious if you suffer from allergies or intolerances.","2-11-7-5");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E218","Methyl 4-hydroxybenzoate","Preservative - Sorbic Acid and its salts. Often added to milk products (cheese) and meat products.",
   "Cancer-Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies-May increase hyperactivity in affected children. Asthmatics sometimes react badly. Be cautious if you suffer from allergies or intolerances.","2-11-7-5");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E219","Methyl 4-hydroxybenzoate, Sodium Salt","Preservative - Sorbic Acid and its salts. Often added to milk products (cheese) and meat products.","Cancer-Headaches- Damage to intestinal microbiota- Intestinal upset- constipation- allergies-May increase hyperactivity in affected children. Asthmatics sometimes react badly. Be cautious if you suffer from allergies or intolerances.","2-11-7-5");




   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E220","Sulphur Dioxide","Preservative - Sulfur Dioxide and its salts Sulfites, Often added to milk products (cheese) and meat products","Headaches-Intestine Upset-Skin Disorders-Destroys Vitamins B5, B6, B12","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E221","Sodium Sulphite","Preservative - Sulfur Dioxide and its salts Sulfites, Often added to milk products (cheese) and meat products","Headaches-Intestine Upset-Skin Disorders-Destroys Vitamins B5, B6, B12","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E222","Sodium Hydrogen Sulphite","Preservative - Sulfur Dioxide and its salts Sulfites, Often added to milk products (cheese) and meat products","Headaches-Intestine Upset-Skin Disorders-Destroys Vitamins B5, B6, B12","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E223","Sodium Metabisulphite","Preservative - Sulfur Dioxide and its salts Sulfites, Often added to milk products (cheese) and meat products","Headaches-Intestine Upset-Skin Disorders-Destroys Vitamins B5, B6, B12","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E224","Potassium Metabisulphite","Preservative - Sulfur Dioxide and its salts Sulfites, Often added to milk products (cheese) and meat products","Headaches-Intestine Upset-Skin Disorders-Destroys Vitamins B5, B6, B12","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E226","Calcium Sulphite","Preservative - Sulfur Dioxide and its salts Sulfites, Often added to milk products (cheese) and meat products","Headaches-Intestine Upset-Skin Disorders-Destroys Vitamins B5, B6, B12","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E227","Calcium Hydrogen Sulphite","Preservative - Sulfur Dioxide and its salts Sulfites, Often added to milk products (cheese) and meat products","Headaches-Intestine Upset-Skin Disorders-Destroys Vitamins B5, B6, B12","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E228","Potassium hydrogen sulphite","Preservative - Sulfur Dioxide and its salts Sulfites, Often added to milk products (cheese) and meat products","Headaches-Intestine Upset-Skin Disorders-Destroys Vitamins B5, B6, B12","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E230","Biphenyl / Diphenyl","Preservative - Biphenyl and its derivatives","Headaches-Intestine Upset-Skin Disorders","7-11-12");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E231","2-Hydroxybiphenyl","Preservative - Biphenyl and its derivatives","Headaches-Intestine Upset-Skin Disorders","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E232","Sodium Biphenyl-2-yl Oxide","Preservative - Biphenyl and its derivatives","Headaches-Intestine Upset-Skin Disorders","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E233","2-(Thiazol-4-yl) Benzimidazole","Preservative - Biphenyl and its derivatives","Headaches-Intestine Upset-Skin Disorders","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E234","Nisin","Preservative - other","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E235","Natamycin, Pimaracin","Preservative - other","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E236","Formic acid","Preservative - other","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E237","Sodium formate","Preservative - other","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E238","Calcium formate","Preservative - other","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E239","Hexamine","Preservative - other","Cancer-Headaches-Intestine Upset-Skin Disorders","5-7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E240","Formaldehyde","Preservative - other","Suspicious-Headaches-Intestine Upset-Skin Disorders","9-7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E242","Dimethyl dicarbonate","Preservative - other","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E249","Potassium Nitrate","Preservative - Pickling Salts","Headaches-Intestine Upset-Skin Disorders","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E250","Sodium Nitrite","Preservative - Pickling Salts","Headaches-Intestine Upset-Skin Disorders","7-11-12-8");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E251","Sodium Nitrate","Preservative - Pickling Salts","Headaches-Intestine Upset-Skin Disorders","7-11-12-8");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E252","Potassium Nitrate(Saltpetre)","Preservative - Pickling Salts","Headaches-Intestine Upset-Skin Disorders","7-11-12-8-6");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E260","Acetic Acid","Miscellaneous - Acids and their Salts","Headaches-Intestine Upset-Skin Disorders","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E261","Potassium Acetate","Miscellaneous - Acids and their Salts","Headaches-Intestine Upset-Skin Disorders","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E262","Potassium Hydrogen Diacetate","Miscellaneous - Acids and their Salts","Headaches-Intestine Upset-Skin Disorders","7-11-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E263","Calcium Acetate","Miscellaneous - Acids and their Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E264","Ammonium acetate","Miscellaneous - Acids and their Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E270","Lactic Acid","Miscellaneous - Acids and their Salts","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E280","Propionic Acid","Miscellaneous - Acids and their Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E281","Sodium Propionate","Miscellaneous - Acids and their Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E282","Calcium Propionate","Miscellaneous - Acids and their Salts","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E283","Potassuim Propionate","Miscellaneous - Acids and their Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E284","Boric acid","Preservative","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E285","Sodium tetraborate (borax)","Preservative","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E290","Carbon Dioxide","Miscellaneous - Acids and their Salts","Intestine Upset","11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E296","Malic acid","Acidity regulator","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E297","Foumaric acid","Acidity regulator","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E300","L-Ascorbic Acid (Vitamin C)","Antioxidants- Vitamin C and derivatives","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E301","Sodium-L-Ascorbate","Antioxidants- Vitamin C and derivatives","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E302","Calcium-L-Ascorbate","Antioxidants- Vitamin C and derivatives","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E303","Potassium ascorbate","Antioxidants- Vitamin C and derivatives","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E304","Ascorbyl Palmitate","Antioxidants- Vitamin C and derivatives","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E306","Natural Extracts rich in Tocopherols","Antioxidants- Vitamin E"," Safe-Possibly genetically modified (GM)","0-1");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E307","Synthetic Alpha-Tocopherol","Antioxidants- Vitamin E"," Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E308","Synthetic Gamma-Tocopherol","Antioxidants- Vitamin E"," Safe-Possibly genetically modified (GM)","0-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E309","Synthetic Delta-Tocopherol","Antioxidants- Vitamin E"," Safe-Possibly genetically modified (GM)","0-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E310","Propyl Gallate","Antioxidants- other","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E311","Octyl Gallate","Antioxidants- other","Possible allergic reaction","2-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E312","Dodecyl Gallate","Antioxidants- other","Possible allergic reaction","2-12");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E315","Erythorbic acid","Antioxidants- other","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E316","Sodium erythorbate","Antioxidants- other","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E317","Erythorbin acid","Antioxidants- other","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E318","Sodium erythorbin","Antioxidants- other","safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E319","Butylhydroxinon","Antioxidants- other","safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E320","Butylated Hydroxyanisole (BHA)","Antioxidants- other","May increase hyperactivity in affected children-Asthmatics sometimes react badly-Be cautious if you suffer from allergies or intolerances-May not be suitable for babies","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E321","BHT","Antioxidants- other","May increase hyperactivity in affected children-Asthmatics sometimes react badly-Be cautious if you suffer from allergies or intolerances-May not be suitable for babies","2");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E322","Lecithins","Emulsifiers and Stabilisers","Safe-Possibly genetically modified (GM)","0-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E325","Sodium Lactate","Miscellaneous - Salts of Lactic Acid","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E326","Potassium Lactate","Miscellaneous - Salts of Lactic Acid","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E327","Calcium Lactate","Miscellaneous - Salts of Lactic Acid","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E329","Magnesium lactate","Miscellaneous - Salts of Lactic Acid","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E330","Citric Acid","Miscellaneous - Citric Acid and its Salts","Cancer-Headaches-Damage to intestinal microbiota-intestinal upset- Constipation","5-7-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E331","Sodium Citrates","Miscellaneous - Citric Acid and its Salts","Cancer-Headaches-Damage to intestinal microbiota-intestinal upset- Constipation","5-7-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E332","Potassium Citrates","Miscellaneous - Citric Acid and its Salts","Cancer-Headaches-Damage to intestinal microbiota-intestinal upset- Constipation","5-7-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E333","Calcium Citrates","Miscellaneous - Citric Acid and its Salts","Cancer-Headaches-Damage to intestinal microbiota-intestinal upset- Constipation","5-7-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E334","Tartaric Acid","Miscellaneous - Tartaric Acid and its Salts","Headaches-Damage to intestinal microbiota-Intestinal upset-Constipation","5-7-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E335","Sodium Tartrate","Miscellaneous - Tartaric Acid and its Salts","Headaches-Damage to intestinal microbiota-Intestinal upset-Constipation","5-7-11");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E336","Potassium Tartrate (Cream of Tartar)","Miscellaneous - Tartaric Acid and its Salts","Headaches-Damage to intestinal microbiota-Intestinal upset-Constipation","5-7-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E337","Potassium Sodium Tartrate","Miscellaneous - Tartaric Acid and its Salts","Headaches-Damage to intestinal microbiota-Intestinal upset-Constipation","5-7-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E338","Orthophosphoric Acid","Miscellaneous - Phosphoric Acid and its Salts","Headaches-Damage to intestinal microbiota-Intestinal upset-Constipation-Allergies","2-5-7-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E339","Sodium phosphates","Miscellaneous - Phosphoric Acid and its Salts","Intestinal upset-Possible allergic reaction","2-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E340","Sodium phosphates","Miscellaneous - Phosphoric Acid and its Salts","Intestinal upset-Possible allergic reaction","2-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E341","Sodium phosphates","Miscellaneous - Phosphoric Acid and its Salts","Intestinal upset-Possible allergic reaction","2-11");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E343","Magnesium phosphates","Miscellaneous","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E350","Sodium malates","Acidity regulator","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E351","Potassium malate","Acidity regulator","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E352","Calcium malate","Acidity regulator","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E353","Metatartaric acid","emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E354","Calcium tartate","emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E355","Adipic acid","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E357","Potassium adipate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E363","Succinic acid","acid","Safe","0");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E365","Sodium fumarate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E366","Potassium fumarate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E367","Calcium fumarate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E370","1,4-Heptonolactone","acid","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E375","Nicotinic acid","Miscellaneous","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E380","Triammonium citrate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E381","Ammoniumferrocitrate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E385","Calcium disodium EDTA","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E400","Alginic Acid","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E401","Sodium Alginate","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E402","Potassium Alginate","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E403","Ammonium Alginate","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E404","Calcium Alginate","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E405","Propane-1,2-Diol Alginate","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E406","Agar","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E407","Sodium malates","Emulsifiers and Stabilisers - Alginates","Intestinal upset-Possible allergic reaction","2-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E407a","Processed eucheuma seaweed","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E410","Locust Bean Gum (Carob Gum)","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E412","Guar Gum","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E413","Tragacanth","Emulsifiers and Stabilisers - Alginates","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E414","Gum Acacia (Gum Arabic)","Emulsifiers and Stabilisers - Alginates","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E415","Xanthan Gum","Emulsifiers and Stabilisers - Alginates","Possibly genetically modified (GM)","1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E416","Karaya gum","Emulsifiers and Stabilisers - Alginates","Possible allergic reaction","2");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E417","Tara gum","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E418","Gellan gum","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E420","Sorbitol","Emulsifiers and Stabilisers - Alginates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E421","Mannitol","Anti-caking agent, sweetener","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E422","Glycerol","Emulsifier,sweetener","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E425","Konjac","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E430","Polyxyethylene (8) stearate","Emulsifier,stabilier","Possible allergic reaction-Possibly of animal origin","2-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E431","polyxyethylene (40) stearate","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E432","Polyxyethylene (20) sorbitan monolaurate","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E433","Polyxyethylene (20) sorbitan monooleate","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E434","Polyxyethylene (20) sorbitan monopalmitate","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E435","Polyxyethylene (20) sorbitan monostearate","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E436","Polyxyethylene (20) sorbitan tristearate","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E440","Pectin","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E441","Gelatin","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E442","Ammonium phosphatides","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E444","Sucrose acetate isobutyrate","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E445","Glycerol esters of wood rosins","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E450","Diphosphates","Emulsifier","Intestinal upset","11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E451","Triphosphates","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E452","Polyphosphates","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E459","Beta-cyclodextrine","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E460","Cellulose","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E461","Methyl cellulose","Emulsifier","Intestinal upset","11");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E462","Ethyl cellulose","Emulsifier","Intestinal upset","11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E463","Hydroxypropylcellulose","Emulsifier","Intestinal upset","11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E464","Hydroxypropyl-Methylcellulose","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E465","Ethylmethylcellulose","Emulsifier","Intestinal upset","11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E466","Carboxymethylcellulose, Sodium Salt","Emulsifier","Intestinal upset","11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E468","Crosslinked sodium carboxymethyl cellulose","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E469","Enzymically hydrolysed carboxymethylcellulose","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E470a","Sodium, Potassium and Calcium Salts of Fatty Acids","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E470b","Magnesium Salts of Fatty Acids","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E471","Mono-and Diglycerides of Fatty Acids","Emulsifier","Safe-Possibly of animal origin-Possibly genetically modified","0-1-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E472a","Acetic acid Esters of Mono- and Diglycerides of Fatty Acids","Emulsifier","Possibly of animal origin-Possibly genetically modified","1-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E472b","Lactic acid Esters of Mono- and Diglycerides of Fatty Acids","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E472c","Citric acid Esters of Mono- and Diglycerides of Fatty Acids","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E472d","Tartaric acid Esters of Mono- and Diglycerides of Fatty Acids","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E472e","Mono- and diacetyl tartaric acid Esters of Mono-and Diglycerides of Fatty Acids","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E472f","Mixed Acetic and tartaric acid Esters of Mono-and Diglycerides of Fatty Acids","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E473","Sucrose Esters of Fatty Acids","Emulsifier","Possibly of animal origin-Possibly genetically modified","1-6");




   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E474","Sucroglycerides","Emulsifier","Possibly of animal origin-Possibly genetically modified (GM)","6-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E475","Polyglycerol Esters of Fatty Acids","Emulsifier","Possibly of animal origin-Possibly genetically modified (GM)","6-1");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E476","Polyglycerol polyricinoleate","Emulsifier","Possibly of animal origin-Possibly genetically modified","6-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E477","Propane-1,2-Diol Esters of Fatty Acids","Emulsifier","Suspicious-Possibly of animal origin-Possibly genetically modified","9-6-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E478","Lactylated fatty acid esters of glycerol and propane-1","Emulsifier","Safe- Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E479b","Thermally oxidized soya bean oil interacted with mono- and diglycerides of fatty acids","Emulsifier","Possibly of animal origin-Possibly genetically modified","1-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E481","Sodium Stearoyl-2-Lactylate","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E482","Calcium Stearoyl-2-Lactylate","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E483","Stearyl Tartrate","Emulsifier","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E491","Sorbitan monostearate","Emulsifier","Possibly of animal origin-Possibly genetically modified","1-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E492","Sorbitan tristearate","Emulsifier","Possibly of animal origin-safe","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E493","Sorbitan monolaurate","Emulsifier","Possibly of animal origin-Safe","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E494","Sorbitan monooleate","Emulsifier","Possibly of animal origin-Safe","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E495","Sorbitan monopalmitate","Emulsifier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E500","Sodium Carbonate / Sodium","Miscellaneous - Acids and Salts: Carbonates","Safe","0");




   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E501","Potassium Carbonate /Potassium Bicarbonate","Miscellaneous - Acids and Salts: Carbonates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E503","Ammonium Carbonate","Miscellaneous - Acids and Salts: Carbonates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E504"," Magnesium Carbonate","Miscellaneous - Acids and Salts: Carbonates","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E507"," Hydrochloric Acid","Miscellaneous - Acids and Salts: Hydrochloric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E508"," Potassium Chloride","Miscellaneous - Acids and Salts: Hydrochloric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E509"," Calcium Chloride","Miscellaneous - Acids and Salts: Hydrochloric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E510"," Ammonium Chloride","Miscellaneous - Acids and Salts: Hydrochloric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E511"," Magnesium chloride","Miscellaneous - Acids and Salts: Hydrochloric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E512"," Stannous chloride","Miscellaneous - Acids and Salts: Hydrochloric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E513"," Sulphuric Acid","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E514"," Sodium Sulphate","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E515"," Potassium Sulphate","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E516"," Calcium Sulphate","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E517"," Ammonium sulphate","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E518"," Magnesium Sulphate","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E519"," Copper sulphate","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E520"," Aluminium sulphate","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","safe","0");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E521","Aluminium sodium sulphate","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E522","Aluminium potassium sulphate","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E523","Aluminium ammonium sulphate","Miscellaneous - Acids and Salts: Sulphuric Acid and its Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E524","Sodium Hydroxide","Miscellaneous - Alkalis","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E525","Potassium Hydroxide","Miscellaneous - Alkalis","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E526","Calcium Hydroxide","Miscellaneous - Alkalis","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E527","Ammonium Hydroxide","Miscellaneous - Alkalis","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E528","Magnesium Hydroxide","Miscellaneous - Alkalis","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E529","Calcium Oxide","Miscellaneous - Alkalis","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E530","Magnesium Oxide","Miscellaneous - Alkalis","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E535","Sodium Ferrocyanide","Miscellaneous - other Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E536","Potassium Ferrocyanide","Miscellaneous - other Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E538","Calcium ferrocyanide","Miscellaneous - other Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E540","Dicalcium Ferrocyanide","Miscellaneous - other Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E541","sodium Aluminium Phosphate","Miscellaneous - other Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E542","Edible Bone Phosphate (Bone-Meal)","Miscellaneous - Anti-Caking Agents","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E542","Edible Bone Phosphate (Bone-Meal)","Miscellaneous - Anti-Caking Agents","Safe-possible of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E543","Calcium sodium polyphosphate","miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E544","Calcium Polyphosphates","Miscellaneous - Anti- Caking Agents","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E545","Ammonium Polyphosphates","Miscellaneous - Anti-Caking Agents","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E550","Sodium silicate","miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E551","Silicon Dioxide (Silica Salt)","Miscellaneous - Silicon Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E552","Calcium Silicate","Miscellaneous - Silicon Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E553a","Magnesium Silicate","Miscellaneous - Silicon Salts","Safe","0");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E553b","Talc","Miscellaneous - Silicon Salts","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E554","Aluminium Sodium Silicate","Miscellaneous - Silicon Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E556","Aluminium Calcium Silicate","Miscellaneous - Silicon Salts","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E558","Bentonite","Miscellaneous - other compounds","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E559","Kaolin (Aluminium Silicate)","Miscellaneous - other compounds","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E570","Stearic Acid","Miscellaneous - other compounds","Possibly of animal origin-Possibly genetically modified (GM)","6-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E572","Magnesium Stearate","Miscellaneous - other compounds","Possibly of animal origin-Possibly genetically modified (GM)","6-1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E574","Gluconic acid","Miscellaneous - other compounds","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E575","Glucono Delta-Lactone","Miscellaneous - other compounds","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E576","Sodium Gluconate","Miscellaneous - other compounds","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E577","Potassium Gluconate","Miscellaneous - other compounds","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E578","Calcium Gluconate","Miscellaneous - other compounds","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E579","Ferrous gluconate","colour","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E585","Ferrous lactate","colour","Safe-Possibly of animal origin","0-6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E620","L-Glutamic Acid","Miscellaneous - Flavour Enhancers","Possibly genetically modified (GM)","1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E621","Monosodium Glutamate (MSG)","Miscellaneous - Flavour Enhancers","TOXIC-Headaches- Intestine Upset- Skin Disorders","7-12-11");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E622","Monopotassium Glutamate","Miscellaneous - Flavour Enhancers","Possibly genetically modified (GM)","1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E623","Calcium Glutamate","Miscellaneous - Flavour Enhancers","Possibly genetically modified (GM)","1");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E624","Monoammonium Glutamate","Miscellaneous - Flavour Enhancers","Possibly genetically modified (GM)","1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E625","Magnesium diglutamate","Miscellaneous - Flavour Enhancers","Possibly genetically modified (GM)","1");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E626","Guanylic acid","Miscellaneous - Flavour Enhancers","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E627","Sodium Guanylate","Miscellaneous - Flavour Enhancers","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E628","dipotassium Guanylate","Miscellaneous - Flavour Enhancers","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E629","calcium Guanylate","Miscellaneous - Flavour Enhancers","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E630","Disodium inosinate","Miscellaneous - Flavour Enhancers","Possibly of animal origin","6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E632","Dipotassium inosinate","Miscellaneous - Flavour Enhancers","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E633","Calcium inosinate","Miscellaneous - Flavour Enhancers","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E634","Calcium 5?-ribonucleotides","Miscellaneous - Flavour Enhancers","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E635","Sodium5-Ribonucleotide","Miscellaneous - Flavour Enhancers","Possibly of animal origin","6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E636","Maltol","Miscellaneous - Flavour Enhancers","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E637","Ethyl Maltol","Miscellaneous - Flavour Enhancers","safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E640","Glycine and its sodium salt","Miscellaneous - Flavour Enhancers","Possibly of animal origin","6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E900","Dimethylpolysiloxane","Miscellaneous - Flavour Enhancers","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E901","Beeswax","Miscellaneous - Glazing Agents","Possible allergic reaction-Possibly of animal origin","6-2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E902","Candelilla","Miscellaneous - Glazing Agents","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E903","Carnauba wax","Miscellaneous - Glazing Agents","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E904","Shellac","Miscellaneous - Glazing Agents","Animal origin","6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E905","Mineral Hydrocarbons","Miscellaneous - Glazing Agents","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E907","Refined Microcrystalline Wax","Miscellaneous - Glazing Agents","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E910","L-cysteine","Miscellaneous","Animal origin","6");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E912","Montanic acid esters","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E913","Lanolin","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E914","Oxidized polyethylene wax","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E915","Ester of Kollophoniums","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E920","L-Cysteine Hydrochloride","Miscellaneous -Compounds used to treat Flour","Animal origin","6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E921","L-Cysteine Hydrochloride monohydrate flour","MiscellanMiscellaneous -Compounds used to treat Floureous","Animal origin","6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E924","Potassium Bromate","Miscellaneous -Compounds used to treat Flour","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E925","Chlorine","Miscellaneous -Compounds used to treat Flour"," Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E926","Chlorine Dioxide","Miscellaneous -Compounds used to treat Flour","Safe ","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E927b","Azodicarbonamide","Miscellaneous -Compounds used to treat Flour"," Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E928","Benzole peroxide","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E938","Argon","Packaging gas","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E939","Helium","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E941","Nitrogen","Packaging gas","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E942","Nitrous oxide","propellant","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E948","Oxygen","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E949","Hydrogen","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E950","Aceculfame K","sweetener","Possible allergic reaction","2");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E951","Aspartame","sweetener","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E952","Cyclamic acid and its Na and Ca salts","sweetener","Possible allergic reaction","2");


   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E953","Isomalt","sweetener","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E954","Saccharin and its Na, K and salts","sweetener","Possible allergic reaction","2");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E957","Thaumatin","sweetener","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E959","Neosperidine DC","sweetener","Possible allergic reaction","2");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E965","Maltitol","sweetener","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E966","Lactitol","sweetener","Animal origin","6");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E967","Xylitol","sweetener","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E999","Quillaia extract","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1103","Invertase","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1105","Lysozyme","preservative","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1200","Polydextrose","stabilizer- thickening agent-humectant- carrier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1201","Polyvinylpyrrolidone","stabilizer","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1202","Polyvinylpolypyrrolidone","carrier","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1400","Dextrin","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1401","Modified starch","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1402","Alkaline Modified starch","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1403","Bleached starch","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1404","Oxidized starch","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1410","Monostarch phospate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1412","Distarch phospate","Miscellaneous","Safe","0");



   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1413","Phosphate distarch phospate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1414","Acetylated distarch phospate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1420"," Acetylated starch, mono starch acetate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1422","Acetylated distarch adipate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1430","Distarch glycerin","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1440","Hydroxyl propyl starch","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1441","Hydroxyl propyl distarch glycerin","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1442","Hydroxyl propyl distarch phosphate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1450","Starch sodium octenyl succinate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1451","Acetylated oxidized starch","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1505","Triethyl citrate","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1510","Ethanon","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1517","Triacetin","Miscellaneous","Safe","0");

   INSERT INTO esubstances (name,compound,attribute,side_effect,category)
   VALUES("E1520","Propylene glycol","Miscellaneous","Safe","0");

