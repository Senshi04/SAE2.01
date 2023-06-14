# SAE2.01
Ce github servira de dépot du travail de notre SAE développement d'une application.
#

## Les classes
**Formes Simples :**
- Triangle
- Quadrilatère
- Chapeau

**Formes Composées :**
- Maison
- Etoile

#

## Description des formes composées

### Maison 
Pour construire la classe Maison, nous avons fait le choix de créer un constructeur dynamique qui demande à l’utilisateur d’entrer des données cohérentes telles que la largeur de la maison, sa hauteur et sa position. Ces données nous permettrons de construire les différents composants de la maison. Suivre cette méthode nous a aidé à réduire les cas d'éventuelles erreurs en plaçant nous mêmes les points. Dans le cas où l'utilisateur entre de mauvaises données, une boucle lui permettra de resaisir à nouveau jusqu'à ce que celles-ci correspondent.

### Etoile
Pour construire un objet Etoile, l'utilisateur devra seulement rentrer les points qui construiront le premier chapeau (qui correspond au cône du haut). La suite de l'étoile sera faite à partir de celui-ci et les autres chapeaux de l'étoile auront donc tous la même taille que le premier.

#
## Situation pouvant provoquer des erreurs
### Quadrilatère
- p1 = p2
- ordonnée p1 > ordonnée p2
- abscisse p1 > abscisse p2 
### Triangle
- p1 = p2 ou p1 = p3 ou p2 = p3
### Chapeau
- segment p1 p2 != segment p2 p3
### Étoile
- p2 du chapeau en paramètre a une ordonnée inférieure à celle de p1 ou p3


#
## Traitement des erreurs : Classes d'exception
### InvalidOrder 
Vérifie que les deux points choisis pour le quadrilatère soient cohérents car il faut déduire les deux autres points.
### InvalidDistanceChapeau
Vérifie que les distances p1, p2 et p2, p3 soient les mêmes
### LengthSegmentZero
Vérifie qu'aucun segment n'est égal à 0, autrement dit qu'aucun point n'est égal à un autre.
### InvalidOrd
Vérifie que l'ordonnée du point 1 est égal à celle du point 3 (Pour former une étoile)
