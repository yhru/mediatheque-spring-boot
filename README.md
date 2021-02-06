# Mediatheque 

Réalisation d’une application permettant de gérer une bibliothéque d’images en mettant en place une API Java et une interface graphique
 
# User Stories
- En tant que Utilisateur non connecté :   
- je veux pouvoir m'authentifier par identifiant et mot de passe  

## En tant que Gestionnaire : 
- je veux visualiser la liste des images disponibles  
- je veux visualiser le detail d'une image  
- je veux ajouter une image  

## En tant que Gestionnaire et suite au dépot d'une image : 
- je souhaite que l'application m'indique :  
	- La présence d'individus  
	- La liste des objets présents sur la photo avec la probablité de présence  
	- la réalisation de différents images en différents formats à partir de l'image originelle (507*338, 725*483, 2122*1415, 4050*2700)  

## En tant que Gestionnaire, suite au dépot d'une image et lorsque des individus sont detectés : 
- je souhaite indiquer la date de l'accord de la publication de l'image par les personnes présentes sur l'image  

## En tant que Gestionnaire, suite au dépot d'une image
- je souhaite qu'un copyright soit intégré à l'image  
- je souhaite ajouter une description à l'image  
- je souhaite catégoriser l'image  
- je souhaite modifier et compléter la liste des objets detectés lors du dépot de l'image  
- je souhaite activer la publication de l'image.  

## En tant que Gestionnaire : 
- je souhaite déactiver la publication de l'image.  
- je souhaite supprimer une image. Lors de la suppression, l'image est supprimée du disque et les données stockées en base de données sont archivées

## En tant que Utilisateur : 
- la page d'accueil affiche les 10 dernières images publiées  
- je veux rechercher des images à partir des filtres suivants :  
	- la catégorie  
	- une saisie texte  
La saisie texte va rechercher les images parmi la description, la catégorie et les libelles
Seules les images dont la publication est activée sont visibles à un utilisateur
Lors de l'affichage des résultats un mécanisme de pagination doit être mis à disposition (pagination ou scroll infini)

## En tant que Utilisateur et suite à une recherche : 
- je souhaiter pourvoir accéder aux informations sur l'image

## En tant que Utilisateur et lors de l'accés aux informations sur l'image : 
- je souhaiter pourvoir télécharger l'image dans un des formats  
- je souhaiter pourvoir télécharger tous les formats de l'image dans un fichier zip  
