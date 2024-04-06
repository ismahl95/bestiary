# bestiary

 ![image](/doc/imgs/Bestiary-white-diagram.png)

In this image we can see the configuration diagram of the bestiary APP.

First we have 'BestiaryApp' which is the Application itself, which will use 'BestiaryRunApp' to run the application. 

When running the application, we can use three sections:

* 'BestiaryHelp', which is used to return the commands to use the APP.
* 'BeastService', which will return basic searches within the bestiary.
* BeastQueryService', which will be used for more specific searches. For this Service it will depend on an implementation (which is in charge of 'BeastQueryServiceImp').

Finally, 'BeastService' and 'BeastQueryServiceImp' depend on 'BeastDao' which is in charge of building the model that comes from the class 'Beast'.

* 'Beast': This is the model class, which will contain the fields of each of the beasts.

* 'BeastDao': It is an interface that contains the methods to perform the searches (FindByName, findAll...).

* 'BeastDaoImplMemory': It is a class that implements the previous interface and it is the one that has the logic of the methods for the searches.


Finally we have a last class called 'UtilBeastReader' which will be in charge of debugging the whole CSV file that contains the different beasts. 

---------------------------------------------------------------------------------------------------
# Tips
 ![image](/doc/imgs/Optional.png)

In this case, we must use Optional because it may or may not return a result. 
Unlike working lists that may be empty. Optional should return the object or a null.