Installation & Configuration : 

Projet Java Spring Boot 
BDD : MySQL (local)
IDE (intelliJ)


*** Configuration du projet  ***

Url application : http://localhots:9001


Pour consulter la base de donnée : 

Concernant la console H2, une fois l’application démarrée, 
vous pouvez aller sur l’URL “http://localhost:9000/h2-console”. 

Une fenêtre de login s’ouvre, et il est nécessaire d’indiquer l’URL Jdbc (qui change à chaque démarrage de l’application).
Dans votre console, vous aurez une ligne qui doit ressembler à la suivante :
“H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:b59feadd-5612-45fe-bd1c-3b62db66ea8a'”.

Récupérez l’URL JDBC (en l'occurrence jdbc:h2:mem:b59feadd-5612-45fe-bd1c-3b62db66ea8a'), 
saisissez l'url dans le formulaire proposé, puis “Connect”. 

Le username par défaut est bien “sa”, et le password par défaut est vide.



