**PETITCUENOT Mélanie**

**DOLLE Jérémy**

# Rapport TP4

Lors de ce TP 4, nous avons mis en place 3 types d'agent que nous appeleront "tortue"
par la suite. Ainsi, lors de l'exécution du projet, vous pouvez choisir entre
des tortues controlables, autonomes ou intelligentes.

Nous allons détailler le code et les patterns utilisés uniquement pour les tortues
intelligentes car c'est pour ce type d'agent que nous en avons le plus utilisé.

Comme le digramme complet du projet est assez important, nous allons le morceler 
suivant les partterns utilisés afin de faciliter sa compréhension.

### MVC

Nous avons commencé par découper notre code en suivant le modèle MCV

##### *Modèle :*

![alt text](images/modele.png)

##### *Vue :*

![alt text](images/vue.png)

##### *Controleur :*

![alt text](images/controleur.png)


### Design Pattern Factory

Nous avons utilisé ce pattern afin de créer de nouveaux environnements facilement et
de pouvoir les interchanger sans modifier tout notre code.

![alt text](images/factory.png)

### Design Pattern Decorator

Nous avons utilisé ce pattern afin de créer de nouvelles capacités à nos tortues facilement. Il nous suffit
à présent de créer une classe implémentée par notre interface capacité puis de l'ajouter à la liste des
capaités de notre tortue.

![alt text](images/decorateur.png)

Dans le coonstructeur de notre classe tortue intlligente, nous ajoutons les différentes capacitées désirées.

```java
 public TortueIntelligente() {
    super();
    this.listCapacites = new ArrayList<>();
    this.listCapacitesVues = new ArrayList<>();
    add(new CapaciteCouleurAttraction(this, 30),new CapaciteAttractionVue());
    add(new CapaciteCurseur(this), new CapaciteObjectifVue())
    add(new CapaciteObstacle(this,6,20,15),new CapaciteObstacleVue());
    add(new CapaciteObstacle(this,3,45,10),new CapaciteObstacleVue());
    add(new CapaciteObstacle(this,1,10,45),new CapaciteObstacleVue());
    add(new CapaciteObstacle(this,1,90,5),new CapaciteObstacleVue());
 }
```

Puis les capacités sont exécutées à chaque fois que la tortue avance.

```java
@Override
    public void avancer(ArrayList<Tortue> toutesLesTortues, Environment environment) {
        for (Capacite c : listCapacites) {
            c.lancerCapacité(environment);
        }
        super.avancer(toutesLesTortues, environment);
    }
```

