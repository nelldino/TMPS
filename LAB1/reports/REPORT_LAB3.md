# Laboratory work 3 - Behavioural Design Patterns

### Author: Nelli Garbuz

----
## Task:

1. Study and understand the Behavioral Design Patterns.

2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.

3. Implement some additional functionalities using behavioral design patterns.

## Theory

Behavioral design patterns are a category of design patterns that focus on the interactions and communication between objects. They help define how objects collaborate and distribute responsibility among them, making it easier to manage complex control flow and communication in a system. [1]

The Behavioural Patterns are:

1. Chain Of Responsibility - allows passing rquests along a chain of handlers. Upon receinving a request, each handler decides either to process the request or to pass it to the next handler in the chain
   
3. Command - turns a request into a stand-alone object that contains all information about the request. 
4. Interpreter -defines a way to interpret and evaluate language grammar or expressions. It provides a mechanism to evaluate sentences in a language by representing their grammar as a set of classes [1]
5. Mediator - reduces chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via mediator object 
6. Memento  - allows one to save and restore the previous state of an object without revealing the details of its implementation
7. Observers- defines a subscription mechanism to notify multiple objects about any events that happent to the object they're observing
8. State - allows an object to alter its behaviour when its internal stae changes. It appears as if the object changed its class
9. Strategy - defines a family of algorithms, put each of them into a separate class, and make their objects interchangeable
10. Template- defines a skeleton of an algorithm in the superclass but allows subclasses override specific steps of the algorithm without changing its structure
11. Visitor - separates algorithms from the objects on which they operate [2]


In my project I implemented one Behavioural Pattern - Strategy. And I decided to change my Search Filter using the Behavioural Pattern

The previous functionalities implemented for my Art Gallery Management System:

* Add artworks (paintings or sculptures)
* Display all the artworks from the gallery
* Search for a specific artwork (by title or author)
* Creating an exhibition
* Displaying all the exhibitions
* Categorize an artwork (limited or featured edition)
* Display a specific artwork

**Strategy Pattern**

The structure of the Strategy Patter is:

1. **Strategy Interface** - in my case, I have ```SearchStrategy``` interface that defines the contract for all search strategies
For the Pattern, I have an interface ```DedcribableArtwork``` and a class ```ArtworkAdapter```. This class implements the DescribableArtwork interface, which allows to get a description of the artwork using the getDescription() method. It internally assigns the description logic to the original Artwork class.

```public interface SearchStrategy {
    List<Artwork> search(List<Artwork> artworks, String criteria);
}
```
2. **Concrete Strategies** - I have 2, the Author and Title (```AuthorSearchStrategy``` ```TitleSearchStrategy```) classes that implement ```SearchStrategy``` interface, providing specific algorithms for searching by author and title, respectively,
As mentioned previously, this allows for the user to get the description of a specific artwork based on its name.

``` 
public class AuthorSearchStrategy implements SearchStrategy {
    @Override
    public List<Artwork> search(List<Artwork> artworks, String author) {
        return artworks.stream()
                .filter(a -> a.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }
}
```
3. **Context** - the ```SearchContext``` class acts as the Context that holds a reference to a ```SearchStrategy``` object. It delegates the search operation to the strategy.

```
public class SearchContext {
    private SearchStrategy strategy;

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Artwork> executeSearch(List<Artwork> artworks, String criteria) {
        if (strategy == null) {
            throw new IllegalStateException("Search strategy not set");
        }
        return strategy.search(artworks, criteria);
    }
}
```



## Conclusions 
In this laboratory work, I enhanced the functionality of my Art Gallery system, more specifically my searching filter by implementing the Strategy Design Pattern. This pattern provides a flexible way to search for artworks by separating the search logic into individual strategies. Consequently, an user can easily search for artworks by different criteria, such as author or title, without altering the core gallery logic.

![image](https://github.com/user-attachments/assets/c1584f9d-4eda-4361-af48-16e7ecf63c50)
![image](https://github.com/user-attachments/assets/e03d161b-35e5-4fef-a3aa-6ecead03e781)
![image](https://github.com/user-attachments/assets/ef22129e-6b97-4fc2-92a1-4930da7723a5)

## Bibliography
[1] https://www.geeksforgeeks.org/behavioral-design-patterns/

[2] https://refactoring.guru/design-patterns/strategy



