Stockage de données sous Android
================================


 1-	Stockage des données temporaires d'une activité
 2-	Stockage des données persistantes
  a- préférences (couples de clé-valeur ou Shared Preferences)
  b- Fichiers internes 
  c- Fichiers externes (usb, card memorie …)
  d- Cache file
  e- Online file (sur mon propre server)
  f- Base de données SQLite3
  g-Cloud server (Drop box, Box, Google Cloud …)


1-Stockage des données temporaires d'une activité
Une activité peut être détruite :
– En cas de changement de l’orientation de l'écran
– En cas de l’ insuffisance de mémoire centrale
Avant destruction, sauvegarde manuelle des structures de données temporaires utiles ,et restauration de l'état de l'activité lors de la réinstantiation.
– onSaveInstanceState(Bundle outState) : sauvegarde des données
– onCreate(Bundle state) : restauration des données

2.a- Préférences
Dans toutes applications, il est souvent nécessaire d'utiliser des variables qui doivent être gardé en mémoire même suite à une fermeture. La solution des SharedPreferences est la plus simple a implémenté.
– getSharedPreferences(String Preferences_name, int mode) récupère les préférences du nom de l'activité courante
– Plusieurs applications peuvent accéder aux mêmes préférences si mode = MODE_WORLD_READABLE ou MODE_WORLD_WRITABLE

Pour récupérer une valeur: get{Boolean, Float, Int, Long, String}(String key, X defaultValue)

2.b- Fichiers internes 
Chaque application dispose d'un répertoire réservé pour stocker ses fichiers (noms de fichier en UTF-8) récupérable avec File Context.getFilesDir() (ce répertoire est détruit lors de la désinstallation de l'application).
Le système de fichiers interne peut être chiffré à l'aide du mot de passe de déverrouillage

2.c- Fichiers externe
Les fichiers sur support externes sont toujours publics et non chiffrés.

d- Cache file
Utile pour y stocker des données temporaires (issues de calculs, de récupération de données sur Internet...),Les données stockées peuvent être effacées par le système en cas de désinstallation de l'application, cas de pénurie de mémoire de stockage,l’application nécessité d'être raisonnable pour l'espace 
utilisé par le cache (partage par toutes les applications)

2.e- Online file
On peut utilise le réseau (quand il est disponible) pour stocker et récupérer des données sur le Web.

