# Arbre_Genealogique
Projet: Arbre généalogique
Pour ce projet, nous nous intéresserons à la manipulation d'arbres généalogiques. Un arbre généalogique est représenté par un assemblage d'objet de type personne. Chaque objet contient une référence vers le prénom d'une personne ainsi que des références vers son père, sa mère et ses enfants. Une personne est identifiée par son prénom, son sexe, sa date de naissance et de mort (null si vivant). Le programme doit permettre de saisir un arbre généalogique. Ensuite il offre le menu suivant :
1. Afficher l'arbre
2. Afficher les ancêtres d'une personne donnée
3. Afficher les (demi) frères et (demi) sœurs d'une personne donnée 4.
4. Afficher les cousins d'une personne donnée 5.
5. Donner le lien de parenté entre deux personnes données
________________________________________________________________________________________________________________________________________
Le projet se compose de 3 packages : "model", qui contient les classes nécessaires au fonctionnement du
programme, "vue", qui regroupe toutes les classes des interfaces graphiques utilisées, et "controler", qui
héberge les classes chargées de faire le lien entre les classes du modèle et les interfaces graphiques de la
vue. Chaque bouton de l'interface a sa propre classe qui le gère. Le package 'controler' a pour rôle de
rendre l'application fonctionnelle et interactive.
