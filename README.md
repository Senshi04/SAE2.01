# SAE2.01
Ce github servira de dépot du travail de notre SAE développement d'une application.

## Les classes
**Formes Simples :**
- Triangle
- Quadrilatère
- Chapeau

**Formes Composées :**
- Maison
- Etoile

## Description des formes composées :

### Maison 
Pour construire l'objet Maison, nous avons fait le choix de créer un constructeur dynamique qui demande à l’utilisateur d’entrer des données cohérentes telles que la largeur de la maison, sa hauteur et sa position. Ces données nous permettrons de construire les différents composants de la maison. Suivre cette méthode nous a aidé à réduire les cas d'éventuelles erreurs en plaçant nous mêmes les points. Dans le cas où l'utilisateur entre de mauvaises données, une boucle lui permettra de resaisir à nouveau jusqu'à ce que celles-ci correspondent.

### Etoile
Pour construire un objet Etoile, l'utilisateur devra seulement rentrer les points qui construiront le premier chapeau (qui correspond au cône du haut). La suite de l'étoile sera faite à partir de celui-ci et les autres chapeaux de l'étoile auront donc tous la même taille que le premier.
