#  Laboratory work 1 - Creational Design Patterns

### Author: Nelli Garbuz

----
## Task:

1. Study and understand the Structural Design Patterns.

2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.

3. Implement some additional functionalities using structural design patterns.

## Theory

Structural Design Patterns are solutions in software design that focus on how classes and objects are organized to form larger, functional structures. [1]

There are two recurring themes in these patterns:

* This pattern is particularly useful for making independently developed class libraries work together.
* Structural Design Patterns describe ways to compose objects to realize new functionality.
* The added flexibility of object composition comes from the ability to change the composition at run-time, which is impossible with static class composition.

The Structural Patterns are:
* Adapter - allows objects with incopatible interfaces to collaborate
* Bridge - lets you split a large class or a set of closely related classes into separate hierarchies - abstraction and implementation - which can be developed independently of each other
* COmposite - lets you compose objects into tree structures as if they were individual objects
* Decorator - lets you attach new behaviours to objects by placing these objects inside special wrapper objects that contain the behaviours
* Facade - provides a simplifies interface tp a library, a framework, or any other complex set of classes
* Flyweight - lets you fit more objects intp the available amount of RAM by sharing common parts of state between multiple objects instead og keeping all of the data in each object
* Proxy - lets you provide a subsitute or placeholder for another object. A peoxy controls access to the original objects, allowing you to perform something either before or after the request gets trough to the original object [2].
## Implementation description

In my project I implemented 3 CStructural Patterns - Adapter, Composite and Decorator.

The previous and new functionalities implemented for my Art Gallery Management System:

* Add artworks (paintings or sculptures)
* Display all the artworks from the gallery
* Search for a specific artwork (by title or author)
* Creating an exhibition
* Displaying all the exhibitions
* Categorize an artwork (limited or featured edition)
* Display a specific artwork

**Adapter Pattern**

For the Adapter Pattern, I have an interface ```DedcribableArtwork``` and a class ```ArtworkAdapter```. This class implements the DescribableArtwork interface, which allowsto get a description of the artwork using the getDescription() method. It internally assigns the description logic to the original Artwork class.

```public class ArtworkAdapter implements DescribableArtwork {
    private Artwork artwork;

    public ArtworkAdapter(Artwork artwork) {
        this.artwork = artwork;
    }

    @Override
    public String getDescription() {
        return "Artwork by " + artwork.getAuthor() + ": " + artwork.getTitle() + ", a " + artwork.getMedium() + " piece of size " + artwork.getSize();
    }
}
```
As mentioned previously, this allows for the user to get the description of a specific artwork based on its name.

**Composite Pattern**

The composite pattern is made out of 3 parts:

* Component Interface
* Leaf
* Composite

If we will map the parts to my Art Gallery Management System:
* Component Interface - It iwll be the ``` Artwork ```, which defines the common methods for both individual artwork objects (like ```Sculpture``` or ```Painting```) and composite objects (like ```Exhibition```). )Worth to mention that ``` Artwork ``` interface changed from the previous lab, and it does not containt the ```getDetails()``` method anymore.)
* Leaf - will be the individual artwork elements (```Painting``` and ```Scultpure```) that implement the``` Artwork``` interface directly and provide the implementation for the ```displayDetails()``` method.
* Composite - is represented by the ```Exhibition``` class that implements the ```Artwork``` interface and holds a list of Artwork objects. It assigns the call to ```displayDetails()``` for each artwork it contains, allowing an exhibition to contain both individual artworks and other exhibitions (optional).


``` 
public class Exhibition implements Artwork {
    private String exhibitionTitle;
    private List<Artwork> artworks;

    public Exhibition(String exhibitionTitle) {
        this.exhibitionTitle = exhibitionTitle;
        this.artworks = new ArrayList<>();
    }

    // Add an Artwork (can be individual or another Exhibition)
    public void addArtwork(Artwork artwork) {
        artworks.add(artwork);
    }

    @Override
    public void displayDetails() {
        System.out.println("Exhibition Title: " + exhibitionTitle);
        for (Artwork artwork : artworks) {
            artwork.displayDetails(); 
        }
    }
    
    public void displayExhibition() {
        System.out.println("Exhibition Title: " + exhibitionTitle);
        System.out.println("Artworks in this exhibition:");
        for (Artwork artwork : artworks) {
            artwork.displayDetails(); 
        }
    }
```

