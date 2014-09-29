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

2.a- Préférences

Dans toutes applications, il est souvent nécessaire d'utiliser des variables qui doivent être gardé en mémoire même suite à une fermeture. La solution des SharedPreferences est la plus simple a implémenté.

2.b- Fichiers internes Chaque application dispose d'un répertoire réservé pour stocker ses fichiers (noms de fichier en UTF-8) récupérable avec File Context.getFilesDir() (ce répertoire est détruit lors de la désinstallation de l'application).
Le système de fichiers interne peut être chiffré à l'aide du mot de passe de déverrouillage
