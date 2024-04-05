# bestiary

 ![image](/doc/imgs/Bestiary-white-diagram.png)

In this image we can see the configuration diagram of the bestiary APP.

First we have 'BestiaryApp' which is the Application itself, which will use 'BestiaryRunApp' to run the application. 

When running the application, we can use three sections:

* 'BestiaryHelp', which is used to return the commands to use the APP.
* 'BeastService', which will return basic searches within the bestiary.
* BeastQueryService', which will be used for more specific searches. For this Service it will depend on an implementation (which is in charge of 'BeastQueryServiceImp').

Finally, 'BeastService' and 'BeastQueryServiceImp' depend on 'BestiaryDao' which is in charge of building the model that comes from the class 'Beast'.