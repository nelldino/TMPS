#  Laboratory work 1 - Creational Design Patterns

### Author: Nelli Garbuz

----
## Task:

1. Study and understand the Creational Design Patterns.

2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.

3. Use some creational design patterns for object instantiation in a sample project.

## Theory

Creational Design Patterns focus on the process of object creation or problems related to object creation. They help in making a system independent of how its objects are created, composed, and represented. Creational patterns give a lot of flexibility in what gets created, who creates it, and how it gets created. There are two main themes in these patterns:

* They keep information about the specific classes used in the system hidden.
* They hide the details of how instances of these classes are created and assembled. [1]

The Creational Design Patterns are: [2]

* Factory Method - provides an interface for crating objects in a superclass, but allows subclasses to alter the type of the objects that will be created
* Abstract Method - Lets one to produce families of related objects without specifying their concrete classes
* Builder - lets one to construct complex objects step by step. The pattern allows to produce different types and representations of an object using the same construction code
* Prototype - lets one copy existing objects without making code dependent on their classes
* Singleton - ensure that class has only one instance, while providing a global access point to this instance

## Implementation description

In my project I implemented 3 Creational Patterns - Singleton, Factory Method and Builder.

I decided to make an Art Gallery Management System, where a user can:

* Add artworks (paintings or sculptures)
* Display all the artworks from the gallery
* Search for a specific artwork (by title or author)
* Creating an exhibition
* Displaying all the exhibitions

**Singleton Pattern**

For the Singleton Pattern I created the class ```Art Gallery```, that ensures that there is only one instance of it across the application and manages the collections of all artworks and exhibitions.
For the implementation of the pattern I have the ```getInstance()``` method that provides a single access point to the  ```Art Gallery instance```, creting it if it does not already exist.

``` public class ArtGallery {
    private static ArtGallery instance;
    private List<Artwork> artworks;
    private List<Exhibition> exhibitions;

 private ArtGallery() {
        artworks = new ArrayList<>();
        exhibitions = new ArrayList<>();
    }
``` 
Public Static Method to Get the Instance:
```getInstance()``` is the only way to access the ```ArtGallery``` instance. When ```getInstance()``` is called for the first time, it checks if ```instance``` is ```null```.If it is, a new ```ArtGallery``` instance is created, initializing ```instance``` with that new object (a method called lazy initialization).           
```   

    public static ArtGallery getInstance() {
        if (instance == null) {
            instance = new ArtGallery();
        }
        return instance;
    }
```
Once the ```ArtGallery``` instance is created the first time ```getInstance()``` is called, every future call to ```getInstance()``` just returns that same instance without creating a new one. This way, the ```ArtGallery``` class always has a single, shared instance for the whole program.

**Factory Method Pattern**

For the Factory Method I have 3 classes: 
* ```ArtworkFactory``` (which is an abstract factory)
* ```PaintingFactory```
* ```SculptureFactory```

The Factory Method Pattern implements the creation logic for the different types of artworks, allowing to add a new type without having to change the core application code.  
Each factory subclass (e.g ```PaintingFactory```) provides a wat to instantiate types of ```Artwork```, keeping ```ArtGalleryApp``` decoupled from specific artwork types.

```
public class PaintingFactory extends ArtworkFactory {
    public Artwork createArtwork(String author, String title, String medium, String size) {
        return new Painting(author, title, medium, size);
    }
}

public class SculptureFactory extends ArtworkFactory {
    public Artwork createArtwork(String author, String title, String medium, String size) {
        return new Sculpture(author, title, medium, size);
    }
}
```

***Builder Pattern**

Builder Pattern provides a flexible way to create search filters by allowing optional criteria like title and author. 

```SearchFilter.Builder``` allows step-by-step construction of the ```SearchFilter``` object, making it easy to add additional search parameters if needed. 

``` public static class Builder {
        private String title;
        private String author;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }
```
In ```SearchFilter```, a private constructor takes a ```Builder``` instance and copies its values to the fields in ```SearchFilter```. This ensures only the Builder can create ```SearchFilter``` instances, enforcing the use of the ```Builder ```pattern.
```
        public SearchFilter build() {
            return new SearchFilter(this);
        }
    }
```
In my case, the Builder pattern was helpful, since I wanted to search an artwork based wither on the title or the painter's/sculptor's name, (considered in some cases optional parameters).

## Conclusions 
In this laboratory work, I made an implementation of an Art Gallery, using 3 creational patterns - Singleton, Factory Method and Builder. The Singleton patterns ensures a centralized management of artworks for the exhibitions data. The Factory Method enables a flexible creation of different artwork types, such as paintings and scultpures (in my case). In addition, the Builder patters allows to create a search filter with optional patters, which makes it adaptable to user's needs. 

## Screenshots
![image](https://github.com/user-attachments/assets/33d48254-14cb-44d1-a139-66c28a5f3068)
![image](https://github.com/user-attachments/assets/3073cbdd-e506-474a-a7da-637b1582c551)
![image](https://github.com/user-attachments/assets/fb2c243c-a473-4123-877e-6c6810a38d76)
![image](https://github.com/user-attachments/assets/25305498-fa5b-4634-b573-414f357f1278)
![image](https://github.com/user-attachments/assets/1e8076f0-a08a-4db3-8dbd-ae4fc3596f06)


## Bibliography
[1] https://www.geeksforgeeks.org/creational-design-pattern/

[2] https://refactoring.guru/design-patterns/creational-patterns
