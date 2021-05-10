# ASI

###### GOUY Quentin | POULARD Antonin | VEBER Vincent | VERGNON Corentin

## Atelier 1

### Comparaison entre Web Statique + Web Services, Web Dynamique

| Crtière | Web Statique | Web Dynamique
| ------ | ------ | ------ |
| Généralités | Un site web statique est composé de pages statiques dans le sens où leur contenu n'est pas dynamique. Qu'importe le contexte (utilisateur, OS, navigateur, heure, nombre de visites, etc.) la page sera toujours identique. Elle est donc stockée telle quelle sur le serveur et envoyée au client. | A l'inverse du Web Statique, le Web Dynamique pourra rendre une page différente selon les critères retenus. Une même page (URL) pourra donc donner plusieurs résultats selon ces paramètres. Il ne peut pas savoir à l'avance ce qu'il va renvoyer au client car elle "se contruit" dynamiquement lorsque le client la demande. |
| Difficulté de dévelopement | Les pages statiques sont très souvent bien plus simples à mettre en place. En effet, le contenu étant identique à tout moment, il suffit de construire et de remplir sa page comme on l'entend sans trop s'embêter. En revanche, ce n'est pas facile à maintenir si l'on doit souvent modifier le contenu des pages. | Plus complexes à mettre en oeuvre, les pages dynamiques sont bien plus adaptées aux contextes changeants (espace client, site de commerce, blogs, etc.) et donc par essence dépendant du contexte. C'est aussi plus résistant au changements car on doit pouvoir facilement les étendre et les maintenir à long terme. |
| Langages utilisés | HTML, CSS, JavaScript | JEE (JSP, Servlet, etc.), AJAX, ASP, PHP, Perl, etc. |
| Base de données | Il n'y a pas besoin de base de données car les données sont directement écrites dans la page statique. | Il n'y a pas nécessairement de base de données même si on en retrouvera souvent. |
| Cas d'utilisation | Le Web Statique n'est pas meilleur ou pire que le Web Dynamique. Tout dépend du contexte et du cas d'utilisation. Le Web Statique sera plus adapté aux pages peu susceptibles de changer telle qu'un portfolio, une page vitrine de présentation, etc. Les pages statiques auront rarement des éléments intéractifs. En revanche, si l'on commence à devoir gérer beaucoup de pages statiques, il peut être intéressant de basculer vers du Web Dynamique. | Le Web Dynamique n'est pas meilleur ou pire que le Web Statique. Tout dépend du contexte et du cas d'utilisation. Le Web Dynamique sera plus adapté aux contextes changeants et lorsqu'il faudra s'adapter au client (on l'a dit, espace client, site de commerce, blogs, etc.). Il n'est pas utile de s'efforcer à faire du Web Dynamique si il n'y en a pas besoin. |
| Fréquence de mise à jour | Les moins souvent possible car cela implique d'aller modifier à la main le code source des pages. | Si le travail est bien fait, les pages n'ont pas besoin d'être mises à jour car c'est le contexte autour de ces pages qui les fait changer, pas la page elle même. |
| Performance | Très rapide à charger car tout est statique. | Plus long à charger de par sa nature dynamique. |
