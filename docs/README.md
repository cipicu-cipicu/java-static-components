## Java "static" keyword

We can add the static keyword to variables, methods, classes, and blocks

In Java, the keyword static means that the particular member belongs to the type itself,
rather than to an instance of that type. This means we'll create only one instance of
that static member that's shared across all instances of the class.

For example:

In the Cat example when you create new objects the static variables will be shared across
multiple objects

Example - add count (initially public)

You can access with the object or with the class name, but the convention is to use the class name
If private the methods should be static (although non-static works, this is confusing, so not recommended)
Static methods can also be called on an instance or on the class, but the convention is to use the class.

Characteristics of static components:

- **Shared memory allocation:** Static variables and methods are allocated memory space only once during the execution of the program. This memory space is shared among all instances of the class, which makes static members useful for maintaining global state or shared functionality.
- **Accessible without object instantiation (global):** Static members can be accessed without the need to create an instance of the class. This makes them useful for providing utility functions and constants that can be used across the entire program. *Static variables are, essentially, global variables.*
- **Associated with class, not objects:** Static members are associated with the class, not with individual objects. This means that changes to a static member are reflected in all instances of the class, and that you can access static members using the class name rather than an object reference.
- **Cannot access non-static members:** Static methods and variables cannot access non-static members of a class, as they are not associated with any particular instance of the class.
- **Can be overloaded, but not overridden:** Static methods can be overloaded, which means that you can define multiple methods with the same name but different parameters. However, they cannot be overridden, as they are associated with the class rather than with a particular instance of the class.

## TextEditor - review concepts, and re-factor

### Java packages

Java packages are a way of grouping functionality
Beginning of the package is usually at company level
Then follows the application (or library)
Then components within the application or library

For our text editor we can use something like:

com.so.texteditor

### UI MVC

For a UI application the functionality is logically separated into:
- model
- view
- controller

So normally we will have packages structure to reflect this:

**com.so.texteditor**  - will have the main application class (the one with the main method), called TextEditor  
**com.so.texteditor.model**  - will have the data  
**com.so.texteditor.view**  - will have all the UI classes (JFrame, JToolBar, JButton, etc.)  
**com.so.texteditor.controller**  - will have all the action and event listener classes (ActionListener, DocumentListener)  

One more thing - when we are not using the swing component as is, or if we have to group components,
then we will create our own classes extending swing classes (for example MainWindow extends JFrame), and these classes
will include internally other components.

For this project, to access the model, and other components that we need globally, we will make them static.


### Our project:

Rewrite our text editor properly with the packages above, and split the code into proper logical purpose (MVC)

##### Step 1. Create the MainWindow class

Create a class called `MainWindow` in the `com.so.texteditor.view` package
This class extends JFrame, and is the container for all the other UI components

Add the default close operation (exit the application on close)
Add an initial size (let's say and 400 px height, and 600 px width)

##### Step 2. Create the TextEditor class

Create a class called `TextEditor` in the `com.so.texteditor` package
This class has the main method, and creates an instance of the MainWindow

Test that the application works (and opens a blank window)

Check-in the code (get used to check-in code that works)

##### Step 3. Create the TextEditorModel class

This class goes into the `com.so.texteditor.model` package. This class will have only one attribute in our case called "text"
Let's create the attribute as private and create getter and setter methods

Things to consider - what will be the initial value of text attribute?

##### Step 4. Complete the UI

Add all the UI components to the MainWindow
- main panel
- toolbar (hint: this should be it's own class, that includes two buttons: "Open File", and "Close File")
Let's call the class MyToolBar
- scrollable text area (hint: initialize this from the model, as an experiment try different initial values for the text attribute)

Test that the application looks OK  
Check-in the code (get used to check-in code that works)

##### Step 5. Add listeners to the toolbar buttons

Create two separate classes in the package `com.so.texteditor.controller` called `OpenFileAction` and `CloseFileAction`
These classes will implement `ActionListener` and we will add them as action listeners to the corresponding buttons

Hint: start with classes that System.out.println a message, and link the to buttons, then check that clicking the buttons
will call the class

Add code to read the selected file into the model, and save the model to a file.  
Hint: put System.out.println in the model to make sure all works as expected

##### Step 6. Link the model change to the view controller

For this exercise we will add a static method in MainWindow called `refreshText` that will set the textArea text with the content of the model.

Test that the application works OK  
Check-in the code (get used to check-in code that works)

##### Step 7. Link the UI change events to the model

Theory: textArea.getDocument().addDocumentListener(...)  

See this first:  
[https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/events/documentlistener.html](https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/events/documentlistener.html)

Then this:  
[javax.swing.event.DocumentListener](https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/javax/swing/event/DocumentListener.html)

Create a class called `MainTextListener` in the package `??` (what do you think the package should be?)  
Output the contents of: document.getText(0, document.getLength()) <--- discuss this

Update the model with the text from the event

This completes the application.  

Test the application  
Check-in the code

...  