**Decorator Pattern**

In my case, I used the decorator pattern to add additional functionality (make a distinction between type of artworks - limited/feature) to my existing Artwork objects (painting and sculptures) without modifying the original ```Artwork``` class.

Based on the Decorator pattern structure, I have:

* Component  (```Artwork Interface```), which defines basic methods that any artwork class should have, such as ```getAuthor```, ```getTitle```, ```getSize```, ```getMedium```, and ```displayDetails```.

* Concrete implementation (```BaseArtwork```) is an abstract class that implements the ```Artwork``` interface and provides a base for storing artwork attributes like author, title, medium, and size. The method ```displayDetails``` prints out the artwork's author, title, medium, and size.


```
public BaseArtwork(String author, String title, String medium, String size) {
        this.author = author;
        this.title = title;
        this.medium = medium;
        this.size = size;
    }

    @Override
    public String getAuthor() { return author; }

    @Override
    public String getTitle() { return title; }

    @Override
    public String getSize() { return size; }

    @Override
    public String getMedium() { return medium; }

    @Override
    public void displayDetails() {
        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Medium: " + medium);
        System.out.println("Size: " + size);
    }
}
```

* Decorator Base Class (```ArtworkDecorator```) is another abstract class that implements the ```Artwork``` interface and wraps an ```Artwork``` instance. This class forwards method calls to the wrapped Artwork instance, serving as a pass-through for the methods ```getAuthor```, ```getTitle```, ```getSize```, ```getMedium```, and ```displayDetails```. Subclasses of ```ArtworkDecorator``` can override these methods to add additional behavior without altering the underlying ```Artwork``` instance.
```
public abstract class ArtworkDecorator implements Artwork {
    protected Artwork artwork;  // The wrapped artwork object

    public ArtworkDecorator(Artwork artwork) {
        this.artwork = artwork;
    }

    @Override
    public void displayDetails() {
        artwork.displayDetails();
    }

    @Override
    public String getAuthor() {
        return artwork.getAuthor();
    }

    @Override
    public String getTitle() {
        return artwork.getTitle();
    }

    @Override
    public String getSize() {
        return artwork.getSize();
    }

    @Override
    public String getMedium() {
        return artwork.getMedium();
    }
}
```

* Concrete Decorator (```FeaturedArtworkDecorator``` and ```LimitedArtworkDecorator```) are the following classes ```FeaturedArtworkDecorator``` or ```LimitedArtworkDecorator``` that extends ```ArtworkDecorator``` and overrides the ```displayDetails``` method. In ```displayDetails```, it first calls the wrapped artwork's ```displayDetails``` to print the base details (author, title, medium, size), then adds an additional message ("This is a featured artwork!" or "This artwork is a limited edition!") to mark this piece as featured/limited.This addition does not alter the underlying Artwork object itself, preserving the original Artwork behavior.

```public class LimitedEditionDecorator extends ArtworkDecorator {
    public LimitedEditionDecorator(Artwork artwork) {
        super(artwork);
    }

    @Override
    public void displayDetails() {
        artwork.displayDetails();
        System.out.println("This artwork is a limited edition!");
    }
}
 ``` 


## Conclusions 
In this laboratory work, I enhanced the functionality of my Art Gallery system by implementing three structural design patterns: Adapter, Composite, and Decorator. The Adapter pattern enables integration by allowing artworks to be displayed in various formats without altering their original structure. The Composite pattern provides a way to manage collections of artworks and exhibitions as individual or grouped entities, simplifying complex gallery structures. In addition to this, the Decorator pattern adds additional enhancements to artworks, such as featured or limited edition tags, without modifying the core artwork classes.

## Screenshots
![image](https://github.com/user-attachments/assets/544221bd-6e09-431b-8c80-ae611798dec7)
![image](https://github.com/user-attachments/assets/be73dfbb-1a45-4d3a-b05f-3e154ec2de0f)
![image](https://github.com/user-attachments/assets/d9d154c2-24cc-4a89-bc96-295612e9296f)
![image](https://github.com/user-attachments/assets/ab92277a-e51d-4738-b868-98f9db48460f)



## Bibliography
[1] https://www.geeksforgeeks.org/structural-design-patterns/

[2] https://refactoring.guru/design-patterns/structural-patterns



