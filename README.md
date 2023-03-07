# vuthanhtam-demo

**Folder structure :** 
      
├── gennerateCsv <br>
│    GenerateTranslationService.java  --->   Generate
English-Vietnamese translation csv file <br>
├── importcsv <br>
│    ImportTranslationService.java  ---> Import translation csv file to PostgreSQL <br>
└── translation  <br>
     TranslationsService.java --->  public API service <br>

**How to use :** 

+ Call API: http://thanhtam-hust.tech/generate/eng-vi   to enerate
English-Vietnamese translation csv file


+ Call API: http://thanhtam-hust.tech:5002/import   to Import translation csv file to PostgreSQL

+ Call API: http://thanhtam-hust.tech/api/translations?page_number=5&page_size=10     to get data translate

**Result** 
+ ![image](https://user-images.githubusercontent.com/49809669/223333916-b8f59c0c-8e47-40bc-b3c8-c782143c648d.png)


**Generate English-Vietnamese translation csv file** <br>
 ![image](https://user-images.githubusercontent.com/49809669/223334135-00a3e44e-4bd7-43c5-8bd6-5e1ac2b25b0c.png)

**Import translation csv file to PostgreSQL**<br>

![image](https://user-images.githubusercontent.com/49809669/223334447-92d12af8-b801-454d-853d-b6be98ae1c3f.png)

